package gwt.material.demo.errai.client.local.page.components;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.*;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "tabs")
public class TabsPage extends PageBase {

    private final int BASIC = 0;
    private final int WITH_ICONS = 1;

    @Inject
    @DataField
    MaterialRow rowBasic;

    @Inject
    MaterialTab tabBasic;


    @Inject
    @DataField
    MaterialRow rowDisabled;

    @Inject
    MaterialTab tabDisabled;

    @Inject
    @DataField
    MaterialRow rowTabIndex;

    @Inject
    MaterialTab tabIndex;

    @Inject
    @DataField
    MaterialRow rowWithIcons;

    @Inject
    MaterialTab tabWithIcons;

    @Inject
    @DataField
    MaterialRow rowIndicatorColor;

    @Inject
    MaterialTab tabIndicatorColor;

    @Inject
    @DataField
    MaterialButton btnSetIndex;

    private int index = 1;

    @PostConstruct
    public void init() {
        initPage("Tabs", "The tabs structure consists of an unordered list of tabs that have hashes corresponding to tabBasic ids. Then when you click on each tabBasic, only the container with the corresponding tabBasic id will become visible.", COMPONENTS_COLOR);
        buildBasic();
        buildDisabled();
        buildTabIndex();
        buildWithIcons();
        buildIndicatorColor();
    }

    private void buildIndicatorColor() {
        tabIndicatorColor.setBackgroundColor("green");
        tabIndicatorColor.setIndicatorColor("green lighten-3");
        tabIndicatorColor.setWaves(WavesType.YELLOW);
        buildTab(tabIndicatorColor, rowIndicatorColor, BASIC);
    }

    private void buildWithIcons() {
        tabWithIcons.setBackgroundColor("blue");
        tabWithIcons.setIndicatorColor("yellow");
        buildTab(tabWithIcons, rowWithIcons, WITH_ICONS);
    }

    private void buildTabIndex() {
        tabIndex.setBackgroundColor("blue");
        tabIndex.setIndicatorColor("yellow");
        buildTab(tabIndex, rowTabIndex, BASIC);
        btnSetIndex.setText("Set Tab 2");
        btnSetIndex.addClickHandler(clickEvent -> {
            tabIndex.setTabIndex(1);
        });
    }

    private void buildDisabled() {
        tabDisabled.setBackgroundColor("blue");
        tabDisabled.setIndicatorColor("yellow");
        buildTab(tabDisabled, rowDisabled, BASIC);
        ((MaterialWidget)tabDisabled.getWidget(1)).setEnabled(false);
    }

    private void buildBasic() {
        tabBasic.setBackgroundColor("blue");
        tabBasic.setIndicatorColor("yellow");
        buildTab(tabBasic, rowBasic, BASIC);
    }

    private void buildTab(MaterialTab tab, MaterialRow row, int type) {
        row.add(tab);
        for (int i = 1; i <= 3; i++) {
            String id = "tab" + index;

            MaterialTabItem item = new MaterialTabItem();
            item.setGrid("s4 m4 l4");
            item.setWaves(WavesType.YELLOW);
            MaterialLink link = new MaterialLink();
            link.setTextColor("white");
            link.setText("Item " + i);
            link.setHref("#" + id);

            if (type == WITH_ICONS) {
                link.setIconType(IconType.POLYMER);
            }

            item.add(link);
            tab.add(item);

            // Build tab panel
            MaterialLabel label = new MaterialLabel();
            label.setText("Panel " + i);
            label.setId(id);
            row.add(label);
            index ++;
        }
    }
}
