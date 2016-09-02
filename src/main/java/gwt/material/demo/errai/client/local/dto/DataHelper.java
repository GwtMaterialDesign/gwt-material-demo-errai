package gwt.material.demo.errai.client.local.dto;

import java.util.ArrayList;
import java.util.List;

public class DataHelper {

    public static List<Link> getAppLinks() {
        List<Link> links = new ArrayList<>();

        Link about = new Link("About", "#about");

        Link components = new Link("Components");
        components.addSubLink(new Link("Buttons", "#button"));
        components.addSubLink(new Link("Badges", "#badge"));
        components.addSubLink(new Link("Forms", "#forms"));

        Link addins = new Link("Addins");
        addins.addSubLink(new Link("Autocomplete", "#autocomplete"));
        addins.addSubLink(new Link("ComboBox", "#combobox"));
        addins.addSubLink(new Link("RichEditor", "#richeditor"));

        links.add(about);
        links.add(components);
        links.add(addins);
        return links;
    }
}
