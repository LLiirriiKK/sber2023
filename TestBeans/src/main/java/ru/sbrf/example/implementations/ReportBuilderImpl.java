package ru.sbrf.example.implementations;

import ru.sbrf.example.models.Analyzer;
import ru.sbrf.example.models.ReportBuilder;

import java.util.Map;

public class ReportBuilderImpl implements ReportBuilder {
    private final Analyzer analyzer;

    public ReportBuilderImpl(Analyzer analyzer) {
        this.analyzer = analyzer;
    }

    @Override
    public void createReport() {
        Map<String, Integer> myMap = analyzer.getTokenMap();
        System.out.println("Total number of tokens: " + analyzer.getTokenCounter());
        for (String token: myMap.keySet()){
            System.out.println(token + "   " + myMap.get(token));
        }
    }
}
