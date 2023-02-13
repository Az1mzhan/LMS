import model.*;
import exceptions.*;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isSession = true;
        while (isSession) {
            System.out.println("Choose the operation:");
            System.out.println("1 - CREATE, 2 - READ, 3 - UPDATE, 4 - DELETE, q - QUIT");
            String key = sc.next();
            switch (key) {
                case "1":
                    System.out.println("What are you going to create?\n");
                    break;
                case "2":
                    System.out.println("DB\n");
                    break;
                case "3":
                    System.out.println("Pick which entity you're going to update\n");
                    break;
                case "4":
                    System.out.println("Pick which entity you're going to delete\n");
                    break;
                case "q":
                    System.out.println("Terminating the application...");
                    sc.close();
                    isSession = false;
                    break;
            }
        }
    }
}