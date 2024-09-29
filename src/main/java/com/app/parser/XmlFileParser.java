package com.app.parser;

import com.app.parser.stax.StaxParser;

import static com.app.constant.AppConstant.XML_FILE_NAME;

public class XmlFileParser {
    public static void main(String[] args) throws Exception {
        XmlParser parser= new StaxParser();
        parser.parseXml(XML_FILE_NAME);
    }
}
