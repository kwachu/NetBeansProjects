/*
 * test :)
 */
package menutester;

import java.util.Scanner;
import java.io.IOException;
/**
 *
 * @author kwachu
 */
public class MenuTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int choice =1;
        Scanner reader = new Scanner(System.in);
        //IOException ioe;
        
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
                    + "2. Dodaj wpis do bazy\n"
                    + "3. unter Konstrukzionierung\n");
            choice = Integer.parseInt(reader.next());
            
            switch(choice) {
                case 1: {
                    System.out.println("Wybrano 1");
                    break;
                }
                case 2: {
                    System.out.println("Wybrano 2");
                    break;
                }
                default: {
                    System.out.println("Wybrano nieobslugiwana opcje");
                }    

        
        }
    }

    }
}