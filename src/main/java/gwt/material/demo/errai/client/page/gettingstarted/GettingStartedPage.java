package gwt.material.demo.errai.client.page.gettingstarted;

import gwt.material.demo.errai.client.local.page.AbstractPage;
import gwt.material.demo.errai.client.local.page.PageCategory;
import gwt.material.demo.errai.client.page.PageCategory;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;

@Templated
@Page(path = "getting_started")
public class GettingStartedPage extends AbstractPage {

    @Override
    public String getName() {
        return "Getting Started";
    }

    @Override
    public String getDescription() {
        return "Learn how to easily start using GWT Material + Errai in to your app.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.GETTING_STARTED;
    }
}
