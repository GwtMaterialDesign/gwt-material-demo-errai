package gwt.material.demo.errai.client.page.components;

import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.client.constants.*;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialToast;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.inject.Inject;

@Templated
@Page(path = "button")
public class ButtonPage extends AbstractPage {

    @Inject
    @DataField
    private MaterialButton btn1, btn2, btn3, btn4, btn5;

    @Inject
    @DataField
    private MaterialButton btnFloating1, btnFloating2, btnFloating3, btnFloating4, btnFloating5;

    @Inject
    @DataField
    private MaterialButton btnFlat1, btnFlat2, btnFlat3, btnFlat4;

    @Inject
    @DataField
    private MaterialButton btnLarge1, btnLarge2, btnLarge3;

    @Inject
    @DataField
    private MaterialButton btnDisabled1, btnDisabled2, btnDisabled3, btnDisabled4;

    @Inject
    @DataField
    private MaterialButton btnEvents1, btnEvents2, btnEvents3;

    @Inject
    @DataField
    private MaterialLink btnLink1, btnLink2, btnLink3;

    @Inject
    @DataField
    private MaterialIcon btnIconButton1, btnIconButton2, btnIconButton3;

    @Override
    public String getName() {
        return "Button";
    }

    @Override
    public String getDescription() {
        return "There are 3 main button types described in material design. The raised button is a standard button " +
               "that signify actions and seek to give depth to a mostly flat page. The floating circular action " +
               "button is meant for very important functions. Flat buttons are usually used within elements that " +
               "already have depth like cards or modals.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.COMPONENTS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
        buildRaised();
        buildFloating();
        buildFlat();
        buildLarge();
        buildDisabled();
        buildEvents();
        buildLinks();
        buildIconButton();
    }

    private void buildIconButton() {
        btnIconButton1.setIconType(IconType.MENU);
        btnIconButton1.setIconColor(Color.BLUE);
        btnIconButton1.setWaves(WavesType.DEFAULT);
        btnIconButton1.setCircle(true);

        btnIconButton2.setIconType(IconType.FAVORITE);
        btnIconButton2.setIconColor(Color.RED);
        btnIconButton2.setEnabled(false);
        btnIconButton2.setWaves(WavesType.DEFAULT);
        btnIconButton2.setCircle(true);

        btnIconButton3.setIconType(IconType.MORE_VERT);
        btnIconButton3.setIconColor(Color.GREY);
        btnIconButton3.setWaves(WavesType.DEFAULT);
        btnIconButton3.setCircle(true);
    }

    private void buildLinks() {
        btnLink1.setText("Normal Link");
        btnLink1.setTextColor(Color.RED);
        btnLink1.setIconPosition(IconPosition.LEFT);
        btnLink1.setIconType(IconType.POLYMER);

        btnLink2.setText("Link with Href");
        btnLink2.setHref("#button");
        btnLink2.setTextColor(Color.RED);
        btnLink2.setIconPosition(IconPosition.LEFT);
        btnLink2.setIconType(IconType.POLYMER);

        btnLink3.setText("Link with different color");
        btnLink3.setTextColor(Color.BLACK);
        btnLink3.setIconColor(Color.RED);
        btnLink3.setIconPosition(IconPosition.LEFT);
        btnLink3.setIconType(IconType.POLYMER);
    }

    private void buildEvents() {
        btnEvents1.setText("Click Me");
        btnEvents1.setIconType(IconType.POLYMER);
        btnEvents1.setWaves(WavesType.LIGHT);
        btnEvents1.addClickHandler(clickEvent -> {
            MaterialToast.fireToast("Clicked");
        });

        btnEvents2.setText("Hover Me");
        btnEvents2.setIconType(IconType.POLYMER);
        btnEvents2.setWaves(WavesType.LIGHT);
        btnEvents2.addMouseOverHandler(clickEvent -> {
            MaterialToast.fireToast("Hovered");
        });

        btnEvents3.setText("Double Click Me");
        btnEvents3.setIconType(IconType.POLYMER);
        btnEvents3.setWaves(WavesType.LIGHT);
        btnEvents3.addDoubleClickHandler(clickEvent -> {
            MaterialToast.fireToast("Double Clicked");
        });
    }

