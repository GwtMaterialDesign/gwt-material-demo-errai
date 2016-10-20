package gwt.material.demo.errai.client.local.page.addins;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.client.constants.Color;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;

@Templated
@Page(path = "fileuploader")
public class FileUploaderPage extends PageBase {

    @PostConstruct
    public void init() {
        initPage("File Uploader", "Custom file uploader with Dnd support with the help of dropzone.js. It has multiple feature just like the GWT File Uploader core widget.", ADDINS);
    }
}
