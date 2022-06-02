/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Project ID: 32
 */
public class Faq {
    
    //reads the FAQ file
    public void printFaq(){

        BufferedReader br = null;
        try {
            // Initialize the BufferedReader, which is used to read contents from FAQ.txt.
            br = new BufferedReader(new FileReader("./resources/FAQ.txt"));
            String faq = null;
            while((faq = br.readLine()) != null){
                System.out.println(faq);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Faq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Faq.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Faq.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    
    
    
}
