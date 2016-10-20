package gwt.material.demo.errai.client.local.page.addins;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.client.constants.Color;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;

@Templated
@Page(path = "masonry")
public class MasonryPage extends PageBase {

    @PostConstruct
    public void init() {
        initPage("Masonry", "Masonry works by placing elements in optimal position based on available vertical space, sort of like a mason fitting stones in a wall.", ADDINS);
    }
}
