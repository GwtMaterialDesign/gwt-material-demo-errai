package gwt.material.demo.errai.client.page.addins;

import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.Templated;

@Templated
@Page(path = "waterfall")
public class WaterfallPage extends AbstractPage {

    @Override
    public String getName() {
        return "Waterfall";
    }

    @Override
    public String getDescription() {
        return "Act like a collapsible header below the nav bar component when scrolling up / down to provide delightful transition of components.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.ADDINS;
    }
}
