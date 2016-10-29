package gwt.material.demo.errai.client.page.addins;

import gwt.material.demo.errai.client.local.page.AbstractPage;
import gwt.material.demo.errai.client.local.page.PageCategory;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.addins.client.iconmorph.MaterialIconMorph;
import gwt.material.design.client.constants.IconSize;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialIcon;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "iconmorph")
public class IconMorphPage extends AbstractPage {

    @Inject
    @DataField
    MaterialIconMorph iconMorph;

    @Inject
    @DataField
    MaterialIconMorph iconMorphTiny, iconMorphSmall, iconMorphMedium, iconMorphLarge;

    @Override
    public String getName() {
        return "Icon Morph";
    }

    @Override
    public String getDescription() {
        return "Provides visual continuity by morphing two material icons.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.ADDINS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
        buildBasic(iconMorph);
        buildSizes();
    }

    private void buildSizes() {
        iconMorphTiny.setIconSize(IconSize.TINY);
        buildBasic(iconMorphTiny);
        iconMorphSmall.setIconSize(IconSize.SMALL);
        buildBasic(iconMorphSmall);
        iconMorphMedium.setIconSize(IconSize.MEDIUM);
        buildBasic(iconMorphMedium);
        iconMorphLarge.setIconSize(IconSize.LARGE);
        buildBasic(iconMorphLarge);
    }

    private void buildBasic(MaterialIconMorph iconMorph) {
        MaterialIcon icon = new MaterialIcon(IconType.MENU);
        MaterialIcon icon2 = new MaterialIcon(IconType.ARROW_BACK);
        iconMorph.add(icon);
        iconMorph.add(icon2);
    }
}
