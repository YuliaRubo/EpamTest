package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;
import java.util.ArrayList;

public class SaxParserHandler extends DefaultHandler {

    //private static final String TAG_NAME_MAIN = "name";
    //private static final String TAG_NAME_MAIN_ONE = "name";
    //private static final String  TAG_NAME_MAIN_TWO ="name";
    private static final String TAG_NAME = "name";
    private static final String TAG_MASS = "mass";
    private static final String TAG_STAR_SYSTEM = "starSystem";
    private static final String TAG_STAR = "star";
    private static final String TAG_PLANET = "planet";
    private static final String TAG_SATELLITE = "satellite";


    StarSystems starSystems = new StarSystems();
    List<StarSystem> starSystemsList = new ArrayList<>();
    Star stars = new Star();
    List<Star> starsList = new ArrayList<>();
    Planet planet = new Planet();
    List<Planet>planetList = new ArrayList<>();
    Satellite satellite = new Satellite();
    List<Satellite> satellitesList = new ArrayList<>();


    private String currentTagName;
    private boolean isStarSystem = false;
    private boolean isStar = false;
    private boolean isPlanet = false;
    private boolean isSatellite = false;

    private String nameStSm;

    private String nameSt;
    private int massSt;

    private String namePl;
    private int massPl;

    private String nameSalt;
    private int massSalt;

    @Override
    public void startDocument() throws SAXException {
//        System.out.println("Start");
    }

    @Override
    public void endDocument() throws SAXException {
//        System.out.println("End");
        starSystems.setStarSystems(starSystemsList);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        System.out.println("Start Element "+ qName);
        currentTagName = qName;
        if (currentTagName.equals(TAG_STAR_SYSTEM)){
            isStarSystem = true;
        }else if (currentTagName.equals(TAG_STAR)){
            isStar = true;
        }else if (currentTagName.equals(TAG_PLANET)){
            isPlanet = true;
        }else if (currentTagName.equals(TAG_SATELLITE)){
            isSatellite = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        System.out.println("End Element "+qName);
        if (currentTagName != null){
            if (currentTagName.equals(TAG_STAR_SYSTEM)){
                isStarSystem = false;
                StarSystem starSystem = new StarSystem(nameStSm, starsList);
                starSystemsList.add(starSystem);
                starsList.clear();
            }else if(currentTagName.equals(TAG_STAR)){
                isStar = false;
                Star star = new Star();
                star.setName(nameSt);
                star.setMass(massSt);
                star.setPlanet(planetList);
                starsList.add(star);
                planetList.clear();
            }else if(currentTagName.equals(TAG_PLANET)){
                isPlanet = false;
                Planet planet = new Planet();
                planet.setName(namePl);
                planet.setMass(massPl);
                planet.setSatellite(satellitesList);
                planetList.add(planet);
                satellitesList.clear();
            }else if(currentTagName.equals(TAG_SATELLITE)){
                isSatellite = false;
                Satellite satellite = new Satellite();
                satellite.setName(nameSalt);
                satellite.setMass(massSalt);
                satellitesList.add(satellite);

            }
        }
        currentTagName = null;
    }



    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(currentTagName==null){
            return;
        }else if(isStarSystem&&!isStar&&!isPlanet&&!isSatellite&&currentTagName.equals(TAG_NAME)){
           nameStSm = new String(ch, start, length);
        }else if(isStarSystem&&isStar&&!isPlanet&&!isSatellite) {
            if(currentTagName.equals(TAG_NAME)) {
                nameSt = new String(ch, start, length);
            }else if(currentTagName.equals(TAG_MASS)) {
                massSt = Integer.valueOf(new String(ch, start, length));
        }


        }

    }
    }





