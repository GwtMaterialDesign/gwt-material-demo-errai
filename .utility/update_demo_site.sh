#!/bin/bash
set -ev
if [ "$TRAVIS_JDK_VERSION" == "oraclejdk8" ] && [ "$TRAVIS_PULL_REQUEST" == "false" ] && [ "$TRAVIS_BRANCH" == "master" ]; then

if [[ -z "$GH_TOKEN" ]]; then
echo -e "GH_TOKEN is not set"
exit 1
fi

if [ ! -f $TRAVIS_BUILD_DIR/target/gwt-material-demo-errai*.war ]; then
echo -e "demo war file not found."
exit 1
fi

echo -e "Publishing demo to gh-pages . . .\n"

git config --global user.email "travis@travis-ci.org"
git config --global user.name "travis-ci"

# clone the gh-pages branch.
cd $HOME
rm -rf gh-pages
git clone --quiet --branch=gh-pages https://$GH_TOKEN@github.com/GwtMaterialDesign/gwt-material-demo-errai gh-pages > /dev/null
cd gh-pages

# remove the GwtMaterialDemo directories from git.
if [[ -d ./1.0-SNAPSHOT/App ]]; then
git rm -rf ./1.0-SNAPSHOT/App
fi
if [[ -f ./1.0-SNAPSHOT/index.html ]]; then
git rm -rf ./1.0-SNAPSHOT/index.html
fi
if [[ -d ./1.0-SNAPSHOT/META-INF ]]; then
git rm -rf ./1.0-SNAPSHOT/META-INF
fi
if [[ -d ./1.0-SNAPSHOT/WEB-INF ]]; then
git rm -rf ./1.0-SNAPSHOT/WEB-INF
fi

# copy the new GwtMaterialDemo the 1.0-SNAPSHOT dir.
unzip -u $TRAVIS_BUILD_DIR/target/gwt-material-demo-errai*.war -d ./1.0-SNAPSHOT/
rm -rf ./1.0-SNAPSHOT/META-INF
rm -rf ./1.0-SNAPSHOT/WEB-INF

git add -f .
git commit -m "Auto-push demo to gh-pages successful. (Travis build: $TRAVIS_BUILD_NUMBER)"
git push -fq origin gh-pages > /dev/null

echo -e "Published demo to gh-pages.\n"

fi