    private void buildDisabled() {
        btnDisabled1.setText("Disabled");
        btnDisabled1.setIconType(IconType.POLYMER);
        btnDisabled1.setIconPosition(IconPosition.LEFT);
        btnDisabled1.setSize(ButtonSize.LARGE);
        btnDisabled1.setEnabled(false);

        btnDisabled2.setText("Disabled");
        btnDisabled2.setIconType(IconType.POLYMER);
        btnDisabled2.setIconPosition(IconPosition.LEFT);
        btnDisabled2.setEnabled(false);

        btnDisabled3.setText("Disabled");
        btnDisabled3.setType(ButtonType.FLAT);
        btnDisabled3.setEnabled(false);

        btnDisabled4.setIconType(IconType.POLYMER);
        btnDisabled4.setType(ButtonType.FLOATING);
        btnDisabled4.setEnabled(false);
    }

    private void buildLarge() {
        btnLarge1.setText("Large");
        btnLarge1.setWaves(WavesType.LIGHT);
        btnLarge1.setSize(ButtonSize.LARGE);

        btnLarge2.setText("Large");
        btnLarge2.setWaves(WavesType.LIGHT);
        btnLarge2.setSize(ButtonSize.LARGE);
        btnLarge2.setIconType(IconType.POLYMER);
        btnLarge2.setIconPosition(IconPosition.LEFT);

        btnLarge3.setText("Large");
        btnLarge3.setWaves(WavesType.LIGHT);
        btnLarge3.setSize(ButtonSize.LARGE);
        btnLarge3.setIconType(IconType.POLYMER);
        btnLarge3.setIconPosition(IconPosition.RIGHT);
    }

    private void buildFlat() {
        btnFlat1.setType(ButtonType.FLAT);
        btnFlat1.setText("Button");
        btnFlat1.setWaves(WavesType.DEFAULT);

        btnFlat2.setType(ButtonType.FLAT);
        btnFlat2.setText("Primary (No Waves)");
        btnFlat2.setTextColor(Color.BLUE);

        btnFlat3.setType(ButtonType.FLAT);
        btnFlat3.setText("Disabled");
        btnFlat3.setWaves(WavesType.DEFAULT);
        btnFlat3.setEnabled(false);

        btnFlat4.setType(ButtonType.FLAT);
        btnFlat4.setText("Warn");
        btnFlat4.setTextColor(Color.RED);
        btnFlat4.setWaves(WavesType.RED);
    }

    private void buildFloating() {
        btnFloating1.setType(ButtonType.FLOATING);
        btnFloating1.setWaves(WavesType.LIGHT);
        btnFloating1.setSize(ButtonSize.LARGE);
        btnFloating1.setBackgroundColor(Color.RED);
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
        btnFloating5.setIconColor(Color.GREEN);
        btnFloating5.setBackgroundColor(Color.WHITE);
        btnFloating5.setIconType(IconType.ANDROID);
    }

    private void buildRaised() {
        btn1.setText("Button");
        btn1.setBackgroundColor(Color.WHITE);
        btn1.setTextColor(Color.BLACK);
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
        btn4.setBackgroundColor(Color.RED);
        btn4.setIconPosition(IconPosition.RIGHT);

        btn5.setText("Icon Color");
        btn5.setWaves(WavesType.RED);
        btn5.setIconType(IconType.POLYMER);
        btn5.setIconColor(Color.RED);
        btn5.setBackgroundColor(Color.WHITE);
        btn5.setTextColor(Color.BLACK);
        btn5.setIconPosition(IconPosition.RIGHT);
    }
}
