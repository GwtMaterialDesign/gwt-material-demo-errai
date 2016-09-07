package gwt.material.demo.errai.client.local.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Link implements Serializable {

    private String name;
    private String href;
    private boolean ready;
    private List<Link> subLinks = new ArrayList<>();

    public Link() {
    }

    public Link(String name) {
        this.name = name;
    }

    public Link(String name, String href) {
        this.name = name;
        this.href = href;
    }

    public Link(String name, String href, boolean ready) {
        this.name = name;
        this.href = href;
        this.ready = ready;
    }

    public Link(String name, List<Link> subLinks) {
        this.name = name;
        this.subLinks = subLinks;
    }

    public Link(String name, String href, List<Link> subLinks) {
        this.name = name;
        this.href = href;
        this.subLinks = subLinks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<Link> getSubLinks() {
        return subLinks;
    }

    public void setSubLinks(List<Link> subLinks) {
        this.subLinks = subLinks;
    }

    public void addSubLink(Link link) {
        subLinks.add(link);
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }
}
