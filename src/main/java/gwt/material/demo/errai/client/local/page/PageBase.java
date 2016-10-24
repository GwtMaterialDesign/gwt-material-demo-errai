package gwt.material.demo.errai.client.local.page;

import com.google.gwt.user.client.ui.Composite;
import gwt.material.demo.errai.client.local.events.PageChangeEvent;
import gwt.material.design.client.constants.Color;
import gwt.material.design.jquery.client.api.JQueryElement;
import org.jboss.errai.ui.nav.client.local.PageShown;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import static gwt.material.design.jquery.client.api.JQuery.$;

/**
 * Created by kevin on 9/1/2016.
 */
public class PageBase extends Composite {

    public static final int ABOUT = 1;
    public static final int GETTING_STARTED = 2;
    public static final int COMPONENTS = 3;
    public static final int ADDINS = 4;
    public static final int ANIMATIONS = 5;

    @Inject
    private Event<PageChangeEvent> pageChangeEvent;

    public void initPage(String title, String description, int type) {
        Color color = Color.BLUE;
        Color secondaryColor = Color.BLUE_DARKEN_1;
        switch (type) {
            case ABOUT:
                color = Color.BLUE;
                secondaryColor = Color.BLUE_DARKEN_1;
                break;
            case GETTING_STARTED:
                color = Color.GREEN;
                secondaryColor = Color.GREEN_DARKEN_1;
                break;
            case COMPONENTS:
                color = Color.INDIGO;
                secondaryColor = Color.INDIGO_DARKEN_1;
                break;
            case ADDINS:
                color = Color.RED;
                secondaryColor = Color.RED_DARKEN_1;
                break;
            case ANIMATIONS:
                color = Color.ORANGE;
                secondaryColor = Color.ORANGE_DARKEN_1;
                break;
            default:
                break;
        }
        pageChangeEvent.fire(new PageChangeEvent(title, description, color, secondaryColor));
    }

    @PageShown
    public void page() {
        $(".code i").on("click", e -> {
            JQueryElement el = $(e.getCurrentTarget()).parent().find("pre");
            if (el.hasClass("active")) {
                el.removeClass("active");
            } else {
                el.addClass("active");
            }

            return true;
        });
    }
}
