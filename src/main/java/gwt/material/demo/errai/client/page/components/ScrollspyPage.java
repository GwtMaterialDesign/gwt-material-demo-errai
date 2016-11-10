package gwt.material.demo.errai.client.page.components;

import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.client.constants.HideOn;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialScrollspy;
import gwt.material.design.client.ui.MaterialTitle;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "scrollspy")
public class ScrollspyPage extends AbstractPage {

    @Inject
    @DataField
    MaterialPanel panels;

    @Inject
    @DataField
    MaterialScrollspy tableContents;

    @Override
    public String getName() {
        return "Scrollspy";
    }

    @Override
    public String getDescription() {
        return "Scrollspy is a jQuery plugin that tracks certain elements and which element the user's " +
               "screen is currently centered on. Our main demo of this is our table of contents on every " +
               "documentation page to the right. Clicking on these links will also scroll the page to " +
               "that element.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.COMPONENTS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
        buildScrollspy();
    }

    private void buildScrollspy() {
        panels.setGrid("s10");
        tableContents.setGrid("s2");
        tableContents.setHideOn(HideOn.HIDE_ON_SMALL);
        for (int i = 1; i <= 5; i++) {
            MaterialPanel panel = new MaterialPanel();
            panel.setScrollspy("item" + i);
            MaterialTitle title = new MaterialTitle();
            title.setTitle("Item " + i);
            title.setDescription("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc,");
            panel.add(title);
            panels.add(panel);

            MaterialLink link = new MaterialLink();
            link.setText("Item " + i);
            link.setHref("#item" + i);
            tableContents.add(link);
        }
    }
}
