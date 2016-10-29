package gwt.material.demo.errai.client.page.components;

import gwt.material.demo.errai.client.local.page.AbstractPage;
import gwt.material.demo.errai.client.local.page.PageCategory;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.client.ui.MaterialPushpin;
import gwt.material.design.client.ui.MaterialTitle;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "pushpin")
public class PushpinPage extends AbstractPage {

    @Inject
    @DataField
    MaterialTitle target;

    @Override
    public String getName() {
        return "Push Pin";
    }

    @Override
    public String getDescription() {
        return "Pushpin is our fixed positioning plugin. You can check out our live examples: the fixed Table of Contents on the right.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.COMPONENTS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
        target.setTitle("Pushpin");
        target.setDescription("This will be pinned on scroll and go out side of the card");
        MaterialPushpin.apply(target, 300, 200, 200);
    }
}
