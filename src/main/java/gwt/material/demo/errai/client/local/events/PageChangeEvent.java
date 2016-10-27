package gwt.material.demo.errai.client.local.events;

import gwt.material.design.client.constants.Color;

public class PageChangeEvent {

    private int type;
    private String title;
    private String description;
    private Color color;
    private String htmlCodeLink;
    private String javaCodeLink;

    public PageChangeEvent(int type, String title, String description, Color color, String htmlCodeLink, String javaCodeLink) {
        this.type = type;
        this.title = title;
        this.description = description;
        this.color = color;
        this.htmlCodeLink = htmlCodeLink;
        this.javaCodeLink = javaCodeLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getHtmlCodeLink() {
        return htmlCodeLink;
    }

    public String getJavaCodeLink() {
        return javaCodeLink;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
