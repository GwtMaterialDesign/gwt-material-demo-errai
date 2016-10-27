package gwt.material.demo.errai.client.local.page.components;

import com.google.gwt.dom.client.Style;
import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.client.constants.CollapsibleType;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.*;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "collapsible")
public class CollapsiblePage extends PageBase {

    private final int BASIC = 0;
    private final int NESTED = 1;
    private final int SECONDARY = 2;

    @Inject
    @DataField
    MaterialCollapsible accordion;

    @Inject
    @DataField
    MaterialCollapsible expandable;

    @Inject
    @DataField
    MaterialCollapsible popout;

    @Inject
    @DataField
    MaterialCollapsible colapsPreselected;

    @Inject
    @DataField
    MaterialCollapsible colapsNested;

    @Inject
    @DataField
    MaterialCollapsible colapsSecondary;

    @PostConstruct
    public void init() {
        initPage(this, "Collapsibles", "Collapsibles are accordion elements that expand when clicked on. They allow you to hide content that is not immediately relevant to the user.", COMPONENTS);
        buildAccordion();
        buidExpandable();
        builPopout();
        buildPreSelected();
        buildNested();
        buildSecondary();
    }

    private void buildSecondary() {
        buildCollapsible(colapsSecondary, SECONDARY);
    }

    private void buildNested() {
        buildCollapsible(colapsNested, NESTED);
    }

    private void buildPreSelected() {
        buildCollapsible(colapsPreselected, BASIC);
        colapsPreselected.setActive(1);
    }

    private void builPopout() {
        popout.setType(CollapsibleType.POPOUT);
        buildCollapsible(popout, BASIC);
    }

    private void buidExpandable() {
        buildCollapsible(expandable, BASIC);
        expandable.setAccordion(false);
    }

    private void buildAccordion() {
        buildCollapsible(accordion, BASIC);
    }

    public void buildCollapsible(MaterialCollapsible collapsible, int type) {
        for (int i = 1; i <= 5; i++) {
            MaterialCollapsibleItem item = new MaterialCollapsibleItem();
            MaterialCollapsibleHeader header = new MaterialCollapsibleHeader();
            MaterialLink link = new MaterialLink();
            link.setText("Item " + i);
            link.setIconType(IconType.POLYMER);
            link.setIconPosition(IconPosition.LEFT);
            link.setTextColor(Color.BLACK);
            header.add(link);

            if (type == SECONDARY) {
                MaterialIcon icon1 = new MaterialIcon();
                icon1.setFloat(Style.Float.RIGHT);
                icon1.setIconType(IconType.POLYMER);

                MaterialIcon icon2 = new MaterialIcon();
                icon2.setFloat(Style.Float.RIGHT);
                icon2.setIconType(IconType.NOTIFICATIONS);
                header.add(icon1);
                header.add(icon2);
            }

            item.add(header);

            MaterialCollapsibleBody body = new MaterialCollapsibleBody();
            if (type == NESTED) {
                MaterialCollapsible child = new MaterialCollapsible();
                buildCollapsible(child, BASIC);
                body.add(child);
            } else {
                MaterialLabel label = new MaterialLabel();
                label.setTextColor(Color.BLACK);
                label.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
                body.add(label);
            }
            item.add(body);
            collapsible.add(item);
        }
    }
}
