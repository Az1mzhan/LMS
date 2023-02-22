package repositories;

import connection.PostgresConnectionSingleton;
import exceptions.*;
import model.*;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class ImplementationCRUD implements CRUD{
    private final PostgresConnectionSingleton psql = PostgresConnectionSingleton.getInstance();

    protected ImplementationCRUD() throws SQLException, ClassNotFoundException {
    }

    public static String getFields(String tableName) throws IllegalAccessException {
        switch (tableName) {
            case STUDENT:
                return ("(id, name, surname, email, password, group_name, created, updated)"
                        + "values (?, ?, ?, ?, ?, ?, ?, ?)");
            case TEACHER:
                return ("(id, name, surname, email, password, degree, created, updated)"
                        + "values (?, ?, ?, ?, ?, ?, ?, ?)");
            case SUBJECT:
                return ("(id, name, syllabus, creditNumber)"
                        + "values (?, ?, ?, ?)");
            case STUDENT_SUBJECT:
                return ("subject_id, student_id, teacher_id, grade, attendance"
                        + "values (?, ?, ?, ?, ?)");
            case TEACHER_SUBJECT:
                return ("subject_id, teacher_id"
                        + "values (?, ?)");
            default:
                throw new IllegalAccessException("No such table");
        }
    }

    private PreparedStatement getPreparedStatement(String sql, Model model) throws SQLException {
        System.out.println();
        PreparedStatement preparedStatement = psql.getConnection().prepareStatement(sql);
        if (model.getClass().equals(Student.class)) {//                ("(id, name, surname, email, password, groupName, created, updated)
            preparedStatement.setInt(1, model.getId());
            preparedStatement.setString(2, ((Student) model).getName());
            preparedStatement.setString(3, ((Student) model).getSurname());
            preparedStatement.setString(4, ((Student) model).getEmail());
            preparedStatement.setString(5, ((Student) model).getPassword());
            preparedStatement.setString(6, ((Student) model).getGroupName());
            preparedStatement.setString(7, ((Student) model).getCreated().toString());
            preparedStatement.setString(8, ((Student) model).getUpdated().toString());
        }
        else if (model.getClass().equals(Teacher.class)) {//                "(id, name, surname, email, password, degree, created, updated)"
            preparedStatement.setInt(1, model.getId());
            preparedStatement.setString(2, ((Teacher) model).getName());
            preparedStatement.setString(3, ((Teacher) model).getSurname());
            preparedStatement.setString(4, ((Teacher) model).getEmail());
            preparedStatement.setString(5, ((Teacher) model).getPassword());
            preparedStatement.setString(6, ((Teacher) model).getDegree());
            preparedStatement.setString(7, ((Teacher) model).getCreated().toString());
            preparedStatement.setString(8, ((Teacher) model).getUpdated().toString());
        }
        else if (model.getClass().equals(Subject.class)) {//                "(id, name, syllabus, creditNumber)
            preparedStatement.setInt(1, model.getId());
            preparedStatement.setString(2, ((Subject) model).getName());
            preparedStatement.setString(3, ((Subject) model).getSyllabus());
            preparedStatement.setInt(4, ((Subject) model).getCreditNumber());
            preparedStatement.setString(5, ((Subject) model).getCreated().toString());
            preparedStatement.setString(6, ((Subject) model).getUpdated().toString());
        }
        else if (model.getClass().equals(StudentSubject.class)){
            preparedStatement.setInt(1, model.getId());
            preparedStatement.setInt(2, ((StudentSubject) model).getStudentId());
            preparedStatement.setInt(3, ((StudentSubject) model).getTeacherId());
            preparedStatement.setDouble(3, ((StudentSubject) model).getGrade());
            preparedStatement.setDouble(4, ((StudentSubject) model).getAttendance());
            preparedStatement.setString(5, ((StudentSubject) model).getCreated().toString());
            preparedStatement.setString(6, ((StudentSubject) model).getUpdated().toString());
        }
        else if (model.getClass().equals(TeacherSubject.class)) {//                "subjectId, teacherId"
            preparedStatement.setInt(1, model.getId());
            preparedStatement.setInt(2, ((TeacherSubject) model).getSubjectId());
            preparedStatement.setInt(3, ((TeacherSubject) model).getTeacherId());
        }
        return preparedStatement;
    }

    public void create (String tableName, Model model) throws SQLException, IllegalAccessException {
        String sql = null;
        sql = "insert into " + tableName + " " + getFields(tableName);
        PreparedStatement preparedStatement =  getPreparedStatement(sql, model);
        preparedStatement.execute();
        preparedStatement.close();
        System.out.println("Student have been added.");
    }

    private Model buildModel(ResultSet resultSet, String tableNames) throws SQLException, PasswordException, NameException, GroupNameException, EmailException, SubjectException, SurnameException, IdException, DegreeException, SyllabusException, CreditNumberException, TeacherIdException, SubjectIdException, AttendanceException, StudentIdException, GradeException {
        switch (tableNames) {
            case STUDENT:
                return new Student(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getString("group_name"),
                    LocalDateTime.parse(resultSet.getString("created")),
                    LocalDateTime.parse(resultSet.getString("updated"))
                );
            case TEACHER:
                return new Teacher(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("degree"),
                        LocalDateTime.parse(resultSet.getString("created")),
                        LocalDateTime.parse(resultSet.getString("updated"))
                );
            case SUBJECT:
                return new Subject(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("syllabus"),
                        resultSet.getInt("creditnumber"),
                        LocalDateTime.parse(resultSet.getString("created")),
                        LocalDateTime.parse(resultSet.getString("updated"))
                );
            case TEACHER_SUBJECT:
                return new TeacherSubject(
                        resultSet.getInt("id"),
                        resultSet.getInt("subject_id"),
                        resultSet.getInt("teacher_id"),
                        LocalDateTime.parse(resultSet.getString("created")),
                        LocalDateTime.parse(resultSet.getString("updated"))
                );
            case STUDENT_SUBJECT:
                return new StudentSubject(
                        resultSet.getInt("id"),
                        resultSet.getInt("subject_id"),
                        resultSet.getInt("student_id"),
                        resultSet.getInt("teacher_id"),
                        resultSet.getDouble("grade"),
                        resultSet.getDouble("attendance"),
                        LocalDateTime.parse(resultSet.getString("created")),
                        LocalDateTime.parse(resultSet.getString("updated"))
                );
            default:
                throw new IllegalArgumentException("wrong table name");
        }
    }

    public  List<Model> getAll(String tableName) throws SQLException, PasswordException, NameException, GroupNameException, EmailException, SubjectException, SurnameException, IdException, TeacherIdException, DegreeException, AttendanceException, StudentIdException, GradeException, SyllabusException, CreditNumberException, SubjectIdException {
        String sql = "select *  from " + tableName;

        List<Model> list = new ArrayList<>();
        Connection conn = psql.getConnection();

        Statement statement= conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Model m = buildModel(resultSet, tableName);
            list.add(m);
        }

        resultSet.close();
        statement.close();

        return list;
    }

    public Model getById(String tableName, int id) throws SQLException, TeacherIdException, StudentIdException, GradeException, GroupNameException, SubjectException, CreditNumberException, PasswordException, DegreeException, AttendanceException, NameException, EmailException, SyllabusException, SurnameException, SubjectIdException, IdException {
        String sql = "select *  from " + tableName + " where id = "  + id;
        System.out.println(sql);
        Statement statement= psql.getConnection().createStatement();
        ResultSet resultSet= statement.executeQuery(sql);
        while (resultSet.next()) {
            Model m = buildModel(resultSet, tableName);
            resultSet.close();
            statement.close();
            return m;
        }
        resultSet.close();
        statement.close();
        return null;
    }

    public void update (String tableName, int id, List<String>fields, List<Object>values) throws SQLException, NoSuchElementException {
        Connection conn = psql.getConnection();
        String sql = "select * from "
                + tableName
                + " where id=" + id;

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        if (!resultSet.next()) {
            throw new NoSuchElementException("Can't update no such element");
        }
        sql = "update " + tableName + " set ";
        for(int i = 0; i < values.size(); i++) {
            sql += fields.get(i) + " = ?";
            if(i + 1 < values.size())
                sql += ", ";
        }
        sql += " where id = " + id;
        System.out.println(sql);
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).getClass().equals(String.class)) {
                preparedStatement.setString(i+1, (String) values.get(i));
            }
            else if (values.get(i).getClass().equals(Integer.class)) {
                preparedStatement.setInt(i+1, (Integer) values.get(i));
            }
        }
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void delete(String tableName, int id) throws SQLException, GroupNameException, SubjectException, CreditNumberException, PasswordException, DegreeException, AttendanceException, NameException, EmailException, SyllabusException, SurnameException, SubjectIdException, IdException, TeacherIdException, StudentIdException, GradeException {
        Model model = getById(tableName , id);
        if (model == null)
            throw new IdException("Invalid ");
        Statement statement = psql.getConnection().createStatement();
        statement.executeUpdate("delete from " + tableName + " where  id =" + id);
        statement.close();
    }
    public final static String STUDENT = "student";
    public final static String TEACHER = "teacher";
    public final static String SUBJECT = "subject";
    public final static String STUDENT_SUBJECT = "student subject";
    public final static String TEACHER_SUBJECT = "teacher subject";

}