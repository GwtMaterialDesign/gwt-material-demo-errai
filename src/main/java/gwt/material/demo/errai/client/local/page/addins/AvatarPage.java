package gwt.material.demo.errai.client.local.page.addins;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.addins.client.avatar.MaterialAvatar;
import gwt.material.design.client.ui.MaterialTextBox;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "avatar")
public class AvatarPage extends PageBase {

    @Inject
    @DataField
    MaterialAvatar avatar;

    @Inject
    @DataField
    MaterialAvatar avatar2;

    @Inject
    @DataField
    MaterialTextBox txtAvatar;

    @PostConstruct
    public void init() {
        initPage("Avatar", "Generated avatar based on JDenticon that provides a unique avatar based on unique name.", ADDINS);
        buildDefault();
        buildInitialize();
    }

    private void buildInitialize() {
        txtAvatar.setPlaceholder("Avatar Name");
        txtAvatar.setText("Marjorie");
        txtAvatar.addKeyUpHandler(keyUpEvent -> {
            avatar2.setName(txtAvatar.getText());
            avatar2.initialize();
        });

        avatar2.setName(txtAvatar.getText());
    }

    private void buildDefault() {
        avatar.setName("kevzlou7979");
    }
}
