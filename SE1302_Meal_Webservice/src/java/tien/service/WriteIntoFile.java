/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class WriteIntoFile implements Serializable{
    public static void writeIntoFile(File output, String content) throws IOException{
        try(FileWriter fw = new FileWriter(output) ){
            fw.write(content);
        }
        System.out.println("writeIntoFile successfully");
    }
}
