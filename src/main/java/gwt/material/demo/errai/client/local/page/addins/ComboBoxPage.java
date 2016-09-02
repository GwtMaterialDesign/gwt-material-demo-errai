package gwt.material.demo.errai.client.local.page.addins;

import gwt.material.demo.errai.client.local.page.PageBase;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.Templated;

@Templated
@Page(path = "combobox")
public class ComboBoxPage extends PageBase {

    /*@Inject
    @DataField
    MaterialComboBox combo1;*/

    @Override
    public void init() {
        initPage("ComboBox", "", ADDINS_COLOR);
        /*combo1.addItem("Option 1");
        combo1.addItem("Option 2");
        combo1.addItem("Option 3");*/
    }
}
