package gwt.material.demo.errai.client.page.addins;

import gwt.material.demo.errai.client.events.CodeCutOutEvent;
import gwt.material.demo.errai.client.events.SearchCutOutEvent;
import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.client.constants.IconSize;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialIcon;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.enterprise.event.Event;
import javax.inject.Inject;

@Templated
@Page(path = "cutout")
public class CutoutPage extends AbstractPage {

    @Inject
    private Event<CodeCutOutEvent> codeCutOut;

    @Inject
    private Event<SearchCutOutEvent> searchCutOut;

    @Inject
    @DataField
    MaterialButton btnCodeCutout, btnSearchCutout;

    @Override
    public String getName() {
        return "Cut Out";
    }

    @Override
    public String getDescription() {
        return "The MaterialCutOut is an excellent component to show users about new " +
               "features and important components (buttons, labels and so) on the UI.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.ADDINS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();

        btnSearchCutout.setText("Basic Cut Out");
        btnSearchCutout.addClickHandler(clickEvent -> searchCutOut.fire(new SearchCutOutEvent()));

        btnCodeCutout.setText("Customized Cut Out");
        btnCodeCutout.addClickHandler(clickEvent -> codeCutOut.fire(new CodeCutOutEvent()));
    }

    @Override
    protected void onShown() {
        searchCutOut.fire(new SearchCutOutEvent());
    }
}
