package gwt.material.demo.errai.client.page.addins;

import gwt.material.demo.errai.client.events.CodeCutOutEvent;
import gwt.material.demo.errai.client.events.SearchCutOutEvent;
import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.addins.client.cutout.MaterialCutOut;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconSize;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialTitle;
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
    private MaterialButton btnCodeCutout, btnSearchCutout;

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
        MaterialCutOut cutOut = new MaterialCutOut();
        cutOut.setTextAlign(TextAlign.CENTER);
        // Building the content of the cutout
        MaterialTitle title = new MaterialTitle("Customized Cutout", "Here is a custom cutout content implementation.");
        title.setTextColor(Color.WHITE);
        cutOut.add(title);

        MaterialButton btnClose = new MaterialButton("Close");
        btnClose.addClickHandler(clickEvent -> cutOut.close());
        cutOut.add(btnClose);

        // Cutout Properties
        cutOut.setBackgroundColor(Color.PURPLE);
        cutOut.setOpacity(0.8);
        cutOut.setTarget(btnCodeCutout);

        btnCodeCutout.addClickHandler(clickEvent -> cutOut.open());
    }

    @Override
    protected void onShown() {
        searchCutOut.fire(new SearchCutOutEvent());
    }
}
