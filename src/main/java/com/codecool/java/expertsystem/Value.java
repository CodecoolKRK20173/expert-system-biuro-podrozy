package com.codecool.java.expertsystem;

import java.util.List;

public abstract class Value {

    //private String param;
    protected boolean selectionType;

    public abstract List<String> getInputPattern();
  
    //public abstract boolean getSelectionType();
    public boolean getSelectionType() {
        return this.selectionType;
    }

    public abstract String getParam ();
}