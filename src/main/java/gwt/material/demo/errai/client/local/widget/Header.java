package gwt.material.demo.errai.client.local.widget;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.Composite;
import gwt.material.demo.errai.client.local.events.PageChangeEvent;
import gwt.material.design.client.constants.HideOn;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.NavBarType;
import gwt.material.design.client.ui.*;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@Templated
public class Header extends Composite {

    @Inject
    @DataField
    MaterialNavBar navBar;

    @Inject
    @DataField
    MaterialNavBar searchNav;

    @Inject
    MaterialSearch search;

    @Inject
    MaterialNavSection navSection;

    @Inject
    MaterialLink iconSearch;

    @Inject
    @DataField
    MaterialPanel titlePanel;

    @Inject
    MaterialLabel lblTitle;

    @Inject
    MaterialLabel lblDescription;

    @PostConstruct
    public void init() {
        navBar.setActivates("sideNav");
        navBar.setType(NavBarType.FIXED);

        // Nav section
        navSection.setHideOn(HideOn.NONE);
        iconSearch.setIconType(IconType.SEARCH);
        iconSearch.addClickHandler(clickEvent -> {
            changeNav(searchNav);
        });
        navSection.add(iconSearch);
        navBar.add(navSection);

        // Title Panel
        lblTitle.setFontSize(2.3, Style.Unit.EM);
        titlePanel.add(lblTitle);
        titlePanel.add(lblDescription);

        // Search Navbar
        search.setPlaceholder("Search");
        search.setActive(true);
        search.addCloseHandler(closeEvent -> {
            changeNav(navBar);
        });
        searchNav.add(search);
        changeNav(navBar);
    }

    protected void changeNav(MaterialNavBar nav) {
        searchNav.setVisible(false);
        navBar.setVisible(false);
        nav.setVisible(true);
    }

    public void onPageChange(@Observes PageChangeEvent event) {
        lblTitle.setText(event.getTitle());
        lblDescription.setText(event.getDescription());
        navBar.setBackgroundColor(event.getColor() + " darken-1");
        titlePanel.setBackgroundColor(event.getColor());
    }
}
