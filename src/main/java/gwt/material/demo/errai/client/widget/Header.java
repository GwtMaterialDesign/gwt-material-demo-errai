package gwt.material.demo.errai.client.widget;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.demo.errai.client.ThemeManager;
import gwt.material.demo.errai.client.events.CodeCutOutEvent;
import gwt.material.demo.errai.client.events.PageChangeEvent;
import gwt.material.demo.errai.client.events.SearchCutOutEvent;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.addins.client.cutout.MaterialCutOut;
import gwt.material.design.client.base.SearchObject;
import gwt.material.design.client.constants.*;
import gwt.material.design.client.events.SideNavClosedEvent;
import gwt.material.design.client.events.SideNavOpenedEvent;
import gwt.material.design.client.ui.*;
import gwt.material.design.themes.client.ThemeLoader;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static gwt.material.design.jquery.client.api.JQuery.$;

@Templated
public class Header extends Composite {

    @Inject
    @DataField
    private MaterialNavBar navBar;

    @Inject
    @DataField
    private MaterialNavBar searchNav;

    @Inject
    private MaterialSearch search;

    @Inject
    private MaterialNavSection navSection;

    @Inject
    private MaterialLink iconSearch;

    @Inject
    private MaterialComboBox<ThemeLoader.ThemeBundle> comboBox;

    @Inject
    private ThemeSwitcher themeSwitcher;

    @Inject
    @DataField
    private MaterialCutOut codeCutout, searchCutout;

    private PageChangeEvent pageChangeEvent;

    @PostConstruct
    protected void init() {
        ThemeManager.register(navBar, ThemeManager.DARKER_SHADE);

        navBar.setActivates("sideNav");

        // Nav section
        navSection.setHideOn(HideOn.NONE);
        iconSearch.setIconType(IconType.SEARCH);

        iconSearch.addClickHandler(clickEvent -> {
            search.open();
        });
        navSection.add(themeSwitcher);
        navSection.add(iconSearch);
        navBar.add(navSection);

        // Search Navbar
        search.setPlaceholder("Search");
        search.addOpenHandler(e -> changeNav(searchNav));
        search.addCloseHandler(closeEvent -> changeNav(navBar));
        searchNav.add(search);
        changeNav(navBar);
        buildSearches();

        ThemeManager.register(codeCutout, ThemeManager.DARKER_SHADE);
        /*setupCutout(codeCutout, codePanel, true, 0.8, 10, "1430px", "Code Samples",
            "See code examples of the feature here!");*/

        ThemeManager.register(searchCutout, ThemeManager.REGULAR_SHADE);
        setupCutout(searchCutout, iconSearch.getIcon(), true, 0.8, -3, null, "Search Feature",
            "Search for any features you are interested in!");
    }

    protected void setupCutout(MaterialCutOut cutout, Widget target, boolean circle, double opacity, int padding,
                               String panelWidth, String titleStr, String desc) {
        // Code Cutout
        cutout.setTarget(target);
        cutout.setOpacity(opacity);
        cutout.setCircle(circle);
        cutout.setCutOutPadding(padding);
        cutout.setTextAlign(TextAlign.CENTER);
        cutout.addClickHandler(clickEvent -> cutout.close());

        MaterialPanel detailPanel = new MaterialPanel();
        detailPanel.setPaddingTop(85);
        if(panelWidth != null) {
            detailPanel.setWidth(panelWidth);
        }
        MaterialTitle title = new MaterialTitle();
        title.setTextColor(Color.WHITE);
        title.setTitle(titleStr);
        title.setDescription(desc);
        detailPanel.add(title);

        MaterialButton btnClose = new MaterialButton();
        btnClose.setMarginTop(20);
        btnClose.setText("Close");
        btnClose.addClickHandler(clickEvent -> cutout.close());
        detailPanel.add(btnClose);
        cutout.add(detailPanel);
    }

    protected void changeNav(MaterialNavBar nav) {
        searchNav.setVisible(false);
        navBar.setVisible(false);
        nav.setVisible(true);
    }

    public void onCodeCutOut(@Observes CodeCutOutEvent event) {
        Scheduler.get().scheduleDeferred(() -> codeCutout.open());
    }

    public void onSearchCutOut(@Observes SearchCutOutEvent event) {
        Scheduler.get().scheduleDeferred(() -> searchCutout.open());
    }

