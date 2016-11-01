package gwt.material.demo.errai.client.page.styles;

import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.Templated;

@Templated
@Page(path = "helpers")
public class HelpersPage extends AbstractPage {

    @Override
    public String getName() {
        return "Helpers";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.STYLES;
    }
}
