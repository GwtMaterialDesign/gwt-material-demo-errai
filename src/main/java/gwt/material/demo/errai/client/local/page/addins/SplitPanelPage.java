package gwt.material.demo.errai.client.local.page.addins;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.addins.client.splitpanel.MaterialSplitPanel;
import gwt.material.design.addins.client.splitpanel.constants.Dock;
import gwt.material.design.client.constants.Axis;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialTitle;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import static gwt.material.design.client.constants.Color.BLUE_LIGHTEN_3;
import static gwt.material.design.client.constants.Color.GREY_LIGHTEN_3;

@Templated
@Page(path = "splitpanel")
public class SplitPanelPage extends PageBase {

    @Inject
    @DataField
    MaterialRow splitPanelContainer, splitPanelStylingContainer, splitPanelVerticalContainer, splitPanelDockContainer, splitPanelMinMaxContainer, splitPanelBarPositionContainer;

    @PostConstruct
    public void init() {
        initPage("Split Panel", "A high performance content splitter compatible with touch events", ADDINS);
    }

    @Override
    public void page() {
        super.page();
        buildSplitPanel(splitPanelContainer);
        buildSplitPanel(splitPanelStylingContainer);
        buildSplitPanel(splitPanelVerticalContainer);
        buildSplitPanel(splitPanelDockContainer);
        buildSplitPanel(splitPanelMinMaxContainer);
        buildSplitPanel(splitPanelBarPositionContainer);
    }

    private void buildSplitPanel(MaterialRow splitPanelContainer) {
        MaterialSplitPanel splitPanel = new MaterialSplitPanel();

        splitPanel.setHeight("500px");
        MaterialPanel leftPanel = new MaterialPanel();
        leftPanel.setPadding(0);
        leftPanel.setBackgroundColor(GREY_LIGHTEN_3);
        leftPanel.setGrid("l6 m6 s6");
        MaterialTitle leftTitle = new MaterialTitle();
        leftTitle.setTextAlign(TextAlign.CENTER);
        leftTitle.setTitle("Left Zone");
        leftTitle.setDescription("Content must be added here");
        leftPanel.add(leftTitle);
        splitPanel.add(leftPanel);

        MaterialPanel rightPanel = new MaterialPanel();
        rightPanel.setPadding(0);
        rightPanel.setGrid("l6 m6 s6");
        MaterialTitle rightTitle = new MaterialTitle();
        rightPanel.setBackgroundColor(GREY_LIGHTEN_3);
        rightTitle.setTextAlign(TextAlign.CENTER);
        rightTitle.setTitle("Right Zone");
        rightTitle.setDescription("Content must be added here");
        rightPanel.add(rightTitle);
        splitPanel.add(rightPanel);

        if (splitPanelContainer == splitPanelStylingContainer) {
            splitPanel.setBackgroundColor(Color.BLUE);
            leftPanel.setBackgroundColor(Color.BLUE_LIGHTEN_2);
            rightPanel.setBackgroundColor(BLUE_LIGHTEN_3);
        } else if (splitPanelContainer == splitPanelVerticalContainer) {
            splitPanel.setAxis(Axis.VERTICAL);
            leftPanel.setGrid("s12");
            rightPanel.setGrid("s12");
        } else if (splitPanelContainer == splitPanelDockContainer) {
            splitPanel.setDock(Dock.RIGHT);
        } else if (splitPanelContainer == splitPanelMinMaxContainer) {
            splitPanel.setLeftMin(100);
            splitPanel.setLeftMax(400);
            splitPanel.setRightMin(100);
            splitPanel.setRightMax(300);
        } else if (splitPanelContainer == splitPanelBarPositionContainer) {
            splitPanel.setBarPosition(10);
        }

        splitPanelContainer.add(splitPanel);
    }
}
