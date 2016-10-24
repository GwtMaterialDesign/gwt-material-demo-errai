package gwt.material.demo.errai.client.local.page.gettingstarted;

import gwt.material.demo.errai.client.local.page.PageBase;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@Templated
@Page(path = "getting_started")
public class GettingStartedPage extends PageBase {

    @PostConstruct
    public void init() {
        initPage("Getting Started", "Learn how to easily start using GWT Material + Errai in to your app.", GETTING_STARTED);
    }
}
