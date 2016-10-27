package gwt.material.demo.errai.client.local.page;

import com.google.gwt.user.client.ui.Composite;
import gwt.material.demo.errai.client.local.events.PageChangeEvent;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.jquery.client.api.JQueryElement;
import org.jboss.errai.ui.nav.client.local.PageShown;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import static gwt.material.design.jquery.client.api.JQuery.$;

public class PageBase extends Composite {

    public static final int ABOUT = 1;
    public static final int GETTING_STARTED = 2;
    public static final int COMPONENTS = 3;
    public static final int ADDINS = 4;
    public static final int ANIMATIONS = 5;
    public static final int THEMES = 6;

    private String CODE_PREFIX = "https://github.com/GwtMaterialDesign/gwt-material-demo-errai/blob/master/src/main/java/gwt/material/demo/errai/client/local/page/";

    @Inject
    private Event<PageChangeEvent> pageChangeEvent;

    public void initPage(PageBase page, String title, String description, int type) {
        Color color = Color.BLUE;
        switch (type) {
            case ABOUT:
                color = Color.BLUE;
                break;
            case GETTING_STARTED:
                color = Color.GREEN;
                break;
            case COMPONENTS:
                color = Color.INDIGO;
                CODE_PREFIX = CODE_PREFIX + "components/";
                break;
            case ADDINS:
                color = Color.RED;
                CODE_PREFIX = CODE_PREFIX + "addins/";
                break;
            case ANIMATIONS:
                color = Color.ORANGE;
                CODE_PREFIX = CODE_PREFIX + "animations/";
                break;
            default:
                break;
        }
        pageChangeEvent.fire(new PageChangeEvent(type, title, description, color, CODE_PREFIX + page.getClass().getSimpleName() + ".html", CODE_PREFIX + page.getClass().getSimpleName() + ".java"));
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
