package gwt.material.demo.errai.client.page.addins;

import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;

@Templated
@Page(path = "camera")
public class CameraPage extends AbstractPage {

    @Override
    public String getName() {
        return "Camera";
    }

    @Override
    public String getDescription() {
        return "MaterialCameraCapture is a widget that captures the video stream from the camera, using the MediaDevices.getUserMedia() (Streams API). This widget can capture images from the video, to allow the upload to the server of photos from the camera.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.ADDINS;
    }
}
