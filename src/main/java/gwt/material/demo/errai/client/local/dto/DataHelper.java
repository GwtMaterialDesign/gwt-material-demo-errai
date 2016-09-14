package gwt.material.demo.errai.client.local.dto;

import java.util.ArrayList;
import java.util.List;

public class DataHelper {

    public DataHelper() {}

    public static List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/stevedesigner/128.jpg", User.Position.DEVELOPER, true, "Luis Hoppe", "luis@mail.com", "123123123", "718-555-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/yassiryahya/128.jpg", User.Position.DEVELOPER, true, "Irwin Mueller", "irwin@mail.com", "123123123", "718-432-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/lebinoclard/128.jpg", User.Position.DEVELOPER, true, "Levin Card", "levin@mail.com", "123123123", "432-555-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/lmjabreu/128.jpg", User.Position.DEVELOPER, false, "Dr. Cassie Keeling", "cassie@mail.com", "123123123", "432-555-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/ariil/128.jpg", User.Position.DEVELOPER, false, "Dr. Madelynn Schamberger", "madelyn@mail.com", "123123123", "543-555-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/devankoshal/128.jpg", User.Position.MARKETING, false, "Dominique Schmidt", "dom@mail.com", "123123123", "718-657-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/karthipanraj/128.jpg", User.Position.CTO, false, "Rowland Heller", "rowland@mail.com", "123123123", "718-765-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/GavicoInd/128.jpg", User.Position.CEO, false, "Quincy Schimmel", "quincy@mail.com", "123123123", "46-555-876", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/roybarberuk/128.jpg", User.Position.MARKETING, false, "Tierra VonRueden", "tierra@mail.com", "123123123", "654-56-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/kimcool/128.jpg", User.Position.MARKETING, false, "Travis Larson", "travis@mail.com", "123123123", "465-456-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/tonymillion/128.jpg", User.Position.MARKETING, false, "Clint Heller", "clint@mail.com", "123123123", "645-555-65", "Makati City, Philippines", "Gwt Material"));
        return list;
    }

    public static List<Link> getAppLinks() {
        List<Link> links = new ArrayList<>();

        Link about = new Link("About", "#about");

        Link components = new Link("Components");
        components.addSubLink(new Link("Badges", "#badge", true));
        components.addSubLink(new Link("Buttons", "#button", true));
        components.addSubLink(new Link("Breadcrumb", "#breadcrumbs", true));
        components.addSubLink(new Link("Cards", "#card", true));
        components.addSubLink(new Link("Chips", "#chip", true));
        components.addSubLink(new Link("Collapsible", "#collapsible", true));
        components.addSubLink(new Link("Collections", "#collection", true));
        components.addSubLink(new Link("DatePicker", "#datepicker", true));
        components.addSubLink(new Link("Modals", "#modals", true));
        components.addSubLink(new Link("Dropdown", "#dropdown", true));
        components.addSubLink(new Link("Errors", "#errors"));
        components.addSubLink(new Link("Forms", "#forms", true));
        components.addSubLink(new Link("FAB", "#fab", true));
        components.addSubLink(new Link("Footer", "#footer", true));
        components.addSubLink(new Link("Loaders", "#loader", true));
        components.addSubLink(new Link("Media", "#media", true));
        components.addSubLink(new Link("NavBar", "#navbar", true));
        components.addSubLink(new Link("Pushpin", "#pushpin", true));
        components.addSubLink(new Link("Search", "#search", true));
        components.addSubLink(new Link("Sidenavs", "#sidenav", true));
        components.addSubLink(new Link("Scrollspy", "#scrollspy", true));
        components.addSubLink(new Link("Tabs", "#tab", true));
        components.addSubLink(new Link("Toast", "#toast", true));
        components.addSubLink(new Link("Tooltip", "#tooltip", true));

        Link animations = new Link("Animations");
        animations.addSubLink(new Link("Core", "#core"));
        animations.addSubLink(new Link("Meaningful", "#meaningful"));

        Link addins = new Link("Addins");
        addins.addSubLink(new Link("Autocomplete", "#autocomplete", true));
        addins.addSubLink(new Link("Avatar", "#avatar", true));
        addins.addSubLink(new Link("Bubble", "#bubble", true));
        addins.addSubLink(new Link("Camera", "#camera"));
        addins.addSubLink(new Link("ComboBox", "#combobox", true));
        addins.addSubLink(new Link("CutOut", "#cutout", true));
        addins.addSubLink(new Link("Data Table", "#datatable"));
        addins.addSubLink(new Link("Doc Viewer", "#docviewer", true));
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
        addins.addSubLink(new Link("Steppers", "#stepper", true));
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

    public List<TimeZone> getTimeZones() {
        List<TimeZone> timeZones = new ArrayList<>();
        timeZones.add(new TimeZone("Alaskan/Hawaiian Time Zone", getHawaiianTimeZone()));
        timeZones.add(new TimeZone("Pacific Time Zone", getPacificTimeZone()));
        return timeZones;
    }

    protected List<State> getHawaiianTimeZone() {
        List<State> states = new ArrayList<>();
        states.add(new State("Alaska", "AK"));
        states.add(new State("Hawaii", "HI"));
        return states;
    }

    protected List<State> getPacificTimeZone() {
        List<State> states = new ArrayList<>();
        states.add(new State("California", "CA"));
        states.add(new State("Nevada", "NV"));
        states.add(new State("Oregon", "OR"));
        states.add(new State("Washington", "WA"));
        return states;
    }
}
