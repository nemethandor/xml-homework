package com.foldik.xml.homework.xml.homework.reader;


import com.foldik.xml.homework.xml.homework.model.Color;
import com.foldik.xml.homework.xml.homework.model.Rectangle;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DomReader {

    private static final String XML_ROOT_FOLDER = "/";

    public void getListOfElementsByTag() throws Exception {
        Document doc = getDocument("rectangle-example.xml");

        NodeList nodeList = doc.getElementsByTagName("Rectangle");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element rectangleTag = (Element) doc.getElementsByTagName("Rectangle").item(i);

            Color color = new Color(rectangleTag.getAttribute("Color"));

            Rectangle rectangle = new Rectangle(
                    Double.parseDouble(rectangleTag.getAttribute("Width")),
                    Double.parseDouble(rectangleTag.getAttribute("Height")),
                    Double.parseDouble(rectangleTag.getAttribute("X")),
                    Double.parseDouble(rectangleTag.getAttribute("Y")),
                    color
            );
            System.out.println(rectangle.toString());
        }

    }

    public String calculateAVG(String tagName, String attribute) {
        Document doc = getDocument("rectangle-example.xml");

        NodeList nodeList = doc.getElementsByTagName(tagName);
        Double sum = 0.0;

        for (int i = 0; i < nodeList.getLength(); i++) {

            Element rectangleTag = (Element) doc.getElementsByTagName(tagName).item(i);

            sum += Double.parseDouble(rectangleTag.getAttribute(attribute));

        }

//        double average=;

        return "Average of " + attribute + ": " + Math.round(sum / nodeList.getLength() * 100.0) / 100.0;

    }

    private Document getDocument(String inputXML) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document doc = documentBuilder.parse(getClass().getResourceAsStream(XML_ROOT_FOLDER + inputXML));
            doc.getDocumentElement().normalize();
            return doc;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
