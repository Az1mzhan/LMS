package repositories;
import exceptions.*;
import model.Model;

import java.sql.SQLException;
import java.util.*;

public interface CRUD {
    void create (String tableName, Model model) throws ClassNotFoundException, SQLException, IllegalAccessException;
    List<Model> getAll(String tableName) throws SQLException, PasswordException, NameException, GroupNameException, EmailException, SubjectException, SurnameException, IdException, TeacherIdException, DegreeException, AttendanceException, StudentIdException, GradeException, SyllabusException, CreditNumberException, SubjectIdException;

    Model getById(String tableName, int id) throws SQLException, TeacherIdException, StudentIdException, GradeException, GroupNameException, SubjectException, CreditNumberException, PasswordException, DegreeException, AttendanceException, NameException, EmailException, SyllabusException, SurnameException, SubjectIdException, IdException;
//
//    void update (TableNames tableName, int id) throws SQLException;
//    void delete(TableNames tableName, int id) throws SQLException ;
}