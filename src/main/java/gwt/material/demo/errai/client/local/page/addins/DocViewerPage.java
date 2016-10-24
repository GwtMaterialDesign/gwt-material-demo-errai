package gwt.material.demo.errai.client.local.page.addins;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.addins.client.docviewer.MaterialDocViewer;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "docviewer")
public class DocViewerPage extends PageBase {

    @Inject
    @DataField
    MaterialDocViewer docViewer;

    @PostConstruct
    public void init() {
        initPage("DocViewer", "A document viewer for your word, excel, powerpoint, pdf and other supported file types Note that this viewer only work with public files.", ADDINS);
        buildDocViewer();
    }

    private void buildDocViewer() {
        docViewer.setWidth("100%");
        docViewer.setHeight("600px");
        docViewer.setUrl("http://www.khazanah.com.my/khazanah/files/20/200f21f3-07ff-4903-ab99-7c0cb557eb51.pdf");
    }
}
