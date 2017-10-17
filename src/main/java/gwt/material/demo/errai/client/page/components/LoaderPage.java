package gwt.material.demo.errai.client.page.components;

import com.google.gwt.user.client.Timer;
import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.client.constants.LoaderSize;
import gwt.material.design.client.constants.ProgressType;
import gwt.material.design.client.constants.SpinnerColor;
import gwt.material.design.client.ui.*;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "loader")
public class LoaderPage extends AbstractPage {

    @Inject
    @DataField
    private MaterialButton btnCircular;

    @Inject
    @DataField
    private MaterialButton btnProgress;

    @Inject
    @DataField
    private MaterialProgress progress;

    @Inject
    @DataField
    private MaterialProgress progress2;

    @Inject
    @DataField
    private MaterialPreLoader loader1, loader2, loader3;

    @Inject
    private MaterialSpinner spinner1, spinner2, spinner3;

    @Override
    public String getName() {
        return "Loaders";
    }

    @Override
    public String getDescription() {
        return "If you have content that will take a long time to load, you should give the user feedback. " +
               "For this reason we provide a number activity + progress indicators.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.COMPONENTS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
        buildCircular();
        buildProgress();
        buildDeterminate();
        buildIndeterminate();
        buildStandAlone();
    }

    private void buildStandAlone() {
        loader1.setSize(LoaderSize.BIG);
        spinner1.setColor(SpinnerColor.BLUE_ONLY);
        loader1.add(spinner1);

        loader2.setSize(LoaderSize.MEDIUM);
        spinner2.setColor(SpinnerColor.RED_ONLY);
        loader2.add(spinner2);

        loader3.setSize(LoaderSize.SMALL);
        spinner3.setColor(SpinnerColor.YELLOW_ONLY);
        loader3.add(spinner3);
    }

    private void buildIndeterminate() {
        progress2.setType(ProgressType.INDETERMINATE);
    }

    private void buildDeterminate() {
        progress.setType(ProgressType.DETERMINATE);
        progress.setPercent(30);
    }

    private void buildProgress() {
        btnProgress.setText("Show Progress");
        btnProgress.addClickHandler(clickEvent -> {
            MaterialLoader.progress(true);
            Timer timer = new Timer() {
                @Override
                public void run() {
                    MaterialLoader.progress(false);
                }
            };
            timer.schedule(2000);
        });
    }

    private void buildCircular() {
        btnCircular.setText("Show Loader");
        btnCircular.addClickHandler(clickEvent -> {
            MaterialLoader.loading(true);
            Timer timer = new Timer() {
                @Override
                public void run() {
                    MaterialLoader.loading(false);
                }
            };
            timer.schedule(2000);
        });
    }
}
