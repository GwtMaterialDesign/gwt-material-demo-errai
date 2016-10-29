package gwt.material.demo.errai.client.page.addins;

import gwt.material.demo.errai.client.local.page.AbstractPage;
import gwt.material.demo.errai.client.local.page.PageCategory;
import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.addins.client.fileuploader.MaterialFileUploader;
import gwt.material.design.addins.client.fileuploader.MaterialUploadLabel;
import gwt.material.design.client.ui.MaterialPanel;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "fileuploader")
public class FileUploaderPage extends AbstractPage {

    @Inject
    @DataField
    MaterialPanel uploadPanel;

    @Override
    public String getName() {
        return "File Uploader";
    }

    @Override
    public String getDescription() {
        return "Custom file uploader with Dnd support with the help of dropzone.js. It has multiple feature" +
               " just like the GWT File Uploader core widget.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.ADDINS;
    }

    @Override
    public void onShown() {
        super.onShown();
        MaterialFileUploader fileUploader = new MaterialFileUploader();
        fileUploader.setUrl("/");
        fileUploader.add(new MaterialUploadLabel("Drag Files to Upload", "Some description here"));
        uploadPanel.add(fileUploader);
    }
}
