# gwt-material-demo-errai
A GWT Material Demo built with Errai
[![Build Status](https://travis-ci.org/GwtMaterialDesign/gwt-material-demo-errai.svg?branch=master)](https://travis-ci.org/GwtMaterialDesign/gwt-material-demo-errai) [![Join the chat at https://gitter.im/GwtMaterialDesign/gwt-material](https://img.shields.io/badge/GITTER-join%20chat-green.svg)](https://gitter.im/GwtMaterialDesign/gwt-material?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
## Current Version 1.0-SNAPSHOT

## Demo
- https://gwtmaterialdesign.github.io/gwt-material-demo-errai/1.0-SNAPSHOT/

## Introduction
Starting GMD (GWT Material Design) 2.0 we have supported Errai 4.0 Framework to build Web & Mobile Applications in order to support html & java code development. This demo represents all core and addin components that are running on errai instance. We chose Errai because of its power on specific features like CDI, Navigation, Messaging, Data Binding, JPA, Jaxrs and Cordova.


## Setting up a new project
You can easily setup a new gwt-material-errai project using Maven Archetype which contains a starter template.
```
mvn archetype:generate -DarchetypeGroupId=com.github.gwtmaterialdesign -DarchetypeArtifactId=gwt-material-errai-archetype -DarchetypeRepository=https://oss.sonatype.org/content/repositories/snapshots/ -DarchetypeVersion=1.0-SNAPSHOT
```

## Projects Included
Here are the lists of projects included inside the archetype.
- gwt-material 
- gwt-material-addins
- gwt-material-themes
- gwt-material-jquery
- gwt-material-table
- errai 4.0


## Wiki
A brief information about gwt-material using Github Wikis.
- [Changelog](https://github.com/GwtMaterialDesign/gwt-material/wiki/Changelog)
- [Contributing](https://github.com/GwtMaterialDesign/gwt-material/wiki/Contributing)
- [How to file a bug](https://github.com/GwtMaterialDesign/gwt-material/wiki/How-to-file-a-bug)
- [GMD 2.0](https://github.com/GwtMaterialDesign/gwt-material/wiki/2.0---API-Changes)
- [GMD Addins  2.0](https://github.com/GwtMaterialDesign/gwt-material-addins/wiki/2.0-API-Changes)
- [GMD Themes 2.0](https://github.com/GwtMaterialDesign/gwt-material-themes/wiki/2.0---API-Changes)


## Configuring your module
You will have to configure your App.gwt.xml file to inherit the Gwt Material Widget library. You can do it like this:
<inherits name="gwt.material.design.GwtMaterialWithJQuery" />


## List of GMD Modules
- GwtMaterialDesign # Standard use with all resources (but will not load jQuery for you).
- GwtMaterialDesignDebug # Same as above but will load non-minified js and Source URL included for Chrome debugging
- GwtMaterialWithJQuery # Standard use with all resources and will also include loading jQuery
- GwtMaterialWithJQueryDebug # Same as but will load non-minified js and Source URL included for Chrome debugging
- GwtMaterialDesignBasic # Use without materialize.css file (but will not load jQuery for you).
- GwtMaterialBasicWithJQuery # Same as above but will also include loading jQuery
- GwtMaterialBasicWithJQueryDebug # Same as above but with non-minified js and Source URL included for Chrome debugging.




## Theming
We created another project for gwt-material themes. Also starting 2.0 we have supported dynamic theming.
https://github.com/GwtMaterialDesign/gwt-material-themes


First: Make sure you are using GwtMaterialDesignBasic module (This will not load the materialize.css default file allowing you to customize your design.)
<inherits name="gwt.material.design.GwtMaterialDesignBasic" />


Second: Checkout the theme project and add it to your build path. And define it on your app.gwt.xml file.
<inherits name="gwt.material.design.themes.ThemeBlue"/>




## GMD 2.0 Getting Started
You can browse GMD Getting started guide here.
http://gwtmaterialdesign.github.io/gwt-material-demo/2.0-SNAPSHOT/#!gettingstarted


## Errai 4.0 Documentation
You can browse ErraiGetting started guide here.
http://erraiframework.org/getting-started/index.html#SetupPage


