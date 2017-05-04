package gwt.material.demo.errai.client.page.addins;

import gwt.material.demo.errai.client.dto.DataHelper;
import gwt.material.demo.errai.client.dto.State;
import gwt.material.demo.errai.client.dto.TimeZone;
import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialModal;
import gwt.material.design.client.ui.MaterialModalContent;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.client.ui.html.OptGroup;
import gwt.material.design.client.ui.html.Option;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Templated
@Page(path = "combobox")
public class ComboBoxPage extends AbstractPage {

    @Inject
    private DataHelper dataHelper;

    @Inject
    @DataField
    private MaterialComboBox<String> combo1;

    @Inject
    @DataField
    private MaterialComboBox<State> combo2;

    @Inject
    @DataField
    private MaterialComboBox<State> combo3;

    @Inject
    @DataField
    private MaterialComboBox<State> combo4;

    @Inject
    @DataField
    private MaterialComboBox<State> combo5;

    @Inject
    @DataField
    private MaterialComboBox<State> combo6;

    @Inject
    @DataField
    private MaterialComboBox<State> combo7;

    @Inject
    @DataField
    private MaterialComboBox<State> combo8;

    @Inject
    @DataField
    private MaterialComboBox<State> combo9, combo10;

    @Inject
    @DataField
    private MaterialComboBox<State> combo11, combo12;

    @Inject
    @DataField
    private MaterialComboBox<State> combo13;

    @Inject
    @DataField
    private MaterialComboBox<State> combo14;

    @Inject
    @DataField
    private MaterialComboBox<State> combo15, combo16;

    @Inject
    @DataField
    private MaterialButton btnGetValue, btnGetValues;

    @Inject
    @DataField
    private MaterialComboBox<State> combo17, combo18;

    @Inject
    @DataField
    private MaterialButton btnSetValue, btnSetValues;

    @Inject
    @DataField
    private MaterialComboBox<State> combo19;

    @Inject
    @DataField
    private MaterialButton btnOpen, btnClose;

    @Inject
    @DataField
    private MaterialComboBox<State> combo20;

    @Inject
    @DataField
    private MaterialButton btnAddItem;

    @Inject
    private MaterialComboBox<State> combo21, comboCloseOnClick;

    @Inject
    @DataField
    private MaterialModal modal;

    @Inject
    private MaterialModalContent modalContent;

    @Inject
    @DataField
    private MaterialButton btnOpenModal;

    @Override
    public String getName() {
        return "ComboBox";
    }

    private int dynamicIndex;

    @Override
    public String getDescription() {
        return "Material ComboBox gives you a customizable select box with support for searching, tagging, remote data sets, infinite scrolling, and many other highly used options.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.ADDINS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
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
        buildCloseOnClick();
    }

    private void buildCloseOnClick() {
        comboCloseOnClick.setPlaceholder("Time Zone");
        comboCloseOnClick.setMultiple(true);
        comboCloseOnClick.setCloseOnSelect(true);
        addStateItemsWithGroup(comboCloseOnClick);
    }

    private void buildModal() {
        combo21.setLabel("Please provide your timezone");
        addStateItemsWithGroup(combo21);
        modal.add(modalContent);
        modal.setDismissible(true);
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
            combo20.setSingleValue(newState);
            dynamicIndex++;
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
            combo17.setSingleValue(california);
        });

        combo18.setMultiple(true);
        combo18.setCloseOnSelect(false);
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
            MaterialToast.fireToast("Value: " + combo15.getSelectedValue().get(0).getName());
        });

        combo16.setMultiple(true);
        combo16.setCloseOnSelect(false);
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
        combo13.setCloseOnSelect(false);
        combo13.addRemoveItemHandler(event -> {
            MaterialToast.fireToast("Removed: " + event.getSelectedValues().get(0).getName());
        });

        addStateItemsWithGroup(combo13);
    }

    private void buildSelection() {
        combo11.addSelectionHandler(selectionEvent -> {
            MaterialToast.fireToast("State: " + selectionEvent.getSelectedValues().get(0).getName() + " Value: " + selectionEvent.getSelectedValues().get(0).getValue());
        });
        addStateItemsWithGroup(combo11);

        combo12.setPlaceholder("Time Zone");
        combo12.setMultiple(true);
        combo12.setCloseOnSelect(false);
        combo12.addSelectionHandler(selectionEvent -> {
            MaterialToast.fireToast("State: " + selectionEvent.getSelectedValues().get(0).getName() + " Value: " + selectionEvent.getSelectedValues().get(0).getValue());
        });
        addStateItemsWithGroup(combo12);
    }

    private void buildValueChange() {
        combo9.addValueChangeHandler(valueChangeEvent -> {
            MaterialToast.fireToast("State: " + valueChangeEvent.getValue().get(0).getName() + " Value: " + valueChangeEvent.getValue().get(0).getValue());
        });
        addStateItemsWithGroup(combo9);

        combo10.setMultiple(true);
        combo10.setCloseOnSelect(false);
        combo10.setPlaceholder("Time Zone");
        combo10.addValueChangeHandler(valueChangeEvent -> {
            for (State state : combo10.getSelectedValues()) {
                MaterialToast.fireToast(state.getValue());
            }
        });
        addStateItemsWithGroup(combo10);
    }

    private void buildLimit() {
        combo8.setMultiple(true);
        combo8.setCloseOnSelect(false);
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
        combo5.setCloseOnSelect(false);
        combo5.setPlaceholder("Time Zone");
        addStateItemsWithGroup(combo5);
    }

    private void buildWithOptGroup() {
        addStateItemsWithGroup(combo4);
    }

    private void buildAllowClear() {
        combo3.setPlaceholder("Time Zone");
        combo3.setMultiple(true);
        combo3.setCloseOnSelect(false);
        combo3.setAllowClear(true);
        addStateItems(combo3);
    }

    private void buildLabelAndPlaceholder() {
        combo2.setPlaceholder("This is placeholder");
        combo2.setLabel("This is label");
        combo2.setMultiple(true);
        combo2.setCloseOnSelect(false);
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
