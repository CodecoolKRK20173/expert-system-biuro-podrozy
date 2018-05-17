package com.codecool.java.expertsystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MultipleValue extends Value {

    private List<String> params;
    //private boolean selectionType;

    public MultipleValue(List<String> params, boolean selectionType) {
        
        this.params = params;
        this.selectionType = selectionType;
    }

    public List<String> getInputPattern() {
        return params;
    }

    public String getParam (){
        String paramsToString = "";
        for (int i = 0; i<params.size(); i++) {
            paramsToString += params.get(i) + " ";
        }
        return paramsToString;
    }
}