package com.codecool.java.expertsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class XMLParser {

    protected String xmlString;

    public void loadXmlDocument(String xmlPath) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(xmlPath))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                sb.append(sCurrentLine);
            }
            this.xmlString = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}