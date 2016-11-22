package gwt.material.demo.errai.client.page.addins;

import com.google.gwt.user.client.Timer;
import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.addins.client.stepper.MaterialStep;
import gwt.material.design.addins.client.stepper.MaterialStepper;
import gwt.material.design.client.constants.Axis;
import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.Display;
import gwt.material.design.client.ui.*;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "stepper")
public class StepperPage extends AbstractPage {

    private static final int BASIC = 0;
    private static final int FEEDBACK = 1;
    private static final int ERROR = 2;

    @Inject
    @DataField
    private MaterialStepper stepper;

    @Inject
    @DataField
    private MaterialStepper stepper2;

    @Inject
    @DataField
    private MaterialModal modal;

    @Inject
    @DataField
    private MaterialButton btnModal;

    @Inject
    private MaterialModalContent content;

    @Inject
    private MaterialStepper stepper3;

    @Inject
    @DataField
    private MaterialStepper stepper4;

    @Inject
    @DataField
    private MaterialStepper stepper5;

    @Inject
    @DataField
    private MaterialStepper stepper6;

    @Inject
    @DataField
    private MaterialStepper stepperMobile;

    @Override
    public String getName() {
        return "Stepper";
    }

    @Override
    public String getDescription() {
        return "Steppers convey progress through numbered steps. They may also be used for navigation.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.ADDINS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
        buildVertical();
        buildHorizontal();
        buildModal();
        buildEvents();
        buildFeedback();
        buildError();
        buildMobile();
    }

    private void buildMobile() {
        stepperMobile.setDetectOrientation(true);
        stepperMobile.addCompleteHandler(event -> {
            MaterialToast.fireToast("All done");
            stepperMobile.reset();
        });
        buildStepper(stepperMobile, ERROR);
    }

    private void buildError() {
        stepper6.setAxis(Axis.HORIZONTAL);
        stepper6.addCompleteHandler(event -> {
            MaterialToast.fireToast("All done");
            stepper6.reset();
        });
        buildStepper(stepper6, ERROR);
    }

    private void buildFeedback() {
        stepper5.setAxis(Axis.HORIZONTAL);
        stepper5.addCompleteHandler(event -> {
            MaterialToast.fireToast("All done");
            stepper5.reset();
        });
        buildStepper(stepper5, FEEDBACK);
    }

    private void buildEvents() {
        stepper4.setAxis(Axis.HORIZONTAL);
        stepper4.addStartHandler(event -> {
            MaterialToast.fireToast("Start Event Fired");
        });

        stepper4.addNextHandler(event -> {
            MaterialToast.fireToast("Next Event Fired");
        });

        stepper4.addPreviousHandler(event -> {
            MaterialToast.fireToast("Previous Event Fired");
        });

        stepper4.addCompleteHandler(event -> {
            MaterialToast.fireToast("Complete Event: " + event.getLastStep());
            stepper4.reset();
        });
        buildStepper(stepper4, BASIC);
    }

    private void buildModal() {
        btnModal.setText("Open Modal");
        btnModal.addClickHandler(clickEvent -> {
            modal.open();
        });
        stepper3.addCompleteHandler(event -> {
            MaterialToast.fireToast("All done");
            modal.close();
            stepper3.reset();
        });
        stepper3.setAxis(Axis.HORIZONTAL);
        modal.add(content);
        content.add(stepper3);
        buildStepper(stepper3, BASIC);
    }

    private void buildHorizontal() {
        stepper2.setAxis(Axis.HORIZONTAL);
        stepper2.addCompleteHandler(event -> {
            MaterialToast.fireToast("All done");
            stepper2.reset();
        });
        buildStepper(stepper2, BASIC);
    }

    private void buildVertical() {
        buildStepper(stepper, BASIC);
        stepper.addCompleteHandler(event -> {
            MaterialToast.fireToast("All done");
            stepper.reset();
        });
    }

    private void buildStepper(MaterialStepper stepper, int type) {
        for (int i = 1; i <= 3; i++) {
            MaterialStep step = new MaterialStep();
            step.setStep(i);
            step.setTitle("Step " + i);
            step.setDescription("Description " + i);

            MaterialPanel panel = new MaterialPanel();
            panel.setDisplay(Display.BLOCK);
            panel.setWidth("100%");
            panel.setHeight("200px");
            panel.setMarginBottom(20);
            panel.setBackgroundColor(Color.GREY_LIGHTEN_2);
            step.add(panel);

            MaterialButton btnNext = new MaterialButton();
            btnNext.setText("Next");
            btnNext.addClickHandler(clickEvent -> {
                if (type == FEEDBACK) {
                    stepper.showFeedback("Waiting for next step");
                    Timer t = new Timer() {
                        @Override
                        public void run() {
                            stepper.nextStep();
                            stepper.hideFeedback();
                        }
                    };
                    t.schedule(2000);
                } else {
                    stepper.nextStep();
                }
            });
            step.add(btnNext);

            MaterialButton btnPrev = new MaterialButton();
            btnPrev.setText("Previous");
            btnPrev.setType(ButtonType.FLAT);
            if (type == ERROR) {
                btnPrev.setText("Set Error");
                btnPrev.addClickHandler(clickEvent -> {
                    stepper.setError("Alert Error");
                });
            } else {
                btnPrev.addClickHandler(clickEvent -> {
                    stepper.prevStep();
                });
            }

            if (i != 1) {
                step.add(btnPrev);
            }

            stepper.add(step);
        }
    }
}
