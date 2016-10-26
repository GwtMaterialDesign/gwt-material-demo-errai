package gwt.material.demo.errai.client.local;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import gwt.material.demo.errai.client.local.resources.AppResources;
import gwt.material.demo.errai.client.local.widget.*;
import gwt.material.design.client.ui.MaterialToast;
import org.jboss.errai.ioc.client.api.EntryPoint;
import org.jboss.errai.ui.nav.client.local.Navigation;
import org.jboss.errai.ui.nav.client.local.PageShown;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@EntryPoint
public class Client extends Composite {

    @Inject
    Navigation navigation;

    @Inject
    Header header;

    @Inject
    SideNav sideNav;

    @Inject
    Main content;

    @Inject
    Footer footer;

    @PostConstruct
    public void init() {
        StyleInjector.inject(AppResources.INSTANCE.appCss().getText());
        content.getContainer().add(navigation.getContentPanel());
        ThemeManager.initialize();
        RootPanel.get().add(header);
        RootPanel.get().add(sideNav);
        RootPanel.get().add(content);
        RootPanel.get().add(footer);
        Timer timer = new Timer() {
            @Override
            public void run() {
                DOM.removeChild(RootPanel.getBodyElement(), DOM.getElementById("splashscreen"));
            }
        };
        timer.schedule(2000);
    }
}
