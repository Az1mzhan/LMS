import repositories.StudentRepository;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        StudentRepository studentController =new StudentRepository();
        System.out.println(studentController.getAll());
//        studentController.create();
    }
}
