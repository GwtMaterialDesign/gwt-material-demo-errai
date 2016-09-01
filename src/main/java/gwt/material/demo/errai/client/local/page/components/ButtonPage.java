package gwt.material.demo.errai.client.local.page.components;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.client.constants.*;
import gwt.material.design.client.ui.MaterialButton;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "button")
public class ButtonPage extends PageBase {

    @Inject
    @DataField
    MaterialButton btn1, btn2, btn3, btn4, btn5;

    @Inject
    @DataField
    MaterialButton btnFloating1, btnFloating2, btnFloating3, btnFloating4, btnFloating5;

    @PostConstruct
    public void init() {
        initPage("Button", "There are 3 main button types described in material design. The raised button is a standard button that signify actions and seek to give depth to a mostly flat page. The floating circular action button is meant for very important functions. Flat buttons are usually used within elements that already have depth like cards or modals.", COMPONENTS_COLOR);
        buildRaised();
        buildFloating();
    }

    private void buildFloating() {
        btnFloating1.setType(ButtonType.FLOATING);
        btnFloating1.setWaves(WavesType.LIGHT);
        btnFloating1.setSize(ButtonSize.LARGE);
        btnFloating1.setBackgroundColor("red");
        btnFloating1.setIconType(IconType.CAKE);

        btnFloating2.setType(ButtonType.FLOATING);
        btnFloating2.setWaves(WavesType.LIGHT);
        btnFloating2.setSize(ButtonSize.LARGE);
        btnFloating2.setIconType(IconType.ANDROID);

        btnFloating3.setType(ButtonType.FLOATING);
        btnFloating3.setWaves(WavesType.LIGHT);
        btnFloating3.setSize(ButtonSize.LARGE);
        btnFloating3.setIconType(IconType.MESSAGE);
        btnFloating3.setEnabled(false);

        btnFloating4.setType(ButtonType.FLOATING);
        btnFloating4.setWaves(WavesType.DEFAULT);
        btnFloating4.setSize(ButtonSize.LARGE);
        btnFloating4.setIconType(IconType.GROUP);

        btnFloating5.setType(ButtonType.FLOATING);
        btnFloating5.setWaves(WavesType.DEFAULT);
        btnFloating5.setSize(ButtonSize.LARGE);
        btnFloating5.setIconColor("green");
        btnFloating5.setBackgroundColor("white");
        btnFloating5.setIconType(IconType.ANDROID);
    }

    private void buildRaised() {
        btn1.setText("Button");
        btn1.setBackgroundColor("white");
        btn1.setTextColor("black");
        btn1.setWaves(WavesType.DEFAULT);

        btn2.setText("Primary");
        btn2.setWaves(WavesType.LIGHT);
        btn2.setIconType(IconType.POLYMER);

        btn3.setText("Disabled");
        btn3.setWaves(WavesType.LIGHT);
        btn3.setIconType(IconType.POLYMER);
        btn3.setIconPosition(IconPosition.RIGHT);
        btn3.setEnabled(false);

        btn4.setText("Warn");
        btn4.setWaves(WavesType.LIGHT);
        btn4.setIconType(IconType.POLYMER);
        btn4.setBackgroundColor("red");
        btn4.setIconPosition(IconPosition.RIGHT);

        btn5.setText("Icon Color");
        btn5.setWaves(WavesType.RED);
        btn5.setIconType(IconType.POLYMER);
        btn5.setIconColor("red");
        btn5.setBackgroundColor("white");
        btn5.setTextColor("black");
        btn5.setIconPosition(IconPosition.RIGHT);
    }
}
