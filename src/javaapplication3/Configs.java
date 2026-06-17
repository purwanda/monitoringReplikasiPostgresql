/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;
/**
 *
 * @author Wanda
 */
public class Configs {
    public static Properties prop = new Properties();
    public void SaveProp(String title,String value){        
        try {
            prop.setProperty(title, value);
            prop.store(new FileOutputStream("config.ini"), null);
            value = prop.getProperty(title);
        } catch (IOException e){
            
        }
    }
    public String GetProp(String title){
        String value = "";
        try {
            prop.load(new FileInputStream("config.ini"));
            value = prop.getProperty(title);
        } catch (IOException e){
            
        }
        return value;
    }
    public void UpdateProp(String title, String newvalue){
        try {
            prop.load(new FileInputStream("config.ini"));
            prop.setProperty(title, newvalue);
            prop.store(new FileOutputStream("config.ini"), "sorted props");
        } catch (IOException e){
            
        }        
    }

    public String enctext(String inputtext){
        String text="";
        char[] chars = inputtext.toCharArray();
        for(char c : chars){
            c+=1;
            text=text+c;
        }
        return text;
    }    
    
    public String dectext(String inputtext){
        String text="";
        char[] chars = inputtext.toCharArray();
        for(char c : chars){
            c-=1;
            text=text+c;
        }
        return text;
    }

    public static void replaceLines(String lama, String baru) {
    try {
        // input the (modified) file content to the StringBuffer "input"
        BufferedReader file = new BufferedReader(new FileReader("config.ini"));
        StringBuffer inputBuffer = new StringBuffer();
        String line;

        while ((line = file.readLine()) != null) {
            if (line.equals(lama)) line=baru;
//            line = "tes1";
            inputBuffer.append(line);
            inputBuffer.append('\n');
        }
        file.close();

        // write the new string with the replaced line OVER the same file
        FileOutputStream fileOut = new FileOutputStream("config.ini");
        fileOut.write(inputBuffer.toString().getBytes());
        fileOut.close();

    } catch (Exception e) {
        System.out.println("Problem reading file.");
    }
}    
    
}
