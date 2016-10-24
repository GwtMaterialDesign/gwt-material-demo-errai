package gwt.material.demo.errai.client.local.page.addins;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.client.constants.Color;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@Templated
@Page(path = "scrollfire")
@ApplicationScoped
public class ScrollfirePage extends PageBase {

    @PostConstruct
    public void init() {
        initPage("Scrollfire", "Executes callback functions depending on how far into the page you've scrolled.", ADDINS);
    }
}
