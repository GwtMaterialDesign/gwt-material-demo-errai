package gwt.material.demo.errai.client.page.components;

import com.google.gwt.dom.client.Style;
import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialNavBar;
import gwt.material.design.client.ui.MaterialNavBrand;
import gwt.material.design.client.ui.MaterialNavSection;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "navbar")
public class NavBarPage extends AbstractPage {

    private final int BASIC = 0;
    private final int ALIGNMENT = 1;

    @Inject
    @DataField
    private MaterialNavBar navbar1;

    @Inject
    @DataField
    private MaterialNavBar navbar2;

    @Override
    public String getName() {
        return "NavBar";
    }

    @Override
    public String getDescription() {
        return "The navbar is fully contained by an HTML5 Nav tag. Inside a recommended container div, " +
               "there are 2 main parts of the navbar. A logo or brand link, and the navigations links. " +
               "You can align these links to the left or right.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.COMPONENTS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
        buildNavBar(navbar1, BASIC);
        buildNavBar(navbar2, ALIGNMENT);
    }

    private void buildNavBar(MaterialNavBar navBar, int type) {
        MaterialNavBrand navBrand = new MaterialNavBrand();
        navBrand.setMarginLeft(60);
        navBrand.setText("App Title");
        MaterialNavSection navSection = new MaterialNavSection();
        MaterialLink link = new MaterialLink();
        link.setIconType(IconType.POLYMER);
        link.setText("Link 1");
        MaterialLink icon = new MaterialLink();
        icon.setIconType(IconType.POLYMER);
        navSection.add(link);
        navSection.add(icon);
        if (type == ALIGNMENT) {
            navSection.setFloat(Style.Float.LEFT);
            navBrand.setFloat(Style.Float.RIGHT);
        } else {
            navSection.setFloat(Style.Float.RIGHT);
            navBrand.setFloat(Style.Float.LEFT);
        }
        navBar.add(navBrand);
        navBar.add(navSection);
    }
}
