package gwt.material.demo.errai.client.local.page.addins;

import gwt.material.demo.errai.client.local.page.PageBase;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;

@Templated
@Page(path = "camera")
public class CameraPage extends PageBase {

    @PostConstruct
    public void init() {
        initPage("Camera", "MaterialCameraCapture is a widget that captures the video stream from the camera, using the MediaDevices.getUserMedia() (Streams API). This widget can capture images from the video, to allow the upload to the server of photos from the camera.", ADDINS);
    }
}
