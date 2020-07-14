/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien.jaxb;

import java.io.File;
import java.io.Serializable;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import tien.jaxb.obj.Materials;
//import tien.jaxb.obj.Attributes;
//import tien.jaxb.obj.Materials;

/**
 *
 * @author Admin
 */
public class JAXBUnmarshalling implements Serializable{
   public static Materials JAXBUnmarshalling(File validatedXML) throws JAXBException{
       JAXBContext context = JAXBContext.newInstance(Materials.class);
       Unmarshaller um = context.createUnmarshaller();
       Materials materials = (Materials)um.unmarshal(validatedXML);
       
       System.out.println("JAXBUnmarshalling successfully");
       return materials;
   }
}
