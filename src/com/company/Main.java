package com.company;


public class Main {

    public static void main(String[] args) {

        SaxMyParser parser = new SaxMyParser();
        StarSystems starSystems = parser.parse();

        System.out.println("starSystems" + starSystems);

    }

}