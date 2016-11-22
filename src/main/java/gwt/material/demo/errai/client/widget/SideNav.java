package gwt.material.demo.errai.client.widget;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.Composite;
import gwt.material.demo.errai.client.ThemeManager;
import gwt.material.demo.errai.client.dto.DataHelper;
import gwt.material.demo.errai.client.dto.Link;
import gwt.material.design.addins.client.avatar.MaterialAvatar;
import gwt.material.design.addins.client.sideprofile.MaterialSideProfile;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.SideNavType;
import gwt.material.design.client.events.SideNavClosedEvent;
import gwt.material.design.client.events.SideNavOpenedEvent;
import gwt.material.design.client.ui.*;
import gwt.material.design.client.ui.html.UnorderedList;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@Templated
public class SideNav extends Composite {

    @Inject
    @DataField
    private MaterialSideNav sideNav;

    @Inject
    private MaterialSideProfile profile;

    @Inject
    private Event<SideNavOpenedEvent> sidenavOpenedEvent;

    @Inject
    private Event<SideNavClosedEvent> sideNavClosedEvent;

    @PostConstruct
    protected void init() {
        sideNav.setId("sideNav");
        sideNav.setShowOnAttach(false);
        sideNav.setType(SideNavType.PUSH);
        sideNav.setWidth(280);
        sideNav.reinitialize();

        ThemeManager.register(profile);
        MaterialAvatar avatar = new MaterialAvatar("kevzlou7979");
        avatar.setWidth("50");
        avatar.setHeight("50");
        avatar.setCircle(true);
        avatar.setBackgroundColor(Color.WHITE);
        avatar.setShadow(1);
        MaterialLabel label = new MaterialLabel("gwt-material-errai");
        label.setFontWeight(Style.FontWeight.BOLD);
        MaterialLabel description = new MaterialLabel("Version 1.0");
        description.setFontSize(0.8, Style.Unit.EM);
        description.setMarginTop(20);
        profile.setTextColor(Color.WHITE);
        profile.setUrl("https://lh3.googleusercontent.com/-HDNu3zUU0zA/VMSgMzf77OI/AAAAAAAADx4/ZP5sRDbc8ag/w1920-h1080/Google%2BIO%2BPlane%2BDesign_HD.jpg");
        profile.add(avatar);
        profile.add(label);
        profile.add(description);
        sideNav.add(profile);

        sideNav.addOpenedHandler(event -> {
            sidenavOpenedEvent.fire(new SideNavOpenedEvent());
        });

        sideNav.addClosingHandler(event -> {
            sideNavClosedEvent.fire(new SideNavClosedEvent());
        });

        for (Link l : DataHelper.getAppLinks()) {
            if (l.getSubLinks().size() > 0) {
                MaterialCollapsible colaps = new MaterialCollapsible();
                MaterialCollapsibleItem item = new MaterialCollapsibleItem();
                MaterialLink link = new MaterialLink();
                link.setText(l.getName());
                if (l.getIcon() != null) {
                    link.setIconType(l.getIcon());
                }
                MaterialCollapsibleHeader header = new MaterialCollapsibleHeader();
                MaterialCollapsibleBody body = new MaterialCollapsibleBody();
                UnorderedList list = new UnorderedList();

                for (Link sub : l.getSubLinks()) {
                    MaterialLink subLink = new MaterialLink();
                    subLink.setText(sub.getName());
                    subLink.setHref(sub.getHref());
                    if (sub.isReady()) {
                        MaterialBadge badge = new MaterialBadge();
                        badge.setText("Ready");
                        badge.setBackgroundColor(Color.GREEN);
                        subLink.add(badge);
                    }
                    list.add(subLink);
                }

                colaps.add(item);
                item.add(header);
                item.add(body);
                body.add(list);
                body.setParent(colaps);
                header.add(link);
                sideNav.add(colaps);
            } else {
                MaterialLink link = new MaterialLink();
                if (l.getIcon() != null) {
                    link.setIconType(l.getIcon());
                }
                link.setText(l.getName());
                if (l.getHref() != null) {
                    link.setHref(l.getHref());
                }
                sideNav.add(link);
            }
        }
    }

}

