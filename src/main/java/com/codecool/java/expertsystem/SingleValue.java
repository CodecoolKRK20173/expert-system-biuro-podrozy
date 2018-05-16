package com.codecool.java.expertsystem;

import java.util.Collections;
import java.util.List;

public class SingleValue extends Value {

    private String param;
    private boolean selectionType;

    public SingleValue(String param, boolean selectionType) {
        
        this.param = param;
        this.selectionType = selectionType;
    }

    public List<String> getInputPattern() {

        return Collections.singletonList(this.param);
    }

    public boolean getSelectionType() {

        return this.selectionType;
    }
}