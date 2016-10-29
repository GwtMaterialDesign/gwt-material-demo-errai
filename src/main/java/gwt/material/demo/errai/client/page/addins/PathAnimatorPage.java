package gwt.material.demo.errai.client.page.addins;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickHandler;
import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.addins.client.overlay.MaterialOverlay;
import gwt.material.design.addins.client.pathanimator.MaterialPathAnimator;
import gwt.material.design.client.constants.*;
import gwt.material.design.client.ui.*;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "pathanimator")
public class PathAnimatorPage extends AbstractPage {

    @Inject
    @DataField
    MaterialButton btnSource1;

    @Inject
    @DataField
    MaterialOverlay overlay1;

    @Inject
    @DataField
    MaterialCard card;

    @Inject
    @DataField
    MaterialOverlay overlay2;

    @Inject
    @DataField
    MaterialButton btnSource2;

    @Inject
    @DataField
    MaterialCard card2;

    @Inject
    @DataField
    MaterialColumn grid1, grid2, grid3, grid4, grid5, grid6, grid7;

    @Inject
    @DataField
    MaterialOverlay gridOverlay1, gridOverlay2, gridOverlay3, gridOverlay4, gridOverlay5, gridOverlay6, gridOverlay7;

    @Override
    public String getName() {
        return "Path Animator";
    }

    @Override
    public String getDescription() {
        return "Custom component that provides meaningful transition between two elements to show visual continuity.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.ADDINS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
        buildButtonToOverlay();
        buildCardToOverlay();
        buildButtonCard();
        buildGrids();
    }

    private void buildGrids() {
        grid1.addClickHandler(clickEvent -> {
            MaterialPathAnimator.animate(grid1.getElement(), gridOverlay1.getElement());
        });
        buildOverlay(gridOverlay1, clickEvent -> {
            MaterialPathAnimator.reverseAnimate(grid1.getElement(), gridOverlay1.getElement());
        });

        grid2.addClickHandler(clickEvent -> {
            MaterialPathAnimator.animate(grid2.getElement(), gridOverlay2.getElement());
        });
        buildOverlay(gridOverlay2, clickEvent -> {
            MaterialPathAnimator.reverseAnimate(grid2.getElement(), gridOverlay2.getElement());
        });

        grid3.addClickHandler(clickEvent -> {
            MaterialPathAnimator.animate(grid3.getElement(), gridOverlay3.getElement());
        });
        buildOverlay(gridOverlay3, clickEvent -> {
            MaterialPathAnimator.reverseAnimate(grid3.getElement(), gridOverlay3.getElement());
        });

        grid4.addClickHandler(clickEvent -> {
            MaterialPathAnimator.animate(grid4.getElement(), gridOverlay4.getElement());
        });
        buildOverlay(gridOverlay4, clickEvent -> {
            MaterialPathAnimator.reverseAnimate(grid4.getElement(), gridOverlay4.getElement());
        });

        grid5.addClickHandler(clickEvent -> {
            MaterialPathAnimator.animate(grid5.getElement(), gridOverlay5.getElement());
        });
        buildOverlay(gridOverlay5, clickEvent -> {
            MaterialPathAnimator.reverseAnimate(grid5.getElement(), gridOverlay5.getElement());
        });

        grid6.addClickHandler(clickEvent -> {
            MaterialPathAnimator.animate(grid6.getElement(), gridOverlay6.getElement());
        });
        buildOverlay(gridOverlay6, clickEvent -> {
            MaterialPathAnimator.reverseAnimate(grid6.getElement(), gridOverlay6.getElement());
        });

        grid7.addClickHandler(clickEvent -> {
            MaterialPathAnimator.animate(grid7.getElement(), gridOverlay7.getElement());
        });
        buildOverlay(gridOverlay7, clickEvent -> {
            MaterialPathAnimator.reverseAnimate(grid7.getElement(), gridOverlay7.getElement());
        });
    }

    private void buildButtonCard() {
        // Build Button
        btnSource2.setText("Meaningful Transitions");
        btnSource2.setSize(ButtonSize.LARGE);
        btnSource2.addClickHandler(clickEvent -> {
            MaterialPathAnimator.animate(btnSource2.getElement(), card2.getElement());
        });

        // Build Card
        card2.setVisibility(Style.Visibility.HIDDEN);
        card2.setOpacity(0);
        buildCard(card2, clickEvent -> {
            MaterialPathAnimator.reverseAnimate(btnSource2.getElement(), card2.getElement());
        });
    }

    private void buildCardToOverlay() {
        buildCard(card, clickEvent -> {
            MaterialPathAnimator.animate(card.getElement(), overlay2.getElement());
        });

        // Build Overlay
        buildOverlay(overlay2, clickEvent -> {
            MaterialPathAnimator.reverseAnimate(card.getElement(), overlay2.getElement());
        });
    }

    private void buildButtonToOverlay() {
        // Build Button
        btnSource1.setText("Meaningful Transitions");
        btnSource1.setSize(ButtonSize.LARGE);
        btnSource1.addClickHandler(clickEvent -> {
            MaterialPathAnimator.animate(btnSource1.getElement(), overlay1.getElement());
        });

        // Build Overlay
        buildOverlay(overlay1, clickEvent -> {
            MaterialPathAnimator.reverseAnimate(btnSource1.getElement(), overlay1.getElement());
        });
    }

    private void buildCard(MaterialCard card, ClickHandler handler) {
        MaterialCardContent content = new MaterialCardContent();
        content.setTextColor(Color.WHITE);
        MaterialCardTitle title = new MaterialCardTitle();
        title.setText("Sample");
        title.setIconType(IconType.POLYMER);
        title.setIconPosition(IconPosition.RIGHT);
        MaterialLabel label = new MaterialLabel("I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.");
        content.add(title);
        content.add(label);
        card.add(content);

        MaterialCardAction action = new MaterialCardAction();
        MaterialLink link = new MaterialLink("Transition this card");
        link.addClickHandler(handler);
        action.add(link);
        card.add(action);
    }

    private void buildOverlay(MaterialOverlay overlay, ClickHandler handler) {
        overlay.setVisibility(Style.Visibility.HIDDEN);
        overlay.setTextAlign(TextAlign.CENTER);
        overlay.setOpacity(0);

        MaterialTitle title = new MaterialTitle();
        title.setGrid("s12 l6 m6");
        title.setOffset("s0 l3 m3");
        title.setMarginBottom(80);
        title.setTextColor(Color.WHITE);
        title.setTitle("Meaningful transitions");
        title.setDescription("Motion design can effectively guide the user’s attention in ways that both inform and delight. Use motion to smoothly transport users between navigational contexts, explain changes in the arrangement of elements on a screen, and reinforce element hierarchy.");

        MaterialColumn column = new MaterialColumn();
        MaterialButton btnClose = new MaterialButton();
        column.setTextAlign(TextAlign.CENTER);
        column.setGrid("s12");
        btnClose.setText("Back to Main Page");
        btnClose.setBackgroundColor(Color.BLUE_LIGHTEN_2);
        btnClose.setTextColor(Color.WHITE);
        btnClose.setSize(ButtonSize.LARGE);
        btnClose.addClickHandler(handler);
        column.add(btnClose);

        overlay.add(title);
        overlay.add(column);
    }
}
