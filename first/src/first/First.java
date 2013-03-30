/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package first;

import first.MySQLAccess;
import first.consoleInput;
import java.util.Scanner;
import java.io.IOException;

public class First {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception, IOException {
        MySQLAccess dao = new MySQLAccess();
        consoleInput readme = new consoleInput();
       // dao.writeDataBase();
        //dao.readDataBase();
        
                int choice =1;
        Scanner reader = new Scanner(System.in);
        
        
        //MENU BEGIN
         while(choice != 0)  {
            try { 
                Runtime.getRuntime().exec("echo duap");
            } 
            catch (IOException ioe) {
                System.err.print(ioe);
            }
                
            System.out.print("***********MENU*************\n"
                    + "Wybierz opcje:\n"
                    + "1. Pokaz baze\n"
                    + "2. Dodaj czlowieka do bazy\n"
                    + "3. unter Konstrukzionierung\n");
            choice = Integer.parseInt(reader.next());
            
            switch(choice) {
                case 1: {
                    //System.out.println("Wybrano 1");
                     dao.readDataBase();
                    break;
                }
                case 2: {
                    //System.out.println("Wybrano 2");
                    dao.addDBuser(readme.getUserInput());
                    break;
                }
                default: {
                    System.out.println("Wybrano nieobslugiwana opcje");
                }    

        
             }
        }
        //MENU END
       
        //dao.writeDataBase(readme.getUserInput());
        //dao.readDataBase();
    }
}
