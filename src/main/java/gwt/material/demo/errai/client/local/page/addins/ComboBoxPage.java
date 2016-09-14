package gwt.material.demo.errai.client.local.page.addins;

import gwt.material.demo.errai.client.local.dto.DataHelper;
import gwt.material.demo.errai.client.local.dto.State;
import gwt.material.demo.errai.client.local.dto.TimeZone;
import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialModalContent;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.client.ui.html.OptGroup;
import gwt.material.design.client.ui.html.Option;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Templated
@Page(path = "combobox")
@ApplicationScoped
public class ComboBoxPage extends PageBase {

    @Inject
    private DataHelper dataHelper;

    @Inject
    @DataField
    MaterialComboBox<String> combo1;

    @Inject
    @DataField
    MaterialComboBox<State> combo2;

    @Inject
    @DataField
    MaterialComboBox<State> combo3;

    @Inject
    @DataField
    MaterialComboBox<State> combo4;

    @Inject
    @DataField
    MaterialComboBox<State> combo5;

    @Inject
    @DataField
    MaterialComboBox<State> combo6;

    @Inject
    @DataField
    MaterialComboBox<State> combo7;

    @Inject
    @DataField
    MaterialComboBox<State> combo8;

    @Inject
    @DataField
    MaterialComboBox<State> combo9, combo10;

    @Inject
    @DataField
    MaterialComboBox<State> combo11, combo12;

    @Inject
    @DataField
    MaterialComboBox<State> combo13;

    @Inject
    @DataField
    MaterialComboBox<State> combo14;

    @Inject
    @DataField
    MaterialComboBox<State> combo15, combo16;

    @Inject
    @DataField
    MaterialButton btnGetValue, btnGetValues;

    @Inject
    @DataField
    MaterialComboBox<State> combo17, combo18;

    @Inject
    @DataField
    MaterialButton btnSetValue, btnSetValues;

    @Inject
    @DataField
    MaterialComboBox<State> combo19;

    @Inject
    @DataField
    MaterialButton btnOpen, btnClose;

    @Inject
    @DataField
    MaterialComboBox<State> combo20;

    @Inject
    @DataField
    MaterialButton btnAddItem;

    private int dynamicIndex;

    @Inject
    MaterialComboBox<State> combo21;

    @Inject
    @DataField
    MaterialModal modal;

    @Inject
    MaterialModalContent modalContent;

    @Inject
    @DataField
    MaterialButton btnOpenModal;

    @PostConstruct
    public void init() {
        initPage("ComboBox", "Material ComboBox gives you a customizable select box with support for searching, tagging, remote data sets, infinite scrolling, and many other highly used options.", ADDINS_COLOR);
        buildBasic();
        buildLabelAndPlaceholder();
        buildAllowClear();
        buildWithOptGroup();
        buildMultipleSelect();
        buidDisabled();
        buildDisablingResult();
        buildLimit();
        buildValueChange();
        buildSelection();
        buildRemoveItem();
        buildOpenClose();
        buildGetSelectedValue();
        buildSetSelectedValue();
        buidProgrammaticAccess();
        buildInitializeUpdate();
        buildModal();
    }

    private void buildModal() {
        combo21.setLabel("Please provide your timezone");
        addStateItemsWithGroup(combo21);
        modal.add(modalContent);
        modal.setDismissable(true);
        modalContent.add(combo21);

        btnOpenModal.setText("Open Modal");
        btnOpenModal.addClickHandler(clickEvent -> {
            modal.open();
        });
    }

    private void buildInitializeUpdate() {
        combo20.setPlaceholder("Time Zone");

        btnAddItem.setText("Add Item");
        btnAddItem.addClickHandler(clickEvent -> {
            State newState = new State("Item " + dynamicIndex, "I" + dynamicIndex);
            combo20.addItem(newState.getName(), newState);
            combo20.setValue(newState);
            dynamicIndex ++;
        });
    }

    private void buidProgrammaticAccess() {
        addStateItems(combo19);

        btnOpen.setText("Open");
        btnOpen.addClickHandler(clickEvent -> {
            combo19.open();
        });

        btnClose.setText("Close");
        btnClose.addClickHandler(clickEvent -> {
            combo19.close();
        });
    }

    private void buildSetSelectedValue() {
        addStateItemsWithGroup(combo17);

        btnSetValue.setText("Set California");
        btnSetValue.addClickHandler(clickEvent -> {
            State california = combo17.getValues().get(2);
            combo17.setValue(california);
        });

        combo18.setMultiple(true);
        combo18.setPlaceholder("Time Zone");
        addStateItemsWithGroup(combo18);
        btnSetValues.setText("Set California and Nevada");
        btnSetValues.addClickHandler(clickEvent -> {
            List<State> states = new ArrayList<>();
            State california = combo18.getValues().get(2);
            State alabama = combo18.getValues().get(3);
            states.add(california);
            states.add(alabama);
            combo18.setValues(states);
        });
    }

