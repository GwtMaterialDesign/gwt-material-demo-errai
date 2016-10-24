package gwt.material.demo.errai.client.local.page.addins;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.client.constants.Color;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;

@Templated
@Page(path = "waterfall")
public class WaterfallPage extends PageBase {

    @PostConstruct
    public void init() {
        initPage("Waterfall", "Act like a collapsible header below the nav bar component when scrolling up / down to provide delightful transition of components.", ADDINS);
    }
}
