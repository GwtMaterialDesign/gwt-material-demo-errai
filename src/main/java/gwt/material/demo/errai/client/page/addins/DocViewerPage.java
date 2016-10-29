package gwt.material.demo.errai.client.page.addins;

import gwt.material.demo.errai.client.local.page.AbstractPage;
import gwt.material.demo.errai.client.local.page.PageCategory;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.addins.client.docviewer.MaterialDocViewer;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "docviewer")
public class DocViewerPage extends AbstractPage {

    @Inject
    @DataField
    MaterialDocViewer docViewer;

    @Override
    public String getName() {
        return "DocViewer";
    }

    @Override
    public String getDescription() {
        return "A document viewer for your word, excel, powerpoint, pdf and other supported file types " +
               "Note that this viewer only work with public files.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.ADDINS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
        buildDocViewer();
    }

    private void buildDocViewer() {
        docViewer.setWidth("100%");
        docViewer.setHeight("600px");
        docViewer.setUrl("http://www.khazanah.com.my/khazanah/files/20/200f21f3-07ff-4903-ab99-7c0cb557eb51.pdf");
    }
}
