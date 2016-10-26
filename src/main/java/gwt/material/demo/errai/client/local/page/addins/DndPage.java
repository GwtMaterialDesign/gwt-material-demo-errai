package gwt.material.demo.errai.client.local.page.addins;

import com.google.gwt.dom.client.Style;
import com.google.gwt.uibinder.client.UiField;
import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.addins.client.dnd.MaterialDnd;
import gwt.material.design.addins.client.dnd.constants.Restriction;
import gwt.material.design.addins.client.dnd.js.JsDragOptions;
import gwt.material.design.client.constants.*;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialPanel;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "dnd")
public class DndPage extends PageBase {

    @Inject
    @DataField
    MaterialPanel draggableContainer;

    @PostConstruct
    public void init() {
        initPage("Drag and Drop", "Provides a delightful dragging capability.", ADDINS);
        buildBasic();
    }

    /*
    <m:MaterialPanel ui:field="panel" margin="10" textAlign="CENTER" paddingTop="50" backgroundColor="WHITE" waves="DEFAULT" width="150px" height="150px" shadow="1">
                <m:MaterialIcon iconType="TOUCH_APP" iconSize="SMALL" />
                <m:MaterialLabel text="Default" fontSize="1.5em"/>
            </m:MaterialPanel>
     */

    protected void buildBasic() {
        draggableContainer.setBackgroundColor(Color.GREY_LIGHTEN_4);
        buildDraggableBlocks("Default", JsDragOptions.create());
        buildDraggableBlocks("With Inertia", JsDragOptions.create(false));
        Restriction restriction = new Restriction();
        restriction.setEndOnly(false);
        buildDraggableBlocks("End Only", JsDragOptions.create(restriction));
        Restriction restriction1 = new Restriction();
        restriction1.setRestriction(Restriction.Restrict.SELF);
        buildDraggableBlocks("Self Restrict", JsDragOptions.create(restriction1));
        Restriction restriction2 = new Restriction();
        restriction2.setTop(0.25);
        restriction2.setLeft(0.25);
        restriction2.setRight(0.75);
        restriction2.setBottom(0.75);
        buildDraggableBlocks("Rect Restrict", JsDragOptions.create(restriction2));
    }

    protected void buildDraggableBlocks(String label, JsDragOptions options) {
        MaterialPanel panel = new MaterialPanel();
        panel.setMargin(10);
        panel.setTextAlign(TextAlign.CENTER);
        panel.setPaddingTop(50);
        panel.setBackgroundColor(Color.WHITE);
        panel.setShadow(1);
        panel.setWaves(WavesType.DEFAULT);
        panel.setWidth("150px");
        panel.setHeight("150px");

        MaterialIcon icon = new MaterialIcon(IconType.TOUCH_APP);
        icon.setIconSize(IconSize.SMALL);
        panel.add(icon);

        MaterialLabel title = new MaterialLabel(label);
        title.setFontSize(1.5, Style.Unit.EM);
        panel.add(title);
        draggableContainer.add(panel);
        MaterialDnd.draggable(panel, options);
    }
}
