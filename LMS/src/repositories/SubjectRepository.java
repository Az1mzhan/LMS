package repositories;

import data.PostgresDB;
import model.entities.Subject;

import java.sql.*;
import java.util.*;

public class SubjectRepository implements CRUD {

    private static PostgresDB psql = new PostgresDB();
    private static Scanner sc = new Scanner(System.in);


    public ResultSet getCertain(String name) throws SQLException {
        Connection conn = psql.getConnection();
        String sql = "select * from subject where name ='" + name + "'";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }

    public List<Object> getAll() throws SQLException {
        Connection conn = psql.getConnection();

        List<Subject> list = new ArrayList<>();
        String sql = "select *  from subject";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Subject student = new Subject(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("syllabus"),
                    resultSet.getInt("credit_number")
            );
            list.add(student);
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
        System.out.println("Enter a syllabus: ");
        String syllabus = sc.next();
        System.out.println("Enter a credit number: ");
        int creditNumber = sc.nextInt();

        String sql = "insert into subject (name, syllabys, credit_number) values ( ?,?,?)";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, syllabus);
        preparedStatement.setInt(3, creditNumber);

        preparedStatement.execute();
        preparedStatement.close();
        conn.close();
        System.out.println("Subject have been added.");

    }

    public void update () throws SQLException {

        Connection conn = psql.getConnection();
        System.out.println("Enter an id of subject to update: ");
        int id = sc.nextInt();
        String sql = "select * from subject where id='"+id+"'";

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        if (!resultSet.next()) {
            System.out.println("Subject does not found.");
            return;
        }

        System.out.println(resultSet.getString("name"));
        System.out.println("Syllabus: "+resultSet.getString("syllabus"));
        System.out.println("Number of credits: "+resultSet.getInt("credit_number"));

        boolean running = true;
        while (running) {
            System.out.println("Choose a field you want to change: ");
            System.out.println("1. name");
            System.out.println("2. syllabus");
            System.out.println("3. credit number");
            System.out.println("0. quit");
            int choose = sc.nextInt();
            if (choose==0)
                return;
            updateSubject(deCode(choose), id);

        }
    }


    private static String deCode(int n){
        String [] arr = new String[] {"name", "syllabus", "credit_number"};
        return arr[n-1];
    }

    private static void updateSubject(String set, int subjectId) throws SQLException {
        System.out.println("Enter new value: ");
        String updatedValue = null;
        int updatedValueInt = 0;
        if (set.equals("name") || set.equals("syllabus"))
        updatedValue = sc.next();
        else 
            updatedValueInt = sc.nextInt();
        String sql = "update subject set "  + set + " =? where id = " + subjectId;
        Connection connection = psql.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        if (set.equals("name") || set.equals("syllabus"))
        preparedStatement.setString(1,updatedValue);
        else
            preparedStatement.setInt(1,updatedValueInt);
            
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }


    public void delete() throws SQLException {
        Connection connection= psql.getConnection();
        Statement statement = connection.createStatement();

        System.out.println("Enter subject id to delete: ");
        int id= sc.nextInt();
        String sql = "SELECT * FROM subject WHERE id="+id;

        ResultSet resultSet = statement.executeQuery(sql);

        if (!resultSet.next()) {
            System.out.println("Subject does not found. Please, make sure that you have entered correctly.");
            resultSet=null;
            System.out.println("Do you want to try again? Y/n");
            String answer = sc.next();
            if (answer.equals("Y") || answer.equals("y"))
                delete();
            else
                return;
        }

        System.out.println(resultSet.getString("name"));
        System.out.println("Syllabus: "+resultSet.getString("syllabus"));
        System.out.println("Number of credits: "+resultSet.getString("credit_number"));

        System.out.println("Confirm your choice by entering 1");

        String answer = sc.next();
        if (!answer.equals("1")) {
            System.out.println("Delete cancelled");
            return;
        }

        Statement deleteStatement = connection.createStatement();
        String sqlDelete="DELETE FROM subject WHERE id = "+resultSet.getInt("id");
        deleteStatement.executeUpdate(sqlDelete);

        System.out.println("Subject has been deleted.");

        resultSet.close();
        statement.close();
        deleteStatement.close();
        connection.close();
    }

}
