package com.app.parser.stax;

import com.app.domain.Employee;
import com.app.parser.XmlParser;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import java.util.ArrayList;
import java.util.List;

import static com.app.constant.AppConstant.EMPLOYEE_ATTRIBUTE;

public class StaxParser implements XmlParser {
    private final List<Employee> employees = new ArrayList<>();

    @Override
    public void parseXml(String fileName) throws Exception {
        String name = null, salary = null, city = null, country = null;
        XMLEventReader xmlEventReader = XMLInputFactory.newInstance().createXMLEventReader(this.getClass().getClassLoader().getResourceAsStream(fileName));
        Employee e = new Employee();
        while (xmlEventReader.hasNext()) {
            XMLEvent xmlEvent = xmlEventReader.nextEvent();
            if (xmlEvent.getEventType() == XMLStreamConstants.START_ELEMENT) {
                String elementName = xmlEvent.asStartElement().getName().getLocalPart();

                switch (elementName) {

                    case EMPLOYEE_ATTRIBUTE:
                        System.out.println("---------------------------");
                        break;
                    case "name":

                        name = getXmlData(xmlEventReader);
                        e.setName(name);
                        break;
                    case "salary":
                        salary = getXmlData(xmlEventReader);
                        e.setSalary(salary);
                        break;
                    case "city":
                        city = getXmlData(xmlEventReader);
                        e.setCity(city);
                        break;
                    case "country":
                        country = getXmlData(xmlEventReader);
                        e.setCountry(country);
                        break;
                }
            } else if (xmlEvent.getEventType() == XMLStreamConstants.END_ELEMENT) {
                String endElement = xmlEvent.asEndElement().getName().getLocalPart();
                if (endElement.equalsIgnoreCase(EMPLOYEE_ATTRIBUTE)) {
                    employees.add(e);
                    System.out.println(name);
                    System.out.println(salary);
                    System.out.println(city);
                    System.out.println(country);
                    System.out.println("--------------------------------------");
                }
            }
        }


    }

    @Override
    public List<Employee> getDetails() {
        return employees;
    }

    private String getXmlData(XMLEventReader xmlEventReader) throws XMLStreamException {
        return xmlEventReader.nextEvent().asCharacters().getData();
    }
}
