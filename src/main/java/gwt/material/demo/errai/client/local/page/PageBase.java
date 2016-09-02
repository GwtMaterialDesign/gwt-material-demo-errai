package gwt.material.demo.errai.client.local.page;

import com.google.gwt.user.client.ui.Composite;
import gwt.material.demo.errai.client.local.events.PageChangeEvent;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.jquery.client.api.JQueryElement;
import org.jboss.errai.ui.nav.client.local.PageShown;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import static gwt.material.design.jquery.client.api.JQuery.$;

/**
 * Created by kevin on 9/1/2016.
 */
public class PageBase extends Composite {

    public static final String ABOUT_COLOR = "blue";
    public static final String COMPONENTS_COLOR = "blue";
    public static final String ADDINS_COLOR = "red";

    @Inject
    private Event<PageChangeEvent> pageChangeEvent;

    public void initPage(String title, String description, String color) {
        pageChangeEvent.fire(new PageChangeEvent(title, description, color));
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
