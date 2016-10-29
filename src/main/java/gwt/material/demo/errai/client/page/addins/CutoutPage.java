package gwt.material.demo.errai.client.page.addins;

import gwt.material.demo.errai.client.ThemeManager;
import gwt.material.demo.errai.client.ThemeManager;
import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.addins.client.cutout.MaterialCutOut;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialTitle;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.inject.Inject;

@Templated
@Page(path = "cutout")
public class CutoutPage extends AbstractPage {

    @Inject
    @DataField
    MaterialIcon btnOpenCutout;

    @Inject
    @DataField
    MaterialCutOut cutout;

    @Override
    public String getName() {
        return "Cutout";
    }

    @Override
    public String getDescription() {
        return "The MaterialCutOut is an excellent component to show users about new " +
               "features and important components (buttons, labels and so) on the UI.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.ADDINS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();

        ThemeManager.register(cutout);
        cutout.setOpacity(0.8);
        cutout.setCircle(true);
        cutout.setTextAlign(TextAlign.CENTER);

        MaterialTitle title = new MaterialTitle();
        title.setTextColor(Color.WHITE);
        title.setTitle("New Feature");
        title.setDescription("Description of your new Feature");
        MaterialButton btnClose = new MaterialButton();
        btnClose.setText("Close");
        btnClose.addClickHandler(clickEvent -> {
            cutout.close();
        });
        cutout.add(title);
        cutout.add(btnClose);

        btnOpenCutout.setIconType(IconType.POLYMER);
        btnOpenCutout.addClickHandler(clickEvent -> {
            cutout.setTarget(btnOpenCutout);
            cutout.open();
        });
    }

    @Override
    public void onShown() {
        super.onShown();

        cutout.open();
    }
}
