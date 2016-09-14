package gwt.material.demo.errai.client.local.page.components;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.client.constants.ImageType;
import gwt.material.design.client.ui.*;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Templated
@Page(path = "media")
@ApplicationScoped
public class MediaPage extends PageBase {

    @Inject
    @DataField
    MaterialImage image;

    @Inject
    @DataField
    MaterialImage imageCircle;

    @Inject
    @DataField
    MaterialVideo video;

    @Inject
    @DataField
    MaterialSlider slider;

    @PostConstruct
    public void init() {
        initPage("Media", "Media components include things that have to do with large media objects like Images, Video, Audio, etc.", COMPONENTS_COLOR);
        buildImage();
        buildCircleImage();
        buildVideo();
        buildSlider();
    }

    private void buildSlider() {
        for(int i = 1; i <= 3; i++) {
            MaterialSlideItem item = new MaterialSlideItem();
            MaterialImage image = new MaterialImage();
            image.setUrl("http://mayastepien.nl/googlecalendar/google-drinks.jpg");
            MaterialSlideCaption caption = new MaterialSlideCaption();
            MaterialTitle title = new MaterialTitle();
            title.setTitle("Item " + i);
            title.setDescription("Description " + i);
            caption.add(title);
            item.add(image);
            item.add(caption);
            slider.add(item);
        }
    }

    private void buildVideo() {
        video.setUrl("http://www.youtube.com/embed/Q8TXgCzxEnw?rel=0");
    }

    private void buildCircleImage() {
        imageCircle.setUrl("http://b.vimeocdn.com/ps/339/488/3394886_300.jpg");
        imageCircle.setType(ImageType.CIRCLE);
        imageCircle.setWidth("100px");
        imageCircle.setHeight("100px");
    }

    private void buildImage() {
        image.setUrl("http://assets.materialup.com/uploads/0587e4a8-6a46-4e27-b8bf-836e4350fe82/candycons.gif");
        image.setCaption("I love material design");
        image.setType(ImageType.MATERIALBOXED);
    }
}
