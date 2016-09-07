package gwt.material.demo.errai.client.local.page.addins;

import com.google.gwt.user.client.ui.SuggestOracle;
import gwt.material.demo.errai.client.local.dto.User;
import gwt.material.demo.errai.client.local.dto.UserOracle;
import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.addins.client.autocomplete.MaterialAutoComplete;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialModalContent;
import gwt.material.design.client.ui.MaterialToast;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Templated
@Page(path = "autocomplete")
public class AutocompletePage extends PageBase {

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

    @PostConstruct
    public void init() {
        initPage("Autocomplete", "Autocompletes are best way for selecting item easily and grouped them into chips for later search based on item values.", ADDINS_COLOR);
        buildBasic();
        buildEvents();
        buildItemLimit();
        buildModal();
    }

    private void buildModal() {
        MaterialModalContent content = new MaterialModalContent();
        modal.setDismissable(true);
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
            for(SuggestOracle.Suggestion user : valueChangeEvent.getValue()) {
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
            for(SuggestOracle.Suggestion user : ac1.getValue()){
                MaterialToast.fireToast("Value : " + user.getDisplayString());
            }
        });
        btnClear.setText("Clear");
        btnClear.setTextColor("black");
        btnClear.setBackgroundColor("white");
        btnClear.addClickHandler(clickEvent -> {
            ac1.clear();
        });
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/stevedesigner/128.jpg", User.Position.DEVELOPER, true, "Luis Hoppe", "luis@mail.com", "123123123", "718-555-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/yassiryahya/128.jpg", User.Position.DEVELOPER, true, "Irwin Mueller", "irwin@mail.com", "123123123", "718-432-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/lebinoclard/128.jpg", User.Position.DEVELOPER, true, "Levin Card", "levin@mail.com", "123123123", "432-555-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/lmjabreu/128.jpg", User.Position.DEVELOPER, false, "Dr. Cassie Keeling", "cassie@mail.com", "123123123", "432-555-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/ariil/128.jpg", User.Position.DEVELOPER, false, "Dr. Madelynn Schamberger", "madelyn@mail.com", "123123123", "543-555-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/devankoshal/128.jpg", User.Position.MARKETING, false, "Dominique Schmidt", "dom@mail.com", "123123123", "718-657-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/karthipanraj/128.jpg", User.Position.CTO, false, "Rowland Heller", "rowland@mail.com", "123123123", "718-765-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/GavicoInd/128.jpg", User.Position.CEO, false, "Quincy Schimmel", "quincy@mail.com", "123123123", "46-555-876", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/roybarberuk/128.jpg", User.Position.MARKETING, false, "Tierra VonRueden", "tierra@mail.com", "123123123", "654-56-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/kimcool/128.jpg", User.Position.MARKETING, false, "Travis Larson", "travis@mail.com", "123123123", "465-456-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/tonymillion/128.jpg", User.Position.MARKETING, false, "Clint Heller", "clint@mail.com", "123123123", "645-555-65", "Makati City, Philippines", "Gwt Material"));
        return list;
    }
}
