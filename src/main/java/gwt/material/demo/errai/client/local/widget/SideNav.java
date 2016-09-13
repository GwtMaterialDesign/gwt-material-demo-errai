package gwt.material.demo.errai.client.local.widget;

import com.google.gwt.user.client.ui.Composite;
import gwt.material.demo.errai.client.local.dto.DataHelper;
import gwt.material.demo.errai.client.local.dto.Link;
import gwt.material.design.client.constants.SideNavType;
import gwt.material.design.client.ui.*;
import gwt.material.design.client.ui.html.UnorderedList;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
public class SideNav extends Composite {

    @Inject
    @DataField
    MaterialSideNav sideNav;

    @Inject
    MaterialNavBrand navBrand;

    @PostConstruct
    public void init() {
        sideNav.setId("sideNav");
        sideNav.setType(SideNavType.FIXED);
        sideNav.setWidth(280);
        sideNav.reinitialize();

        navBrand.setText("gwt-material");
        sideNav.add(navBrand);

        for (Link l : DataHelper.getAppLinks()) {
            if (l.getSubLinks().size() > 0) {
                MaterialCollapsible colaps = new MaterialCollapsible();
                MaterialCollapsibleItem item = new MaterialCollapsibleItem();
                MaterialLink link = new MaterialLink();
                link.setText(l.getName());
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
                        badge.setBackgroundColor("green");
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
                link.setText(l.getName());
                if (l.getHref() != null) {
                    link.setHref(l.getHref());
                }
                sideNav.add(link);
            }
        }
    }

}

