package gwt.material.demo.errai.client.widget;

import com.google.gwt.user.client.ui.Composite;
import gwt.material.demo.errai.client.ThemeManager;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.themes.amber.ThemeAmber;
import gwt.material.design.themes.blue.ThemeBlue;
import gwt.material.design.themes.brown.ThemeBrown;
import gwt.material.design.themes.client.ThemeLoader;
import gwt.material.design.themes.green.ThemeGreen;
import gwt.material.design.themes.grey.ThemeGrey;
import gwt.material.design.themes.orange.ThemeOrange;
import gwt.material.design.themes.pink.ThemePink;
import gwt.material.design.themes.purple.ThemePurple;
import gwt.material.design.themes.red.ThemeRed;
import gwt.material.design.themes.yellow.ThemeYellow;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Templated
public class ThemeSwitcher extends Composite {

    @Inject
    @DataField
    MaterialComboBox<ThemeLoader.ThemeBundle> comboThemes;

    @PostConstruct
    protected void init() {
        initThemes();
    }

    protected void initThemes() {
        ThemeManager.initialize();

        buildThemeList();
        comboThemes.setValue(ThemeManager.getBundle());
        comboThemes.addValueChangeHandler(event -> ThemeManager.loadTheme(event.getValue()));
    }

    protected void buildThemeList() {
        comboThemes.addItem("Amber", ThemeAmber.INSTANCE);
        comboThemes.addItem("Blue", ThemeBlue.INSTANCE);
        comboThemes.addItem("Brown", ThemeBrown.INSTANCE);
        comboThemes.addItem("Green", ThemeGreen.INSTANCE);
        comboThemes.addItem("Grey", ThemeGrey.INSTANCE);
        comboThemes.addItem("Orange", ThemeOrange.INSTANCE);
        comboThemes.addItem("Pink", ThemePink.INSTANCE);
        comboThemes.addItem("Purple", ThemePurple.INSTANCE);
        comboThemes.addItem("Red", ThemeRed.INSTANCE);
        comboThemes.addItem("Yellow", ThemeYellow.INSTANCE);
    }
}
