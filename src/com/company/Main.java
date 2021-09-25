package com.company;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        SaxMyParser parser = new SaxMyParser();
        StarSystems starSystems = parser.parse();
//        SaxParserHandler saxParserHandler = new SaxParserHandler();
//        ArrayList<StarSystem> starSystemList = new ArrayList<>();
        System.out.println( "starSystems"+ starSystems.toString());



    }

}