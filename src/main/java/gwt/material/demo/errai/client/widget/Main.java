package gwt.material.demo.errai.client.widget;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import gwt.material.demo.errai.client.ThemeManager;
import gwt.material.demo.errai.client.events.PageChangeEvent;
import gwt.material.demo.errai.client.page.PageCategory;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.MaterialChip;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialPanel;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import static gwt.material.design.jquery.client.api.JQuery.$;

@Templated
public class Main extends Composite {

    @Inject
    @DataField
    private MaterialPanel container;

    @Inject
    @DataField
    private MaterialPanel titlePanel;

    @Inject
    private MaterialLabel lblTitle;

    @Inject
    private MaterialPanel codePanel;

    @Inject
    private MaterialChip chipHtml, chipJava;

    @Inject
    private MaterialLabel lblDescription;
    private PageChangeEvent pageChangeEvent;

    @PostConstruct
    public void init() {
        ThemeManager.register(titlePanel);

        // Title Panel
        lblTitle.setFontSize(2.3, Style.Unit.EM);
        titlePanel.add(lblTitle);
        lblDescription.setMarginBottom(20);
        titlePanel.add(lblDescription);

        codePanel.setWidth("190px");
        chipHtml.setText("HTML");
        chipHtml.setLetter("H");
        chipHtml.setMarginRight(12);
        chipHtml.setTextColor(Color.WHITE);

        ThemeManager.register(chipHtml.getLetterMixin().getSpan(), ThemeManager.LIGHTER_SHADE);
        ThemeManager.register(chipHtml, ThemeManager.DARKER_SHADE);

        chipJava.setText("JAVA");
        chipJava.setLetter("J");
        chipJava.setTextColor(Color.WHITE);
        ThemeManager.register(chipJava.getLetterMixin().getSpan(), ThemeManager.LIGHTER_SHADE);
        ThemeManager.register(chipJava, ThemeManager.DARKER_SHADE);

        chipHtml.addClickHandler(clickEvent -> {
            Window.open(getPageChangeEvent().getHtmlCodeLink(), "_blank", "");
        });

        chipJava.addClickHandler(clickEvent -> {
            Window.open(getPageChangeEvent().getJavaCodeLink(), "_blank", "");
        });
    }

    public void onPageChange(@Observes PageChangeEvent event) {
        setPageChangeEvent(event);

        PageCategory pageCategory = pageChangeEvent.getPageCategory();
        switch (pageCategory) {
            case ADDINS:
            case COMPONENTS:
            case ANIMATIONS:
                codePanel.add(chipHtml);
                codePanel.add(chipJava);
                titlePanel.add(codePanel);
                break;
            default:
                codePanel.removeFromParent();
                break;
        }
        $("body").scrollTop(0);
        lblTitle.setText(event.getTitle());
        lblDescription.setText(event.getDescription());
    }

    public void setPageChangeEvent(PageChangeEvent pageChangeEvent) {
        this.pageChangeEvent = pageChangeEvent;
    }

    public MaterialPanel getContainer() {
        return container;
    }

    public PageChangeEvent getPageChangeEvent() {
        return pageChangeEvent;
    }
}
