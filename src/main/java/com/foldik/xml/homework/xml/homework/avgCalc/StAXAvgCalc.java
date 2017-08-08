package com.foldik.xml.homework.xml.homework.avgCalc;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.util.Iterator;

public class StAXAvgCalc {

    private static final String XML_ROOT_FOLDER = "/";

    public String calculateAVG(String tagName, String attributeName) throws XMLStreamException {

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader eventReader = factory.createXMLEventReader(getClass().getResourceAsStream(XML_ROOT_FOLDER + "rectangle-example.xml"));
        Double sum = 0.0;
        int count = 0;

        while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
            switch (event.getEventType()) {
                case XMLStreamConstants.START_ELEMENT:
                    StartElement element = event.asStartElement();
                    String qName = element.getName().getLocalPart();
                    if (qName.equals(tagName)) {
                        Iterator<Attribute> attributes = element.getAttributes();

                        while (attributes.hasNext()) {
                            Attribute myAttribute = attributes.next();
                            if (myAttribute.getName().getLocalPart().equals(attributeName)) {
                                sum += Double.parseDouble(myAttribute.getValue().toString());
                                count++;
//                                System.out.println(sum + " "+ count);
                            }
                        }

                    }
            }
        }

//        return " " +sum;
        return "Average of " + attributeName + ": " + Math.round(sum / count * 100.0) / 100.0;
    }
}
