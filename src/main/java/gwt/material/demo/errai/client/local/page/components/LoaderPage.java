package gwt.material.demo.errai.client.local.page.components;

import com.google.gwt.user.client.Timer;
import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.client.constants.LoaderSize;
import gwt.material.design.client.constants.ProgressType;
import gwt.material.design.client.constants.SpinnerColor;
import gwt.material.design.client.ui.*;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "loader")
public class LoaderPage extends PageBase {

    @Inject
    @DataField
    MaterialButton btnCircular;

    @Inject
    @DataField
    MaterialButton btnProgress;

    @Inject
    @DataField
    MaterialProgress progress;

    @Inject
    @DataField
    MaterialProgress progress2;

    @Inject
    @DataField
    MaterialPreLoader loader1, loader2, loader3;

    @Inject
    MaterialSpinner spinner1, spinner2, spinner3;

    @PostConstruct
    public void init() {
        initPage("Loaders", "If you have content that will take a long time to load, you should give the user feedback. For this reason we provide a number activity + progress indicators.", COMPONENTS_COLOR);
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
            MaterialLoader.showProgress(true);
            Timer timer = new Timer() {
                @Override
                public void run() {
                    MaterialLoader.showProgress(false);
                }
            };
        });
    }

    private void buildCircular() {
        btnCircular.setText("Show Loader");
        btnCircular.addClickHandler(clickEvent -> {
            MaterialLoader.showLoading(true);
            Timer timer = new Timer() {
                @Override
                public void run() {
                    MaterialLoader.showLoading(false);
                }
            };
            timer.schedule(2000);
        });
    }
}
