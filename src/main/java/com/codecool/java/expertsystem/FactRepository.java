package main.java.com.codecool.java.expertsystem;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class FactRepository {

    private Iterator factIterator;    
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

    private class FactIterator implements Iterator {
        
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