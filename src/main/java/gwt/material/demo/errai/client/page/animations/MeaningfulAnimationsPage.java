package gwt.material.demo.errai.client.page.animations;

import gwt.material.demo.errai.client.ThemeManager;
import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.*;
import gwt.material.design.client.ui.animate.MaterialAnimator;
import gwt.material.design.client.ui.animate.Transition;
import gwt.material.design.client.ui.html.UnorderedList;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "meaningful_animation")
public class MeaningfulAnimationsPage extends AbstractPage {

    @Inject
    @DataField
    MaterialRow rowCards;

    @Inject
    @DataField
    MaterialButton btnShowGrid, btnCloseGrid, btnShowStaggeredList, btnShowFadeInImage;

    @Inject
    @DataField
    UnorderedList listItems;

    @Inject
    @DataField
    MaterialImage image;

    @Override
    public String getName() {
        return "Meaningful Animations";
    }

    @Override
    public String getDescription() {
        return "Motion design can effectively guide the user’s attention in ways that both inform and delight. " +
               "Use motion to smoothly transport users between navigational contexts, explain changes in the " +
               "arrangement of elements on a screen, and reinforce element hierarchy.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.ANIMATIONS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
        buildShowGrid();
        buildStaggeredList();
        buildFadeInImage();
    }

    protected void buildFadeInImage() {
        btnShowFadeInImage.setText("Show Fade in Image");
        btnShowFadeInImage.addClickHandler(clickEvent -> {
            MaterialAnimator.animate(Transition.FADE_IN_IMAGE, image, 0);
        });
    }

    protected void buildStaggeredList() {
        btnShowStaggeredList.setText("Show Staggered List");
        btnShowStaggeredList.addClickHandler(clickEvent -> {
            MaterialAnimator.animate(Transition.SHOW_STAGGERED_LIST, listItems, 0);
        });
        for (int i = 1; i <= 5; i++) {
            listItems.add(new MaterialTitle("Item " + i, "Description " + i));
        }
    }

    protected void buildShowGrid() {
        btnShowGrid.setText("Show Grid");
        btnShowGrid.addClickHandler(clickEvent -> {
            MaterialAnimator.animate(Transition.SHOW_GRID, rowCards, 0);
        });

        btnCloseGrid.setText("Close Grid");
        btnCloseGrid.setType(ButtonType.FLAT);
        btnCloseGrid.addClickHandler(clickEvent -> {
            MaterialAnimator.animate(Transition.CLOSE_GRID, rowCards, 0);
        });
        for (int i = 1; i <= 12; i++) {
            MaterialColumn col = new MaterialColumn(12, 3, 3);
            MaterialCard card = new MaterialCard();
            ThemeManager.register(card);
            MaterialCardContent content = new MaterialCardContent();
            MaterialIcon icon = new MaterialIcon(IconType.POLYMER);
            icon.setIconPosition(IconPosition.LEFT);
            MaterialLink link = new MaterialLink("Card " + i, icon);
            link.setTextColor(Color.WHITE);
            content.add(link);
            card.add(content);
            col.add(card);
            rowCards.add(col);
        }
    }
}
