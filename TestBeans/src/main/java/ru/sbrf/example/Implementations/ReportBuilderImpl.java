package ru.sbrf.example.Implementations;

import ru.sbrf.example.Models.Analyzer;
import ru.sbrf.example.Models.Parser;
import ru.sbrf.example.Models.ReportBuilder;

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
