package com.app.csv;

import com.app.constant.AppConstant;
import com.app.domain.Employee;
import com.app.xml.XmlFileProcessor;
import com.app.xml.parser.sax.SaxParser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static com.app.constant.AppConstant.*;

public class CSVFileProcessor {
    public static void main(String[] args) throws Exception {
        new CSVFileProcessor().addEmployee(new XmlFileProcessor().getDataFromXML(new SaxParser()));
    }

    public void addEmployee(List<Employee> employees) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Paths.get(AppConstant.CSV_FILE_NAME).getFileName().toFile()))) {
            addHeading(writer);
            System.out.println("Adding total employee into CSV file "+employees.size());
            for (Employee e : employees) {
                writer.write(e.convertInCSVFormat());
                writer.newLine();
            }

        } catch (Exception ex) {
            System.out.println("Exception occurred while writing to file " + ex.getMessage());
        }
        System.out.println("CSV File Processing Completed");
    }

    private void addHeading(BufferedWriter writer) throws IOException {
        writer.write(EMPLOYEE_ATTRIBUTE_NAME+" , ");
        writer.write(EMPLOYEE_ATTRIBUTE_SALARY+" ,");
        writer.write(EMPLOYEE_ATTRIBUTE_CITY+" , ");
        writer.write(EMPLOYEE_ATTRIBUTE_COUNTRY);
        writer.newLine();
    }
}
