package gwt.material.demo.errai.client.page.addins;

import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.addins.client.scrollfire.MaterialScrollfire;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialTitle;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.client.ui.animate.MaterialAnimation;
import gwt.material.design.client.ui.animate.Transition;
import gwt.material.design.client.ui.html.ListItem;
import gwt.material.design.client.ui.html.UnorderedList;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Templated
@Page(path = "scrollfire")
@ApplicationScoped
public class ScrollfirePage extends AbstractPage {

    @Inject
    @DataField
    private MaterialPanel panel;

    @Inject
    @DataField
    private UnorderedList listItem;

    @Inject
    @DataField
    private MaterialImage image;

    @Override
    public String getName() {
        return "Scrollfire";
    }

    @Override
    public String getDescription() {
        return "Executes callback functions depending on how far into the page you've scrolled.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.ADDINS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
        MaterialScrollfire.apply(panel.getElement(), () -> {
            MaterialToast.fireToast("Toasted");
        });

        MaterialScrollfire.apply(listItem.getElement(), () -> {
            new MaterialAnimation().transition(Transition.SHOW_STAGGERED_LIST).animate(listItem);
        });
        MaterialScrollfire.apply(image.getElement(), () -> {
            new MaterialAnimation().transition(Transition.FADE_IN_IMAGE).animate(image);
        });

        for (int i = 1; i <= 5; i++) {
            ListItem item = new ListItem();
            item.setOpacity(0);
            item.add(new MaterialTitle("List Item", "List Item"));
            listItem.add(item);
        }
    }
}
