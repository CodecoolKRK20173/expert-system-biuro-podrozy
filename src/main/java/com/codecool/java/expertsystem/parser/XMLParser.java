package com.codecool.java.expertsystem.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;

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
        // File xmlFile = new File(xmlPath);
        // DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        // DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        // try {
        // doc = dBuilder.parse(xmlFile);
        // doc.getDocumentElement().normalize();
        // } finally {
        // dbFactory.close();
        // }
        // } catch (FileNotFoundException e) {
        // System.out.println("File not found");
        // } catch (IOException e) {
        // System.out.println("Failed read attempt");
        // }
    }
}
