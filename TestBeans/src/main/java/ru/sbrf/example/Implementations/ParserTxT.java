package ru.sbrf.example.Implementations;

import ru.sbrf.example.Models.Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ParserTxT implements Parser {

    private int pos = 0;
    private String[] tokenList;

    public ParserTxT(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            StringBuilder lineText = new StringBuilder(line);
            lineText.append(" ");
            line = reader.readLine();

            while (line != null) {
                lineText.append(line).append(" ");
                line = reader.readLine();

            }
            String resultLine = lineText.toString();
            resultLine = resultLine.replaceAll("\\s+", " ").trim();
            tokenList = resultLine.split(" ");
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String next() {
        int curPos = pos;
        pos++;
        return tokenList[curPos];
    }

    @Override
    public boolean hasNext() {
        return pos < tokenList.length;
    }
}

