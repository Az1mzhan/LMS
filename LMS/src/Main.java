import model.*;
import exceptions.*;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        System.out.println(User.getCurrentId());
        try {
            Student s = new Student(User.getCurrentId(), "b", "z", "Zhn@gmail.com", "1Qw_2xvIosf*", "2207");
            System.out.println(s);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Student s = new Student(0, "b", "z", "Zhn@gmail.com", "1Qw_2xvIosf*", "2207");
            System.out.println(s);
        } catch (Exception e) {
            System.out.println(e);
        }
//        Scanner sc = new Scanner(System.in);
//        boolean isSession = true;
//        while (isSession) {
//            System.out.println("Choose the operation:");
//            System.out.println("1 - CREATE, 2 - READ, 3 - UPDATE, 4 - DELETE, q - QUIT");
//            String key = sc.next();
//            switch (key) {
//                case "1":
//                    System.out.println("What are you going to create?\n");
//                    break;
//                case "2":
//                    System.out.println("DB\n");
//                    break;
//                case "3":
//                    System.out.println("Pick which entity you're going to update\n");
//                    break;
//                case "4":
//                    System.out.println("Pick which entity you're going to delete\n");
//                    break;
//                case "q":
//                    System.out.println("Terminating the application...");
//                    sc.close();
//                    isSession = false;
//                    break;
//            }
//        }
    }
}