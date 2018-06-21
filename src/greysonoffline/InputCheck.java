/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greysonoffline;

import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class InputCheck { //classa definuje funkcie ktore pracuju s vstupom od pouzivatela
    public static int loginCheck(String username, Map<String, String> messages){ //funkcia prijma meno zadane pouzivatelom v premennej username a kontroluje ci obsahuje len pismena. Ak ano vrati 1 inak napise chybu a vrati 0
        if(username.matches("[a-zA-Z]+")){
            return 1;
        }
        else{
            System.out.println(messages.get("Wrong username"));
            return 0; 
        }
    }
    public static String input(){ //funkcia na ziskanie vstupu od pouzivatela
        Scanner reader = new Scanner(System.in);
        String input = reader.next();
        
        return input;
    }
    public static int guessCheck(String guess, Map<String, String> messages, int target){ //funckia prijme string a skontroluje ci obsahuje len cisla (kladne alebo zaporne)
        if(guess.matches("-?[0-9]+")){
            int guessNumber = Integer.valueOf(guess); //ulozime si prijaty string ako integer aby sme ho vedeli porovnavat s hladanym cislom
            if(guessNumber < target){
                System.out.println(messages.get("Too low"));
                return 0;
            }
            else if(guessNumber > target){
                System.out.println(messages.get("Too high"));
                return 0;
            }
            else{
                return 1;
            }    
        }
        else System.out.println(messages.get("Not number1") + " '" + guess + "' " + messages.get("Not number2"));
        return 0; //ak to nie je cislo tak sa vypise chyba a vrati 0
    }
}
