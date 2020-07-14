/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author Admin
 */
public class XMLIntoValidatedXML implements Serializable{
    public static void transformXMLIntoValidatedXML(String xslPath, File outputXML, String content) throws TransformerConfigurationException, TransformerException{
        StreamSource ss = new StreamSource(xslPath);
        Source src = new StreamSource(new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)));
        
        TransformerFactory tff = TransformerFactory.newInstance();
        Transformer tf = tff.newTransformer(ss);
        
        tf.transform(src, new StreamResult(outputXML));
        
        System.out.println("transformXMLIntoValidatedXML successfully");
    }
}
