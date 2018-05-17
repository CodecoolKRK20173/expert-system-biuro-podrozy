package com.codecool.java.expertsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.w3c.dom.Document;
import javax.xml.parsers.ParserConfigurationException;
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
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Failed read attempt");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } 
    
        

        // try {
        //     File xmlFile = new File(xmlPath);
        //     DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        //     DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        //     try {
        //         doc = dBuilder.parse(xmlFile);
        //         doc.getDocumentElement().normalize();
        //     } finally {
        //         dbFactory.close();
        //     }
        // } catch (FileNotFoundException e) {
        //     System.out.println("File not found");
        // } catch (IOException e) {
        //     System.out.println("Failed read attempt");
        // }
    }
}
