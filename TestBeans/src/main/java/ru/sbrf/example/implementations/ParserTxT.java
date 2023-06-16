package ru.sbrf.example.implementations;

import ru.sbrf.example.models.Parser;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class ParserTxT implements Parser {

    private Scanner scanner;

    public ParserTxT(String filePath){
        try {
            scanner = new Scanner(new File(filePath));
            scanner.useDelimiter(" ");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public String next() {
        HashSet<Character> avoidSym = new HashSet<>();
        avoidSym.add('.');
        avoidSym.add(',');
        avoidSym.add('!');
        avoidSym.add('?');
        String token = scanner.next();
        if (avoidSym.contains(token.charAt(token.length()-1))){
            token = token.substring(0, token.length()-1);
        }
        return token;
    }

    @Override
    public boolean hasNext() {
        return scanner.hasNextLine();
    }
}

