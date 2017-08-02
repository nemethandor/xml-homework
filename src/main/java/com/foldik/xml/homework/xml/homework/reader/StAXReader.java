package com.foldik.xml.homework.xml.homework.reader;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StAXReader {

    private static final String XML_ROOT_FOLDER="/";

    public void readDocument() throws XMLStreamException{
        XMLEventReader eventReader= XMLInputFactory.newInstance().createXMLEventReader(getClass().getResourceAsStream(XML_ROOT_FOLDER+"rectangle-example.xml"));
        while (eventReader.hasNext()){
            XMLEvent event=eventReader.nextEvent();
            switch(event.getEventType()){
                case XMLStreamConstants.START_ELEMENT:
                    StartElement element=event.asStartElement();
                    System.out.println(element.getName().getLocalPart());

            }
        }
    }

}
