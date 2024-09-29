package com.app.parser.stax;

import com.app.parser.XmlParser;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import static com.app.constant.AppConstant.EMPLOYEE_ATTRIBUTE_NAME;

public class StaxParser implements XmlParser {
    private String name,salary,city,country;
    @Override
    public void parseXml(String fileName) throws Exception {

        XMLEventReader xmlEventReader = XMLInputFactory.newDefaultFactory().createXMLEventReader(this.getClass().getClassLoader().getResourceAsStream(fileName));
        while(xmlEventReader.hasNext()){
            XMLEvent xmlEvent = xmlEventReader.nextEvent();
            if(xmlEvent.getEventType()== XMLStreamConstants.START_ELEMENT){
                String elementName = xmlEvent.asStartElement().getName().getLocalPart();

                switch (elementName){
                    case EMPLOYEE_ATTRIBUTE_NAME:
                        System.out.println("---------------------------");
                        break;
                    case "name":
                     name=  getXmlData(xmlEventReader);
                     break;
                    case "salary":
                        salary=getXmlData(xmlEventReader);
                        break;
                    case "city":
                        city=getXmlData(xmlEventReader);
                        break;
                    case "country":
                        country=getXmlData(xmlEventReader);
                        break;
                }
            }
            else if (xmlEvent.getEventType()==XMLStreamConstants.END_ELEMENT){
                String endElement = xmlEvent.asEndElement().getName().getLocalPart();
                if(endElement.equalsIgnoreCase(EMPLOYEE_ATTRIBUTE_NAME)){
                    System.out.println(name);
                    System.out.println(salary);
                    System.out.println(city);
                    System.out.println(country);
                    System.out.println("--------------------------------------");
                }
            }
        }


    }
    private String getXmlData( XMLEventReader xmlEventReader) throws XMLStreamException {
        return xmlEventReader.nextEvent().asCharacters().getData();
    }
}
