package gwt.material.demo.errai.client.local.page.components;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.client.constants.Axis;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.*;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Templated
@Page(path = "card")
@ApplicationScoped
public class CardPage extends PageBase {

    @Inject
    @DataField
    MaterialCard cardBasic;

    @Inject
    @DataField
    MaterialCard cardImage;

    @Inject
    @DataField
    MaterialCard cardHorizontal;

    @Inject
    @DataField
    MaterialCard cardReveal;

    @PostConstruct
    public void init() {
        initPage("Cards", "Cards are a convenient means of displaying content composed of different types of objects. They are also well-suited for presenting similar objects whose size or supported actions can vary considerably, like photos with captions of variable length.", COMPONENTS_COLOR);
        buildBasic();
        buildCardImage();
        buildHorizontalCard();
        buildCardReveal();
    }

    private void buildCardReveal() {
        MaterialCardImage cardImageCon = new MaterialCardImage();
        cardImageCon.setWaves(WavesType.LIGHT);
        MaterialImage image = new MaterialImage();
        image.setUrl("http://assets.materialup.com/uploads/b6992fb2-7bf4-401d-a233-e34a486b9337/gif.gif");
        cardImageCon.add(image);

        MaterialCardContent content = new MaterialCardContent();
        MaterialCardTitle title = new MaterialCardTitle();
        title.setIconType(IconType.MORE_VERT);
        title.setIconPosition(IconPosition.RIGHT);
        title.setText("Sample");
        content.add(title);

        MaterialCardReveal reveal = new MaterialCardReveal();
        MaterialCardTitle revealTitle = new MaterialCardTitle();
        revealTitle.setIconType(IconType.MORE_VERT);
        revealTitle.setIconPosition(IconPosition.RIGHT);
        revealTitle.setText("Sample");
        MaterialLabel revealDescription = new MaterialLabel();
        revealDescription.setText("Here is some more information about this product that is only revealed once clicked on.");
        reveal.add(revealTitle);
        reveal.add(revealDescription);

        MaterialCardAction action = new MaterialCardAction();
        MaterialLink link = new MaterialLink();
        link.setText("Link 1");
        action.add(link);

        cardReveal.add(cardImageCon);
        cardReveal.add(content);
        cardReveal.add(reveal);
        cardReveal.add(action);
    }

    private void buildHorizontalCard() {
        cardHorizontal.setAxis(Axis.HORIZONTAL);
        MaterialCardImage cardImageCon = new MaterialCardImage();
        cardImageCon.setWaves(WavesType.LIGHT);
        MaterialImage image = new MaterialImage();
        image.setUrl("http://assets.materialup.com/uploads/b6992fb2-7bf4-401d-a233-e34a486b9337/gif.gif");
        cardImageCon.add(image);

        MaterialCardContent content = new MaterialCardContent();
        MaterialLabel title = new MaterialLabel();
        title.setText("Title of your card");
        MaterialLabel description = new MaterialLabel();
        description.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
        description.setTruncate(true);
        content.add(title);
        content.add(description);

        MaterialCardAction action = new MaterialCardAction();
        MaterialLink link = new MaterialLink();
        link.setText("Link 1");
        action.add(link);

        cardHorizontal.add(cardImageCon);
        cardHorizontal.add(content);
        cardHorizontal.add(action);
    }

    private void buildCardImage() {
        MaterialCardImage cardImageCon = new MaterialCardImage();
        cardImageCon.setWaves(WavesType.LIGHT);
        MaterialImage image = new MaterialImage();
        image.setUrl("http://assets.materialup.com/uploads/b6992fb2-7bf4-401d-a233-e34a486b9337/gif.gif");
        MaterialCardTitle title = new MaterialCardTitle();
        title.setText("Sample");
        cardImageCon.add(image);
        cardImageCon.add(title);

        MaterialCardContent content = new MaterialCardContent();
        MaterialLabel label = new MaterialLabel();
        label.setText("I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.");
        content.add(label);

        MaterialCardAction action = new MaterialCardAction();
        MaterialLink link = new MaterialLink();
        link.setText("Link 1");
        action.add(link);

        cardImage.add(cardImageCon);
        cardImage.add(content);
        cardImage.add(action);
    }

    private void buildBasic() {
        MaterialCardContent content = new MaterialCardContent();
        MaterialCardTitle title = new MaterialCardTitle();
        title.setText("Sample");
        title.setIconType(IconType.POLYMER);
        title.setIconPosition(IconPosition.RIGHT);

        MaterialLabel label = new MaterialLabel();
        label.setText("I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.");
        content.add(title);
        content.add(label);

        MaterialCardAction action = new MaterialCardAction();
        MaterialLink link = new MaterialLink();
        link.setText("Link 1");
        action.add(link);

        cardBasic.add(content);
        cardBasic.add(action);
    }
}
