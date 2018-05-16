package com.codecool.java.expertsystem;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class RuleParser extends XMLParser {

    private RuleRepository ruleRepository;

    public RuleParser() {

        this.ruleRepository = new RuleRepository();


        loadXmlDocument("src/main/resources/Rules.xml");

        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

        parseRules(doc);


    }

    private void parseRules(Document document) {

        NodeList nList = document.getElementsByTagName("Rule");
        
        for (int i = 0; i < nList.getLength(); i++) {

            if (nList.item(i).getNodeName().equals("Rule")) {
                parseOneRule((Element) nList.item(i));
            }
        }
    }

    private void parseOneRule(Element rule) {

        String id = rule.getAttribute("id");
            System.out.println("Id : " + id);

        Element question = (Element) rule.getElementsByTagName("Question").item(0);
        String questionDesc = question.getTextContent();
            System.out.println("Question : " + questionDesc);
            
        Element answer = (Element) rule.getElementsByTagName("Answer").item(0);
        NodeList selections = answer.getElementsByTagName("Selection");

        for(int i = 0; i < selections.getLength(); i++) {
            if (selections.item(i).getNodeName().equals("Selection")) {
                parseOneSelection((Element) selections.item(i));
            }
        }
    }

    private void parseOneSelection(Element selection) {

        String booleanValue = selection.getAttribute("value");
            System.out.println("Selection value : " + booleanValue);
        
        NodeList list = selection.getChildNodes();
        Node value ;
        for(int i = 0; i < list.getLength(); i++) {
            if (list.item(i).getNodeName().equals("SingleValue")) {
                value = list.item(i).getAttributes().getNamedItem("value");
                System.out.printf("%s value: %s %n%n", list.item(i).getNodeName(), value);  
                
            }
            if (list.item(i).getNodeName().equals("MultipleValue")) {
                value = list.item(i).getAttributes().getNamedItem("value");
                System.out.printf("%s value: %s %n%n", list.item(i).getNodeName(), value);  
            }
                        
        }
    }
        
    public RuleRepository getRuleRepository() {

        return this.ruleRepository;
    }

    // public void loadXmlDocument(String xmlPath) {

    //     //to implement
    // }




}