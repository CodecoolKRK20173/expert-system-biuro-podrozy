package com.codecool.java.expertsystem.repository;

import com.codecool.java.expertsystem.model.Fact;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class FactRepository {

    private Iterator<Fact> factIterator;
    private List<Fact> facts = new ArrayList<>();

    public FactRepository() {

        factIterator = new FactIterator();
    }

    public void addFact(Fact fact) {

        facts.add(fact);
    }

    public Iterator<Fact> getIterator() {

        return factIterator;
    }

    private class FactIterator implements Iterator<Fact> {

        int index = 0;

        @Override
        public boolean hasNext() {

            return index < facts.size();
        }

        @Override
        public Fact next() {

            return hasNext() ? facts.get(index++) : null;
        }
    }
}