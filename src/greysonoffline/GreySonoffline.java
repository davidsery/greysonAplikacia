/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greysonoffline;


import java.io.IOException;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author David
 */
public class GreySonoffline {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException  {
        UserObject user = new UserObject(); //classa pouzivatela obsahuje meno, id, pocet pokusov ktore potreboval
        Map<String, String> messages = ReadFile.readMessages("messages.txt"); //Hashmapa sprav ktore sa vypisuju
        
        do{ //ziadanie pouzivatela o zvolenie si username kym nezada meno vo validnom formate
            System.out.print(messages.get("Username") + " ");
            user.setName(InputCheck.input());
        }while(InputCheck.loginCheck(user.getName(), messages) != 1);
        
        int target = ReadFile.getTarget("config.txt"); //volanie funkcie ktora generuje nahodne cislo a ulozime ho do premennej target
        
        int tmp; //pouziva sa na zistenie ci uz pouzivatel uhadol spravne cilo. Ak ano nastavi sa na 1 a while podmienka skonci
        int tries = 0; //pocitadlo poctu pokusov ktore pouzivatel potreboval na uhadnutie hladaneho cisla
        do{ //ziadanie pouzivatela o uhadnutie cisla ktore hladame, kontroluje sa tu ci zadal cislo inak vypise chybu
            System.out.print(messages.get("Guess") + " ");
            String guess = InputCheck.input();
            tmp = InputCheck.guessCheck(guess, messages, target);
            tries++;
            user.setScore(tries);
        }while(tmp != 1);
        if(tmp == 1){
            System.out.println(messages.get("Correct"));
        }
        
        System.out.println(messages.get("Score") + " " + tries);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GreySonofflinePU"); //pouzitie entity managera na ukladanie vysledkov pouzivatelov do databazy
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();        
    }
}
