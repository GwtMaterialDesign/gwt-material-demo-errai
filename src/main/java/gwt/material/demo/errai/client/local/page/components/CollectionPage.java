package gwt.material.demo.errai.client.local.page.components;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.client.constants.*;
import gwt.material.design.client.ui.*;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "collection")
public class CollectionPage extends PageBase {

    @Inject
    @DataField
    MaterialCollection collectionBasic;

    @Inject
    @DataField
    MaterialCollection collectionSelection;

    @Inject
    @DataField
    MaterialCollection collectionHeader;

    @Inject
    @DataField
    MaterialCollection collectionSecondary;

    @Inject
    @DataField
    MaterialCollection collectionAvatar;

    @Inject
    @DataField
    MaterialCollection collectionDismissable;

    @Inject
    @DataField
    MaterialCollection collectionCheckBox;

    @Inject
    @DataField
    MaterialCollection collectionSwitch;

    @PostConstruct
    public void init() {
        initPage(this, "Collections", "Collections allow you to group list objects together.", COMPONENTS);
        buildBasic();
        buildPreSelection();
        buildHeader();
        buildSecondaryContent();
        buildAvatar();
        buildDismissable();
        buildCheckBox();
        buildSwitch();
    }

    private void buildSwitch() {
        for (int i = 1; i <= 5; i++) {
            MaterialCollectionItem item = new MaterialCollectionItem();
            item.setType(CollectionType.CHECKBOX);
            item.setWaves(WavesType.DEFAULT);

            MaterialLink link = new MaterialLink("Item " + i);
            link.setDisplay(Display.INLINE_BLOCK);
            link.setIconPosition(IconPosition.LEFT);
            link.setIconType(IconType.POLYMER);
            link.setIconColor(Color.BLACK);
            link.setTextColor(Color.BLACK);
            item.add(link);

            MaterialCollectionSecondary secondary = new MaterialCollectionSecondary();
            MaterialSwitch switch1 = new MaterialSwitch();
            switch1.setValue(true);
            secondary.add(switch1);
            item.add(secondary);

            collectionSwitch.add(item);
        }
    }

    private void buildCheckBox() {
        for (int i = 1; i <= 5; i++) {
            MaterialCollectionItem item = new MaterialCollectionItem();
            item.setType(CollectionType.CHECKBOX);
            item.setWaves(WavesType.DEFAULT);

            MaterialLabel label = new MaterialLabel("Item " + i);
            label.setDisplay(Display.INLINE_BLOCK);
            item.add(label);

            MaterialCollectionSecondary secondary = new MaterialCollectionSecondary();
            MaterialCheckBox checkBox = new MaterialCheckBox();
            checkBox.setType(CheckBoxType.FILLED);
            checkBox.setValue(false);
            secondary.add(checkBox);
            item.add(secondary);

            collectionCheckBox.add(item);
        }
    }

    private void buildDismissable() {
        for (int i = 1; i <= 5; i++) {
            MaterialCollectionItem item = new MaterialCollectionItem();
            item.setType(CollectionType.AVATAR);
            item.setDismissible(true);

            MaterialImage image = new MaterialImage("http://materializecss.com/images/yuna.jpg");
            image.setType(ImageType.CIRCLE);
            item.add(image);

            MaterialLabel title = new MaterialLabel("Title");
            title.setFontSize("1.5em");
            item.add(title);

            item.add(new MaterialLabel("First Line"));
            item.add(new MaterialLabel("Second Line"));
            collectionDismissable.add(item);
        }
    }

    private void buildAvatar() {
        for (int i = 1; i <= 5; i++) {
            MaterialCollectionItem item = new MaterialCollectionItem();
            item.setType(CollectionType.AVATAR);

            MaterialImage image = new MaterialImage("http://materializecss.com/images/yuna.jpg");
            image.setType(ImageType.CIRCLE);
            item.add(image);

            MaterialLabel title = new MaterialLabel("Title");
            title.setFontSize("1.5em");
            item.add(title);

            item.add(new MaterialLabel("First Line"));
            item.add(new MaterialLabel("Second Line"));
            collectionAvatar.add(item);
        }
    }

    private void buildSecondaryContent() {
        for (int i = 1; i <= 5; i++) {
            MaterialCollectionItem item = new MaterialCollectionItem();
            item.add(new MaterialLabel("Collection Item " + i));
            MaterialCollectionSecondary secondary = new MaterialCollectionSecondary();
            MaterialIcon icon = new MaterialIcon(IconType.POLYMER);
            icon.setIconPosition(IconPosition.RIGHT);
            icon.setWaves(WavesType.DEFAULT);
            secondary.add(icon);
            item.add(secondary);
            collectionSecondary.add(item);
        }
        collectionSecondary.setHeader("Header Title");
    }

    private void buildHeader() {
        buildCollection(collectionHeader);
        collectionHeader.setActive(2);
        collectionHeader.setHeader("Header Title");
    }

    private void buildPreSelection() {
        buildCollection(collectionSelection);
        collectionSelection.setActive(1);
    }

    private void buildBasic() {
        buildCollection(collectionBasic);
    }

    private void buildCollection(MaterialCollection collection) {
        for (int i = 1; i <= 5; i++) {
            MaterialCollectionItem item = new MaterialCollectionItem();
            item.add(new MaterialLabel("Collection Item " + i));
            collection.add(item);
        }
    }
}
