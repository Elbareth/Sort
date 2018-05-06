/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author izab
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */    
    
    public static void main(String[] args){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try{
            br = new BufferedReader(new FileReader("/home/izab/NetBeansProjects/plik.txt"));
            bw = new BufferedWriter(new FileWriter("/home/izab/NetBeansProjects/plik2.txt"));
            int i;             
            List <Character> tak = new ArrayList<Character>();
            List<String> gotowe = new ArrayList<String>();
            while((i=br.read())!=-1){
                if(i==32){                    
                    StringBuilder build = new StringBuilder(tak.size());
                    for(Character ch : tak){                        
                        build.append(ch);
                    }                    
                    gotowe.add(build.toString());
                    tak.clear();
                }
                tak.add((char)i);                
            }            
            Collections.sort(gotowe);           
            for(String s : gotowe){
                for(int k=0;k<s.length();k++){
                    Character a =s.charAt(k);
                    int b = a.charValue();
                    bw.write(b);
                    bw.flush();
                }
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        try{
            br.close();
            bw.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        
    }  
}
