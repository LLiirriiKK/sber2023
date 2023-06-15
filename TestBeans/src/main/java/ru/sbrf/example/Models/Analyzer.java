package ru.sbrf.example.Models;

import java.util.Map;

public interface Analyzer {
    Map<String, Integer> getTokenMap();
    int getTokenCounter();
}
