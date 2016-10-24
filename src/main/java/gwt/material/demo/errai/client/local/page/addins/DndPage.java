package gwt.material.demo.errai.client.local.page.addins;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.client.constants.Color;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;

@Templated
@Page(path = "dnd")
public class DndPage extends PageBase {

    @PostConstruct
    public void init() {
        initPage("Drag and Drop", "Provides a delightful dragging capability.", ADDINS);
    }
}
