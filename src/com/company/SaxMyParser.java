package com.company;

import org.xml.sax.SAXException;

import javax.swing.text.html.parser.Parser;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxMyParser {
    public StarSystems parse() {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SaxParserHandler handler = new SaxParserHandler();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (Exception e) {
            System.out.println("open sax parser error" + e.toString());
            return null;
        }

        File file = new File("text.xml");
        try {
            parser.parse(file, handler);
        } catch (SAXException e) {
            System.out.println("sax parsering error" + e.toString());
            return null;
        } catch (IOException e) {
            System.out.println("IO parsering error" + e.toString());
            return null;
        }

        return handler.getStarSystems();
    }
}
