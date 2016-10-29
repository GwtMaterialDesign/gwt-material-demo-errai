package gwt.material.demo.errai.client.page.components;

import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.TabType;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.*;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "tab")
public class TabsPage extends AbstractPage {

    @Inject
    @DataField
    MaterialTab tabBasic, tabDisabled, tabIndicator, tabIndex, tabIcon;

    @Inject
    @DataField
    MaterialPanel basicContent, disabledContent, indicatorContent, indexContent, iconContent;

    @Override
    public String getName() {
        return "Tabs";
    }

    @Override
    public String getDescription() {
        return "The tabs structure consists of an unordered list of tabs that have hashes corresponding " +
               "to tabBasic ids. Then when you click on each tabBasic, only the container with the corresponding " +
               "tabBasic id will become visible.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.COMPONENTS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
        buildBasic();
        buildDisabled();
        buildIndicator();
        buildTabIndex();
        buildTabIcon();
    }

    @Override
    protected void onShown() {
        super.onShown();
        tabIndicator.setIndicatorColor(Color.YELLOW);
    }

    protected void buildTabIcon() {
        tabIcon.setType(TabType.ICON);
        buildTabs(tabIcon, iconContent, "tabIcon", true);
    }

    protected void buildTabIndex() {
        buildTabs(tabIndex, indexContent, "tabIndex");
        tabIndex.setTabIndex(1);
    }

    protected void buildIndicator() {
        buildTabs(tabIndicator, indicatorContent, "tabIndicator");
    }

    protected void buildDisabled() {
        buildTabs(tabDisabled, disabledContent, "tabDisabled");
        if (tabDisabled.getWidget(0) instanceof MaterialTabItem) {
            ((MaterialTabItem) tabDisabled.getWidget(0)).setEnabled(false);
        }
    }

    protected void buildBasic() {
        buildTabs(tabBasic, basicContent, "tabBasic");
    }

    protected void buildTabs(MaterialTab tab, MaterialPanel content, String uniqueTabId) {
        buildTabs(tab, content, uniqueTabId, false);
    }

    protected void buildTabs(MaterialTab tab, MaterialPanel content, String uniqueTabId, boolean withIcon) {
        for (int i = 1; i <= 3; i++) {
            MaterialTabItem item = new MaterialTabItem();
            item.setWaves(WavesType.DEFAULT);
            MaterialLink link = new MaterialLink("Item " + i, uniqueTabId + i);
            link.setTextColor(Color.WHITE);
            if (withIcon) {
                link.setIconType(IconType.POLYMER);
            }
            item.add(link);
            tab.add(item);

            MaterialPanel panel = new MaterialPanel();
            panel.setId(uniqueTabId + i);
            panel.add(new MaterialLabel("Tab Content " + i));
            content.add(panel);
        }
    }
}
