package gwt.material.demo.errai.client.page.components;

import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.client.constants.*;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialFAB;
import gwt.material.design.client.ui.MaterialFABList;
import gwt.material.design.client.ui.MaterialToast;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "fab")
public class FABPage extends AbstractPage {

    @Inject
    @DataField
    MaterialFAB fabBasic;

    @Inject
    @DataField
    MaterialFAB fabOpenClose;

    @Inject
    @DataField
    MaterialButton btnOpen;

    @Inject
    @DataField
    MaterialButton btnClose;

    @Inject
    @DataField
    MaterialFAB fabAxis;

    @Inject
    @DataField
    MaterialFAB fabClickOnly;

    @Inject
    @DataField
    MaterialFAB fabEvents;

    @Override
    public String getName() {
        return "FAB";
    }

    @Override
    public String getDescription() {
        return "FAB or Floating action buttons are used for a promoted action. " +
               "They are distinguished by a circled icon floating above the UI and " +
               "have motion behaviors that include morphing, launching, and a " +
               "transferring anchor point.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.COMPONENTS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
        buildFABBasic();
        buildFABOpenClose();
        buildFABAxis();
        buildFABClickOnly();
        buildFABEvents();
    }

    private void buildFABEvents() {
        fabEvents.setAxis(Axis.HORIZONTAL);
        fabEvents.addOpenHandler(openEvent -> {
            MaterialToast.fireToast("Open Event Fired");
        });

        fabEvents.addCloseHandler(closeEvent -> {
            MaterialToast.fireToast("Close Event Fired");
        });
        buildFAB(fabEvents);
    }

    private void buildFABClickOnly() {
        fabClickOnly.setType(FABType.CLICK_ONLY);
        fabClickOnly.setAxis(Axis.HORIZONTAL);
        buildFAB(fabClickOnly);
    }

    private void buildFABAxis() {
        fabAxis.setAxis(Axis.HORIZONTAL);
        buildFAB(fabAxis);
    }

    private void buildFABOpenClose() {
        fabOpenClose.setAxis(Axis.HORIZONTAL);
        buildFAB(fabOpenClose);
        btnOpen.setText("Open");
        btnOpen.addClickHandler(clickEvent -> {
            fabOpenClose.open();
        });

        btnClose.setText("Close");
        btnClose.addClickHandler(clickEvent -> {
            fabOpenClose.close();
        });
    }

    private void buildFABBasic() {
        buildFAB(fabBasic);
    }

    private void buildFAB(MaterialFAB fab) {
        MaterialFABList fabList = new MaterialFABList();
        MaterialButton btn1 = new MaterialButton();
        btn1.setIconType(IconType.POLYMER);
        btn1.setType(ButtonType.FLOATING);
        btn1.setSize(ButtonSize.LARGE);
        btn1.setWaves(WavesType.LIGHT);
        fab.add(btn1);

        MaterialButton btn2 = new MaterialButton();
        btn2.setIconType(IconType.POLYMER);
        btn2.setType(ButtonType.FLOATING);
        btn2.setBackgroundColor(Color.PURPLE);
        btn2.setWaves(WavesType.LIGHT);
        fabList.add(btn2);

        MaterialButton btn3 = new MaterialButton();
        btn3.setIconType(IconType.POLYMER);
        btn3.setType(ButtonType.FLOATING);
        btn3.setBackgroundColor(Color.RED);
        btn3.setWaves(WavesType.LIGHT);
        fabList.add(btn3);

        MaterialButton btn4 = new MaterialButton();
        btn4.setIconType(IconType.POLYMER);
        btn4.setType(ButtonType.FLOATING);
        btn4.setBackgroundColor(Color.GREEN);
        btn4.setWaves(WavesType.LIGHT);
        fabList.add(btn4);
        fab.add(fabList);
    }
}
