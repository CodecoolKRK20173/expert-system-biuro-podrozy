package com.codecool.java.expertsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public abstract class XMLParser {

    protected Document doc;

    public void loadXmlDocument(String xmlPath) {
        try {
            File xmlFile = new File(xmlPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //protected String xmlString;
    
    // public void loadXmlDocument(String xmlPath) {
        
    //     StringBuilder sb = new StringBuilder();
    //     try (BufferedReader br = new BufferedReader(new FileReader(xmlPath))) {
    //         String sCurrentLine;
    //         while ((sCurrentLine = br.readLine()) != null) {
    //             sb.append(sCurrentLine);
    //         }
    //         this.xmlString = sb.toString();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

}
