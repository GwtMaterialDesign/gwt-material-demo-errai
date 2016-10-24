package gwt.material.demo.errai.client.local.events;

import gwt.material.design.client.constants.Color;

public class PageChangeEvent {

    private String title;
    private String description;
    private Color color;
    private Color secondaryColor;

    public PageChangeEvent(String title, String description, Color color, Color secondaryColor) {
        this.title = title;
        this.description = description;
        this.color = color;
        this.secondaryColor = secondaryColor;
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

    public Color getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(Color secondaryColor) {
        this.secondaryColor = secondaryColor;
    }
}
