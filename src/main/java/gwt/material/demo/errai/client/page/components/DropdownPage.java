package gwt.material.demo.errai.client.page.components;

import com.google.gwt.dom.client.Style;
import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.client.constants.ButtonType;
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
@Page(path = "dropdown")
public class DropdownPage extends AbstractPage {

    @Inject
    @DataField
    private MaterialButton btnDropdown1;

    @Inject
    private MaterialDropDown dropdown1;

    @Inject
    @DataField
    private MaterialButton btnDropdown2;

    @Inject
    private MaterialDropDown dropdown2;

    @Inject
    @DataField
    private MaterialButton btnDropdown3;

    @Inject
    private MaterialDropDown dropdown3;

    @Inject
    @DataField
    private MaterialButton btnDropdown4;

    @Inject
    private MaterialDropDown dropdown4;

    @Inject
    @DataField
    private MaterialNavBar navbarDropdown;

    @Inject
    private MaterialNavSection navSection;

    @Inject
    private MaterialButton btnDropdown5;

    @Inject
    private MaterialDropDown dropdown5;

    @Override
    public String getName() {
        return "Dropdown";
    }

    @Override
    public String getDescription() {
        return "You can add dropdown easily by specifying it's item content and add a UiHandler " +
               "on it to implement any event.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.COMPONENTS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
        buildBasic();
        buildDesign();
        buildIconDropdown();
        buildSelectionEvent();
        buildNavBar();
    }

    private void buildNavBar() {
        navbarDropdown.add(navSection);
        navSection.setFloat(Style.Float.RIGHT);

        btnDropdown5.add(dropdown5);
        btnDropdown5.setTextColor(Color.WHITE);
        btnDropdown5.setText("Dropdown");
        btnDropdown5.setType(ButtonType.FLAT);
        btnDropdown5.setIconPosition(IconPosition.RIGHT);
        btnDropdown5.setIconType(IconType.ARROW_DROP_DOWN);
        navSection.add(btnDropdown5);

        for (int i = 1; i <= 3; i++) {
            MaterialLink link = new MaterialLink("Sample " + i);
            dropdown5.add(link);
        }
    }

    private void buildSelectionEvent() {
        btnDropdown4.add(dropdown4);
        btnDropdown4.setText("Dropdown");
        btnDropdown4.setIconPosition(IconPosition.RIGHT);
        btnDropdown4.setIconType(IconType.ARROW_DROP_DOWN);
        for (int i = 1; i <= 3; i++) {
            MaterialLink link = new MaterialLink("Sample " + i);
            dropdown4.add(link);
        }
        dropdown4.addSelectionHandler(selectionEvent -> {
            MaterialToast.fireToast(((MaterialLink) selectionEvent.getSelectedItem()).getText());
        });
    }

    private void buildIconDropdown() {
        btnDropdown3.add(dropdown3);
        dropdown3.setWidth("300px");
        dropdown3.setConstrainWidth(false);
        btnDropdown3.setShadow(0);
        btnDropdown3.setType(ButtonType.FLOATING);
        btnDropdown3.setIconType(IconType.DIRECTIONS_BIKE);
        for (int i = 1; i <= 3; i++) {
            MaterialLink link = new MaterialLink("Sample " + i);
            link.setIconColor(Color.PINK);
            link.setIconType(IconType.POLYMER);
            link.setIconPosition(IconPosition.RIGHT);
            dropdown3.add(link);
        }
    }

    private void buildDesign() {
        btnDropdown2.add(dropdown2);
        btnDropdown2.setText("Dropdown");
        btnDropdown2.setIconPosition(IconPosition.RIGHT);
        btnDropdown2.setIconType(IconType.ARROW_DROP_DOWN);
        for (int i = 1; i <= 3; i++) {
            MaterialLink link = new MaterialLink("Sample " + i);
            link.setIconColor(Color.PINK);
            link.setIconType(IconType.POLYMER);
            link.setIconPosition(IconPosition.RIGHT);
            dropdown2.add(link);
        }
    }

    private void buildBasic() {
        btnDropdown1.add(dropdown1);
        btnDropdown1.setText("Dropdown");
        btnDropdown1.setIconPosition(IconPosition.RIGHT);
        btnDropdown1.setIconType(IconType.ARROW_DROP_DOWN);
        for (int i = 1; i <= 3; i++) {
            MaterialLink link = new MaterialLink("Sample " + i);
            dropdown1.add(link);
        }
    }
}
