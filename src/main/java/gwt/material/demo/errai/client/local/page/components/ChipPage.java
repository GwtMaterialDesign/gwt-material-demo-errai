package gwt.material.demo.errai.client.local.page.components;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialChip;
import gwt.material.design.client.ui.MaterialToast;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Templated
@Page(path = "chip")
@ApplicationScoped
public class ChipPage extends PageBase {

    @Inject
    @DataField
    MaterialChip chip1, chip2, chip3, chip4, chip5;

    @Inject
    @DataField
    MaterialChip letterChip1, letterChip2, letterChip3, letterChip4;

    @Inject
    @DataField
    MaterialChip staticChip1, staticChip2, staticChip3;

    @Inject
    @DataField
    MaterialChip contactChip1, contactChip2, contactChip3;

    @Inject
    @DataField
    MaterialChip event1, event2;

    @PostConstruct
    public void init() {
        initPage("Chips", "Chips represent complex entities in small blocks, such as a contact. They can contain a photo, short title string, and brief information. Chips are manipulated through drag-and-drop. Touching them invokes the full view in a card or full screen view or invokes a menu of options related to that chip's entity.", COMPONENTS);
        buildChips();
        buildLetterChips();
        buildStaticChips();
        buildContactChips();
        buildEventChips();
    }

    private void buildEventChips() {
        event1.setText("Click Me");
        event1.addClickHandler(clickEvent -> {
            MaterialToast.fireToast("Clicked");
        });

        event2.setText("Remove Me");
        event2.setIconType(IconType.CLOSE);
        event2.getIcon().addClickHandler(clickEvent -> {
            MaterialToast.fireToast("Removed");
        });
    }

    private void buildContactChips() {
        contactChip1.setUrl("http://b.vimeocdn.com/ps/339/488/3394886_300.jpg");
        contactChip1.setText("Yunalis Mat Zara'ai");

        contactChip2.setUrl("http://lorempixel.com/50/50/people?1");
        contactChip2.setText("Marjoarie Matias");

        contactChip3.setUrl("http://lorempixel.com/50/50/people?8");
        contactChip3.setText("Zenaida Ringor");
    }

    private void buildStaticChips() {
        staticChip1.setText("Apple");
        staticChip2.setText("Apple");
        staticChip3.setText("Apple");
    }

    private void buildLetterChips() {
        letterChip1.setText("Apple");
        letterChip1.setLetter("A");
        letterChip1.setLetterColor(Color.WHITE);
        letterChip1.setLetterBackgroundColor(Color.RED);
        letterChip1.setIconType(IconType.CLOSE);

        letterChip2.setText("Grapes");
        letterChip2.setLetter("G");
        letterChip2.setLetterColor(Color.PINK_ACCENT_1);
        letterChip2.setLetterBackgroundColor(Color.PURPLE);
        letterChip2.setIconType(IconType.CLOSE);

        letterChip3.setText("Dalandan");
        letterChip3.setLetter("D");
        letterChip3.setLetterColor(Color.WHITE);
        letterChip3.setLetterBackgroundColor(Color.GREEN);
        letterChip3.setIconType(IconType.CLOSE);

        letterChip4.setText("Mango");
        letterChip4.setLetter("M");
        letterChip4.setLetterColor(Color.ORANGE);
        letterChip4.setLetterBackgroundColor(Color.YELLOW);
        letterChip4.setIconType(IconType.CLOSE);
    }

    private void buildChips() {
        chip1.setText("Default");

        chip2.setText("Apple");
        chip2.setBackgroundColor(Color.RED);
        chip2.setIconType(IconType.CLOSE);

        chip3.setText("Orange");
        chip3.setBackgroundColor(Color.ORANGE);
        chip3.setIconType(IconType.CLOSE);

        chip4.setText("Banana");
        chip4.setBackgroundColor(Color.AMBER);
        chip4.setIconType(IconType.CLOSE);

        chip5.setText("Mango");
        chip5.setBackgroundColor(Color.GREEN);
        chip5.setIconType(IconType.CLOSE);
    }
}
