package com.codecool.java.expertsystem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RuleRepository {

    private Iterator guestionIterator;
    private Map<String, Question> questions = new HashMap<>();

    public RuleRepository() {

        guestionIterator = new QuestionIterator();
    }

    public void addQuestion(Question question) {

        questions.put(question.getId(), question);
    }

    public Iterator<Question> getIterator() {

        return guestionIterator;
    }

    private class QuestionIterator implements Iterator {

        int index = 0;

        @Override
        public boolean hasNext() {

            return index < questions.size();
        }

        @Override
        public Question next() {

            return hasNext() ? questions.get(index++) : null;
        }
    }
}