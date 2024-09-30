package com.app.xml.parser.sax;

import com.app.domain.Employee;
import com.app.xml.parser.XmlParser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.List;

import static com.app.constant.AppConstant.XML_FILE_NAME;

public class SaxParser implements XmlParser {
    private final EmployeeDefaultParser employeeDefaultParser = new EmployeeDefaultParser();
    @Override
    public void parseXml(String fileName) throws Exception {
        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();

        saxParser.parse(this.getClass().getClassLoader().getResourceAsStream(XML_FILE_NAME), employeeDefaultParser);
    }

    @Override
    public List<Employee> getDetails() {
        return employeeDefaultParser.getEmployees();
    }
}

