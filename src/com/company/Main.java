package com.company;

//
public class Main {
////    private static final String TAG_NAME_MAIN1 = "name";
////    private static final String TAG_NAME_MAIN2 = "name";
////    private static final String  TAG_NAME_MAIN3 ="name";
////    private static final String TAG_NAME="name";
////    private static final String TAG_PLANET = "planet";
////    private static final String TAG_STAR = "star";
////    private static final String TAG_SATELLITE = "satellite";
//
    public static void main(String[] args) {

        SaxMyParser parser = new SaxMyParser();
        StarSystems starSystems = parser.parse();

        System.out.println("starSystems" + starSystems);



        }}
//        StarSystems starSystems = new StarSystems();
//        File file = new File("text.xml");
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        Document doc = null;
//        try {
//            doc = dbf.newDocumentBuilder().parse(file);
//        } catch (Exception e) {
//            System.out.println("open parsing error" + e.toString());
//            return;
//        }
//
//
////        String mainName= null;
////        Node starNode = null;
//        Node rootNode = doc.getFirstChild();
//        System.out.println("AAA" + rootNode.getNodeName());
//
//        String mainName= null;
//        Node starNode=null;
//
//        NodeList rootChildren = rootNode.getChildNodes();
//        for (int i = 0; i < rootChildren.getLength(); i++) {
//            if (rootChildren.item(i).getNodeType() != Node.ELEMENT_NODE) {
//                continue;
//            }
//            System.out.println("gg" + rootChildren.item(i).getNodeName());
//
//
//
//        switch (rootChildren.item(i).getTextContent()) {
//            case "name": {
//                mainName = rootChildren.item(i).getTextContent();
//                System.out.println("mainName" + mainName);
//                break;
//            }
//            case "star": {
//                starNode = rootChildren.item(i);
//                break;
//            }
//
//        }
//
//
//    }
//    }
//}
//
//
//
//
//
