package com.codecool.java.expertsystem;

import java.lang.Exception;
import java.util.ArrayList;
import java.util.List;

public class Answer {

    List<Value> values = new ArrayList<>();

    public boolean evaluateAswerByInput(String input) throws Exception {

        for (Value value : values) {
            for (String pattern : value.getInputPattern()) {
                if (pattern.equals(input)) {
                    return value.getSelectionType();
                }
            } 
        }
        throw new Exception();
    }

    public void addValue(Value value) {

        values.add(value);
    }
}