package com.app.parser.dom;

import com.app.domain.Employee;
import com.app.parser.XmlParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.util.ArrayList;
import java.util.List;

import static com.app.constant.AppConstant.EMPLOYEE_ATTRIBUTE_NAME;

public class DOMParser implements XmlParser {
    private final List<Employee> employees = new ArrayList<>();

    @Override
    public void parseXml(String fileName) throws Exception {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document parse = documentBuilder.parse(this.getClass().getClassLoader().getResourceAsStream(fileName));
        parse.getDocumentElement().normalize();
        Element root = parse.getDocumentElement();
        NodeList elementsByTagName = root.getElementsByTagName(EMPLOYEE_ATTRIBUTE_NAME);
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            Node item = elementsByTagName.item(i);
            if (item.getNodeType() == Node.ELEMENT_NODE) {
                Employee employee = new Employee();
                Element element = (Element) item;

                employee.setName(element.getElementsByTagName("name").item(0).getTextContent());
                employee.setSalary(element.getElementsByTagName("salary").item(0).getTextContent());
                NodeList addressNodeList = element.getElementsByTagName("address");
                for (int j = 0; j < addressNodeList.getLength(); j++) {
                    Node addressNode = addressNodeList.item(j);
                    Element addressElement = (Element) addressNode;
                    employee.setCity(addressElement.getElementsByTagName("city").item(0).getTextContent());
                    employee.setCountry(addressElement.getElementsByTagName("country").item(0).getTextContent());

                }
                employees.add(employee);
            }
        }
    }

    @Override
    public List<Employee> getDetails() {
        return employees;
    }
}
