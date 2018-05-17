package com.codecool.java.expertsystem.model;

import java.util.List;

public abstract class Value {

    protected boolean selectionType;

    public abstract List<String> getInputPattern();

    public boolean getSelectionType() {
        return this.selectionType;
    }
}