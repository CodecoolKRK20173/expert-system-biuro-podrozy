package com.codecool.java.expertsystem;

import java.util.List;

public abstract class Value {

    protected boolean selectionType;
    //protected List<String> param;

    public abstract List<String> getInputPattern();

    public boolean getSelectionType() {
        return this.selectionType;
    }
}