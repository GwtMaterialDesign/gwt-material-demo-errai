package gwt.material.demo.errai.client.local.page.components;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.*;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Templated
@Page(path = "tab")
@ApplicationScoped
public class TabsPage extends PageBase {

    @Inject
    @DataField
    MaterialTab tabBasic;


    @PostConstruct
    public void init() {
        initPage("Tabs", "The tabs structure consists of an unordered list of tabs that have hashes corresponding to tabBasic ids. Then when you click on each tabBasic, only the container with the corresponding tabBasic id will become visible.", COMPONENTS);
    }

    @Override
    public void page() {
        super.page();
        for (int i = 1; i <= 3; i++) {
            MaterialTabItem item = new MaterialTabItem();
            item.add(new MaterialLink("Item " + i, "#test"));
           // tabBasic.add(item);
        }
    }
}
