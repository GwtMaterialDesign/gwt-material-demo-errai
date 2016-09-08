package gwt.material.demo.errai.client.local.page.components;

import com.google.gwt.i18n.client.DateTimeFormat;
import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialDatePicker;
import gwt.material.design.client.ui.MaterialToast;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Date;

@Templated
@Page(path = "datepicker")
public class DatePickerPage extends PageBase {

    @Inject
    @DataField
    MaterialDatePicker dpBasic;

    @Inject
    @DataField
    MaterialDatePicker dpDisabled;

    @Inject
    @DataField
    MaterialDatePicker dpSelection;

    @Inject
    @DataField
    MaterialDatePicker dpGetSetDate;

    @Inject
    @DataField
    MaterialButton btnGetDate;

    @Inject
    @DataField
    MaterialButton btnSetDate;

    @Inject
    @DataField
    MaterialDatePicker dpFormats;

    @Inject
    @DataField
    MaterialDatePicker dpLimit;

    @Inject
    @DataField
    MaterialDatePicker dpClear;

    @Inject
    @DataField
    MaterialButton btnClear;

    @Inject
    @DataField
    MaterialDatePicker dpEvents;

    @PostConstruct
    public void init() {
        initPage("Date Picker", "A dialog picker is used to select a single date on mobile. The selected day is indicated by a filled circle. The current day is indicated by a different color and type weight.", COMPONENTS_COLOR);
        buildBasic();
        buildDisabled();
        buildSelection();
        buildGetSetDate();
        buildFormats();
        buildLimits();
        buildClear();
        buildEvents();
    }

    private void buildEvents() {
        dpEvents.setPlaceholder("Events");

        dpEvents.addOpenHandler(openEvent -> {
            MaterialToast.fireToast("Opened");
        });
        dpEvents.addCloseHandler(closeEvent -> {
            MaterialToast.fireToast("Closed with value " + dpEvents.getValue());
        });
        dpEvents.addValueChangeHandler(valueChangeEvent -> {
            MaterialToast.fireToast("Changed with value " + valueChangeEvent.getValue());
        });
    }

    private void buildClear() {
        dpClear.setPlaceholder("Date");

        btnClear.setText("Clear");
        btnClear.addClickHandler(clickEvent -> {
            dpClear.clear();
        });
    }

    private void buildLimits() {
        dpLimit.setPlaceholder("Limits");
        dpLimit.setDateMin(new Date(117, 0, 1));
        dpLimit.setDateMax(new Date(117, 0, 15));
    }

    private void buildFormats() {
        dpFormats.setPlaceholder("Formats");
        dpFormats.setFormat("Yehey dd/mm/yyyy");
    }

    private void buildGetSetDate() {
        dpGetSetDate.setPlaceholder("Date");
        btnGetDate.setText("Get Date");
        btnGetDate.addClickHandler(clickEvent -> {
            MaterialToast.fireToast("Value " + dpGetSetDate.getValue());
        });

        btnSetDate.setText("Set Date Today");
        btnSetDate.addClickHandler(clickEvent -> {
            dpGetSetDate.setDate(new Date());
        });
    }

    private void buildSelection() {
        dpSelection.setPlaceholder("Date");
        dpSelection.setSelectionType(MaterialDatePicker.MaterialDatePickerType.YEAR);
    }

    private void buildDisabled() {
        dpDisabled.setPlaceholder("Date");
        dpDisabled.setEnabled(false);
    }

    private void buildBasic() {
        dpBasic.setPlaceholder("Date");
    }
}
