package gwt.material.demo.errai.client.local.page.addins;

import gwt.material.demo.errai.client.local.dto.DataHelper;
import gwt.material.demo.errai.client.local.dto.State;
import gwt.material.demo.errai.client.local.dto.TimeZone;
import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.client.ui.html.OptGroup;
import gwt.material.design.client.ui.html.Option;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "combobox")
public class ComboBoxPage extends PageBase {

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

    @PostConstruct
    public void init() {
        initPage("ComboBox", "", ADDINS_COLOR);
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
    }

    private void buildSelection() {
        addStateItemsWithGroup(combo11);
        combo11.addSelectionHandler(selectionEvent -> {
            MaterialToast.fireToast("State: " + selectionEvent.getSelectedItem().getName() + " Value: " + selectionEvent.getSelectedItem().getValue());
        });

        addStateItemsWithGroup(combo12);
        combo12.setPlaceholder("Time Zone");
        combo12.addSelectionHandler(selectionEvent -> {
            MaterialToast.fireToast("State: " + selectionEvent.getSelectedItem().getName() + " Value: " + selectionEvent.getSelectedItem().getValue());
        });
    }

    private void buildValueChange() {
        addStateItemsWithGroup(combo9);
        combo9.addValueChangeHandler(valueChangeEvent -> {
            MaterialToast.fireToast("State: " + valueChangeEvent.getValue().getName() + " Value: " + valueChangeEvent.getValue().getValue());
        });

        addStateItemsWithGroup(combo10);
        combo10.setPlaceholder("Time Zone");
        combo10.addValueChangeHandler(valueChangeEvent -> {
            MaterialToast.fireToast("State: " + valueChangeEvent.getValue().getName() + " Value: " + valueChangeEvent.getValue().getValue());
        });
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
        for (TimeZone tz : DataHelper.getTimeZones()) {
            for (State s : tz.getStates()) {
                box.addItem(s.getName(), s);
            }
        }
    }

    protected void addStateItemsWithGroup(MaterialComboBox<State> box) {
        for (TimeZone tz : DataHelper.getTimeZones()) {
            OptGroup optGroup = new OptGroup();
            optGroup.setLabel(tz.getName());
            for (State s : tz.getStates()) {
                box.addItem(s.getName(), s, optGroup);
            }
            box.addGroup(optGroup);
        }
    }
}
