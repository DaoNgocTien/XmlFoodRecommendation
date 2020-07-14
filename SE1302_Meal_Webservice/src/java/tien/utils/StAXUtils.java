/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author Admin
 */
public class StAXUtils implements Serializable{
    public static XMLStreamReader getStAXStreamReader(File xmlFile) throws FileNotFoundException, XMLStreamException{
        InputStream is = new FileInputStream(xmlFile);
        XMLInputFactory xif = XMLInputFactory.newFactory();
        XMLStreamReader reader = xif.createXMLStreamReader(is);
        return reader;
    }
}
