package gwt.material.demo.errai.client.widget;

import com.google.gwt.user.client.ui.Composite;
import gwt.material.demo.errai.client.local.ThemeManager;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.*;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
public class Footer extends Composite {

    @Inject
    @DataField
    MaterialFooter footer;

    MaterialFooterCopyright copyright = new MaterialFooterCopyright();

    @PostConstruct
    protected void init() {
        ThemeManager.register(footer);
        ThemeManager.register(copyright, ThemeManager.DARKER_SHADE);

        MaterialRow row = new MaterialRow();

        MaterialColumn col1 = new MaterialColumn(12, 4, 4);
        MaterialTitle title = new MaterialTitle("Join Discussion", "We provide Gitter Chat rooms in order for GWT Developers discussed and collaborate about GWT Material Design and Phonegap Integration.");
        title.setTextColor(Color.WHITE);
        title.setMarginBottom(20);
        MaterialAnchorButton btn1 = new MaterialAnchorButton("Chat");
        btn1.setHref("https://gitter.im/GwtMaterialDesign/gwt-material");
        btn1.setTarget("_blank");
        col1.add(title);
        col1.add(btn1);

        MaterialColumn col2 = new MaterialColumn(12, 4, 4);
        MaterialTitle title2 = new MaterialTitle("Github", "Download, fork, pull, file issues, and more at the official GWT Material repo on Github.");
        title2.setTextColor(Color.WHITE);
        title2.setMarginBottom(20);
        MaterialAnchorButton btn2 = new MaterialAnchorButton("Gitter Channel");
        btn2.setHref("https://github.com/GwtMaterialDesign/gwt-material");
        btn2.setTarget("_blank");
        col2.add(title2);
        col2.add(btn2);

        MaterialColumn col3 = new MaterialColumn(12, 4, 4);
        MaterialTitle title3 = new MaterialTitle("Community", "We created GPlus community for prior announcement and updates on GMD.");
        title3.setTextColor(Color.WHITE);
        title3.setMarginBottom(20);
        MaterialAnchorButton btn3 = new MaterialAnchorButton("G Plus");
        btn3.setHref("https://plus.google.com/communities/108005250093449814286");
        btn3.setTarget("_blank");
        col3.add(title3);
        col3.add(btn3);

        row.add(col1);
        row.add(col2);
        row.add(col3);
        footer.add(row);
        footer.add(copyright);
        copyright.add(new MaterialLabel("@ 2016 Copyright GWT Material"));
    }
}
