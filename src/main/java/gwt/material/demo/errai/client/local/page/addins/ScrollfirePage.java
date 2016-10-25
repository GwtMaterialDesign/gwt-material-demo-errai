package gwt.material.demo.errai.client.local.page.addins;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.addins.client.scrollfire.MaterialScrollfire;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialTitle;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.client.ui.animate.MaterialAnimator;
import gwt.material.design.client.ui.animate.Transition;
import gwt.material.design.client.ui.html.ListItem;
import gwt.material.design.client.ui.html.UnorderedList;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Templated
@Page(path = "scrollfire")
@ApplicationScoped
public class ScrollfirePage extends PageBase {

    @Inject
    @DataField
    MaterialPanel panel;

    @Inject
    @DataField
    UnorderedList listItem;

    @Inject
    @DataField
    MaterialImage image;

    @PostConstruct
    public void init() {
        initPage("Scrollfire", "Executes callback functions depending on how far into the page you've scrolled.", ADDINS);
        MaterialScrollfire.apply(panel.getElement(), () -> {
            MaterialToast.fireToast("Toasted");
        });

        MaterialScrollfire.apply(listItem.getElement(), () -> {
            MaterialAnimator.animate(Transition.SHOW_STAGGERED_LIST, listItem, 0);
        });
        MaterialScrollfire.apply(image.getElement(), () -> {
            MaterialAnimator.animate(Transition.FADE_IN_IMAGE, image, 0);
        });

        for (int i = 1; i <= 5; i++) {
            ListItem item = new ListItem();
            item.setOpacity(0);
            item.add(new MaterialTitle("List Item", "List Item"));
            listItem.add(item);
        }
    }
}
