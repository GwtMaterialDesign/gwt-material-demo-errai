package gwt.material.demo.errai.client.page.components;

import gwt.material.demo.errai.client.ThemeManager;
import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialPushpin;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.inject.Inject;

@Templated
@Page(path = "pushpin")
public class PushpinPage extends AbstractPage {

    @Inject
    @DataField
    private MaterialLabel target;

    @Override
    public String getName() {
        return "Push Pin";
    }

    @Override
    public String getDescription() {
        return "Pushpin is our fixed positioning plugin. You can check out our live examples: the fixed Table of Contents on the right.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.COMPONENTS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
        ThemeManager.register(target);
        target.setText("Pinned Options top at 300, offset at 64 (navbar's height)");
        MaterialPushpin.apply(target, 300.0, 64.0);
    }
}
