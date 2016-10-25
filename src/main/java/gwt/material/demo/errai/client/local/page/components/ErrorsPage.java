package gwt.material.demo.errai.client.local.page.components;

import gwt.material.demo.errai.client.local.dto.DataHelper;
import gwt.material.demo.errai.client.local.dto.User;
import gwt.material.demo.errai.client.local.dto.UserOracle;
import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.addins.client.autocomplete.MaterialAutoComplete;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@Templated
@Page(path = "errors")
@ApplicationScoped
public class ErrorsPage extends PageBase {

    @Inject
    @DataField
    MaterialAutoComplete autocomplete;

    @PostConstruct
    public void init() {
        initPage("Errors", "Errors occur when an app fails to complete what is expected, such as: 1. The app does not understand user input,2. The system or app fails , 3. A user intends to run incompatible operations concurrently", ADDINS);
        buildAutocomplete();
    }

    private void buildAutocomplete() {
        UserOracle oracle = new UserOracle();
        oracle.addContacts(getAllUsers());
        autocomplete.setPlaceholder("Contacts");
        autocomplete.setSuggestions(oracle);
    }

    public List<User> getAllUsers() {
        return DataHelper.getAllUsers();
    }
}
