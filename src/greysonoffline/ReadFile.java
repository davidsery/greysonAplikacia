/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greysonoffline;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/**
 *
 * @author David
 */
public class ReadFile { //classa definuje funckie ktore pracuju s textovym suboroom

    private static int target;
    private static Map<String, String> messages = new HashMap<String,String>();
    
    public static int getTarget(String fileName) throws FileNotFoundException, IOException{
        //tato funkcia cita subor config.txt a ziska z neho rozsah z ktoreho ma vygenerovat nahodne cislo a potom ho vygeneruje a vrati
        String line; 
    
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        while ((line = br.readLine()) != null) { //cita kym nie je koniec suboru
            String s[] = line.split("-"); //rozdeli riadok podla znaku "-"
            Random rn = new Random();
            target = rn.nextInt(Integer.valueOf(s[1]) - Integer.valueOf(s[0])) + Integer.valueOf(s[0]); //vygenerovanie nahodneho cisla ktore musi hrac uhadnut 
        }
        return target;
    }
    
    public static Map readMessages(String fileName) throws FileNotFoundException, IOException{ //funckia precita spravy z textoveho suboru a ulozi ich do mapy
        String line;
    
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        while ((line = br.readLine()) != null) {
            String s[] = line.split(";");
            messages.put(s[0].trim(), s[1].trim()); //ako kluc uklada kratku vetu/slovo ktore popisuje aka sprava sa vola
        }
        return messages;
    }

}
