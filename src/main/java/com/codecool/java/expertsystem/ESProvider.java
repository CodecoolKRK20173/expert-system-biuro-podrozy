package com.codecool.java.expertsystem;

public class ESProvider {

    RuleRepository ruleRepository;
    FactRepository factRepository;
    

    public ESProvider(FactParser factParser, RuleParser ruleParser) {

        ruleRepository = ruleParser.getRuleRepository();
        factRepository = factParser.getFactRepository();
    }

    public void collectAnswers() {

        //to implement
    }

    public boolean getAnswerByQuestion(String questionId) {

        //to implement
        return false;
    }

    public String evaluate() {

        //to implement
        return "";
    }
}