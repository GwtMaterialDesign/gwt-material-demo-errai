package gwt.material.demo.errai.client.local.page.addins;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.addins.client.tree.MaterialTree;
import gwt.material.design.addins.client.tree.MaterialTreeItem;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialPanel;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "tree")
public class TreePage extends PageBase {

    @Inject
    @DataField
    MaterialPanel panel;

    @PostConstruct
    public void init() {
        initPage("Tree", "Tree is a component that wraps all the tree items that provide lists of event handlers like open/close and selection event.", ADDINS);
        buildSimple();
    }

    protected void buildSimple() {
        MaterialTree tree = new MaterialTree();
        panel.add(tree);
        for (int i = 1; i <= 5; i++) {
            MaterialTreeItem item = new MaterialTreeItem("Item " + i);
            item.setIconType(IconType.FOLDER);
            tree.add(item);
            for (int k = 1; k <= 5; k++) {
                MaterialTreeItem item1 = new MaterialTreeItem("Item " + i + "." + k);
                item1.setIconType(IconType.ALBUM);
                item1.setIconColor(Color.PURPLE);
                item.add(item1);
                /*for (int j = 1; j <= 5; j++) {
                    MaterialTreeItem item2 = new MaterialTreeItem("Item " + i + "." + k + "." + j);
                    item2.setIconType(IconType.HEADSET);
                    item2.setIconColor(Color.RED);
                    item1.add(item2);
                }*/
            }
        }
    }
}
