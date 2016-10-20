package gwt.material.demo.errai.client.local.page.animations;

import gwt.material.demo.errai.client.local.page.PageBase;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconSize;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.*;
import gwt.material.design.client.ui.animate.MaterialAnimation;
import gwt.material.design.client.ui.animate.MaterialAnimator;
import gwt.material.design.client.ui.animate.Transition;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
@Page(path = "core_animation")
public class CoreAnimationsPage extends PageBase {

    @Inject
    @DataField
    MaterialComboBox<Transition> lstAnimations;

    @Inject
    @DataField
    MaterialCard card;

    @Inject
    @DataField
    MaterialIcon iconInfinite, iconCallback, iconStatefull;

    @Inject
    @DataField
    MaterialButton btnInfinite, btnStopInfinite, btnCallback, btnStatefull;

    @PostConstruct
    public void init() {
        initPage("Core Animations", "We used AnimateCSS to built our core animations.", ANIMATIONS);
        buildBasic();
        buildInfinite();
        buildIconCallback();
        buildStatefull();
    }

    public void buildStatefull() {
        buildIconSample(iconStatefull);
        iconStatefull.setIconType(IconType.POLYMER);
        iconStatefull.setBackgroundColor(Color.BLUE);
        btnStatefull.setText("Animate");
        btnStatefull.addClickHandler(clickEvent -> {
            new MaterialAnimation().transition(Transition.JELLO).durationMillis(1000).animate(iconStatefull);
        });
    }

    public void buildIconCallback() {
        buildIconSample(iconCallback);
        iconCallback.setIconType(IconType.DIRECTIONS_BIKE);
        iconCallback.setBackgroundColor(Color.BLUE);
        btnCallback.setText("Animate with Callback");
        btnCallback.addClickHandler(clickEvent -> {
            MaterialAnimator.animate(Transition.FLIPINX, iconCallback, 1000, () -> {
                MaterialToast.fireToast("Callback Fired");
            });
        });
    }

    public void buildInfinite() {
        buildIconSample(iconInfinite);
        iconInfinite.setIconType(IconType.FAVORITE);
        iconInfinite.setBackgroundColor(Color.PINK);
        btnInfinite.setText("Infinite Animation");
        btnInfinite.addClickHandler(clickEvent -> {
            MaterialAnimator.animate(Transition.PULSE, iconInfinite, 1000, true);
        });

        btnStopInfinite.setText("Stop Animation");
        btnStopInfinite.setType(ButtonType.FLAT);
        btnStopInfinite.addClickHandler(clickEvent -> {
            MaterialAnimator.stopAnimation(iconInfinite);
        });
    }

    protected void buildIconSample(MaterialIcon icon) {
        icon.setShadow(1);
        icon.setIconSize(IconSize.LARGE);
        icon.setIconColor(Color.WHITE);
        icon.setCircle(true);
        icon.setWidth("130px");
        icon.setHeight("130px");
        icon.setPadding(20);
    }

