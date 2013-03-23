package first;

import java.util.Scanner;

public class consoleInput {
    public String[] getUserInput() {
        String name, surname, age, choice;
        Scanner reader = new Scanner(System.in);
        choice = "n";
        //while (choice != "y") {
            System.out.println("Enter name");
            name=reader.next();
            System.out.println("Enter surname");
            surname=reader.next();
            System.out.println("Enter age");
            age=reader.next();
        //    System.out.println("Is this data correct? [y/N]");
        //    choice=reader.next();
        //} //while
        String[] tab={name, surname, age};
        return tab;
    }
    
}
