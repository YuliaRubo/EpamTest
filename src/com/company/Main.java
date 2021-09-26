package com.company;


import javax.imageio.spi.ImageInputStreamSpi;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int sizeBodiesSystem = 0;
        int massBodiesSystem = 0;

        SaxMyParser parser = new SaxMyParser();
        StarSystems starSystems = parser.parse();
        List<StarSystem> starSystemList = starSystems.getStarSystems();
        System.out.println(""+starSystemList.size()+" systems:");
        for (StarSystem starSystem: starSystemList) {
            List<Star> starList = starSystem.getStars();
            System.out.println(" System \""+starSystem.getName()+"\": "+starList.size()+" stars:");
            sizeBodiesSystem = sizeBodiesSystem + starList.size();
            for (Star star: starList) {
                List<Planet> planetList = star.getPlanets();
                massBodiesSystem = massBodiesSystem + star.getMass();
                if (planetList != null){
                    System.out.println("  Star \""+star.getName()+"\" of system \""+starSystem.getName()+"\": "+planetList.size()+" planets:");
                    sizeBodiesSystem = sizeBodiesSystem + planetList.size();
                    for (Planet planet: planetList) {
                        List<Satellite> satelliteList = planet.getSatellites();
                        massBodiesSystem = massBodiesSystem + planet.getMass();
                        if (satelliteList != null) {
                            System.out.println("   Planet \""+planet.getName()+"\" of star \""+star.getName()+"\": "+satelliteList.size()+" satellites:");
                            sizeBodiesSystem = sizeBodiesSystem + satelliteList.size();
                            for (Satellite satellite: satelliteList) {
                                System.out.println("    Satellite \""+satellite.getName()+";");
                                massBodiesSystem = massBodiesSystem + satellite.getMass();
                            }
                        }
                    }
                }
            }
        }

        System.out.println("Amount - "+sizeBodiesSystem+"; total mass - "+massBodiesSystem);

    }
}

