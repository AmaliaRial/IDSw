package idsw.db.xml;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import idsw.db.pojos.Medical_Record;

public class CreateFullXML {
	
	/**
	 * This method creates a new XML file with the DTD content and the XML content so it can later be turned into an HTML file. 
	 */
	public static void createFULLxml() {
		// Paths to the existing files
        Path dtdPath = Paths.get("./xmls/MedicalRecord.dtd");
        Path xmlPath = Paths.get("./xmls/MedicalRecord.xml");

        // Path to the new file
        Path newPath = Paths.get("./xmls/External_MedicalRecord.xml");

        try {
            // Read the contents of the DTD file
            String dtdContent = Files.readString(dtdPath);

            // Read the contents of the XML file
            String xmlContent = Files.readString(xmlPath);
            
            // Remove the XML declaration from the XML content
            xmlContent = xmlContent.replaceFirst("<\\?xml(.+?)\\?>", "").trim();

            // Combine the contents
            String newContent = dtdContent + "\n" + xmlContent;

            // Write the combined contents to the new file
            Files.writeString(newPath, newContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
       
	}
	
	public static void main(String[] args) {
		createFULLxml();
	}

}
