package gwt.material.demo.errai.client.local.page.animations;

import gwt.material.demo.errai.client.local.page.PageBase;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;

@Templated
@Page(path = "core_animation")
public class CoreAnimationsPage extends PageBase {

    @PostConstruct
    public void init() {
        initPage("Core Animations", "We used AnimateCSS to built our core animations.", ANIMATIONS);
    }
}
