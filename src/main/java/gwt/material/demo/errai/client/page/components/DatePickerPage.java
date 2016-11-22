package gwt.material.demo.errai.client.page.components;

import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialDatePicker;
import gwt.material.design.client.ui.MaterialToast;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.inject.Inject;
import java.util.Date;

@Templated
@Page(path = "datepicker")
public class DatePickerPage extends AbstractPage {

    @Inject
    @DataField
    private MaterialDatePicker dpBasic;

    @Inject
    @DataField
    private MaterialDatePicker dpMobile;

    @Inject
    @DataField
    private MaterialDatePicker dpDisabled;

    @Inject
    @DataField
    private MaterialDatePicker dpSelection;

    @Inject
    @DataField
    private MaterialDatePicker dpGetSetDate;

    @Inject
    @DataField
    private MaterialButton btnGetDate;

    @Inject
    @DataField
    private MaterialButton btnSetDate;

    @Inject
    @DataField
    private MaterialDatePicker dpFormats;

    @Inject
    @DataField
    private MaterialDatePicker dpLimit;

    @Inject
    @DataField
    private MaterialDatePicker dpClear;

    @Inject
    @DataField
    private MaterialButton btnClear;

    @Inject
    @DataField
    private MaterialDatePicker dpEvents;

    @Inject
    @DataField
    private MaterialDatePicker dpOpenClose;

    @Inject
    @DataField
    private MaterialButton btnOpenDp;

    @Inject
    @DataField
    private MaterialDatePicker dpAutoClose;

    @Override
    public String getName() {
        return "Date Picker";
    }

    @Override
    public String getDescription() {
        return "A dialog picker is used to select a single date on mobile. " +
               "The selected day is indicated by a filled circle. The current " +
               "day is indicated by a different color and type weight.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.COMPONENTS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
        buildBasic();
        buildMobile();
        buildDisabled();
        buildSelection();
        buildGetSetDate();
        buildFormats();
        buildLimits();
        buildClear();
        buildEvents();
        buildOpenClose();
        buildAutoClose();
    }

    private void buildAutoClose() {
        dpAutoClose.setPlaceholder("Date");
        dpAutoClose.setAutoClose(true);
        //dpAutoClose.addValueChangeHandler(valueChangeEvent -> {
            //dpAutoClose.close();
            //MaterialToast.fireToast("Date Selected " + valueChangeEvent.getValue());
        //});
    }

    private void buildOpenClose() {
        dpOpenClose.setPlaceholder("Date");
        dpOpenClose.addOpenHandler(openEvent -> {
            MaterialToast.fireToast("Date Picker Opened");
        });
        dpOpenClose.addCloseHandler(openEvent -> {
            MaterialToast.fireToast("Date Picker Close");
        });
        btnOpenDp.setText("Open DatePicker");
        btnOpenDp.addClickHandler(clickEvent -> {
            dpOpenClose.open();
        });
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

    private void buildMobile() {
        dpMobile.setPlaceholder("Supports mobile orientations");
        dpMobile.setDetectOrientation(true);
    }
}
