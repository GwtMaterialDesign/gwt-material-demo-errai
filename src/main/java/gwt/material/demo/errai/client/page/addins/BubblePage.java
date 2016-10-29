package gwt.material.demo.errai.client.page.addins;

import com.google.gwt.dom.client.Style;
import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.addins.client.bubble.MaterialBubble;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.Position;
import gwt.material.design.client.ui.MaterialLabel;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.inject.Inject;

@Templated
@Page(path = "bubble")
public class BubblePage extends AbstractPage {

    @Inject
    @DataField
    MaterialBubble bubble;

    @Inject
    @DataField
    MaterialBubble bubble2, bubble3, bubble4, bubble5;

    @Override
    public String getName() {
        return "Bubble";
    }

    @Override
    public String getDescription() {
        return "Addin component for chat module, it display a good bubble view of messages withing the chat module.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.ADDINS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
        buildBasic();
        buildPosition();
    }

    private void buildPosition() {
        bubble2.setBackgroundColor(Color.BLUE);
        bubble2.setPosition(Position.LEFT);
        buildBubble(bubble2);

        bubble3.setBackgroundColor(Color.RED);
        bubble3.setPosition(Position.TOP);
        buildBubble(bubble3);

        bubble4.setBackgroundColor(Color.GREEN);
        bubble4.setPosition(Position.BOTTOM);
        buildBubble(bubble4);

        bubble5.setBackgroundColor(Color.PURPLE);
        bubble5.setPosition(Position.RIGHT);
        buildBubble(bubble5);
    }

    private void buildBasic() {
        bubble.setBackgroundColor(Color.BLUE);
        buildBubble(bubble);
    }

    private void buildBubble(MaterialBubble bubble) {
        bubble.setMarginLeft(20);
        bubble.setTextColor(Color.WHITE);
        bubble.setFloat(Style.Float.LEFT);

        MaterialLabel lblMesssage = new MaterialLabel();
        lblMesssage.setText("Hello there, How are you?");
        MaterialLabel lblName = new MaterialLabel();
        lblName.setText("John Doe");
        lblName.setFontSize("0.8em");
        bubble.add(lblMesssage);
        bubble.add(lblName);
    }

}
