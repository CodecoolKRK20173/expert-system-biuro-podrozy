package main.java.com.codecool.java.expertsystem;

public class FactParser extends XMLParser {

    private FactRepository factRepository;

    public FactParser(FactRepository factRepository) {

        this.factRepository = factRepository;
    }

    public FactRepository getFactRepository() {

        return this.factRepository;
    }

    public void loadXmlDocument(String xmlPath) {

        //to implement
    }
}