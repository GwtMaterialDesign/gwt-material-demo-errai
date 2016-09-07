package gwt.material.demo.errai.client.local.page.components;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialBreadcrumb;
import gwt.material.design.client.ui.MaterialNavBar;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "breadcrumbs")
public class BreadcrumbsPage extends PageBase {

    @Inject
    @DataField
    MaterialNavBar navbar1;

    @Inject
    @DataField
    MaterialNavBar navbar2;

    @Inject
    @DataField
    MaterialNavBar navbar3;

    @PostConstruct
    public void init() {
        initPage("Breadcrumbs", "Breadcrumbs are a good way to display your current location. This is usually used when you have multiple layers of content.", COMPONENTS_COLOR);
        buildTextOnly();
        buildOnlyIcons();
        buildWithIcons();
    }

    private void buildWithIcons() {
        MaterialBreadcrumb breadcrumb1 = new MaterialBreadcrumb();
        breadcrumb1.setText("First");
        breadcrumb1.setIconType(IconType.POLYMER);

        MaterialBreadcrumb breadcrumb2 = new MaterialBreadcrumb();
        breadcrumb2.setText("Second");
        breadcrumb2.setIconType(IconType.STAR);

        MaterialBreadcrumb breadcrumb3 = new MaterialBreadcrumb();
        breadcrumb3.setText("Third");
        breadcrumb3.setIconType(IconType.MOTORCYCLE);

        navbar3.add(breadcrumb1);
        navbar3.add(breadcrumb2);
        navbar3.add(breadcrumb3);
    }

    private void buildOnlyIcons() {
        MaterialBreadcrumb breadcrumb1 = new MaterialBreadcrumb();
        breadcrumb1.setIconType(IconType.POLYMER);

        MaterialBreadcrumb breadcrumb2 = new MaterialBreadcrumb();
        breadcrumb2.setIconType(IconType.STAR);

        MaterialBreadcrumb breadcrumb3 = new MaterialBreadcrumb();
        breadcrumb3.setIconType(IconType.MOTORCYCLE);

        navbar2.add(breadcrumb1);
        navbar2.add(breadcrumb2);
        navbar2.add(breadcrumb3);
    }

    private void buildTextOnly() {
        MaterialBreadcrumb breadcrumb1 = new MaterialBreadcrumb();
        breadcrumb1.setText("First");

        MaterialBreadcrumb breadcrumb2 = new MaterialBreadcrumb();
        breadcrumb2.setText("Second");

        MaterialBreadcrumb breadcrumb3 = new MaterialBreadcrumb();
        breadcrumb3.setText("Third");

        navbar1.add(breadcrumb1);
        navbar1.add(breadcrumb2);
        navbar1.add(breadcrumb3);
    }
}