    public void buildBasic() {
        card.setBackgroundColor(Color.BLUE);
        card.setPadding(20);
        MaterialLabel title = new MaterialLabel("I love Animation");
        title.setFontSize("2em");
        title.setTextColor(Color.WHITE);
        card.add(title);

        lstAnimations.addValueChangeHandler(event -> {
            MaterialAnimator.animate(event.getValue(), card, 1000);
        });
        lstAnimations.addItem("bounce", Transition.BOUNCE);
        lstAnimations.addItem("flash", Transition.FLASH);
        lstAnimations.addItem("pulse", Transition.PULSE);
        lstAnimations.addItem("rubberBand", Transition.RUBBERBAND);
        lstAnimations.addItem("shake", Transition.SHAKE);
        lstAnimations.addItem("headShake", Transition.HEADSHAKE);
        lstAnimations.addItem("swing", Transition.SWING);
        lstAnimations.addItem("tada", Transition.TADA);
        lstAnimations.addItem("wobble", Transition.WOBBLE);
        lstAnimations.addItem("jello", Transition.JELLO);
        lstAnimations.addItem("bounceIn", Transition.BOUNCEIN);
        lstAnimations.addItem("bounceInDown", Transition.BOUNCEINDOWN);
        lstAnimations.addItem("bounceInLeft", Transition.BOUNCEINLEFT);
        lstAnimations.addItem("bounceInRight", Transition.BOUNCEINRIGHT);
        lstAnimations.addItem("bounceInUp", Transition.BOUNCEINUP);
        lstAnimations.addItem("bounceOut", Transition.BOUNCEOUT);
        lstAnimations.addItem("bounceOutDown", Transition.BOUNCEOUTDOWN);
        lstAnimations.addItem("bounceOutLeft", Transition.BOUNCEOUTLEFT);
        lstAnimations.addItem("bounceOutRight", Transition.BOUNCEOUTRIGHT);
        lstAnimations.addItem("bounceOutUp", Transition.BOUNCEOUTUP);
        lstAnimations.addItem("fadeIn", Transition.FADEIN);
        lstAnimations.addItem("fadeInDown", Transition.FADEINDOWN);
        lstAnimations.addItem("fadeInDownBig", Transition.FADEINDOWNBIG);
        lstAnimations.addItem("fadeInLeft", Transition.FADEINLEFT);
        lstAnimations.addItem("fadeInLeftBig", Transition.FADEINLEFTBIG);
        lstAnimations.addItem("fadeInRight", Transition.FADEINRIGHT);
        lstAnimations.addItem("fadeInRightBig", Transition.FADEINRIGHTBIG);
        lstAnimations.addItem("fadeInUp", Transition.FADEINUP);
        lstAnimations.addItem("fadeInUpBig", Transition.FADEINUPBIG);
        lstAnimations.addItem("fadeOut", Transition.FADEOUT);
        lstAnimations.addItem("fadeOutDown", Transition.FADEOUTDOWN);
        lstAnimations.addItem("fadeOutDownBig", Transition.FADEOUTDOWNBIG);
        lstAnimations.addItem("fadeOutLeft", Transition.FADEOUTLEFT);
        lstAnimations.addItem("fadeOutLeftBig", Transition.FADEOUTLEFTBIG);
        lstAnimations.addItem("fadeOutRight", Transition.FADEOUTRIGHT);
        lstAnimations.addItem("fadeOutRightBig", Transition.FADEOUTRIGHTBIG);
        lstAnimations.addItem("fadeOutUp", Transition.FADEOUTUP);
        lstAnimations.addItem("fadeOutUpBig", Transition.FADEOUTUPBIG);
        lstAnimations.addItem("flipInX", Transition.FLIPINX);
        lstAnimations.addItem("flipInY", Transition.FLIPINY);
        lstAnimations.addItem("flipOutX", Transition.FLIPOUTX);
        lstAnimations.addItem("flipOutY", Transition.FLIPOUTY);
        lstAnimations.addItem("lightSpeedIn", Transition.LIGHTSPEEDIN);
        lstAnimations.addItem("lightSpeedOut", Transition.LIGHTSPEEDOUT);
        lstAnimations.addItem("rotateIn", Transition.ROTATEIN);
        lstAnimations.addItem("rotateInDownLeft", Transition.ROTATEINDOWNLEFT);
        lstAnimations.addItem("rotateInDownRight", Transition.ROTATEINDOWNRIGHT);
        lstAnimations.addItem("rotateInUpLeft", Transition.ROTATEINUPLEFT);
        lstAnimations.addItem("rotateInUpRight", Transition.ROTATEINUPRIGHT);
        lstAnimations.addItem("rotateOut", Transition.ROTATEOUT);
        lstAnimations.addItem("rotateOutDownLeft", Transition.ROTATEOUTDOWNLEFT);
        lstAnimations.addItem("rotateOutDownRight", Transition.ROTATEOUTDOWNRIGHT);
        lstAnimations.addItem("rotateOutUpLeft", Transition.ROTATEOUTUPLEFT);
        lstAnimations.addItem("rotateOutUpRight", Transition.ROTATEOUTUPRIGHT);
        lstAnimations.addItem("hinge", Transition.HINGE);
        lstAnimations.addItem("rollIn", Transition.ROLLIN);
        lstAnimations.addItem("rollOut", Transition.ROLLOUT);
        lstAnimations.addItem("zoomIn", Transition.ZOOMIN);
        lstAnimations.addItem("zoomInDown", Transition.ZOOMINDOWN);
        lstAnimations.addItem("zoomInLeft", Transition.ZOOMINLEFT);
        lstAnimations.addItem("zoomInRight", Transition.ZOOMINRIGHT);
        lstAnimations.addItem("zoomInUp", Transition.ZOOMINUP);
        lstAnimations.addItem("zoomOut", Transition.ZOOMOUT);
        lstAnimations.addItem("zoomOutDown", Transition.ZOOMOUTDOWN);
        lstAnimations.addItem("zoomOutLeft", Transition.ZOOMOUTLEFT);
        lstAnimations.addItem("zoomOutRight", Transition.ZOOMOUTRIGHT);
        lstAnimations.addItem("zoomOutUp", Transition.ZOOMOUTUP);
        lstAnimations.addItem("slideInDown", Transition.SLIDEINDOWN);
        lstAnimations.addItem("slideInLeft", Transition.SLIDEINLEFT);
        lstAnimations.addItem("slideInRight", Transition.SLIDEINRIGHT);
        lstAnimations.addItem("slideInUp", Transition.SLIDEINUP);
        lstAnimations.addItem("slideOutDown", Transition.SLIDEOUTDOWN);
        lstAnimations.addItem("slideOutLeft", Transition.SLIDEOUTLEFT);
        lstAnimations.addItem("slideOutRight", Transition.SLIDEOUTRIGHT);
        lstAnimations.addItem("slideOutUp", Transition.SLIDEOUTUP);
    }
}
