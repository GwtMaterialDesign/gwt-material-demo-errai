package gwt.material.demo.errai.client.local.page.addins;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.addins.client.richeditor.MaterialRichEditor;
import gwt.material.design.addins.client.richeditor.base.constants.ToolbarButton;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Templated
@Page(path = "richeditor")
@ApplicationScoped
public class RichEditorPage extends PageBase {

    @Inject
    @DataField
    MaterialRichEditor rich;

    @Inject
    @DataField
    MaterialRichEditor rich2;

    @Inject
    @DataField
    MaterialButton btnGetHtml;

    @Inject
    @DataField
    MaterialButton btnSetHtml;

    @Inject
    @DataField
    MaterialTextBox txtHtml;

    @Inject
    @DataField
    MaterialRichEditor rich3;

    @Inject
    @DataField
    MaterialRichEditor rich4;

    @Inject
    @DataField
    MaterialRichEditor rich5;

    @Inject
    @DataField
    MaterialRichEditor rich6;

    @Inject
    @DataField
    MaterialButton btnClear, btnInsertText;

    @Inject
    @DataField
    MaterialRichEditor rich7;

    @PostConstruct
    public void init() {
        initPage("Rich Editor", "Provides a great Rich Editor with amazing options built with Material Design Look and Feel.", ADDINS_COLOR);
        buildDefault();
        buildSetGetHtml();
        buildAirmode();
        buildHeight();
        buildControllingOptions();
        buildClearInsertText();
        buildEvents();
    }

    private void buildEvents() {
        rich7.setHeight("200px");
        rich7.addValueChangeHandler(valueChangeEvent -> {
            MaterialToast.fireToast("Value Change: " + rich7.getHTML());
        });

        rich7.addKeyUpHandler(keyUpEvent -> {
            MaterialToast.fireToast("Key Up: " + rich7.getHTML());
        });

        rich7.addKeyDownHandler(keyDownEvent -> {
            MaterialToast.fireToast("Key Down: " + rich7.getHTML());
        });

        rich7.addFocusHandler(focusEvent -> {
            MaterialToast.fireToast("Focus: " + rich7.getHTML());
        });

        rich7.addBlurHandler(blurEvent -> {
            MaterialToast.fireToast("Blur: " + rich7.getHTML());
        });

        rich7.addPasteHandler(event -> {
            MaterialToast.fireToast("Paste: " + rich7.getHTML());
        });
    }

    private void buildClearInsertText() {
        rich6.setHeight("200px");
        btnClear.setText("Clear");
        btnClear.addClickHandler(clickEvent -> {
            rich6.clear();
        });

        btnInsertText.setText("Insert Text");
        btnInsertText.addClickHandler(clickEvent -> {
            rich6.insertText("Material Design");
        });
    }

    private void buildControllingOptions() {
        rich5.setHeight("200px");
        rich5.setStyleOptions(ToolbarButton.STYLE, ToolbarButton.BOLD, ToolbarButton.ITALIC);
        rich5.setParaOptions(ToolbarButton.LEFT, ToolbarButton.RIGHT, ToolbarButton.JUSTIFY);
        rich5.setMiscOptions(ToolbarButton.CODE_VIEW, ToolbarButton.FULLSCREEN);
        // Without undo options
        rich5.setUndoOptions();
    }

    private void buildHeight() {
        rich4.setHeight("200px");
    }

    private void buildAirmode() {
        rich3.setAirMode(true);
        rich3.setHTML("<b>Material Design</b><p>I love Material Design</p>");
    }

    private void buildSetGetHtml() {
        txtHtml.setPlaceholder("Html");
        btnGetHtml.setText("Get Html");
        btnGetHtml.addClickHandler(clickEvent -> {
            MaterialToast.fireToast(rich2.getHTML());
        });

        btnSetHtml.setText("Set Html");
        btnSetHtml.addClickHandler(clickEvent -> {
            rich2.setHTML(txtHtml.getText());
        });
    }

    private void buildDefault() {
        rich.setPlaceholder("Type anything...");
    }
}
