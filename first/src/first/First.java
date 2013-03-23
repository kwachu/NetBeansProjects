/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package first;

import first.MySQLAccess;
import first.consoleInput;


public class First {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        MySQLAccess dao = new MySQLAccess();
        consoleInput readme = new consoleInput();
       // dao.writeDataBase();
        dao.readDataBase();
        
        dao.writeDataBase(readme.getUserInput());
        dao.readDataBase();
    }
}
