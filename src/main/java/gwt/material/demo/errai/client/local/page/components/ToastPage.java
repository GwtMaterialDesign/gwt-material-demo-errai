package gwt.material.demo.errai.client.local.page.components;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialToast;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Templated
@Page(path = "toast")
@ApplicationScoped
public class ToastPage extends PageBase {

    @Inject
    @DataField
    MaterialButton btnBasic;

    @Inject
    @DataField
    MaterialButton btnWithAction;

    @Inject
    @DataField
    MaterialButton btnStyle;

    @Inject
    @DataField
    MaterialButton btnCallback;

    @PostConstruct
    public void init() {
        initPage("Toast", "Toast provides brief feedback about an operation through a message at the bottom of the screen.", COMPONENTS_COLOR);
        buildBasic();
        buildWithAction();
        buildStyle();
        buildCallback();
    }

    private void buildCallback() {
        btnCallback.setText("Open Toast");
        btnCallback.addClickHandler(clickEvent -> {
            new MaterialToast(() -> {
                MaterialToast.fireToast("BANG!");
            }).toast("Explosion in: 5, 4, 3, 2, 1", 5000);
        });
    }

    private void buildStyle() {
        btnStyle.setText("Open Toast");
        btnStyle.addClickHandler(clickEvent -> {
            MaterialToast.fireToast("I love Material Design", "rounded");
        });
    }

    private void buildWithAction() {
        btnWithAction.setText("Open Toast");
        btnWithAction.addClickHandler(clickEvent -> {
            MaterialLink link = new MaterialLink("UNDO");
            link.addClickHandler(clickEvent1 -> {
                MaterialToast.fireToast("UNDO DONE");
            });
            new MaterialToast(link).toast("Item Deleted");
        });
    }

    private void buildBasic() {
        btnBasic.setText("Open Toast");
        btnBasic.addClickHandler(clickEvent -> {
            MaterialToast.fireToast("I love Material Design");
        });
    }
}
