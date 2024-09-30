package com.app.xml.parser;

import com.app.domain.Employee;

import java.util.List;

public interface XmlParser {

    void parseXml(String fileName) throws Exception;
    List<Employee> getDetails();
}
