package gwt.material.demo.errai.client.local.dto;

import java.util.ArrayList;
import java.util.List;

public class DataHelper {

    public static List<Link> getAppLinks() {
        List<Link> links = new ArrayList<>();

        Link about = new Link("About", "#about");

        Link components = new Link("Components");
        components.addSubLink(new Link("Badges", "#badge"));
        components.addSubLink(new Link("Buttons", "#button"));
        components.addSubLink(new Link("Breadcrumb", "#breadcrumb"));
        components.addSubLink(new Link("Cards", "#cards"));
        components.addSubLink(new Link("Chips", "#chips"));
        components.addSubLink(new Link("Collapsible", "#collapsible"));
        components.addSubLink(new Link("Collections", "#collection"));
        components.addSubLink(new Link("DatePicker", "#datepicker"));
        components.addSubLink(new Link("Dialogs", "#dialogs"));
        components.addSubLink(new Link("Dropdown", "#dropdown"));
        components.addSubLink(new Link("Errors", "#errors"));
        components.addSubLink(new Link("Forms", "#forms"));
        components.addSubLink(new Link("FAB", "#fab"));
        components.addSubLink(new Link("Footer", "#footer"));
        components.addSubLink(new Link("Loaders", "#loaders"));
        components.addSubLink(new Link("Media", "#media"));
        components.addSubLink(new Link("NavBar", "#navbar"));
        components.addSubLink(new Link("Pushpin", "#pushpin"));
        components.addSubLink(new Link("Search", "#search"));
        components.addSubLink(new Link("Sidenavs", "#sidenavs"));
        components.addSubLink(new Link("Scrollspy", "#scrollspy"));
        components.addSubLink(new Link("Tabs", "#tabs"));

        Link animations = new Link("Animations");
        animations.addSubLink(new Link("Core", "#core"));
        animations.addSubLink(new Link("Meaningful", "#meaningful"));

        Link addins = new Link("Addins");
        addins.addSubLink(new Link("Autocomplete", "#autocomplete"));
        addins.addSubLink(new Link("Avatar", "#avatar"));
        addins.addSubLink(new Link("Bubble", "#bubble"));
        addins.addSubLink(new Link("Camera", "#camera"));
        addins.addSubLink(new Link("ComboBox", "#combobox"));
        addins.addSubLink(new Link("CutOut", "#cutout"));
        addins.addSubLink(new Link("Data Table", "#datatable"));
        addins.addSubLink(new Link("Doc Viewer", "#docviewer"));
        addins.addSubLink(new Link("Drag and Drop", "#dnd"));
        addins.addSubLink(new Link("File Uploader", "#fileuploader"));
        addins.addSubLink(new Link("Icon Morph", "#iconmorph"));
        addins.addSubLink(new Link("Masonry", "#masonry"));
        addins.addSubLink(new Link("Path Animator", "#pathanimator"));
        addins.addSubLink(new Link("Rating", "#rating"));
        addins.addSubLink(new Link("Rich Editor", "#richeditor"));
        addins.addSubLink(new Link("Scroll Fire", "#scrollfire"));
        addins.addSubLink(new Link("Split Panel", "#splitpanel"));
        addins.addSubLink(new Link("Subheader", "#subheader"));
        addins.addSubLink(new Link("Steppers", "#steppers"));
        addins.addSubLink(new Link("Swipeable", "#swipeable"));
        addins.addSubLink(new Link("Time Picker", "#timepicker"));
        addins.addSubLink(new Link("Tree View", "#treeview"));
        addins.addSubLink(new Link("Waterfall", "#waterfall"));
        addins.addSubLink(new Link("Window", "#window"));

        links.add(about);
        links.add(components);
        links.add(animations);
        links.add(addins);
        return links;
    }
}
