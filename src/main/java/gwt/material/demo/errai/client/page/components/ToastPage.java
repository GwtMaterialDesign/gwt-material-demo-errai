package gwt.material.demo.errai.client.page.components;

import gwt.material.demo.errai.client.local.page.AbstractPage;
import gwt.material.demo.errai.client.local.page.PageCategory;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialToast;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "toast")
public class ToastPage extends AbstractPage {

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

    @Override
    public String getName() {
        return "Toast";
    }

    @Override
    public String getDescription() {
        return "Toast provides brief feedback about an operation through a message at the bottom of the screen.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.COMPONENTS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
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
