package gwt.material.demo.errai.client.local.widget;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.Composite;
import gwt.material.demo.errai.client.local.ThemeManager;
import gwt.material.demo.errai.client.local.events.PageChangeEvent;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.client.constants.HideOn;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.NavBarType;
import gwt.material.design.client.events.SideNavClosedEvent;
import gwt.material.design.client.events.SideNavOpenedEvent;
import gwt.material.design.client.ui.*;
import gwt.material.design.themes.client.ThemeLoader;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import static gwt.material.design.jquery.client.api.JQuery.$;

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

    @Inject
    MaterialComboBox<ThemeLoader.ThemeBundle> comboBox;

    @Inject
    ThemeSwitcher themeSwitcher;

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
        navSection.add(themeSwitcher);
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
        $("body").scrollTop(0);
        lblTitle.setText(event.getTitle());
        lblDescription.setText(event.getDescription());
        ThemeManager.register(navBar, ThemeManager.DARKER_SHADE);
        ThemeManager.register(titlePanel);
    }

    public void onSideNavOpened(@Observes SideNavOpenedEvent event) {
        navBar.getElement().getStyle().setProperty("transition", "none");
        navBar.getElement().getStyle().setProperty("width", "calc(100% - 280px)");
        searchNav.getElement().getStyle().setProperty("width", "calc(100% - 280px)");
    }

    public void onSideNavClosed(@Observes SideNavClosedEvent event) {
        navBar.getElement().getStyle().setProperty("transition", "none");
        navBar.getElement().getStyle().setProperty("width", "100%");
        searchNav.getElement().getStyle().setProperty("width", "calc(100% - 280px)");
    }
}
