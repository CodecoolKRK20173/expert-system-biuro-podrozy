package com.codecool.java.expertsystem;

import com.codecool.java.expertsystem.parser.FactParser;
import com.codecool.java.expertsystem.parser.RuleParser;

public class Main {

    public static void main(String[] args) {

        FactParser factParser = new FactParser();
        RuleParser ruleParser = new RuleParser();

        ESProvider esProvider = new ESProvider(factParser, ruleParser);
        esProvider.collectAnswers();
        System.out.println(esProvider.evaluate());
    }
}
