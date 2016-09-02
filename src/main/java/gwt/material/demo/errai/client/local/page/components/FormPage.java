package gwt.material.demo.errai.client.local.page.components;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.*;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "forms")
public class FormPage extends PageBase {

    @Inject
    @DataField
    MaterialTextBox txtBox1, txtBox2, txtBox3, txtDisTextBox;

    @Inject
    @DataField
    MaterialTextArea txtArea1, txtArea2, txtDisTextArea;

    @Inject
    @DataField
    MaterialTextBox txtCharCounter1, txtCharCounter2;

    @Inject
    @DataField
    MaterialFloatBox txtFloat1, txtDisFloat;

    @Inject
    @DataField
    MaterialIntegerBox txtInteger1, txtDisInteger;

    @Inject
    @DataField
    MaterialDoubleBox txtDouble1, txtDisDouble;

    @Inject
    @DataField
    MaterialLongBox txtLong1, txtDisLong;

    @Inject
    @DataField
    MaterialTextBox txtBoxValueChange, txtBoxKey, txtBoxBlur, txtBoxFocus;

    @Inject
    @DataField
    MaterialListBox lstBox1;

    @PostConstruct
    public void init() {
        initPage("Forms", "Forms are the standard way to receive user inputted data. The transitions and smoothness of these elements are very important because of the inherent user interaction associated with forms.", COMPONENTS_COLOR);
        buildTextBox();
        buildTextArea();
        buildCharCounter();
        buildNumber();
        buildDisabledValueBox();
        buildEventsValueBox();
        buildListBox();
    }

    private void buildListBox() {
        lstBox1.setPlaceholder("ListBox");
        for (int i = 1; i <= 5; i++) {
            lstBox1.addItem("Option " + i);
        }
    }

    private void buildEventsValueBox() {
        txtBoxValueChange.setPlaceholder("Value Change Event");
        txtBoxValueChange.addValueChangeHandler(valueChangeEvent -> {
            txtBoxValueChange.setHelperText("Value Changed to " + valueChangeEvent.getValue());
        });

        txtBoxKey.setPlaceholder("Key Press Event");
        txtBoxKey.addKeyPressHandler(keyPressEvent -> {
            txtBoxKey.setHelperText("Key Pressed : " + txtBoxKey.getText());
        });

        txtBoxBlur.setPlaceholder("Blur Event");
        txtBoxBlur.addBlurHandler(blurEvent -> {
            txtBoxBlur.setHelperText("TextBox on Blur");
        });

        txtBoxFocus.setPlaceholder("Focus Event");
        txtBoxFocus.addFocusHandler(focusEvent -> {
            txtBoxFocus.setHelperText("TextBox on Focus");
        });
    }

    private void buildDisabledValueBox() {
        txtDisTextBox.setPlaceholder("TextBox");
        txtDisTextBox.setEnabled(false);

        txtDisTextArea.setPlaceholder("Text Area");
        txtDisTextArea.setEnabled(false);

        txtDisFloat.setPlaceholder("FloatBox");
        txtDisFloat.setEnabled(false);

        txtDisInteger.setPlaceholder("IntegerBox");
        txtDisInteger.setEnabled(false);

        txtDisDouble.setPlaceholder("DoubleBox");
        txtDisDouble.setEnabled(false);

        txtDisLong.setPlaceholder("LongBox");
        txtDisLong.setEnabled(false);
    }

    private void buildNumber() {
        txtFloat1.setPlaceholder("Float value");
        txtFloat1.setValue(1000.25f);

        txtInteger1.setPlaceholder("Integer value");
        txtInteger1.setValue(10);

        txtDouble1.setPlaceholder("Double value");
        txtDouble1.setValue(999.99);

        txtLong1.setPlaceholder("Long value");
        txtLong1.setValue(Long.valueOf(1000));
    }

    private void buildCharCounter() {
        txtCharCounter1.setPlaceholder("Input Text");
        txtCharCounter1.setLength(10);

        txtCharCounter2.setPlaceholder("Text Area");
        txtCharCounter2.setLength(120);
    }

