package gwt.material.demo.errai.client.widget;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import gwt.material.demo.errai.client.ThemeManager;
import gwt.material.demo.errai.client.events.PageChangeEvent;
import gwt.material.demo.errai.client.events.CodeCutOutEvent;
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

    @Inject
    MaterialPanel codePanel;

    @Inject
    MaterialChip chipHtml, chipJava;

    @Inject
    @DataField
    MaterialCutOut cutout;

    private PageChangeEvent pageChangeEvent;

    @PostConstruct
    protected void init() {
        ThemeManager.register(navBar, ThemeManager.DARKER_SHADE);
        ThemeManager.register(titlePanel);

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
        lblDescription.setMarginBottom(20);
        titlePanel.add(lblDescription);

        codePanel.setWidth("190px");
        chipHtml.setText("HTML");
        chipHtml.setLetter("<>");
        chipHtml.setMarginRight(12);
        chipHtml.setTextColor(Color.WHITE);

        ThemeManager.register(chipHtml.getLetterMixin().getSpan(), ThemeManager.LIGHTER_SHADE);
        ThemeManager.register(chipHtml, ThemeManager.DARKER_SHADE);

        chipJava.setText("JAVA");
        chipJava.setLetter("<>");
        chipJava.setTextColor(Color.WHITE);
        ThemeManager.register(chipJava.getLetterMixin().getSpan(), ThemeManager.LIGHTER_SHADE);
        ThemeManager.register(chipJava, ThemeManager.DARKER_SHADE);

        chipHtml.addClickHandler(clickEvent -> {
            Window.open(getPageChangeEvent().getHtmlCodeLink(), "_blank", "");
        });

        chipJava.addClickHandler(clickEvent -> {
            Window.open(getPageChangeEvent().getJavaCodeLink(), "_blank", "");
        });

        // Search Navbar
        search.setPlaceholder("Search");
        search.setActive(true);
        search.addCloseHandler(closeEvent -> {
            changeNav(navBar);
        });
        searchNav.add(search.getIcon());
        changeNav(navBar);
        buildSearches();

        // Cutout
        ThemeManager.register(cutout, ThemeManager.DARKER_SHADE);
        cutout.setTarget(codePanel);
        cutout.setOpacity(0.8);
        cutout.setCircle(true);
        cutout.setCutOutPadding(10);
        cutout.setTextAlign(TextAlign.CENTER);

        MaterialPanel detailPanel = new MaterialPanel();
        detailPanel.setPaddingTop(85);
        detailPanel.setWidth("1430px");
        MaterialTitle title = new MaterialTitle();
        title.setTextColor(Color.WHITE);
        title.setTitle("Code Samples");
        title.setDescription("See code examples of the feature here!");
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

    public void onPageChange(@Observes PageChangeEvent event) {
        setPageChangeEvent(event);

        PageCategory pageCategory = pageChangeEvent.getPageCategory();
        switch (pageCategory) {
            case ADDINS:
            case COMPONENTS:
            case ANIMATIONS:
                codePanel.add(chipHtml);
                codePanel.add(chipJava);
                titlePanel.add(codePanel);
                break;
            default:
                codePanel.removeFromParent();
                break;
        }
        $("body").scrollTop(0);
        lblTitle.setText(event.getTitle());
        lblDescription.setText(event.getDescription());
    }

    public void onCodeCutOut(@Observes CodeCutOutEvent event) {
        Scheduler.get().scheduleDeferred(() -> cutout.open());
    }

    public void onSideNavOpened(@Observes SideNavOpenedEvent event) {
        navBar.getElement().getStyle().setProperty("transition", "none");
        navBar.getElement().getStyle().setProperty("width", "calc(100% - 280px)");
        searchNav.getElement().getStyle().setProperty("width", "calc(100% - 280px)");
    }

    public void onSideNavClosed(@Observes SideNavClosedEvent event) {
        navBar.getElement().getStyle().setProperty("transition", "none");
        navBar.getElement().getStyle().setProperty("width", "100%");
        searchNav.getElement().getStyle().setProperty("width", "100%");
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
        listSearches.add(new SearchObject(IconType.POLYMER, "Tabs", "#toast"));
        listSearches.add(new SearchObject(IconType.POLYMER, "Tabs", "#tooltip"));

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

    public PageChangeEvent getPageChangeEvent() {
        return pageChangeEvent;
    }

    public void setPageChangeEvent(PageChangeEvent pageChangeEvent) {
        this.pageChangeEvent = pageChangeEvent;
    }
}
