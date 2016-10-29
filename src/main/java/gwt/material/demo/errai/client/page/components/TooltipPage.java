package gwt.material.demo.errai.client.page.components;

import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.client.constants.Position;
import gwt.material.design.client.ui.MaterialButton;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "tooltip")
public class TooltipPage extends AbstractPage {

    @Inject
    @DataField
    MaterialButton btnTop, btnLeft, btnRight, btnBottom;

    @Inject
    @DataField
    MaterialButton btnHtml;

    @Override
    public String getName() {
        return "Tooltip";
    }

    @Override
    public String getDescription() {
        return "Tooltips are small, interactive, textual hints for mainly graphical elements. " +
               "When using icons for actions you can use a tooltip to give people clarification on its function.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.COMPONENTS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
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
