package gwt.material.demo.errai.client.page.styles;

import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.Templated;

@Templated
@Page(path = "shadow")
public class ShadowPage extends AbstractPage {

    @Override
    public String getName() {
        return "Shadow";
    }

    @Override
    public String getDescription() {
        return "By importing another project called gwt-material-themes, you can now easily integrate it and make your app more professional with branding identity.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.STYLES;
    }
}
