package gwt.material.demo.errai.client.local.page.components;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.client.constants.Position;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTooltip;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Templated
@Page(path = "tooltip")
@ApplicationScoped
public class TooltipPage extends PageBase {

    @Inject
    @DataField
    MaterialButton btnTop, btnLeft, btnRight, btnBottom;

    @Inject
    @DataField
    MaterialButton btnHtml;

    @PostConstruct
    public void init() {
        initPage("Tooltip", "Tooltips are small, interactive, textual hints for mainly graphical elements. When using icons for actions you can use a tooltip to give people clarification on its function.", COMPONENTS);
        buildBasic();
        buildHtml();
    }

    private void buildHtml() {
        btnHtml.setText("HTML Tooltip");
        btnHtml.setTooltipHTML("<b>This is bold</b><i>and italic</i>");
    }

    private void buildBasic() {
        btnTop.setText("Top");
        btnTop.setTooltip("I am tooltip");
        btnTop.setTooltipPosition(Position.TOP);

        btnLeft.setText("Left");
        btnLeft.setTooltip("I am tooltip");
        btnLeft.setTooltipPosition(Position.LEFT);

        btnRight.setText("Right");
        btnRight.setTooltip("I am tooltip");
        btnRight.setTooltipPosition(Position.RIGHT);

        btnBottom.setText("Bottom");
        btnBottom.setTooltip("I am tooltip");
        btnBottom.setTooltipPosition(Position.BOTTOM);
    }
}
