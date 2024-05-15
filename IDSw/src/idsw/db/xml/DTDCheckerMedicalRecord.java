package idsw.db.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import idsw.db.xml.utils.CustomErrorHandler;

public class DTDCheckerMedicalRecord {

    public static void main(String[] args) {
        File xmlFile = new File("./xmls/External-Report.xml"); 
        try {
        	// Create a DocumentBuilderFactory
            DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
            // Set it up so it validates XML documents
            dBF.setValidating(true);
            // Create a DocumentBuilder and an ErrorHandler (to check validity)
            DocumentBuilder builder = dBF.newDocumentBuilder();
            CustomErrorHandler customErrorHandler = new CustomErrorHandler();
            builder.setErrorHandler(customErrorHandler);
            // Parse the XML file and print out the result
            Document doc = builder.parse(xmlFile);
            if (customErrorHandler.isValid()) {
                System.out.println(xmlFile + " was valid!");
            }
        } catch (ParserConfigurationException ex) {
            System.out.println(xmlFile + " error while parsing!");
        } catch (SAXException ex) {
            System.out.println(xmlFile + " was not well-formed!"); //proper nesting, only one root element, no 2 attribute with the same name in an element
        } catch (IOException ex) {
            System.out.println(xmlFile + " was not accesible!");
        }

    }
}
