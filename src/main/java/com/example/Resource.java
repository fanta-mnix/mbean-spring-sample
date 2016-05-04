package com.example;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

import java.util.ArrayList;
import java.util.List;

// Hierarchy Folder > Subfolder > Resource
// More on: http://actimem.com/java/jmx-spring/
@ManagedResource(objectName = "Folder:type=Subfolder,name=Resource")
public class Resource {
    List<String> items = new ArrayList<>();

    @ManagedAttribute
    public String getLastItem() {
        return items.get(getSize()-1);
    }

    @ManagedAttribute
    public int getSize() {
        return items.size();
    }

    @ManagedOperation
    public void addItem(String item) {
        items.add(item);
    }

    @ManagedOperation
    public String getItem(int pos) {
        return items.get(pos);
    }

    @ManagedOperation
    public List<String> getItems() {
        return items;
    }
}