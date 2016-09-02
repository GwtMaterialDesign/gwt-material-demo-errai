package gwt.material.demo.errai.client.local.page.addins;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.addins.client.richeditor.MaterialRichEditor;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "richeditor")
public class RichEditorPage extends PageBase {

    @Inject
    @DataField
    MaterialRichEditor rich;

    @PostConstruct
    public void init() {
        initPage("Rich Editor", "", ADDINS_COLOR);
    }

}
