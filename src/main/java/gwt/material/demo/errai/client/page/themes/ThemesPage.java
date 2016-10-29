package gwt.material.demo.errai.client.page.themes;

import gwt.material.demo.errai.client.local.page.AbstractPage;
import gwt.material.demo.errai.client.local.page.PageCategory;
import gwt.material.demo.errai.client.page.PageCategory;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.Templated;

@Templated
@Page(path = "themes")
public class ThemesPage extends AbstractPage {

    @Override
    public String getName() {
        return "Themes";
    }

    @Override
    public String getDescription() {
        return "Learn how to easily start using GWT Material Themes in your app.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.THEMES;
    }
}
