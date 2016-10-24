package gwt.material.demo.errai.client.local.page.components;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.client.constants.*;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialFAB;
import gwt.material.design.client.ui.MaterialFABList;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Templated
@Page(path = "fab")
@ApplicationScoped
public class FABPage extends PageBase {

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

    @PostConstruct
    public void init() {
        initPage("FAB", "FAB or Floating action buttons are used for a promoted action. They are distinguished by a circled icon floating above the UI and have motion behaviors that include morphing, launching, and a transferring anchor point.", COMPONENTS);
        buildFABBasic();
        buildFABOpenClose();
        buildFABAxis();
        buildFABClickOnly();
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
