import connection.PostgresConnectionSingleton;
import model.*;
import exceptions.*;
import repositories.ImplementationCRUD;
import repositories.StudentRepository;
import repositories.TeacherRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void print(Model m) {
        System.out.println(m);
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        StudentRepository studentRepository = new StudentRepository();
        TeacherRepository teacherRepository = new TeacherRepository();
//        try {
//            Model s = new Student(User.getCurrentId(), "b", "z", "Zhn@gmail.com", "1Qw_2xvIosf*", "2207");
//            System.out.println(s);
//            System.out.println("+++++++++++++++++++++++++++");
//            print(s);
//            studentRepository.create(ImplementationCRUD.STUDENT, s);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
        try {
            Teacher t = new Teacher(User.getCurrentId(), "b", "z", "Zhn@gmail.com", "1Qw_2xvIosf*", Teacher.PhD);
//            Teacher t = new Teacher(User.getCurrentId(), "b", "z", "Zhn@gmail.com", "1Qw_2xvIosf*", Teacher.PhD);
            System.out.println(t);
//            teacherRepository.create(1, t);
//            teacherRepository.create(ImplementationCRUD.TEACHER, t);
            List<Model> tl = teacherRepository.getAll(ImplementationCRUD.TEACHER);
            System.out.println(tl);
        } catch (Exception e) {
            System.out.println(e);
        }
//        try {
//            Subject s1 = new Subject(Subject.getCurrentId(), "Calculus1", "cnsjkdcnkjsd", 5);
//            System.out.println(s1);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        try {
//            System.out.println(Subject.getCurrentId());
//            StudentSubject s = new StudentSubject(StudentSubject.getCurrentId(), 0, 0, 0, 90, 100);
//            System.out.println(s);
//        } catch (Exception e) {
//            System.out.println(e+" student subject");
//        }
//        try {
//            TeacherSubject t = new TeacherSubject(TeacherSubject.getCurrentId(), 0, 0);
//            System.out.println(t);
//        } catch (Exception e) {
//            System.out.println(e+" student subject");
//        }
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