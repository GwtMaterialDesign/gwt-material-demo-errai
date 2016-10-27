package gwt.material.demo.errai.client.local.page.themes;

import gwt.material.demo.errai.client.local.page.PageBase;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;

@Templated
@Page(path = "themes")
public class ThemesPage extends PageBase {

    @PostConstruct
    public void init() {
        initPage(this, "Themes", "Learn how to easily start using GWT Material Themes in your app.", THEMES);
    }
}
