package gwt.material.demo.errai.client.page.components;

import gwt.material.demo.errai.client.dto.DataHelper;
import gwt.material.demo.errai.client.dto.UserOracle;
import gwt.material.demo.errai.client.local.dto.DataHelper;
import gwt.material.demo.errai.client.local.dto.User;
import gwt.material.demo.errai.client.local.dto.UserOracle;
import gwt.material.demo.errai.client.local.page.AbstractPage;
import gwt.material.demo.errai.client.local.page.PageCategory;
import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.addins.client.autocomplete.MaterialAutoComplete;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.addins.client.timepicker.MaterialTimePicker;
import gwt.material.design.client.base.HasError;
import gwt.material.design.client.ui.*;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

@Templated
@Page(path = "errors")
public class ErrorsPage extends AbstractPage {

    @Inject
    @DataField
    MaterialAutoComplete autocomplete;

    @Inject
    @DataField
    MaterialDatePicker datePicker;

    @Inject
    @DataField
    MaterialTimePicker timePicker;

    @Inject
    @DataField
    MaterialRange range;

    @Inject
    @DataField
    MaterialSwitch switch1;

    @Inject
    @DataField
    MaterialTextArea textArea;

    @Inject
    @DataField
    MaterialTextBox textBox;

    @Inject
    @DataField
    MaterialComboBox<String> comboBox;

    @Inject
    @DataField
    MaterialRow buttonPanel, buttonDpPanel, buttonTpPanel, buttonRangePanel, buttonSwitchPanel,
                buttonTextAreaPanel, buttonTextBoxPanel, buttonComboBoxPanel;

    @Override
    public String getName() {
        return "Errors";
    }

    @Override
    public String getDescription() {
        return "Errors occur when an app fails to complete what is expected, such as: " +
               "1. The app does not understand user input, " +
               "2. The system or app fails, " +
               "3. A user intends to run incompatible operations concurrently";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.COMPONENTS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
        buildAutocomplete();
        buildDatePicker();
        buildTimePicker();
        buildRange();
        buildSwitch();
        buildTextBox();
        buildTextArea();
        buildComboBox();
    }

    protected void buildComboBox() {
        comboBox.setLabel("ComboBox");
        for (int i = 1; i <= 5; i++) {
            comboBox.addItem("Item " + i);
        }
        buildButtonPanel(comboBox, buttonComboBoxPanel);
    }

    protected void buildTextArea() {
        textArea.setPlaceholder("Text Area");
        buildButtonPanel(textArea, buttonTextAreaPanel);
    }

    protected void buildTextBox() {
        textBox.setPlaceholder("Text Box");
        buildButtonPanel(textBox, buttonTextBoxPanel);
    }

    protected void buildSwitch() {
        buildButtonPanel(switch1, buttonSwitchPanel);
    }

    protected void buildRange() {
        buildButtonPanel(range, buttonRangePanel);
    }

    protected void buildTimePicker() {
        timePicker.setPlaceholder("Time Picker");
        buildButtonPanel(timePicker, buttonTpPanel);
    }

    protected void buildDatePicker() {
        datePicker.setPlaceholder("Date Picker");
        buildButtonPanel(datePicker, buttonDpPanel);
    }

    protected void buildAutocomplete() {
        UserOracle oracle = new UserOracle();
        oracle.addContacts(getAllUsers());
        autocomplete.setPlaceholder("Autocomplete");
        autocomplete.setSuggestions(oracle);
        buildButtonPanel(autocomplete, buttonPanel);
    }

    protected void buildButtonPanel(HasError widget, MaterialRow buttonPanel) {
        buttonPanel.setMarginTop(20);
        MaterialButton btnError = new MaterialButton("Error");
        btnError.addClickHandler(clickEvent -> {
            widget.setError("This is an error message");
        });
        buttonPanel.add(btnError);

        MaterialButton btnSuccess = new MaterialButton("Success");
        btnSuccess.addClickHandler(clickEvent -> {
            widget.setSuccess("This is a success message");
        });
        buttonPanel.add(btnSuccess);

        MaterialButton btnClear = new MaterialButton("Clear");
        btnClear.addClickHandler(clickEvent -> {
            widget.clearErrorOrSuccess();
        });
        buttonPanel.add(btnClear);
    }

    public List<User> getAllUsers() {
        return DataHelper.getAllUsers();
    }
}
