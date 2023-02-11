package repositories;

import data.PostgresDB;
import model.entities.Teacher;
import model.entities.UserRole;

import java.sql.*;
import java.util.*;

public class TeacherRepository implements CRUD{

    private static PostgresDB psql = new PostgresDB();
    private static Scanner sc = new Scanner(System.in);


    public ResultSet getCertain(String name) throws SQLException {
        Connection conn = psql.getConnection();
        String sql = "select * from teacher where name ='" + name + "'";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }

    public List<Object> getAll() throws SQLException {
        Connection conn = psql.getConnection();

        List<Teacher> list = new ArrayList<>();
        String sql = "select *  from teacher";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Teacher teacher = new Teacher(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    UserRole.TEACHER,
                    resultSet.getString("level"),
                    resultSet.getString("degree")
            );
            list.add(teacher);
        }

        resultSet.close();
        statement.close();
        conn.close();

        return Collections.singletonList(list);
    }


    public void create() throws ClassNotFoundException, SQLException {

        Connection conn = psql.getConnection();

        System.out.println("Enter a name: ");
        String name = sc.next();
        System.out.println("Enter a surname: ");
        String surname = sc.next();
        System.out.println("Enter an email: ");
        String email = sc.next();
        System.out.println("Enter a password: ");
        String password = sc.next();
        System.out.println("Enter a level: ");
        String level = sc.next();
        System.out.println("Enter a degree: ");
        String degree = sc.next();

        String sql = "insert into teacher (name, surname, email, password, level, degree) values (?,?,?,?, ?, ?)";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, surname);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, password);
        preparedStatement.setString(5, level);
        preparedStatement.setString(6, degree);

        preparedStatement.execute();
        preparedStatement.close();
        conn.close();
        System.out.println("Teacher have been added.");

    }

    public void update() throws SQLException {

        Connection conn = psql.getConnection();
        System.out.println("Enter an id of teacher to update: ");
        int id = sc.nextInt();
        String sql = "select * from teacher where id='" + id + "'";

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        if (!resultSet.next()) {
            System.out.println("Teacher does not found.");
            return;
        }

        System.out.println(resultSet.getString("name") + " " + resultSet.getString("surname"));
        System.out.println("Email: " + resultSet.getString("email"));
        System.out.println("Level: " + resultSet.getString("level"));
        System.out.println("Degree: " + resultSet.getString("degree"));

        boolean running = true;
        while (running) {
            System.out.println("Choose a field you want to change: ");
            System.out.println("1. name");
            System.out.println("2. surname");
            System.out.println("3. email");
            System.out.println("4. password");
            System.out.println("5. level");
            System.out.println("6. degree");
            System.out.println("0. quit");
            int choose = sc.nextInt();
            if (choose == 0)
                return;
            updateTeacher(deCode(choose), id);

        }
    }


    private static String deCode(int n) {
        String[] arr = new String[]{"name", "surname", "email", "password", "level", "degree"};
        return arr[n - 1];
    }

    private static void updateTeacher(String set, int teacherId) throws SQLException {
        System.out.println("Enter new value: ");
        String updatedValue = sc.next();
        String sql = "update teacher set " + set + " =? where id = " + teacherId;
        Connection connection = psql.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, updatedValue);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    public void delete() throws SQLException {
        Connection connection= psql.getConnection();
        Statement statement = connection.createStatement();

        System.out.println("Enter teacher id to delete: ");
        int id= sc.nextInt();
        String sql = "SELECT * FROM teacher WHERE id="+id;

        ResultSet resultSet = statement.executeQuery(sql);

        if (!resultSet.next()) {
            System.out.println("Teacher does not found. Please, make sure that you have entered correctly.");
            resultSet=null;
            System.out.println("Do you want to try again? Y/n");
            String answer = sc.next();
            if (answer.equals("Y") || answer.equals("y"))
                delete();
            else
                return;
        }

        System.out.println(resultSet.getString("name")+" "+resultSet.getString("surname"));
        System.out.println("Email: "+resultSet.getString("email"));
        System.out.println("Level: "+resultSet.getString("level"));
        System.out.println("Degree: "+resultSet.getString("degree"));

        System.out.println("Confirm your choice by entering 1");

        String answer = sc.next();
        if (!answer.equals("1")) {
            System.out.println("Delete cancelled");
            return;
        }

        Statement deleteStatement = connection.createStatement();
        String sqlDelete="DELETE FROM teacher WHERE id = "+resultSet.getInt("id");
        deleteStatement.executeUpdate(sqlDelete);

        System.out.println("Teacher has been deleted.");

        resultSet.close();
        statement.close();
        deleteStatement.close();
        connection.close();
    }
}
