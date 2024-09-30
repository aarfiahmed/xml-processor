package com.app.xml;

import com.app.domain.Employee;
import com.app.xml.parser.XmlParser;
import com.app.xml.parser.stax.StaxParser;

import java.util.List;

import static com.app.constant.AppConstant.XML_FILE_NAME;

public class XmlFileProcessor {
    public static void main(String[] args) throws Exception {
        System.out.println(new XmlFileProcessor().getDataFromXML(new StaxParser()));
    }

    public List<Employee> getDataFromXML(XmlParser parser) throws Exception {
        parser.parseXml(XML_FILE_NAME);
        return (parser.getDetails());
    }
}
