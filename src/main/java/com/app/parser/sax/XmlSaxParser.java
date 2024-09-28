package com.app.parser.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import static com.app.constant.AppConstant.XML_FILE_NAME;

public class XmlSaxParser {
    public static void main(String[] args) throws Exception {
        new XmlSaxParser().processFile();
    }

    public void processFile()throws Exception{
        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
        saxParser.parse(this.getClass().getClassLoader().getResourceAsStream(XML_FILE_NAME), new EmployeeDefaultParser());
    }
}