    private void buildGetSelectedValue() {
        addStateItemsWithGroup(combo15);

        btnGetValue.setText("Get Value");
        btnGetValue.addClickHandler(clickEvent -> {
            MaterialToast.fireToast("Value: " + combo15.getSelectedValue().getName());
        });

        combo16.setMultiple(true);
        combo16.setPlaceholder("Time Zone");
        addStateItemsWithGroup(combo16);
        btnGetValues.setText("Get Values");
        btnGetValues.addClickHandler(clickEvent -> {
            for (State state : combo16.getSelectedValues()) {
                MaterialToast.fireToast("Value: " + state.getName());
            }
        });
    }

    private void buildOpenClose() {
        combo14.addCloseHandler(closeEvent -> {
            MaterialToast.fireToast("Closed");
        });
        combo14.addOpenHandler(openEvent -> {
            MaterialToast.fireToast("Opened");
        });

        addStateItemsWithGroup(combo14);
    }

    private void buildRemoveItem() {
        combo13.setPlaceholder("Time Zone");
        combo13.setMultiple(true);
        combo13.addRemoveItemHandler(event -> {
            MaterialToast.fireToast("Removed: " + event.getTarget().getName());
        });

        addStateItemsWithGroup(combo13);
    }

    private void buildSelection() {
        combo11.addSelectionHandler(selectionEvent -> {
            MaterialToast.fireToast("State: " + selectionEvent.getSelectedItem().getName() + " Value: " + selectionEvent.getSelectedItem().getValue());
        });
        addStateItemsWithGroup(combo11);

        combo12.setPlaceholder("Time Zone");
        combo12.setMultiple(true);
        combo12.addSelectionHandler(selectionEvent -> {
            MaterialToast.fireToast("State: " + selectionEvent.getSelectedItem().getName() + " Value: " + selectionEvent.getSelectedItem().getValue());
        });
        addStateItemsWithGroup(combo12);
    }

    private void buildValueChange() {
        combo9.addValueChangeHandler(valueChangeEvent -> {
            MaterialToast.fireToast("State: " + valueChangeEvent.getValue().getName() + " Value: " + valueChangeEvent.getValue().getValue());
        });
        addStateItemsWithGroup(combo9);

        combo10.setMultiple(true);
        combo10.setPlaceholder("Time Zone");
        combo10.addValueChangeHandler(valueChangeEvent -> {
            MaterialToast.fireToast("State: " + valueChangeEvent.getValue().getName() + " Value: " + valueChangeEvent.getValue().getValue());
        });
        addStateItemsWithGroup(combo10);
    }

    private void buildLimit() {
        combo8.setMultiple(true);
        combo8.setLimit(2);
        combo8.setPlaceholder("Placeholder");
        addStateItemsWithGroup(combo8);
    }

    private void buildDisablingResult() {
        for (int i = 1; i <= 5; i++) {
            Option option = new Option();
            option.setText("Option " + i);
            if (i == 2) {
                option.setEnabled(false);
            }
            combo7.add(option);
        }
    }

    private void buidDisabled() {
        addStateItemsWithGroup(combo6);
        combo6.setEnabled(false);
    }

    private void buildMultipleSelect() {
        combo5.setMultiple(true);
        combo5.setPlaceholder("Time Zone");
        addStateItemsWithGroup(combo5);
    }

    private void buildWithOptGroup() {
        addStateItemsWithGroup(combo4);
    }

    private void buildAllowClear() {
        combo3.setPlaceholder("Time Zone");
        combo3.setMultiple(true);
        combo3.setAllowClear(true);
        addStateItems(combo3);
    }

    private void buildLabelAndPlaceholder() {
        combo2.setPlaceholder("This is placeholder");
        combo2.setLabel("This is label");
        combo2.setMultiple(true);
        addStateItems(combo2);
    }

    private void buildBasic() {
        combo1.addItem("Option 1");
        combo1.addItem("Option 2");
        combo1.addItem("Option 3");
    }

    protected void addStateItems(MaterialComboBox<State> box) {
        for (TimeZone tz : dataHelper.getTimeZones()) {
            for (State s : tz.getStates()) {
                box.addItem(s.getName(), s);
            }
        }
    }

    protected void addStateItemsWithGroup(MaterialComboBox<State> box) {
       for (TimeZone tz : dataHelper.getTimeZones()) {
            OptGroup optGroup = new OptGroup();
            optGroup.setLabel(tz.getName());
            for (State s : tz.getStates()) {
                box.addItem(s.getName(), s, optGroup);
            }
            box.addGroup(optGroup);
        }
    }
}
