package gwt.material.demo.errai.client.local.page.components;

import com.google.gwt.dom.client.Style;
import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.*;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "badge")
public class BadgePage extends PageBase {

    @Inject
    @DataField
    MaterialLink link;

    @Inject
    @DataField
    MaterialLink icon;

    @Inject
    MaterialLink icon2;

    @Inject
    @DataField
    MaterialCollection collection;

    @Inject
    @DataField
    MaterialButton button;

    @Inject
    MaterialDropDown dp;

    @Inject
    @DataField
    MaterialNavBar navBar;

    @Inject
    MaterialNavSection navSection;

    @PostConstruct
    public void init() {
        initPage("Badges", "Badges can notify you that there are new or unread messages or notifications. Add the new class to the badge to give it the background.", COMPONENTS_COLOR);
        buildLinkAndIcon();
        buildCollection();
        buildDropdown();
        buildNavBar();
    }

    private void buildNavBar() {
        icon2.setIconType(IconType.NOTIFICATIONS);
        icon2.setLayoutPosition(Style.Position.RELATIVE);
        MaterialBadge badge = new MaterialBadge();
        badge.setText("1");
        badge.setRight(0);
        badge.setCircle(true);
        badge.setBackgroundColor("pink");
        icon2.add(badge);
        navBar.add(navSection);
        navSection.add(icon2);
    }

    private void buildLinkAndIcon() {
        link.setText("Link");
        MaterialBadge badge = new MaterialBadge();
        badge.setText("1 new");
        badge.setRight(-70);
        badge.setBackgroundColor("pink");
        link.add(badge);

        icon.setIconType(IconType.NOTIFICATIONS);
        MaterialBadge badge2 = new MaterialBadge();
        badge2.setText("1");
        badge2.setRight(0);
        badge2.setCircle(true);
        badge2.setBackgroundColor("pink");
        icon.add(badge2);
    }

    private void buildDropdown() {
        button.add(dp);
        button.setText("Dropdown");
        button.setIconPosition(IconPosition.RIGHT);
        button.setIconType(IconType.ARROW_DROP_DOWN);
        for (int i = 1; i <= 3; i++) {
            MaterialLink link = new MaterialLink("Sample " + i);
            MaterialBadge badge = new MaterialBadge();
            badge.setText("1 new");
            badge.setBackgroundColor("blue");
            link.add(badge);
            dp.add(link);
        }
    }

    private void buildCollection() {
        for (int i = 1; i <= 5; i++) {
            MaterialCollectionItem item = new MaterialCollectionItem();
            MaterialLink link = new MaterialLink("Sample " + i);
            MaterialBadge badge = new MaterialBadge();
            badge.setText("1 new");
            badge.setBackgroundColor("blue");
            link.add(badge);
            item.add(link);
            collection.add(item);
        }
    }
}
