package gwt.material.demo.errai.client.page;

import com.google.gwt.user.client.ui.Composite;
import gwt.material.demo.errai.client.events.PageChangeEvent;
import gwt.material.demo.errai.client.local.events.PageChangeEvent;
import gwt.material.design.client.constants.Color;
import gwt.material.design.jquery.client.api.JQueryElement;
import org.jboss.errai.ui.nav.client.local.PageShown;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import static gwt.material.design.jquery.client.api.JQuery.$;

public abstract class AbstractPage extends Composite {

    private String CODE_PREFIX = "https://github.com/GwtMaterialDesign/gwt-material-demo-errai/blob/master/src/main/java/gwt/material/demo/errai/client/local/page/";

    @Inject
    private Event<PageChangeEvent> pageChangeEvent;

    abstract public String getName();

    abstract public String getDescription();

    abstract public PageCategory getCategory();

    @PostConstruct
    protected void onPostConstruct() {
        Color color = Color.BLUE;
        PageCategory category = getCategory();
        switch (category) {
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
        pageChangeEvent.fire(new PageChangeEvent(category, getName(), getDescription(), color,
            CODE_PREFIX + getClass().getSimpleName() + ".html", CODE_PREFIX + getClass().getSimpleName() + ".java"));
    }

    @PageShown
    public void onShown() {
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
