package gwt.material.demo.errai.client.local;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import gwt.material.demo.errai.client.local.widget.Main;
import org.jboss.errai.ioc.client.api.EntryPoint;
import org.jboss.errai.ui.nav.client.local.Navigation;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@EntryPoint
public class Client extends Composite{

    @Inject
    Navigation navigation;

    @Inject
    Main content;

    @PostConstruct
    public void init() {
        content.getContainer().add(navigation.getContentPanel());
        RootPanel.get().add(content);
    }
}
