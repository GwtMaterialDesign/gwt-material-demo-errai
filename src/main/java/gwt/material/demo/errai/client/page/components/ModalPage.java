package gwt.material.demo.errai.client.page.components;

import gwt.material.demo.errai.client.local.page.AbstractPage;
import gwt.material.demo.errai.client.local.page.PageCategory;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.client.constants.ModalType;
import gwt.material.design.client.ui.*;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import static gwt.material.design.client.constants.ButtonType.FLAT;

@Templated
@Page(path = "modals")
public class ModalPage extends AbstractPage {

    @Inject
    @DataField
    MaterialModal modalBasic;

    @Inject
    @DataField
    MaterialButton btnBasic;

    @Inject
    @DataField
    MaterialModal modalFixedFooter;

    @Inject
    @DataField
    MaterialButton btnFixedFooter;

    @Inject
    @DataField
    MaterialModal modalBottomSheet;

    @Inject
    @DataField
    MaterialButton btnBottomSheet;

    @Inject
    @DataField
    MaterialModal modalAutoHide;

    @Inject
    @DataField
    MaterialButton btnAutoHide;

    @Inject
    @DataField
    MaterialModal modalEvents;

    @Inject
    @DataField
    MaterialButton btnEvents;

    @Override
    public String getName() {
        return "Modals";
    }

    @Override
    public String getDescription() {
        return "Modal component allows for verification of user actions, simple data input, and alerts to provide extra information to users.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.COMPONENTS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
        buildBasic();
        buildFixedFooter();
        buildBottomSheet();
        buildAutoHide();
        buildEvents();
    }

    private void buildEvents() {
        modalEvents.addCloseHandler(closeEvent -> {
            MaterialToast.fireToast("Closed Modal");
        });

        modalEvents.addOpenHandler(openEvent -> {
            MaterialToast.fireToast("Opened Modal");
        });
        buildModal(modalEvents, btnEvents);
    }

    private void buildAutoHide() {
        modalAutoHide.setDismissible(true);
        buildModal(modalAutoHide, btnAutoHide);
    }

    private void buildBottomSheet() {
        modalBottomSheet.setType(ModalType.BOTTOM_SHEET);
        buildModal(modalBottomSheet, btnBottomSheet);
    }

    private void buildFixedFooter() {
        modalFixedFooter.setType(ModalType.FIXED_FOOTER);
        buildModal(modalFixedFooter, btnFixedFooter);
    }

    private void buildBasic() {
        buildModal(modalBasic, btnBasic);
    }

    private void buildModal(MaterialModal modal, MaterialButton activator) {
        MaterialModalContent content = new MaterialModalContent();
        MaterialTitle title = new MaterialTitle();
        title.setTitle("Default Modal");
        title.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum");
        content.add(title);

        MaterialModalFooter footer = new MaterialModalFooter();
        MaterialButton btnClose = new MaterialButton();
        btnClose.addClickHandler(clickEvent -> {
            modal.close();
        });
        btnClose.setText("Close");
        btnClose.setType(FLAT);
        footer.add(btnClose);
        modal.add(content);
        modal.add(footer);

        activator.setText("Open Modal");
        activator.addClickHandler(clickEvent -> {
            modal.open();
        });
    }
}
