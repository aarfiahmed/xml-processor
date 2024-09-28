package com.app.parser.sax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import static com.app.constant.AppConstant.EMPLOYEE_ATTRIBUTE_NAME;

public class EmployeeDefaultParser extends DefaultHandler {
    private boolean  name;
    private boolean salary;
    private boolean city;
    private boolean country;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)  {
        if(qName.equalsIgnoreCase(EMPLOYEE_ATTRIBUTE_NAME)){
            System.out.println("Employee Details");
        } else if (qName.equalsIgnoreCase("name")) {
            name=true;
        }
        else if (qName.equalsIgnoreCase("salary")) {
            salary=true;
        }
        else if (qName.equalsIgnoreCase("city")) {
            city=true;
        }
        else if (qName.equalsIgnoreCase("country")) {
            country=true;
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String elementData = new String(ch, start, length);
        if(name){
            System.out.println("Name " +elementData);
            name=false;
        }
        else if(salary){
            System.out.println("Salary " +elementData);
            salary=false;
        }
        else if(city){
            System.out.println("City " +elementData);
            city=false;
        }
        else if(country){
            System.out.println("Country " +elementData);
            country=false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)  {
        if(qName.equalsIgnoreCase(EMPLOYEE_ATTRIBUTE_NAME)){
            System.out.println("---------------------------------------");
        }
    }
}
