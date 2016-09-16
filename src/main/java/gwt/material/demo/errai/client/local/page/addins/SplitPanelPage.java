package gwt.material.demo.errai.client.local.page.addins;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.addins.client.splitpanel.MaterialSplitPanel;
import gwt.material.design.addins.client.splitpanel.constants.Dock;
import gwt.material.design.client.constants.Axis;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialTitle;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "splitpanel")
public class SplitPanelPage extends PageBase {

    @Inject
    @DataField
    MaterialSplitPanel splitPanel;

    @Inject
    @DataField
    MaterialSplitPanel splitPanelStyling;

    @Inject
    @DataField
    MaterialSplitPanel splitPanelVertical;

    @Inject
    @DataField
    MaterialSplitPanel splitPanelDock;

    @Inject
    @DataField
    MaterialSplitPanel splitPanelMinMax;

    @Inject
    @DataField
    MaterialSplitPanel splitPanelBarPosition;

    @PostConstruct
    public void init() {
        initPage("Split Panel", "A high performance content splitter compatible with touch events", ADDINS_COLOR);
        buildBasic();
        buildStyle();
    }

    private void buildStyle() {
        buildSplitPanel(splitPanelStyling);
    }

    private void buildBasic() {
        buildSplitPanel(splitPanel);
    }

    private void buildSplitPanel(MaterialSplitPanel splitPanel) {
        splitPanel.setBackgroundColor("black");
        splitPanel.setHeight("500px");
        MaterialPanel leftPanel = new MaterialPanel();
        leftPanel.setGrid("l6 m6 s6");
        leftPanel.setBackgroundColor("grey lighten-2");
        MaterialTitle leftTitle = new MaterialTitle();
        leftTitle.setTextAlign(TextAlign.CENTER);
        leftTitle.setTitle("Left Zone");
        leftTitle.setDescription("Content must be added here");
        leftPanel.add(leftTitle);
        splitPanel.add(leftPanel);

        MaterialPanel rightPanel = new MaterialPanel();
        rightPanel.setGrid("l6 m6 s6");
        rightPanel.setBackgroundColor("grey lighten-3");
        MaterialTitle rightTitle = new MaterialTitle();
        rightTitle.setTextAlign(TextAlign.CENTER);
        rightTitle.setTitle("Right Zone");
        rightTitle.setDescription("Content must be added here");
        rightPanel.add(rightTitle);
        splitPanel.add(rightPanel);

        if (splitPanel == splitPanelStyling) {
            splitPanel.setBackgroundColor("blue");
            leftPanel.setBackgroundColor("blue lighten-2");
            rightPanel.setBackgroundColor("blue lighten-3");
        } else if (splitPanel == splitPanelVertical) {
            splitPanel.setAxis(Axis.VERTICAL);
        } else if (splitPanel == splitPanelDock) {
            splitPanel.setDock(Dock.RIGHT);
        } else if (splitPanel == splitPanelMinMax) {
            splitPanel.setLeftMin(100);
            splitPanel.setLeftMax(400);
            splitPanel.setRightMin(100);
            splitPanel.setRightMax(300);
        } else if (splitPanel == splitPanelBarPosition) {
            splitPanel.setBarPosition(10);
        }
    }
}
