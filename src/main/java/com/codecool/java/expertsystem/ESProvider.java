package com.codecool.java.expertsystem;


import com.codecool.java.expertsystem.model.Fact;
import com.codecool.java.expertsystem.model.Question;
import com.codecool.java.expertsystem.parser.FactParser;
import com.codecool.java.expertsystem.parser.RuleParser;
import com.codecool.java.expertsystem.repository.FactRepository;
import com.codecool.java.expertsystem.repository.RuleRepository;

import java.util.*;

class ESProvider {

    RuleRepository ruleRepository;
    FactRepository factRepository;

    private Map<String, Boolean> userAnswers;

    ESProvider(FactParser factParser, RuleParser ruleParser) {
        ruleRepository = ruleParser.getRuleRepository();
        factRepository = factParser.getFactRepository();
        userAnswers = new TreeMap<>();
    }

    void collectAnswers() {
        while (ruleRepository.getIterator().hasNext()) {
            Question question = ruleRepository.getIterator().next();
            userAnswers.put(question.getId(), validateUserInput(question));
            //System.out.println(userAnswers); // test use only TODO: delete for production
        }
    }

    private Boolean validateUserInput(Question q) {
        Scanner in = new Scanner(System.in);
        boolean success = false;
        Boolean validatedAnswer = null;
        while (!success) {
            try {
                System.out.printf("%n%s ", q.getQuestion());
                String answer = in.nextLine();
                validatedAnswer = q.getEvaluatedAnswer(answer);
                success = true;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        return validatedAnswer;
    }

     String evaluate() {
        String metch = null;
        Iterator<Fact> factIterator = factRepository.getIterator();

        while(factIterator.hasNext() ) {
            Fact fact = factIterator.next();
            if(fact.getFields().equals(this.userAnswers)) {
                metch = fact.getDescription();
            }
        }
        return metch;
    }
}