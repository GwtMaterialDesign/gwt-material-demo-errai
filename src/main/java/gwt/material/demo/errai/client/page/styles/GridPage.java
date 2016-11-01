package gwt.material.demo.errai.client.page.styles;

import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.Templated;

@Templated
@Page(path = "grid")
public class GridPage extends AbstractPage {

    @Override
    public String getName() {
        return "Grid";
    }

    @Override
    public String getDescription() {
        return "We are using a standard 12 column fluid responsive grid system.The grid helps you layout your page in an ordered, easy fashion";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.STYLES;
    }
}
