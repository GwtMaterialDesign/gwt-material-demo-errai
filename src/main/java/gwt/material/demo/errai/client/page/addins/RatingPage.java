package gwt.material.demo.errai.client.page.addins;

import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.demo.errai.client.page.AbstractPage;
import gwt.material.demo.errai.client.page.PageCategory;
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
public class RatingPage extends AbstractPage {

    @Inject
    @DataField
    private MaterialRating ratingBasic;

    @Inject
    @DataField
    private MaterialRating ratingIcon;

    @Inject
    @DataField
    private MaterialRating ratingValueChange;

    @Inject
    @DataField
    private MaterialRating ratingSettingValue;

    @Inject
    @DataField
    private MaterialRating ratingEditable;

    @Inject
    @DataField
    private MaterialRating ratingMaxRating;

    @Override
    public String getName() {
        return "Rating";
    }

    @Override
    public String getDescription() {
        return "MaterialRating is the component used by the 5-star rating system, for example, allowing " +
               "users to easily express their opinion about a product, review, video and so on.";
    }

    @Override
    public PageCategory getCategory() {
        return PageCategory.ADDINS;
    }

    @Override
    protected void onPostConstruct() {
        super.onPostConstruct();
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
