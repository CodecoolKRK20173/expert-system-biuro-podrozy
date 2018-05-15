package com.codecool.java.expertsystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MultipleValue extends Value {

    private List<String> params;
    private boolean selectionType;

    public MultipleValue(List<String> params, boolean selectionType) {
        
        this.params = params;
        this.selectionType = selectionType;
    }

    public List<String> getInputPattern() {

        return params;
    }

    public boolean getSelectionType() {

        return this.selectionType;
    }
}