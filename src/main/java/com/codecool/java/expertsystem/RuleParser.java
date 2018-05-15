package main.java.com.codecool.java.expertsystem;

public class RuleParser extends XMLParser {

    private RuleRepository ruleRepository;

    public RuleParser(RuleRepository ruleRepository) {

        this.ruleRepository = ruleRepository;
    }

    public RuleRepository getRuleRepository() {

        return this.ruleRepository;
    }

    public void loadXmlDocument(String xmlPath) {

        //to implement
    }
}