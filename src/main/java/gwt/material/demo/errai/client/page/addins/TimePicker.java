package gwt.material.demo.errai.client.page.addins;

import com.google.gwt.i18n.client.DateTimeFormat;
import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.addins.client.timepicker.MaterialTimePicker;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialToast;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Date;

@Templated
@Page(path = "timepicker")
public class TimePicker extends AbstractPage {

    @Inject
    @DataField
    MaterialTimePicker tpBasic;

    @Inject
    @DataField
    MaterialTimePicker tpMobile;

    @Inject
    @DataField
    MaterialTimePicker tpDisabled;

    @Inject
    @DataField
    MaterialTimePicker tpHour24;

    @Inject
    @DataField
    MaterialTimePicker tpEvents;

    @Inject
    @DataField
    MaterialTimePicker tpAutoClose;

    @Inject
    @DataField
    MaterialTimePicker tpClear;

    @Inject
    @DataField
    MaterialButton btnClear, btnSetValue;

    @Override
    public String getName() {
        return "Time Pickers";
    }

    @Override
    public String getDescription() {
        return "A dialog picker is used to select a single time (hours:minutes) on mobile. " +
               "The selected time is indicated by the filled circle at the end of the clock hand.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.ADDINS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
        buildBasic();
        buildMobile();
        buildDisabled();
        buildHour24();
        buildEvents();
        buildClear();
        buildAutoClose();
    }

    private void buildAutoClose() {
        tpAutoClose.setPlaceholder("Time");
        tpAutoClose.setAutoClose(true);
    }

    private void buildClear() {
        tpClear.setPlaceholder("Time");
        btnClear.setText("Clear");
        btnClear.addClickHandler(clickEvent -> {
            tpClear.clear();
        });

        btnSetValue.setText("Set Value");
        btnSetValue.addClickHandler(clickEvent -> {
            tpClear.setValue(new Date());
        });
    }

    private void buildEvents() {
        tpEvents.setPlaceholder("Time");
        tpEvents.addOpenHandler(event -> {
            MaterialToast.fireToast("Open Event Fired");
        });

        tpEvents.addCloseHandler(event -> {
            MaterialToast.fireToast("Close Event Fired");
        });

        tpEvents.addValueChangeHandler(event -> {
            DateTimeFormat dtf = DateTimeFormat.getFormat("hh:mm a");
            Date time = event.getValue();
            MaterialToast.fireToast("Value Changed : " + dtf.format(time));
        });
    }

    private void buildHour24() {
        tpHour24.setPlaceholder("Time");
        tpHour24.setHour24(true);
    }

    private void buildDisabled() {
        tpDisabled.setPlaceholder("Time");
        tpDisabled.setEnabled(false);
    }

    private void buildBasic() {
        tpBasic.setPlaceholder("Time");
    }

    private void buildMobile() {
        tpMobile.setPlaceholder("Supports mobile orientations");
        tpMobile.setDetectOrientation(true);
    }
}
