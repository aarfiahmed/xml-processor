package com.app.parser;

import com.app.domain.Employee;
import com.app.parser.stax.StaxParser;

import java.util.List;

import static com.app.constant.AppConstant.XML_FILE_NAME;

public class XmlFileParser {
    public static void main(String[] args) throws Exception {
        System.out.println(new XmlFileParser().getDataFromXML(new StaxParser()));
    }

    public List<Employee> getDataFromXML(XmlParser parser) throws Exception {
        parser.parseXml(XML_FILE_NAME);
        return (parser.getDetails());
    }
}
