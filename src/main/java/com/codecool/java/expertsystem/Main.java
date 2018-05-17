package com.codecool.java.expertsystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        FactParser factParser = new FactParser();
        RuleParser ruleParser = new RuleParser();

        ESProvider esProvider = new ESProvider(factParser, ruleParser);
        esProvider.collectAnswers();

        //fot tests
        RuleParser myrules = new RuleParser(); 
        Scanner input = new Scanner(System.in);
        Question question;
        String userInput;
        boolean booleanAnswer;

        while (myrules.getRuleRepository().getIterator().hasNext()) {
            
            question = myrules.getRuleRepository().getIterator().next();
            
            System.out.println(question.getQuestion());
            userInput = input.nextLine();
            try {
                booleanAnswer = question.getEvalutedAnswer(userInput);
                System.out.println(booleanAnswer);
                
            } catch (Exception e) {
                System.out.println("Bad answer.");
                
            }    
        }     
    }
}
