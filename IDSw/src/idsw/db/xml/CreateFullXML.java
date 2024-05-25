package idsw.db.xml;

import java.io.IOException;
import java.nio.file.*;

public class CreateFullXML {
	
	/**
	 * This method creates a new XML file with the DTD content and the XML content so it can later be turned into an HTML file. 
	 */
	public static void createFULLxml() {
		// Paths to the existing files
        Path dtdPath = Paths.get("./xmls/MedicalRecord.dtd");
        Path xmlPath = Paths.get("./xmls/MedicalRecord.xml"); //file just created by Java2XmlMedicalRecord.java

        // Path to the new file
        Path newPath = Paths.get("./xmls/External_MedicalRecord.xml");

        try {
            // Read the contents of the DTD file
            String dtdContent = Files.readString(dtdPath);

            // Read the contents of the XML file
            String xmlContent = Files.readString(xmlPath);
            
            // Remove the XML declaration from the XML content because it will be added later
            // The XML declaration was removed because the new file will have the DTD declaration and the XML declaration and it will give an error if it has two XML declarations
            // Therefore the XML declaration was removed (since it appears after the DTD in the new file)
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
