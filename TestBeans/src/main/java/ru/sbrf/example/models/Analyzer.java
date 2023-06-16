package ru.sbrf.example.models;

import java.util.Map;

public interface Analyzer {
    Map<String, Integer> getTokenMap();
    int getTokenCounter();
}
