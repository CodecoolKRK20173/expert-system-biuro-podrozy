package main.java.com.codecool.java.expertsystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Fact {

    private String id;
    private String description;
    private Map<String, Boolean> fields = new HashMap<>();

    public Fact(String id, String description) {

        this.id = id;
        this.description = description;
    }

    public Set<String> getIdSet() {

        return this.fields.keySet();
    }

    public void setFactValueById(String id, boolean value) {

        this.fields.put(id, value);
    }

    public boolean getValueById(String id) {

        return fields.get(id);
    }

    public String getDescription() {

        return this.description;
    }
}