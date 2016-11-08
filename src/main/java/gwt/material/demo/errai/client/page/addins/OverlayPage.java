package gwt.material.demo.errai.client.page.addins;

import gwt.material.demo.errai.client.ThemeManager;
import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.addins.client.overlay.MaterialOverlay;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialTitle;
import gwt.material.design.client.ui.MaterialToast;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "overlay")
public class OverlayPage extends AbstractPage {

    @Inject
    @DataField
    MaterialOverlay overlayBasic, overlayEvents;

    @Inject
    @DataField
    MaterialButton btnOverlay, btnOverlayEvents;

    @PostConstruct
    public void init() {
        buildBasic();
        buildEvents();
    }

    public void buildEvents() {
        overlayEvents.addOpenHandler(openEvent -> MaterialToast.fireToast("Opened Overlay"));
        overlayEvents.addCloseHandler(closeEvent -> MaterialToast.fireToast("Closed Overlay"));
        buildOverlay(btnOverlayEvents, overlayEvents);
    }

    public void buildBasic() {
        buildOverlay(btnOverlay, overlayBasic);
    }

    protected void buildOverlay(MaterialButton btnOverlay, MaterialOverlay overlay) {
        ThemeManager.register(overlay);
        btnOverlay.setText("Open Overlay");
        btnOverlay.addClickHandler(e -> overlay.open(btnOverlay));

        MaterialRow row = new MaterialRow();
        row.setTextAlign(TextAlign.CENTER);

        MaterialTitle title = new MaterialTitle("This is an overlay", "Some content goes here");
        title.setMarginBottom(40);
        title.setTextColor(Color.WHITE);
        row.add(title);

        MaterialButton btnClose = new MaterialButton();
        btnClose.setText("Close Overlay");
        btnClose.addClickHandler(clickEvent -> overlay.close());
        row.add(btnClose);

        overlay.add(row);
    }

    @Override
    public String getName() {
        return "Overlay";
    }

    @Override
    public String getDescription() {
        return "Provides a meaningful transition of source widget to popup or overlay panel.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.ADDINS;
    }
}
