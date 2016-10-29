package gwt.material.demo.errai.client.page.addins;

import com.google.gwt.user.client.ui.SuggestOracle;
import gwt.material.demo.errai.client.dto.DataHelper;
import gwt.material.demo.errai.client.dto.User;
import gwt.material.demo.errai.client.dto.UserOracle;
import gwt.material.demo.errai.client.dto.DataHelper;
import gwt.material.demo.errai.client.dto.User;
import gwt.material.demo.errai.client.dto.UserOracle;
import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.addins.client.autocomplete.MaterialAutoComplete;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialModalContent;
import gwt.material.design.client.ui.MaterialToast;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.inject.Inject;
import java.util.List;

@Templated
@Page(path = "autocomplete")
public class AutocompletePage extends AbstractPage {

    @Inject
    @DataField
    MaterialAutoComplete ac1;

    @Inject
    @DataField
    MaterialButton btnGetAllStates, btnClear;

    @Inject
    @DataField
    MaterialAutoComplete ac2;

    @Inject
    @DataField
    MaterialAutoComplete ac3;

    @Inject
    @DataField
    MaterialModal modal;

    @Inject
    @DataField
    MaterialButton btnModal;

    @Override
    public String getName() {
        return "Autocomplete";
    }

    @Override
    public String getDescription() {
        return "Autocompletes are the best way for selecting items easily and grouping them into chips for searches on item values.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.ADDINS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
        buildBasic();
        buildEvents();
        buildItemLimit();
        buildModal();
    }

    private void buildModal() {
        MaterialModalContent content = new MaterialModalContent();
        modal.setDismissible(true);
        modal.add(content);
        MaterialAutoComplete ac4 = new MaterialAutoComplete();
        UserOracle oracle = new UserOracle();
        oracle.addContacts(getAllUsers());
        ac4.setPlaceholder("Contacts");
        ac4.setSuggestions(oracle);
        ac4.setLimit(3);
        content.add(ac4);

        btnModal.setText("Open Modal");
        btnModal.addClickHandler(clickEvent -> {
            modal.open();
        });
    }

    private void buildItemLimit() {
        UserOracle oracle = new UserOracle();
        oracle.addContacts(getAllUsers());
        ac3.setPlaceholder("Contacts");
        ac3.setSuggestions(oracle);
        ac3.setLimit(3);
    }

    private void buildEvents() {
        UserOracle oracle = new UserOracle();
        oracle.addContacts(getAllUsers());
        ac2.setPlaceholder("Contacts");
        ac2.setSuggestions(oracle);
        ac2.addSelectionHandler(selectionEvent -> {
            MaterialToast.fireToast(selectionEvent.getSelectedItem().getDisplayString());
        });

        ac2.addValueChangeHandler(valueChangeEvent -> {
            for (SuggestOracle.Suggestion user : valueChangeEvent.getValue()) {
                MaterialToast.fireToast(user.getDisplayString());
            }
        });
    }

    private void buildBasic() {
        UserOracle oracle = new UserOracle();
        oracle.addContacts(getAllUsers());
        ac1.setPlaceholder("Contacts");
        ac1.setSuggestions(oracle);
        btnGetAllStates.setText("Get All States");
        btnGetAllStates.addClickHandler(clickEvent -> {
            for (SuggestOracle.Suggestion user : ac1.getValue()) {
                MaterialToast.fireToast("Value : " + user.getDisplayString());
            }
        });
        btnClear.setText("Clear");
        btnClear.setTextColor(Color.BLACK);
        btnClear.setBackgroundColor(Color.WHITE);
        btnClear.addClickHandler(clickEvent -> {
            ac1.clear();
        });
    }

    public List<User> getAllUsers() {
        return DataHelper.getAllUsers();
    }
}
