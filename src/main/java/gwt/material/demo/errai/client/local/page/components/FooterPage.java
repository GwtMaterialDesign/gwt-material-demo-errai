package gwt.material.demo.errai.client.local.page.components;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.*;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Templated
@Page(path = "footer")
@ApplicationScoped
public class FooterPage extends PageBase {

    @Inject
    @DataField
    MaterialFooter footer;

    @Inject
    MaterialFooterCopyright copyright;

    @PostConstruct
    public void init() {
        initPage("Footer", "Footers are a great way to organize a lot of site navigation and information at the end of a page. This is where the user will look once hes finished scrolling through the current page or is looking for additional information about your website.", COMPONENTS);
        buildFooter();
    }

    private void buildFooter() {
        MaterialTitle title = new MaterialTitle();
        title.setTitle("Footer");
        title.setDescription("This is description");
        title.setTextColor(Color.WHITE);

        MaterialButton button = new MaterialButton();
        button.setText("Link 1");
        button.setMarginBottom(20);
        footer.setMarginLeft(0);
        footer.add(title);
        footer.add(button);

        MaterialLabel label = new MaterialLabel();
        label.setText("© 2015 Copyright GWT Material");
        copyright.add(label);
        footer.add(copyright);
    }
}
