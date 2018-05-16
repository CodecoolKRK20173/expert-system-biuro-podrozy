package com.codecool.java.expertsystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Test");
        RuleParser myrules = new RuleParser();   
        while (myrules.getRuleRepository().getIterator().hasNext()) {
            
            String questionToPrint = myrules.getRuleRepository().getIterator().next().getQuestion();
            getString(questionToPrint);
            
        }
          
    }

    public static String getString(String text) {
        System.out.println(text);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    } 
}
