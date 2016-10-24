package gwt.material.demo.errai.client.local.page.components;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.client.ui.MaterialPushpin;
import gwt.material.design.client.ui.MaterialTitle;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "pushpin")
public class PushpinPage extends PageBase {

    @Inject
    @DataField
    MaterialTitle target;

    @PostConstruct
    public void init() {
        initPage("Push Pin", "Pushpin is our fixed positioning plugin. You can check out our live examples: the fixed Table of Contents on the right.", COMPONENTS);
        target.setTitle("Pushpin");
        target.setDescription("This will be pinned on scroll and go out side of the card");
        MaterialPushpin.apply(target, 300, 200, 200);
    }
}
