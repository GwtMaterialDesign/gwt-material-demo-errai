package gwt.material.demo.errai.client.local.page.addins;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.addins.client.swipeable.MaterialSwipeablePanel;
import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialCardContent;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialToast;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "swipeable")
public class SwipeablePage extends PageBase {

    @Inject
    @DataField
    MaterialSwipeablePanel swipe;

    @Inject
    @DataField
    MaterialSwipeablePanel swipeEvents;

    @Inject
    @DataField
    MaterialSwipeablePanel swipeDisabled;

    @PostConstruct
    public void init() {
        initPage("Swipeable", "A panel that allows any of its nested children to be swiped away. This component is only applicable to touch screen devices.", ADDINS_COLOR);
        buildBasic();
        buildSwipeEvents();
        buildSwipeDisabled();
    }

    private void buildSwipeDisabled() {
        for(int i = 1; i <= 3; i++) {
            MaterialCard card = new MaterialCard();
            MaterialCardContent content = new MaterialCardContent();
            MaterialLabel lblCard = new MaterialLabel("Item " + i);
            content.add(lblCard);
            card.add(content);
            if ( i >= 2) {
                lblCard.setText("Item " + i + " (Disabled)");
            }
            swipeDisabled.add(card);
        }
        swipeDisabled.ignore(swipeDisabled.getWidget(1), swipeDisabled.getWidget(2));
    }

    private void buildSwipeEvents() {
        swipeEvents.addSwipeLeft(event -> {
            MaterialToast.fireToast("Swiped Left");
        });

        swipeEvents.addSwipeRight(event -> {
            MaterialToast.fireToast("Swiped Right");
        });
        for(int i = 1; i <= 3; i++) {
            MaterialCard card = new MaterialCard();
            MaterialCardContent content = new MaterialCardContent();
            MaterialLabel lblCard = new MaterialLabel("Item " + i);
            content.add(lblCard);
            card.add(content);
            swipeEvents.add(card);
        }
    }

    private void buildBasic() {
        MaterialLabel label = new MaterialLabel("You can swipe native components. This is a plain label");
        label.setBackgroundColor("yellow");
        label.setPadding(12);
        swipe.add(label);

        MaterialCard card = new MaterialCard();
        MaterialCardContent content = new MaterialCardContent();
        MaterialLabel lblCard = new MaterialLabel("This is another Card Component that is swipeable.");
        content.add(lblCard);
        card.add(content);
        swipe.add(card);

        MaterialCard card2 = new MaterialCard();
        card2.setBackgroundColor("blue");
        card2.setTextColor("white");
        MaterialCardContent content2 = new MaterialCardContent();
        MaterialLabel lblCard2 = new MaterialLabel("This is another Card Component that is swipeable.");
        content2.add(lblCard2);
        card2.add(content2);
        swipe.add(card2);
    }
}
