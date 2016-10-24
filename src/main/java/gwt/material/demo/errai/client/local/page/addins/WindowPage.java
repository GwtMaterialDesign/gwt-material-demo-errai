package gwt.material.demo.errai.client.local.page.addins;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconSize;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.*;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "window")
public class WindowPage extends PageBase {

    @Inject
    @DataField
    MaterialButton btnSimple, btnMaximize, btnStyled, btnEvent;

    @Inject
    @DataField
    MaterialWindow windowSimple, windowMaximize, windowStyled, windowEvent;

    @PostConstruct
    public void init() {
        initPage("Window", "Window is another kind of Modal but it has a header toolbar for maximizing and close the window. Also you can attached a tab component on its content.", ADDINS);
        buildSimple();
        buildMaximize();
        buildStyled();
        buildEvent();
    }

    protected void buildEvent() {
        btnEvent.setText("Open Window with Events");
        windowEvent.addOpenHandler(openEvent -> {
            MaterialToast.fireToast("Opened Window");
        });
        windowEvent.addCloseHandler(closeEvent -> {
            MaterialToast.fireToast("Closed Window");
        });
        buildWindow(windowEvent, btnEvent);
    }

    protected void buildStyled() {
        btnStyled.setText("Open Styled Window");
        windowStyled.setBackgroundColor(Color.GREEN_LIGHTEN_4);
        windowStyled.setToolbarColor(Color.GREEN);
        buildWindow(windowStyled, btnStyled);
    }

    protected void buildMaximize() {
        btnMaximize.setText("Open Maximized Window");
        windowMaximize.setMaximize(true);
        buildWindow(windowMaximize, btnMaximize);
    }

    protected void buildSimple() {
        btnSimple.setText("Open Window");
        buildWindow(windowSimple, btnSimple);
    }

    protected void buildWindow(MaterialWindow window, MaterialButton activator) {
        window.setWidth("70%");
        window.setTitle("Documents");
        // Panel
        MaterialPanel panel = new MaterialPanel();
        panel.setPadding(32);
        panel.setTextAlign(TextAlign.CENTER);
        panel.setHeight("400px");
        window.add(panel);
        // Icon
        MaterialIcon icon = new MaterialIcon(IconType.HEADSET);
        icon.setIconColor(Color.ORANGE);
        icon.setPadding(24);
        icon.setIconSize(IconSize.LARGE);
        icon.setCircle(true);
        icon.setShadow(1);
        panel.add(icon);
        // Labels
        MaterialTitle title = new MaterialTitle("I Love Music", "Helps me escape from the reality I live in.");
        panel.add(title);
        // Activate Window
        activator.addClickHandler(clickEvent -> {
            window.open();
        });
    }
}
