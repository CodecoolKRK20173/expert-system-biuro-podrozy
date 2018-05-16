package com.codecool.java.expertsystem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RuleRepository {

    private Iterator<Question> questionIterator;
    private Map<String, Question> questions = new HashMap<>();

    public RuleRepository() {
        questionIterator = new QuestionIterator();
    }

    public void addQuestion(Question question) {
        questions.put(question.getId(), question);
    }

    public Iterator<Question> getIterator() {
        return questionIterator;
    }

    private class QuestionIterator implements Iterator<Question> {

        int index = 0;
        List<String> keyList;

        @Override
        public boolean hasNext() {
            return index < questions.size();
        }

        @Override
        public Question next() {
            if (keyList == null) {
                keyList = new ArrayList<String>(questions.keySet());
            }

            String key = keyList.get(index++);
            return questions.get(key);
        }
    }
}