package gwt.material.demo.errai.client.local.page.addins;

import gwt.material.demo.errai.client.local.page.PageBase;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;

@Templated
@Page(path = "autocomplete")
public class AutocompletePage extends PageBase {

    @PostConstruct
    public void init() {
        initPage("Autocomplete", "Description", ADDINS_COLOR);
    }
}
