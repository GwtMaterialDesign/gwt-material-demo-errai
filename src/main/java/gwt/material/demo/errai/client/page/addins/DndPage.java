package gwt.material.demo.errai.client.page.addins;

import com.google.gwt.dom.client.Style;
import gwt.material.demo.errai.client.local.page.AbstractPage;
import gwt.material.demo.errai.client.local.page.PageCategory;
import gwt.material.design.addins.client.dnd.MaterialDnd;
import gwt.material.design.addins.client.dnd.constants.Restriction;
import gwt.material.design.addins.client.dnd.js.JsDragOptions;
import gwt.material.design.addins.client.dnd.js.JsDropOptions;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.*;
import gwt.material.design.client.ui.*;
import gwt.material.design.jquery.client.api.JQueryElement;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import static gwt.material.design.jquery.client.api.JQuery.$;

@Templated
@Page(path = "dnd")
public class DndPage extends AbstractPage {

    @Inject
    @DataField
    MaterialPanel draggableContainer, draggableEventsContainer, draggableIgnoreContainer, draggableXYAxisContainer;

    @Inject
    @DataField
    MaterialRow dropzoneContainer;

    @Override
    public String getName() {
        return "Drag and Drop";
    }

    @Override
    public String getDescription() {
        return "Provides a delightful dragging capability.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.ADDINS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
        buildBasic();
        buildEvents();
        buildIgnoreFrom();
        buildAxis();
        buildDropzone();
    }

    protected void buildDropzone() {
        dropzoneContainer.setBackgroundColor(Color.GREY_LIGHTEN_1);
        dropzoneContainer.setPadding(10);

        MaterialColumn col = new MaterialColumn();
        col.setGrid("s6");
        dropzoneContainer.add(col);

        MaterialColumn colDrop = new MaterialColumn();
        colDrop.setGrid("s6");
        colDrop.setBackgroundColor(Color.GREY_LIGHTEN_3);
        colDrop.setPadding(20);
        dropzoneContainer.add(colDrop);

        MaterialLabel label = new MaterialLabel("Drop Here");
        colDrop.add(label);

        for (int i = 1; i <= 5; i++) {
            MaterialPanel panel = new MaterialPanel();
            panel.addStyleName("test");
            panel.setBackgroundColor(Color.WHITE);
            panel.setShadow(1);
            panel.setGrid("s12");
            panel.setPadding(8);
            panel.setMargin(4);

            MaterialLink link = new MaterialLink();
            link.setText("Option " + i);
            panel.add(link);

            col.add(panel);
            MaterialDnd.draggable(panel);
        }

        MaterialDnd.dropzone(dropzoneContainer, JsDropOptions.create(".test"));

        dropzoneContainer.addDropActivateHandler(event1 -> {
            MaterialToast.fireToast("Drop Activate");
        });

        dropzoneContainer.addDragEnterHandler(dragEnterEvent -> {
            colDrop.setBackgroundColor(Color.BLUE);
            MaterialToast.fireToast("Drag Enter");
        });

        dropzoneContainer.addDragLeaveHandler(event1 -> {
            colDrop.setBackgroundColor(Color.GREY_LIGHTEN_2);
            MaterialToast.fireToast("Drag Leave");
        });

        dropzoneContainer.addDropHandler(event -> {
            JQueryElement target = $(event.getRelatedTarget());
            MaterialWidget widget = new MaterialWidget(target.asElement());
            colDrop.add(widget);
            MaterialToast.fireToast("Dropped");
        });

        dropzoneContainer.addDropDeactivateHandler(event -> {
            MaterialToast.fireToast("Drop Deactivate");
        });
    }

    protected void buildAxis() {
        buildDraggableBlocks("X Axis", JsDragOptions.create(Axis.HORIZONTAL), draggableXYAxisContainer);
        buildDraggableBlocks("Y Axis", JsDragOptions.create(Axis.VERTICAL), draggableXYAxisContainer);
    }

    protected void buildIgnoreFrom() {
        MaterialPanel panel = new MaterialPanel();
        panel.setGrid("l4 m6 s12");
        panel.setShadow(1);
        panel.setPadding(0);

        MaterialPanel panel1 = new MaterialPanel();
        panel1.setPadding(20);
        panel.add(panel1);
        MaterialLink link = new MaterialLink("This is draggable");
        link.setIconType(IconType.TOUCH_APP);
        panel1.add(link);

        MaterialPanel panel2 = new MaterialPanel();
        panel2.addStyleName("valign-wrapper");
        panel2.setPaddingLeft(80);
        panel2.setBackgroundColor(Color.GREY_LIGHTEN_3);
        panel2.setWidth("100%");
        panel2.setHeight("200px");
        panel.add(panel2);

        MaterialLink link2 = new MaterialLink();
        link2.setIconType(IconType.HIGHLIGHT_OFF);
        link2.setIconColor(Color.RED);
        link2.setTextColor(Color.GREY);
        link2.setFontSize(1.2, Style.Unit.EM);
        link2.setText("This area is ignored from dragging");
        panel2.add(link2);

        MaterialDnd dndIgnore = MaterialDnd.draggable(panel);
        dndIgnore.ignoreFrom(panel2);

        draggableIgnoreContainer.add(panel);
    }

    protected void buildEvents() {
        draggableEventsContainer.setBackgroundColor(Color.GREY_LIGHTEN_4);

        MaterialPanel panel = buildDraggableBlocks("Events", JsDragOptions.create(), draggableEventsContainer);
        panel.addDragStartHandler(dragStartEvent -> {
            MaterialLabel label = (MaterialLabel) panel.getWidget(1);
            label.setText("Started");
        });

        panel.addDragMoveHandler(dragMoveEvent -> {
            MaterialLabel label = (MaterialLabel) panel.getWidget(1);
            label.setText("Moved");
        });

        panel.addDragEndHandler(dragEndEvent -> {
            MaterialLabel label = (MaterialLabel) panel.getWidget(1);
            label.setText("Ended");
        });
    }

    protected void buildBasic() {
        draggableContainer.setBackgroundColor(Color.GREY_LIGHTEN_4);
        buildDraggableBlocks("Default", JsDragOptions.create(), draggableContainer);
        buildDraggableBlocks("With Inertia", JsDragOptions.create(false), draggableContainer);
        Restriction restriction = new Restriction();
        restriction.setEndOnly(false);
        buildDraggableBlocks("End Only", JsDragOptions.create(restriction), draggableContainer);
        Restriction restriction1 = new Restriction();
        restriction1.setRestriction(Restriction.Restrict.SELF);
        buildDraggableBlocks("Self Restrict", JsDragOptions.create(restriction1), draggableContainer);
        Restriction restriction2 = new Restriction();
        restriction2.setTop(0.25);
        restriction2.setLeft(0.25);
        restriction2.setRight(0.75);
        restriction2.setBottom(0.75);
        buildDraggableBlocks("Rect Restrict", JsDragOptions.create(restriction2), draggableContainer);
    }

    protected MaterialPanel buildDraggableBlocks(String label, JsDragOptions options, MaterialPanel container) {
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
        container.add(panel);
        MaterialDnd.draggable(panel, options);

        return panel;
    }
}
