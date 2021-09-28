package com.company;


import javax.imageio.spi.ImageInputStreamSpi;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int sizeBodiesSystem = 0;
        int massBodiesSystem = 0;

        SaxMyParser parser = new SaxMyParser();
        StarSystems starSystems = parser.parse();
        List<StarSystem> starSystemList = starSystems.getStarSystems();
//        System.out.println(""+starSystemList.size()+" systems:");
        for (StarSystem starSystem: starSystemList) {
            List<Star> starList = starSystem.getStars();
//            System.out.println(" System \""+starSystem.getName()+"\": "+starList.size()+" stars:");
            sizeBodiesSystem = sizeBodiesSystem + starList.size();
            for (Star star: starList) {
                List<Planet> planetList = star.getPlanets();
                massBodiesSystem = massBodiesSystem + star.getMass();
                if (planetList != null){
//                    System.out.println("  Star \""+star.getName()+"\" of system \""+starSystem.getName()+"\": "+planetList.size()+" planets:");
                    sizeBodiesSystem = sizeBodiesSystem + planetList.size();
                    for (Planet planet: planetList) {
                        List<Satellite> satelliteList = planet.getSatellites();
                        massBodiesSystem = massBodiesSystem + planet.getMass();
                        if (satelliteList != null) {
//                            System.out.println("   Planet \""+planet.getName()+"\" of star \""+star.getName()+"\": "+satelliteList.size()+" satellites:");
                            sizeBodiesSystem = sizeBodiesSystem + satelliteList.size();
                            for (Satellite satellite: satelliteList) {
//                                System.out.println("    Satellite \""+satellite.getName()+";");
                                massBodiesSystem = massBodiesSystem + satellite.getMass();
                            }
                        }
                    }
                }
            }
        }
//
      System.out.println("Amount - "+sizeBodiesSystem+"; total mass - "+massBodiesSystem);

//        StaxWriteDemo staxWriteDemo = new StaxWriteDemo();
           String amount =  Integer.toString(sizeBodiesSystem);
           String massTotal =  Integer.toString(massBodiesSystem);

        try {
            StringWriter stringWriter = new StringWriter();

            XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xMLStreamWriter = xMLOutputFactory.createXMLStreamWriter(stringWriter);

            xMLStreamWriter.writeStartDocument();
            xMLStreamWriter.writeStartElement("system");

            xMLStreamWriter.writeStartElement("Amount");
            xMLStreamWriter.writeCharacters(amount);
            xMLStreamWriter.writeEndElement();

            xMLStreamWriter.writeStartElement("total");
            xMLStreamWriter.writeAttribute("type", "mass");
            xMLStreamWriter.writeCharacters(massTotal);
            xMLStreamWriter.writeEndElement();

            xMLStreamWriter.writeEndElement();
            xMLStreamWriter.writeEndDocument();

            xMLStreamWriter.flush();
            xMLStreamWriter.close();

            String xmlString = stringWriter.getBuffer().toString();

            stringWriter.close();


            FileWriter writer = null;
            try {
                writer = new FileWriter("filename.xml");
                writer.write(xmlString);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();


        }


    }
}

