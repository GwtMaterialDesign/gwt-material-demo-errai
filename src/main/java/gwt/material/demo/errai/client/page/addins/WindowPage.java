package gwt.material.demo.errai.client.page.addins;

import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconSize;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.*;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "window")
public class WindowPage extends AbstractPage {

    @Inject
    @DataField
    private MaterialButton btnSimple, btnMaximize, btnStyled, btnEvent;

    @Inject
    @DataField
    private MaterialWindow windowSimple, windowMaximize, windowStyled, windowEvent;

    @Override
    public String getName() {
        return "Window";
    }

    @Override
    public String getDescription() {
        return "Window is another kind of Modal but it has a header toolbar for maximizing and close the window. Also you can attached a tab component on its content.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.ADDINS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
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
