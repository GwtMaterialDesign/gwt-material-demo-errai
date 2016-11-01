package gwt.material.demo.errai.client.page.styles;

import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.Templated;

@Templated
@Page(path = "colors")
public class ColorsPage extends AbstractPage {


    @Override
    public String getName() {
        return "Colors";
    }

    @Override
    public String getDescription() {
        return "Color in material design is inspired by bold hues juxtaposed with muted environments, deep shadows, and bright highlights. Material takes cues from contemporary architecture, road signs, pavement marking tape, and athletic courts. Color should be unexpected and vibrant.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.STYLES;
    }
}
