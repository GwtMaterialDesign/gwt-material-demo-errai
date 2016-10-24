package gwt.material.demo.errai.client.local.page.components;

import com.google.gwt.dom.client.Style;
import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.client.base.SearchObject;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.*;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Templated
@Page(path = "search")
@ApplicationScoped
public class SearchPage extends PageBase {

    @Inject
    @DataField
    MaterialNavBar navbar, searchbar;

    @Inject
    MaterialSearch search;

    @Inject
    MaterialNavBrand navBrand;

    @Inject
    MaterialNavSection navSection;

    @Inject
    MaterialLink searchIcon;

    @PostConstruct
    public void init() {
        initPage("Search", "Attached to NavBar component or can be used on external panels.", COMPONENTS);
        navBrand.setText("My App");
        navBrand.setPaddingLeft(20);
        navbar.add(navBrand);

        searchIcon.setIconType(IconType.SEARCH);
        searchIcon.addClickHandler(clickEvent -> {
            navbar.setVisible(false);
            searchbar.setVisible(true);
        });

        search.setPlaceholder("Search");
        search.setActive(true);
        search.addCloseHandler(closeEvent -> {
            navbar.setVisible(true);
            searchbar.setVisible(false);
            MaterialToast.fireToast("Close Event Fired");
        });

        search.addSearchFinishHandler(event -> {
            MaterialToast.fireToast("Search Finish Event Fired");
        });

        search.addValueChangeHandler(valueChangeEvent -> {
            MaterialToast.fireToast("Value Change Event Fired : " + valueChangeEvent.getValue());
        });

        search.addSearchNoResultHandler(event -> {
            MaterialToast.fireToast("Search No Result Event Fired");
        });

        search.addBlurHandler(blurEvent -> {
            MaterialToast.fireToast("Blur Event Fired");
        });

        search.addFocusHandler(focusEvent -> {
            MaterialToast.fireToast("Focus Event Fired");
        });
        search.setListSearches(getAllSearchObject());
        searchbar.add(search);
        navSection.setFloat(Style.Float.RIGHT);
        navSection.add(searchIcon);
        navbar.add(navSection);
    }

    public List<SearchObject> getAllSearchObject() {
        List<SearchObject> objects = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            SearchObject searchObject = new SearchObject();
            searchObject.setIcon(IconType.POLYMER);
            searchObject.setKeyword("Item " + i);
            objects.add(searchObject);
        }
        return objects;
    }
}
