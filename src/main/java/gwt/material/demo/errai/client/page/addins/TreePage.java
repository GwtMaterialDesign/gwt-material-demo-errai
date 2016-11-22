package gwt.material.demo.errai.client.page.addins;

import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.addins.client.tree.MaterialTree;
import gwt.material.design.addins.client.tree.MaterialTreeItem;
import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialToast;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "tree")
public class TreePage extends AbstractPage {

    @Inject
    @DataField
    private MaterialPanel panel;

    @Inject
    @DataField
    private MaterialButton btnExpand, btnCollapse;

    @Override
    public String getName() {
        return "Tree";
    }

    @Override
    public String getDescription() {
        return "Tree is a component that wraps all the tree items that provide lists of event " +
               "handlers like open/close and selection event.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.ADDINS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
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
                item.add(item1);
                for (int j = 1; j <= 5; j++) {
                    MaterialTreeItem item2 = new MaterialTreeItem("Item " + i + "." + k + "." + j);
                    item2.setIconType(IconType.HEADSET);
                    item2.setIconColor(Color.PURPLE);
                    item1.add(item2);
                }
            }
        }

        tree.addSelectionHandler(selectionEvent -> {
            MaterialToast.fireToast("Selected " + selectionEvent.getSelectedItem().getText());
        });

        tree.addOpenHandler(openEvent -> {
            MaterialToast.fireToast("Opened " + openEvent.getTarget().getText());
        });

        tree.addCloseHandler(closeEvent -> {
            MaterialToast.fireToast("Close " + closeEvent.getTarget().getText());
        });

        btnExpand.setText("Expand");
        btnExpand.addClickHandler(clickEvent -> {
            tree.expand();
        });

        btnCollapse.setText("Collapse");
        btnCollapse.setType(ButtonType.FLAT);
        btnCollapse.addClickHandler(clickEvent -> {
            tree.collapse();
        });
        tree.collapse();
    }
}
