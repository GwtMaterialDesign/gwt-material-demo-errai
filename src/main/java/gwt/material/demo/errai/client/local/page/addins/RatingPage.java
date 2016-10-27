package gwt.material.demo.errai.client.local.page.addins;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.addins.client.rating.MaterialRating;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialToast;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "rating")
public class RatingPage extends PageBase {

    @Inject
    @DataField
    MaterialRating ratingBasic;

    @Inject
    @DataField
    MaterialRating ratingIcon;

    @Inject
    @DataField
    MaterialRating ratingValueChange;

    @Inject
    @DataField
    MaterialRating ratingSettingValue;

    @Inject
    @DataField
    MaterialRating ratingEditable;

    @Inject
    @DataField
    MaterialRating ratingMaxRating;

    @PostConstruct
    public void init() {
        initPage(this, "Rating", "MaterialRating is the component used by the 5-star rating system, for example, allowing users to easily express their opinion about a product, review, video and so on.", ADDINS);
        buildBasic();
        buildIcon();
        buildValueChangeEvent();
        buildValueSettingValue();
        buildEditable();
        buildMaxRating();
    }

    private void buildBasic() {
        ratingBasic.setTextColor(Color.AMBER);
    }

    private void buildMaxRating() {
        ratingMaxRating.setTextColor(Color.AMBER);
        ratingMaxRating.setMaxRating(10);
    }

    private void buildEditable() {
        ratingEditable.setTextColor(Color.AMBER);
        ratingEditable.setValue(2);
        ratingEditable.setEditable(false);
    }

    private void buildValueSettingValue() {
        ratingSettingValue.setTextColor(Color.AMBER);
        ratingSettingValue.setValue(3);
    }

    private void buildValueChangeEvent() {
        ratingValueChange.setTextColor(Color.AMBER);
        ratingValueChange.addValueChangeHandler(event -> {
            MaterialToast.fireToast(event.getValue() + " Value");
        });
    }

    private void buildIcon() {
        ratingIcon.setSelectedRatingIcon(IconType.FAVORITE);
        ratingIcon.setUnselectedRatingIcon(IconType.FAVORITE_BORDER);
        ratingIcon.setTextColor(Color.RED);
    }
}
