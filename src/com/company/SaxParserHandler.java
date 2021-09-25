package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;
import java.util.ArrayList;

public class SaxParserHandler extends DefaultHandler {

//    private static final String TAG_NAME_MAIN = "name";
//    private static final String TAG_NAME_MAIN_ONE = "name";
//    private static final String  TAG_NAME_MAIN_TWO ="name";
//    private static final String  TAG_NAME_MAIN_TREE="name";
    private static final String TAG_NAME = "name";
    private static final String TAG_MASS = "mass";
    private static final String TAG_STAR_SYSTEM = "starsystem";
    private static final String TAG_STARS = "stars";
    private static final String TAG_STAR = "star";
    private static final String TAG_PLANETS = "planets";
    private static final String TAG_PLANET = "planet";
    private static final String TAG_SATELLITES = "satellites";
    private static final String TAG_SATELLITE = "satellite";


    StarSystems starSystems = new StarSystems();
    StarSystem starSystem = new StarSystem();
    List<StarSystem> starSystemsList = new ArrayList<>();
    Star star = new Star();
    List<Star> starsList = new ArrayList<>();
    Planet planet = new Planet();
    List<Planet>planetList = new ArrayList<>();
    Satellite satellite = new Satellite();
    List<Satellite> satellitesList = new ArrayList<>();




    private String currentTagName;
    private boolean isStarSystem = false;
    private boolean isStars = false;
    private boolean isStar = false;
    private boolean isPlanets= false;
    private boolean isPlanet = false;
    private boolean isSatellites = false;
    private boolean isSatellite = false;

//    private String nameStSm;

//    private String nameSt;
//    private int massSt;

//    private String namePl;
//    private int massPl;

//    private String nameSalt;
//    private int massSalt;

    public StarSystems getStarSystems(){
        return starSystems;
    }

    @Override
    public void startDocument() throws SAXException {
//        System.out.println("Start");
    }

    @Override
    public void endDocument() throws SAXException {
//      System.out.println("End document" + planetList.size());
        starSystems.setStarSystems(starSystemsList);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//       System.out.println("Start Element "+ qName);
        currentTagName = qName;
        if ( currentTagName.equals(TAG_STAR_SYSTEM)){
            isStarSystem = true;
        }else if ( currentTagName.equals(TAG_STARS)){
            starsList.clear();
            isStars = true;
        }else if ( currentTagName.equals(TAG_STAR)){
            star = new Star();
            isStar = true;
        }else if ( currentTagName.equals(TAG_PLANETS)){
            planetList.clear();
            isPlanets = true;
        }else if ( currentTagName.equals(TAG_PLANET)){
            planet = new Planet();
            isPlanet = true;
        }else if ( currentTagName.equals(TAG_SATELLITES)){
            satellitesList.clear();
            isSatellites = true;
        }else if ( currentTagName.equals(TAG_SATELLITE)){
            satellite =new Satellite();
            isSatellite = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//       System.out.println("End Element "+qName);
        if (qName != null) {
            if (qName.equals(TAG_STAR_SYSTEM)) {
                isStarSystem = false;
                starSystemsList.add(starSystem);
            } else if (qName.equals(TAG_STARS)) {
                isStars = false;
                starSystem.setStar(starsList);
            } else if (qName.equals(TAG_STAR)) {
                isStar = false;
                starsList.add(star);
            } else if (qName.equals(TAG_PLANETS)) {
                isPlanets = false;
                star.setPlanet(planetList);
            } else if (qName.equals(TAG_PLANET)) {
                isPlanet = false;
                planetList.add(planet);
            } else if (qName.equals(TAG_SATELLITES)) {
                isSatellites = false;
                planet.setSatellite(satellitesList);
            } else if (qName.equals(TAG_SATELLITE)) {
                isSatellite = false;
                satellitesList.add(satellite);
            }
            currentTagName = null;
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(currentTagName==null){
            return;
        }else {
            boolean isName=currentTagName.equals(TAG_NAME);
            boolean isMass=currentTagName.equals(TAG_MASS);
            if (!isStar) {
                if (isName){starSystem.setName(new String(ch, start, length));}
            } else if (!isPlanets) {
                if (isName){star.setName(new String(ch, start, length));}
                else if(isMass) {star.setMass(Integer.valueOf(new String(ch, start, length)));}
            } else if (!isSatellites) {
                if (isName){planet.setName(new String(ch, start, length));}
                else if(isMass) {planet.setMass(Integer.valueOf(new String(ch, start, length)));}
            } else if (isSatellite) {
                if (isName){satellite.setName(new String(ch, start, length));}
                else if(isMass) {satellite.setMass(Integer.valueOf(new String(ch, start, length)));}
            }
        }
    }
//    @Override
//        public void characters(char[] ch, int start, int length) throws SAXException {
//        if(currentTagName==null){
////            return;
//    }else if(!isStar&&currentTagName.equals(TAG_NAME_MAIN)){
//            nameStSm = new String(ch, start, length);
//        }
//
//    }
}







