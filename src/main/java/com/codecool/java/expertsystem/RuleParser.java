package com.codecool.java.expertsystem;

import java.util.Arrays;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class RuleParser extends XMLParser {

    private RuleRepository ruleRepository;

    public RuleParser() {
        this.ruleRepository = new RuleRepository();
        loadXmlDocument("src/main/resources/Rules.xml");  
        parseRules(doc);
    }

    private void parseRules(Document document) {

        NodeList nList = document.getElementsByTagName("Rule");
        
        for (int i = 0; i < nList.getLength(); i++) {
            if (nList.item(i).getNodeName().equals("Rule")) {
                ruleRepository.addQuestion(parseOneRule((Element) nList.item(i)));
            }
        }
    }

    private Question parseOneRule(Element rule) {

        String id = rule.getAttribute("id");
        
        Element questionElem = (Element) rule.getElementsByTagName("Question").item(0);
        String questionDesc = questionElem.getTextContent();
            //System.out.println("Question : " + questionDesc);
            
        Element answerElem = (Element) rule.getElementsByTagName("Answer").item(0);
        NodeList selections = answerElem.getElementsByTagName("Selection");

        Answer answer = null;

        for(int i = 0; i < selections.getLength(); i++) {
            if (selections.item(i).getNodeName().equals("Selection")) {
                answer = parseOneSelection((Element) selections.item(i));
            }
        }

        return new Question(id, questionDesc, answer);
    }

    private Answer parseOneSelection(Element selection) {

        Answer answer = new Answer();

        Boolean booleanValue = Boolean.valueOf(selection.getAttribute("value"));
            //System.out.println("Selection value : " + booleanValue);
        
        NodeList list = selection.getChildNodes();
        Node valueNode;
        String value;
        List<String> values;
        for(int i = 0; i < list.getLength(); i++) {
            if (list.item(i).getNodeName().equals("SingleValue")) {
                valueNode = list.item(i).getAttributes().getNamedItem("value");
                value = valueNode.getNodeValue();
                
                //System.out.printf("%s value: %s %n%n", list.item(i).getNodeName(), value); 
                answer.addValue(new SingleValue(value, booleanValue)); 
                
            }
            if (list.item(i).getNodeName().equals("MultipleValue")) {
                valueNode = list.item(i).getAttributes().getNamedItem("value");
                value = valueNode.getNodeValue();
                values = Arrays.asList(value.split(", "));
                //System.out.printf("%s value: %s %n%n", list.item(i).getNodeName(), value);  
                answer.addValue(new MultipleValue(values, booleanValue));                 
            }         
        }
        return answer;
    }
        
    public RuleRepository getRuleRepository() {

        return this.ruleRepository;
    }
}