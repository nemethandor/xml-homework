package com.foldik.xml.homework.xml.homework.invalid;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.util.Iterator;

public class InvalidRectangle {

    private static final String XML_ROOT_FOLDER = "/";

    public void invalidDetails() throws XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader eventReader = factory.createXMLEventReader(getClass().getResourceAsStream(XML_ROOT_FOLDER + "invalid-rectangle-xml-example.xml"));
        int countInvalid = 0;
        int countTag = 0;
        boolean missingWidth = true;
        boolean missingHeight = true;
        boolean missingX = true;
        boolean missingY = true;
        boolean missingColor = true;

        while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
            switch (event.getEventType()) {
                case XMLStreamConstants.START_ELEMENT:
                    StartElement element = event.asStartElement();
                    String qName = element.getName().getLocalPart();
                    if (qName.equals("Rectangle")) {
                        countTag++;
                        Iterator<Attribute> attributes = element.getAttributes();
                        while (attributes.hasNext()) {
                            Attribute myAttribute = attributes.next();
                            if (myAttribute.getName().getLocalPart().equalsIgnoreCase("Width")) {
                                missingWidth = false;
                            }
                            if (myAttribute.getName().getLocalPart().equals("Height")) {
                                missingHeight = false;
                            }
                            if (myAttribute.getName().getLocalPart().equals("X")) {
                                missingX = false;
                            }
                            if (myAttribute.getName().getLocalPart().equals("Y")) {
                                missingY = false;
                            }
                            if (myAttribute.getName().getLocalPart().equals("Color")) {
                                missingColor = false;
                            }
                        }
                        if (missingHeight || missingWidth || missingX || missingY || missingColor) {
                            countInvalid++;
                            System.out.println("Tagnumber: " + countTag + "\n\t Elements [ Width: " + !missingWidth + ", Height: " + !missingHeight + ", X: " + !missingX + ", Y: " + !missingY + ", Color: " + !missingColor + "]");
                        }
                        missingWidth = true;
                        missingHeight = true;
                        missingX = true;
                        missingY = true;
                        missingColor = true;
                    }

            }

        }
        System.out.println("\ntrue - Parameter is exist\nfalse - Parameter is missing");
        System.out.println("\nTotal number of invalid lines:" + countInvalid);

    }


    public void countInvalid() throws XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader eventReader = factory.createXMLEventReader(getClass().getResourceAsStream(XML_ROOT_FOLDER + "invalid-rectangle-xml-example.xml"));
        int countInvalid = 0;
        int countTag = 0;
        boolean missingWidth = true;
        boolean missingHeight = true;
        boolean missingX = true;
        boolean missingY = true;
        boolean missingColor = true;

        while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
            switch (event.getEventType()) {
                case XMLStreamConstants.START_ELEMENT:
                    StartElement element = event.asStartElement();
                    String qName = element.getName().getLocalPart();
                    if (qName.equals("Rectangle")) {
                        countTag++;
                        Iterator<Attribute> attributes = element.getAttributes();
                        while (attributes.hasNext()) {
                            Attribute myAttribute = attributes.next();
                            if (myAttribute.getName().getLocalPart().equalsIgnoreCase("Width")) {
                                missingWidth = false;
                            }
                            if (myAttribute.getName().getLocalPart().equals("Height")) {
                                missingHeight = false;
                            }
                            if (myAttribute.getName().getLocalPart().equals("X")) {
                                missingX = false;
                            }
                            if (myAttribute.getName().getLocalPart().equals("Y")) {
                                missingY = false;
                            }
                            if (myAttribute.getName().getLocalPart().equals("Color")) {
                                missingColor = false;
                            }
                        }
                        if (missingHeight || missingWidth || missingX || missingY || missingColor) {
                            countInvalid++;
                        }
                        missingWidth = true;
                        missingHeight = true;
                        missingX = true;
                        missingY = true;
                        missingColor = true;
                    }

            }

        }
        System.out.println("\nTotal number of invalid lines:" + countInvalid);

    }
}

