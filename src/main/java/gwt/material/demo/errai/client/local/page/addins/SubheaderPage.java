package gwt.material.demo.errai.client.local.page.addins;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.addins.client.subheader.MaterialSubHeader;
import gwt.material.design.addins.client.subheader.MaterialSubHeaderContainer;
import gwt.material.design.addins.client.subheader.constants.SubHeaderType;
import gwt.material.design.client.constants.CollectionType;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.ImageType;
import gwt.material.design.client.ui.MaterialCollection;
import gwt.material.design.client.ui.MaterialCollectionItem;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "subheader")
public class SubheaderPage extends PageBase {

    @Inject
    @DataField
    MaterialSubHeaderContainer subheaderContainer, subheaderContainerStatic;

    @PostConstruct
    public void init() {
        initPage("SubHeaders", "SubHeaders are special list tiles that delineate distinct sections of a list or grid list and are typically related to the current filtering or sorting criteria. Subheader tiles are either displayed inline with tiles or can be associated with content, for example, in an adjacent column.", ADDINS);
        buildSimple();
        buildStatic();
    }

    protected void buildStatic() {
        subheaderContainerStatic.setType(SubHeaderType.STATIC);
        buildSubheader(subheaderContainerStatic);
    }

    protected void buildSimple() {
        subheaderContainerStatic.setType(SubHeaderType.PINNED);
        buildSubheader(subheaderContainer);
    }

    protected void buildSubheader(MaterialSubHeaderContainer container) {
        for (int i = 1; i <= 5; i++) {
            MaterialSubHeader header = new MaterialSubHeader("Subheader " + i);
            container.add(header);
            MaterialCollection collection = new MaterialCollection();
            container.add(collection);
            for (int k = 1; k <= 5; k++) {
                MaterialCollectionItem item = new MaterialCollectionItem();
                item.setType(CollectionType.AVATAR);

                MaterialImage image = new MaterialImage("http://materializecss.com/images/yuna.jpg");
                image.setType(ImageType.CIRCLE);
                item.add(image);

                MaterialLabel title = new MaterialLabel("This is SubHeader");
                title.setFontSize("1.5em");
                item.add(title);

                item.add(new MaterialLabel("First Line"));
                item.add(new MaterialLabel("Second Line"));
                collection.add(item);
            }
        }
    }
}
