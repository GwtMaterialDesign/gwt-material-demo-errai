package gwt.material.demo.errai.client.local.page.addins;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.addins.client.masonry.MaterialMasonry;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.MaterialColumn;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Random;

@Templated
@Page(path = "masonry")
public class MasonryPage extends PageBase {

    @Inject
    @DataField
    MaterialMasonry masonryBasic, masonryLeft, masonryTop, masonryTransition;

    @PostConstruct
    public void init() {
        initPage(this, "Masonry", "Masonry works by placing elements in optimal position based on available vertical space, sort of like a mason fitting stones in a wall.", ADDINS);
        buildBasic();
        buildLeft();
        buildTop();
        buildTransition();
    }

    protected void buildTransition() {
        masonryTransition.setTransitionDuration(0);
        buildMasonry(masonryTransition);
    }

    protected void buildTop() {
        masonryTop.setOriginTop(true);
        buildMasonry(masonryTop);
    }

    protected void buildLeft() {
        masonryLeft.setOriginLeft(true);
        buildMasonry(masonryLeft);
    }

    protected void buildBasic() {
        buildMasonry(masonryBasic);
    }

    protected void buildMasonry(MaterialMasonry masonry) {
        int[] colWidth = new int[]{2, 3, 4};
        int[] colHeight = new int[]{200, 400};
        Color[] colors = new Color[]{
                Color.BLUE, Color.RED, Color.YELLOW, Color.AMBER, Color.ORANGE, Color.PURPLE, Color.BLACK, Color.DEEP_ORANGE, Color.DEEP_PURPLE, Color.GREEN
        };
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int randomWidth = colWidth[random.nextInt(colWidth.length)];
            int randomHeight = colHeight[random.nextInt(colHeight.length)];
            MaterialColumn col = new MaterialColumn(12, randomWidth, randomWidth);
            col.setBackgroundColor(colors[i]);
            col.setHeight(randomHeight + "px");
            masonry.add(col);
        }
    }
}
