package ru.sbrf.example.Implementations;

import ru.sbrf.example.Models.Analyzer;
import ru.sbrf.example.Models.Parser;

import java.util.HashMap;
import java.util.Map;

public class AnalyzerImpl implements Analyzer {
    private final Parser parser;
    private int tokenCounter = 0;

    public AnalyzerImpl(Parser parser) {
        this.parser = parser;
    }


    @Override
    public Map<String, Integer> getTokenMap() {
        Map<String, Integer> tokenMap = new HashMap<>();
        while (parser.hasNext()){
            tokenCounter++;
            String curToken = parser.next();
            if (tokenMap.containsKey(curToken)){
                tokenMap.replace(curToken, tokenMap.get(curToken) + 1);
            }else {
                tokenMap.put(curToken, 1);
            }
        }
        return tokenMap;
    }

    @Override
    public int getTokenCounter() {
        return tokenCounter;
    }
}
