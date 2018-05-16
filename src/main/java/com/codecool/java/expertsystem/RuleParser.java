package com.codecool.java.expertsystem;

import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class RuleParser extends XMLParser {

    private RuleRepository ruleRepository;

    public RuleParser (){
        loadXmlDocument("src/main/resources/Rules.xml");
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("Rule");
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            //System.out.println("\nCurrent Element :" + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;
                
                String id = eElement.getAttribute("id");
                System.out.println("Staff id : " + id);
                System.out.println("First Name : " + eElement.getElementsByTagName("Question").item(0).getTextContent());          
                Element eAnswer = (Element) eElement.getElementsByTagName("Answer").item(0);
                eAnswer.getElementsByTagName("Selection").item(0);
                eAnswer.getElementsByTagName("Selection").item(1);
               
            
                Answer answer = new Answer();
                Question question = new Question(id, eElement.getElementsByTagName("Question").item(0).getTextContent(), answer);

            }
        }
    }

    // public RuleParser(RuleRepository ruleRepository) {

    //     this.ruleRepository = ruleRepository;
    // }

    public RuleRepository getRuleRepository() {

        return this.ruleRepository;
    }

    // public void loadXmlDocument(String xmlPath) {

    //     //to implement
    // }




}