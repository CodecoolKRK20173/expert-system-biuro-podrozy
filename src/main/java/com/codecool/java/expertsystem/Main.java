package com.codecool.java.expertsystem;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.codecool.java.expertsystem.parser.FactParser;
import com.codecool.java.expertsystem.parser.RuleParser;

public class Main {

    public static void main(String[] args) {    
        
        String option = "yes";
        while (option.equals("yes")) {
            clearTerminal();
            System.out.println("Welcome in Globetrotter Travel Agency\nChoose travel direction based on your preferences.");
            try {
                FactParser factParser = new FactParser();
                RuleParser ruleParser = new RuleParser();
                ESProvider esProvider = new ESProvider(factParser, ruleParser);
                esProvider.collectAnswers();
                System.out.println(esProvider.evaluate());  
                option = getString("\nDo you want to answer the question again? yes/no");
            } catch (InputMismatchException e) {
                System.out.println("Enter yes or no");
            }
        }
    }

    private static void clearTerminal(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String getString(String text) {
        System.out.println(text);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    } 
}