    private void buildTextArea() {
        txtArea1.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam mauris, accumsan placerat lectus ac, tincidunt mattis nisl. Ut efficitur massa in libero gravida tincidunt. Vestibulum eget massa eget ex auctor tempus. Aenean vitae augue euismod, lacinia lectus ut, rhoncus enim. Sed vitae laoreet felis, eget ullamcorper nunc. Vivamus elit urna, varius et arcu vel, euismod auctor augue. Praesent scelerisque scelerisque libero sit amet euismod. Mauris eu est at felis feugiat tincidunt eu vel lectus. Ut pretium magna vitae massa sollicitudin, eu tincidunt sapien scelerisque. Maecenas gravida lorem non dui pretium, id vestibulum mi imperdiet. Fusce facilisis, dui nec ultrices molestie, nisi metus bibendum lacus, eget posuere est odio vitae nulla. Mauris laoreet non justo fringilla tempus. Mauris ut risus risus. Vivamus auctor accumsan gravida. Nam venenatis sapien nisl, quis accumsan odio dignissim non. Vestibulum aliquam semper condimentum. Suspendisse a eros elementum, dapibus quam in, aliquet lorem. Morbi mi dui, convallis at luctus ultricies, malesuada at leo. Morbi et turpis a ex vehicula ullamcorper. Vestibulum lacinia, orci eget elementum fermentum, lectus velit interdum erat, sit amet pharetra justo elit in tortor. Suspendisse ac vestibulum nisi. Nunc euismod metus nec elit sollicitudin blandit. Proin eleifend ex bibendum sodales blandit. Vestibulum varius pharetra arcu, sit amet pellentesque odio hendrerit nec. Integer faucibus imperdiet tortor a tempus. Sed accumsan condimentum nisl. Cras interdum sapien quis maximus commodo. Nulla malesuada imperdiet enim, non ornare elit auctor in. Fusce at ipsum eget turpis tincidunt maximus. Nunc sodales tortor nec tincidunt fringilla. Quisque sollicitudin ipsum at dolor faucibus, ultricies convallis ipsum convallis. Donec consequat velit vel molestie tempus. Donec et accumsan lacus, non sollicitudin quam. Morbi arcu lacus, blandit eu lacus nec, finibus tempus ligula.");
        txtArea1.setPlaceholder("Using AUTO");
        txtArea1.setResizeRule(MaterialTextArea.ResizeRule.AUTO);

        txtArea2.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam mauris, accumsan placerat lectus ac, tincidunt mattis nisl. Ut efficitur massa in libero gravida tincidunt. Vestibulum eget massa eget ex auctor tempus. Aenean vitae augue euismod, lacinia lectus ut, rhoncus enim. Sed vitae laoreet felis, eget ullamcorper nunc. Vivamus elit urna, varius et arcu vel, euismod auctor augue. Praesent scelerisque scelerisque libero sit amet euismod. Mauris eu est at felis feugiat tincidunt eu vel lectus. Ut pretium magna vitae massa sollicitudin, eu tincidunt sapien scelerisque. Maecenas gravida lorem non dui pretium, id vestibulum mi imperdiet. Fusce facilisis, dui nec ultrices molestie, nisi metus bibendum lacus, eget posuere est odio vitae nulla. Mauris laoreet non justo fringilla tempus. Mauris ut risus risus. Vivamus auctor accumsan gravida. Nam venenatis sapien nisl, quis accumsan odio dignissim non. Vestibulum aliquam semper condimentum. Suspendisse a eros elementum, dapibus quam in, aliquet lorem. Morbi mi dui, convallis at luctus ultricies, malesuada at leo. Morbi et turpis a ex vehicula ullamcorper. Vestibulum lacinia, orci eget elementum fermentum, lectus velit interdum erat, sit amet pharetra justo elit in tortor. Suspendisse ac vestibulum nisi. Nunc euismod metus nec elit sollicitudin blandit. Proin eleifend ex bibendum sodales blandit. Vestibulum varius pharetra arcu, sit amet pellentesque odio hendrerit nec. Integer faucibus imperdiet tortor a tempus. Sed accumsan condimentum nisl. Cras interdum sapien quis maximus commodo. Nulla malesuada imperdiet enim, non ornare elit auctor in. Fusce at ipsum eget turpis tincidunt maximus. Nunc sodales tortor nec tincidunt fringilla. Quisque sollicitudin ipsum at dolor faucibus, ultricies convallis ipsum convallis. Donec consequat velit vel molestie tempus. Donec et accumsan lacus, non sollicitudin quam. Morbi arcu lacus, blandit eu lacus nec, finibus tempus ligula.");
        txtArea2.setPlaceholder("Using AUTO");
        txtArea2.setResizeRule(MaterialTextArea.ResizeRule.FOCUS);
    }

    private void buildTextBox() {
        txtBox1.setPlaceholder("First Name");

        txtBox2.setPlaceholder("Email");
        txtBox2.setIconType(IconType.ACCOUNT_CIRCLE);

        txtBox3.setPlaceholder("Information");
        txtBox3.setIconType(IconType.INFO);
        txtBox3.setHelperText("A brief info about you");
    }
}
