package gwt.material.demo.errai.client.page.addins;

import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.addins.client.avatar.MaterialAvatar;
import gwt.material.design.client.ui.MaterialTextBox;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.inject.Inject;

@Templated
@Page(path = "avatar")
public class AvatarPage extends AbstractPage {

    @Inject
    @DataField
    private MaterialAvatar avatar;

    @Inject
    @DataField
    private MaterialAvatar avatar2;

    @Inject
    @DataField
    private MaterialTextBox txtAvatar;

    @Override
    public String getName() {
        return "Avatar";
    }

    @Override
    public String getDescription() {
        return "Generated avatar based on JDenticon that provides a unique avatar based on unique name.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.ADDINS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
        buildDefault();
        buildInitialize();
    }

    private void buildInitialize() {
        txtAvatar.setPlaceholder("Avatar Name");
        txtAvatar.setText("Marjorie");
        txtAvatar.addKeyUpHandler(keyUpEvent -> {
            avatar2.setValue(txtAvatar.getText());
            avatar2.reload();
        });

        avatar2.setName(txtAvatar.getText());
    }

    private void buildDefault() {
        avatar.setName("kevzlou7979");
    }
}
