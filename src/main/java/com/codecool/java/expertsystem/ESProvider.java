package com.codecool.java.expertsystem;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ESProvider {

    RuleRepository ruleRepository;
    FactRepository factRepository;

    private Map<String, String> userAnswers;

    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        ruleRepository = ruleParser.getRuleRepository();
        factRepository = factParser.getFactRepository();
        userAnswers = new TreeMap<>();
    }

    public void collectAnswers() {
        Scanner in = new Scanner(System.in);
        while (ruleRepository.getIterator().hasNext()) {
            Question q = ruleRepository.getIterator().next();
            System.out.print("\n" + q.getQuestion() + " :");
            String answer = in.nextLine();
            userAnswers.put(q.getId(), answer);
            System.out.println(userAnswers); // test use only TODO: delete for production
        }
    }

    public boolean getAnswerByQuestion(String questionId) {
//        return this.userAnswers.get(questionId);
        return false;
    }

    public String evaluate() {

        //to implement
        return "";
    }
}