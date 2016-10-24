package gwt.material.demo.errai.client.local.page.animations;

import gwt.material.demo.errai.client.local.page.PageBase;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;

@Templated
@Page(path = "meaningful_animation")
public class MeaningfulAnimationsPage extends PageBase {

    @PostConstruct
    public void init() {
        initPage("Meaningful Animations", "Motion design can effectively guide the user’s attention in ways that both inform and delight. Use motion to smoothly transport users between navigational contexts, explain changes in the arrangement of elements on a screen, and reinforce element hierarchy.", ANIMATIONS);
    }
}
