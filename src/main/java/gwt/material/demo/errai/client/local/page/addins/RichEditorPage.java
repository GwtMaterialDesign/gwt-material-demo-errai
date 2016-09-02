package gwt.material.demo.errai.client.local.page.addins;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.addins.client.richeditor.MaterialRichEditor;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.inject.Inject;

@Templated
@Page(path = "richeditor")
public class RichEditorPage extends PageBase {

    @Inject
    @DataField
    MaterialRichEditor rich;

    @Override
    public void init() {
        initPage("Rich Editor", "Provides a great Rich Editor with amazing options built with Material Design Look and Feel.", ADDINS_COLOR);

    }
}
