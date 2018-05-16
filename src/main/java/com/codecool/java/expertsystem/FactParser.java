package com.codecool.java.expertsystem;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FactParser extends XMLParser {

    private FactRepository factRepository;

    public FactParser() {
        loadXmlDocument("Facts.xml");
    }

    FactRepository getFactRepository() {
        return this.factRepository;
    }

    public void parse() {
        factRepository = new FactRepository();
        NodeList factList = doc.getElementsByTagName("Fact");
        for (int i = 0; i < factList.getLength(); i++) {
            Node nNode = factList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                String factID = eElement.getAttribute("id");
                String factDescription = eElement.getChildNodes()
                                                 .item(1)
                                                 .getAttributes()
                                                 .item(0)
                                                 .getTextContent();

                Fact newFact = new Fact(factID, factDescription);
                NodeList evals = eElement.getElementsByTagName("Eval");
                for(int j=0;j<evals.getLength();j++) {
                    Element eval = (Element) evals.item(j);
                    String factEvalId = eval.getAttribute("id");
                    String factEvalValue = eval.getTextContent();
                    newFact.setFactValueById(factEvalId, Boolean.valueOf(factEvalValue));
                }
                factRepository.addFact(newFact);
            }
        }
    }
}
