package com.app.parser.sax;

import com.app.parser.XmlParser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import static com.app.constant.AppConstant.XML_FILE_NAME;

public class SaxParser implements XmlParser {

    @Override
    public void parseXml(String fileName) throws Exception {
        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
        saxParser.parse(this.getClass().getClassLoader().getResourceAsStream(XML_FILE_NAME), new EmployeeDefaultParser());
    }
}

