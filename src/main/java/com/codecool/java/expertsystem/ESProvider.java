package com.codecool.java.expertsystem;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ESProvider {

    RuleRepository ruleRepository;
    FactRepository factRepository;

    private Map<String, Boolean> userAnswers;

    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        ruleRepository = ruleParser.getRuleRepository();
        factRepository = factParser.getFactRepository();
        userAnswers = new TreeMap<>();
    }

    public void collectAnswers() {
        while (ruleRepository.getIterator().hasNext()) {
            Question question = ruleRepository.getIterator().next();
            userAnswers.put(question.getId(), validateUserInput(question));
            System.out.println(userAnswers); // test use only TODO: delete for production
        }
    }

    private Boolean validateUserInput(Question q) {
        Scanner in = new Scanner(System.in);
        boolean success = false;
        Boolean validatedAnswer = null;
        while (!success) {
            try {
                System.out.print("\n" + q.getQuestion());
                String answer = in.nextLine();
                validatedAnswer = q.getEvalutedAnswer(answer);
                success = true;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        return validatedAnswer;
    }

    public boolean getAnswerByQuestion(String questionId) {
        return this.userAnswers.get(questionId);
    }

    public String evaluate() {

        //to implement
        return "";
    }
}