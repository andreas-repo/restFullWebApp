package com.gepardec;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

//the class ItemList wrap your collection as a class instance:
@XmlRootElement(name="listing")
public class ItemList {
    private List<Item> items;

    public ItemList() {}
    public ItemList(List<Item> items) {
        this.items = items;
    }

    @XmlElement(name="items")
    public List<Item> getItems() {
        return items;
    }
}
