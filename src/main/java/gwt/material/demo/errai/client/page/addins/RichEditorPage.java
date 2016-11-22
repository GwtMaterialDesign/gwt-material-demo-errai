package gwt.material.demo.errai.client.page.addins;

import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.addins.client.richeditor.MaterialRichEditor;
import gwt.material.design.addins.client.richeditor.base.constants.ToolbarButton;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.inject.Inject;

@Templated
@Page(path = "richeditor")
public class RichEditorPage extends AbstractPage {

    @Inject
    @DataField
    private MaterialRichEditor rich;

    @Inject
    @DataField
    private MaterialRichEditor rich2;

    @Inject
    @DataField
    private MaterialButton btnGetHtml;

    @Inject
    @DataField
    private MaterialButton btnSetHtml;

    @Inject
    @DataField
    private MaterialTextBox txtHtml;

    @Inject
    @DataField
    private MaterialRichEditor rich3;

    @Inject
    @DataField
    private MaterialRichEditor rich4;

    @Inject
    @DataField
    private MaterialRichEditor rich5;

    @Inject
    @DataField
    private MaterialRichEditor rich6;

    @Inject
    @DataField
    private MaterialButton btnClear, btnInsertText;

    @Inject
    @DataField
    private MaterialRichEditor rich7;

    @Override
    public String getName() {
        return "Rich Editor";
    }

    @Override
    public String getDescription() {
        return "Provides a great Rich Editor with amazing options built with Material Design Look and Feel.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.ADDINS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
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
