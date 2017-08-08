package com.foldik.xml.homework.xml.homework.reader;

import com.foldik.xml.homework.xml.homework.model.Color;
import com.foldik.xml.homework.xml.homework.model.Rectangle;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StAXReader {

    private static final String XML_ROOT_FOLDER = "/";

    public void readDocument() throws XMLStreamException {
        XMLEventReader eventReader = XMLInputFactory.newInstance().createXMLEventReader(getClass().getResourceAsStream(XML_ROOT_FOLDER + "rectangle-example.xml"));
        while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
            switch (event.getEventType()) {
                case XMLStreamConstants.START_ELEMENT:
                    StartElement element = event.asStartElement();
//                    System.out.println(element.getName().getLocalPart());
                    String qName = element.getName().getLocalPart();
                    if (qName.equals("Rectangle")) {
                        Iterator<Attribute> attributes = element.getAttributes();


                        ArrayList<String> attributeList = new ArrayList();
                        int arrayListIndex = 0;
//                        System.out.print(" " + attributeList.isEmpty() + " " + arrayListIndex + " ");
                        while (attributes.hasNext()) {
                            Attribute myAttribute = attributes.next();
                            attributeList.add(arrayListIndex, myAttribute.getValue());
                            arrayListIndex++;
                        }

//                        System.out.println(attributeList.toString());
//
                        Color color = new Color(attributeList.get(0));

                        color.toString();

                        Rectangle rectangle = new Rectangle(
                                Double.parseDouble(attributeList.get(4)),
                                Double.parseDouble(attributeList.get(3)),
                                Double.parseDouble(attributeList.get(1)),
                                Double.parseDouble(attributeList.get(2)),
                                color
                        );

                        System.out.println(rectangle.toString());
                    }
            }
        }
    }

}
