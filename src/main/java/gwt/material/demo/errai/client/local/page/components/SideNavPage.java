package gwt.material.demo.errai.client.local.page.components;

import gwt.material.demo.errai.client.local.page.PageBase;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;

@Templated
@Page(path = "sidenav")
public class SideNavPage extends PageBase {

    @PostConstruct
    public void init() {
        initPage("SideNavs", "Scrollspy is a jQuery plugin that tracks certain elements and which element the user's screen is currently centered on. Our main demo of this is our table of contents on every documentation page to the right. Clicking on these links will also scroll the page to that element.", COMPONENTS);
    }
}
