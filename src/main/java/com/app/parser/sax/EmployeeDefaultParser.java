package com.app.parser.sax;

import com.app.domain.Employee;
import lombok.Getter;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

import static com.app.constant.AppConstant.EMPLOYEE_ATTRIBUTE_NAME;

public class EmployeeDefaultParser extends DefaultHandler {
    @Getter
    private final List<Employee> employees = new ArrayList<>();
    private boolean name;
    private boolean salary;
    private boolean city;
    private boolean country;

    private Employee employee;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase(EMPLOYEE_ATTRIBUTE_NAME)) {
            employee = new Employee();
        } else if (qName.equalsIgnoreCase("name")) {
            name = true;
        } else if (qName.equalsIgnoreCase("salary")) {
            salary = true;
        } else if (qName.equalsIgnoreCase("city")) {
            city = true;
        } else if (qName.equalsIgnoreCase("country")) {
            country = true;
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String elementData = new String(ch, start, length);
        if (name) {

            employee.setName(elementData);
            name = false;
        } else if (salary) {
           employee.setSalary(elementData);
            salary = false;
        } else if (city) {
           employee.setCity(elementData);
            city = false;
        } else if (country) {
           employee.setCountry(elementData);
            country = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase(EMPLOYEE_ATTRIBUTE_NAME)) {
            employees.add(employee);
        }
    }

}
