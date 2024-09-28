package com.app.parser.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import static com.app.constant.AppConstant.EMPLOYEE_ATTRIBUTE_NAME;
import static com.app.constant.AppConstant.XML_FILE_NAME;

public class DOMParser {

    public static void main(String[] args) throws Exception {

        new DOMParser().processData(XML_FILE_NAME);
    }


    private  void processData(String fileName) throws Exception {
       DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document parse = documentBuilder.parse(this.getClass().getClassLoader().getResourceAsStream(fileName));
        parse.getDocumentElement().normalize();
        Element root = parse.getDocumentElement();
        NodeList elementsByTagName = root.getElementsByTagName(EMPLOYEE_ATTRIBUTE_NAME);
        for (int i=0;i< elementsByTagName.getLength();i++){
            Node item = elementsByTagName.item(i);
            if(item.getNodeType()==Node.ELEMENT_NODE){
                Element element = (Element) item;
                System.out.println(element.getTagName());
                System.out.println(element.getElementsByTagName("name").item(0).getTextContent());
                System.out.println(element.getElementsByTagName("salary").item(0).getTextContent());
                NodeList addressNodeList = element.getElementsByTagName("address");
                for(int j=0;j<  addressNodeList.getLength();j++){
                    Node addressNode = addressNodeList.item(j);
                    Element addressElement = (Element) addressNode;
                    System.out.println(addressElement.getElementsByTagName("city").item(0).getTextContent());
                    System.out.println(addressElement.getElementsByTagName("country").item(0).getTextContent());

                }
            }
        }
    }
}