    public void buildSearches() {
        List<SearchObject> listSearches = new ArrayList<>();
        // About
        listSearches.add(new SearchObject(IconType.INFO_OUTLINE, "About", "#about"));

        // Getting Started
        listSearches.add(new SearchObject(IconType.CLOUD_DOWNLOAD, "Getting Started", "#getting_started"));

        // Components
        listSearches.add(new SearchObject(IconType.POLYMER, "Badges", "#badge"));
        listSearches.add(new SearchObject(IconType.POLYMER, "Buttons", "#button"));
        listSearches.add(new SearchObject(IconType.POLYMER, "Breadcrumbs", "#breadcrumbs"));
        listSearches.add(new SearchObject(IconType.POLYMER, "Cards", "#card"));
        listSearches.add(new SearchObject(IconType.POLYMER, "Chips", "#chip"));
        listSearches.add(new SearchObject(IconType.POLYMER, "Collapsible", "#collapsible"));
        listSearches.add(new SearchObject(IconType.POLYMER, "Collections", "#collection"));
        listSearches.add(new SearchObject(IconType.POLYMER, "Date Picker", "#datepicker"));
        listSearches.add(new SearchObject(IconType.POLYMER, "Modals", "#modals"));
        listSearches.add(new SearchObject(IconType.POLYMER, "Dropdown", "#dropdown"));
        listSearches.add(new SearchObject(IconType.POLYMER, "Errors", "#errors"));
        listSearches.add(new SearchObject(IconType.POLYMER, "Forms", "#forms"));
        listSearches.add(new SearchObject(IconType.POLYMER, "FAB", "#fab"));
        listSearches.add(new SearchObject(IconType.POLYMER, "Footer", "#footer"));
        listSearches.add(new SearchObject(IconType.POLYMER, "Loaders", "#loader"));
        listSearches.add(new SearchObject(IconType.POLYMER, "Media", "#media"));
        listSearches.add(new SearchObject(IconType.POLYMER, "NavBar", "#navbar"));
        listSearches.add(new SearchObject(IconType.POLYMER, "PushPin", "#pushpin"));
        listSearches.add(new SearchObject(IconType.POLYMER, "Search", "#search"));
        listSearches.add(new SearchObject(IconType.POLYMER, "SideNavs", "#sidenav"));
        listSearches.add(new SearchObject(IconType.POLYMER, "Scrollspy", "#scrollspy"));
        listSearches.add(new SearchObject(IconType.POLYMER, "Tabs", "#tab"));
        listSearches.add(new SearchObject(IconType.POLYMER, "Toast", "#toast"));
        listSearches.add(new SearchObject(IconType.POLYMER, "Tooltip", "#tooltip"));

        // Animations
        listSearches.add(new SearchObject(IconType.PLAY_CIRCLE_OUTLINE, "Core Animations", "#core_animation"));
        listSearches.add(new SearchObject(IconType.PLAY_CIRCLE_OUTLINE, "Meaningful", "#meaningful_animation"));

        // Addins
        listSearches.add(new SearchObject(IconType.EXTENSION, "Autocomplete", "#autocomplete"));
        listSearches.add(new SearchObject(IconType.EXTENSION, "Avatar", "#avatar"));
        listSearches.add(new SearchObject(IconType.EXTENSION, "Bubble", "#bubble"));
        listSearches.add(new SearchObject(IconType.EXTENSION, "Camera", "#camera"));
        listSearches.add(new SearchObject(IconType.EXTENSION, "ComboBox", "#combobox"));
        listSearches.add(new SearchObject(IconType.EXTENSION, "CutOut", "#cutout"));
        listSearches.add(new SearchObject(IconType.EXTENSION, "Data Table", "#datatable"));
        listSearches.add(new SearchObject(IconType.EXTENSION, "Doc Viewer", "#docviewer"));
        listSearches.add(new SearchObject(IconType.EXTENSION, "Drag and Drop", "#dnd"));
        listSearches.add(new SearchObject(IconType.EXTENSION, "File Uploader", "#fileuploader"));
        listSearches.add(new SearchObject(IconType.EXTENSION, "IconMorph", "#iconmorph"));
        listSearches.add(new SearchObject(IconType.EXTENSION, "Masonry", "#masonry"));
        listSearches.add(new SearchObject(IconType.EXTENSION, "MenuBar", "#"));
        listSearches.add(new SearchObject(IconType.EXTENSION, "Overlay", "#overlay"));
        listSearches.add(new SearchObject(IconType.EXTENSION, "PathAnimator", "#pathanimator"));
        listSearches.add(new SearchObject(IconType.EXTENSION, "Rating", "#rating"));
        listSearches.add(new SearchObject(IconType.EXTENSION, "Rich Editor", "#richeditor"));
        listSearches.add(new SearchObject(IconType.EXTENSION, "ScrollFire", "#scrollfire"));
        listSearches.add(new SearchObject(IconType.EXTENSION, "Split Panel", "#splitpanel"));
        listSearches.add(new SearchObject(IconType.EXTENSION, "Subheader", "#subheader"));
        listSearches.add(new SearchObject(IconType.EXTENSION, "Steppers", "#stepper"));
        listSearches.add(new SearchObject(IconType.EXTENSION, "Swipeable", "#swipeable"));
        listSearches.add(new SearchObject(IconType.EXTENSION, "Time Picker", "#timepicker"));
        listSearches.add(new SearchObject(IconType.EXTENSION, "Tree View", "#tree"));
        listSearches.add(new SearchObject(IconType.EXTENSION, "Waterfall", "#waterfall"));
        listSearches.add(new SearchObject(IconType.EXTENSION, "Window", "#window"));

        search.setListSearches(listSearches);
    }
}
