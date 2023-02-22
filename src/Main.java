import connection.PostgresConnectionSingleton;
import model.*;
import exceptions.*;
import repositories.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void print(Model m) {
        System.out.println(m);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, CRUDMenuException, TeacherIdException, StudentIdException, GradeException, GroupNameException, SubjectException, CreditNumberException, PasswordException, DegreeException, AttendanceException, NameException, EmailException, SyllabusException, SurnameException, SubjectIdException, IdException, DatabaseRepositoryException, IllegalAccessException {
        StudentRepository studentRepository = new StudentRepository();
        TeacherRepository teacherRepository = new TeacherRepository();
        SubjectRepository subjectRepository = new SubjectRepository();
        StudentSubjectRepository studentSubjectRepository = new StudentSubjectRepository();
        TeacherSubjectRepository teacherSubjectRepository = new TeacherSubjectRepository();
////        try {
////            Model s = new Student(User.getCurrentId(), "b", "z", "Zhn@gmail.com", "1Qw_2xvIosf*", "2207");
////            System.out.println(s);
////            System.out.println("+++++++++++++++++++++++++++");
////            print(s);
////            studentRepository.create(ImplementationCRUD.STUDENT, s);
////        } catch (Exception e) {
////            System.out.println(e);
////        }
//        try {
//            Teacher t = new Teacher(User.getCurrentId(), "b", "z", "Zhn@gmail.com", "1Qw_2xvIosf*", Teacher.PhD);
////            Teacher t = new Teacher(User.getCurrentId(), "b", "z", "Zhn@gmail.com", "1Qw_2xvIosf*", Teacher.PhD);
//            System.out.println(t);
////            teacherRepository.create(1, t);
////            teacherRepository.create(ImplementationCRUD.TEACHER, t);
//            List<Model> tl = teacherRepository.getAll(ImplementationCRUD.TEACHER);
//            System.out.println(tl);
//            Teacher tt = (Teacher) teacherRepository.getById(ImplementationCRUD.TEACHER, 0);
//            System.out.println(tt);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
////        try {
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
        Scanner sc = new Scanner(System.in);
        boolean isSession = true;
        while (isSession) {
            System.out.println("Choose the operation:");
            System.out.println("1 - CREATE, 2.1 - READ ALL, 2.2 - READ BY ID, 3 - UPDATE, 4 - DELETE, q - QUIT");
            String key = sc.next();
            switch (key) {
                case "1" -> {
                    System.out.println("Choose the repository:");
                    System.out.println("1 - Student, 2 - Teacher, 3 - Subject, 4 - Student subject, 5 - Teacher subject");
                    String repositoryKey = sc.next();
                    switch (repositoryKey) {
                        case "1" -> {
                            System.out.println("Enter ID: ");
                            int id = sc.nextInt();
                            System.out.println("Enter a name: ");
                            String name = sc.next();
                            System.out.println("Enter a surname: ");
                            String surname = sc.next();
                            System.out.println("Enter an email: ");
                            String email = sc.next();
                            System.out.println("Enter a password: ");
                            String password = sc.next();
                            System.out.println("Enter a group name: ");
                            String groupName = sc.next();

                            Student student = new Student(id, name, surname, email, password, groupName);

                            studentRepository.create(ImplementationCRUD.STUDENT, student);
                        }
                        case "2" -> {
                            System.out.println("Enter ID: ");
                            int id = sc.nextInt();
                            System.out.println("Enter a name: ");
                            String name = sc.next();
                            System.out.println("Enter a surname: ");
                            String surname = sc.next();
                            System.out.println("Enter an email: ");
                            String email = sc.next();
                            System.out.println("Enter a password: ");
                            String password = sc.next();
                            System.out.println("Enter a degree: ");
                            String degree = sc.next();

                            Teacher student = new Teacher(id, name, surname, email, password, degree);

                            studentRepository.create(ImplementationCRUD.TEACHER, student);
                        }
                        case "3" -> {
                            System.out.println("Enter ID: ");
                            int id = sc.nextInt();
                            System.out.println("Enter a name: ");
                            String name = sc.next();
                            System.out.println("Enter a syllabus: ");
                            String syllabus = sc.next();
                            System.out.println("Enter a number of credits: ");
                            int creditNumber = sc.nextInt();

                            Subject subject = new Subject(id, name, syllabus, creditNumber);

                            subjectRepository.create(ImplementationCRUD.SUBJECT, subject);
                        }
                        case "4" -> {
                            System.out.println("Enter ID: ");
                            int id = sc.nextInt();
                            System.out.println("Enter a subject ID: ");
                            int subjectId = sc.nextInt();
                            System.out.println("Enter a student ID: ");
                            int studentId = sc.nextInt();
                            System.out.println("Enter a teacher ID: ");
                            int teacherId = sc.nextInt();
                            System.out.println("Enter a grade: ");
                            double grade = sc.nextDouble();
                            System.out.println("Enter attendance: ");
                            double attendance = sc.nextDouble();

                            StudentSubject studentSubject = new StudentSubject(id, subjectId, studentId, teacherId, grade, attendance);

                            studentSubjectRepository.create(ImplementationCRUD.STUDENT_SUBJECT, studentSubject);
                        }
                        case "5" -> {
                            System.out.println("Enter ID: ");
                            int id = sc.nextInt();
                            System.out.println("Enter a subject ID: ");
                            int subjectId = sc.nextInt();
                            System.out.println("Enter a teacher ID: ");
                            int teacherId = sc.nextInt();

                            TeacherSubject teacherSubject = new TeacherSubject(id, subjectId, teacherId);

                            teacherSubjectRepository.create(ImplementationCRUD.TEACHER_SUBJECT, teacherSubject);
                        }
                        default -> throw new DatabaseRepositoryException("This relation doesn't exist.");
                    }
                }
                case "2.1" -> {
                    System.out.println("Choose the repository:");
                    System.out.println("1 - Student, 2 - Teacher, 3 - Subject, 4 - Student subject, 5 - Teacher subject");
                    String repositoryKey = sc.next();
                    switch (repositoryKey) {
                        case "1" -> System.out.println(studentRepository.getAll(ImplementationCRUD.STUDENT));
                        case "2" -> System.out.println(teacherRepository.getAll(ImplementationCRUD.TEACHER));
                        case "3" -> System.out.println(subjectRepository.getAll(ImplementationCRUD.SUBJECT));
                        case "4" -> System.out.println(studentSubjectRepository.getAll(ImplementationCRUD.STUDENT_SUBJECT));
                        case "5" -> System.out.println(teacherSubjectRepository.getAll(ImplementationCRUD.TEACHER_SUBJECT));
                        default -> throw new DatabaseRepositoryException("This relation doesn't exist.");
                    }
                }
                case "2.2" -> {
                    System.out.println("Choose the repository:");
                    System.out.println("1 - Student, 2 - Teacher, 3 - Subject, 4 - Student subject, 5 - Teacher subject");
                    String repositoryKey = sc.next();
                    switch (repositoryKey) {
                        case "1" -> {
                            System.out.println("Enter ID: ");
                            int id = sc.nextInt();
                            System.out.println(studentRepository.getById(ImplementationCRUD.STUDENT, id));
                        }
                        case "2" -> {
                            System.out.println("Enter ID: ");
                            int id = sc.nextInt();
                            System.out.println(teacherRepository.getById(ImplementationCRUD.TEACHER, id));
                        }
                        case "3" -> {
                            System.out.println("Enter ID: ");
                            int id = sc.nextInt();
                            System.out.println(subjectRepository.getById(ImplementationCRUD.SUBJECT, id));
                        }
                        case "4" -> {
                            System.out.println("Enter ID: ");
                            int id = sc.nextInt();
                            System.out.println(studentSubjectRepository.getById(ImplementationCRUD.STUDENT_SUBJECT, id));
                        }
                        case "5" -> {
                            System.out.println("Enter ID: ");
                            int id = sc.nextInt();
                            System.out.println(teacherSubjectRepository.getById(ImplementationCRUD.TEACHER_SUBJECT, id));
                        }
                        default -> throw new DatabaseRepositoryException("This relation doesn't exist.");
                    }
                }
                case "3" -> {
                    System.out.println("Choose the repository:");
                    System.out.println("1 - Student, 2 - Teacher, 3 - Subject, 4 - Student subject, 5 - Teacher subject");
                    String repositoryKey = sc.next();
                    List<String> fields = new ArrayList<>();
                    List<Object> values = new ArrayList<>();
                    switch (repositoryKey) {
                        case "1" -> {
                            System.out.print("Enter ID: ");
                            int id = sc.nextInt();
                            System.out.println("Input new values for columns (if you don't want to change the value of column, press ENTER)");
                            System.out.print("Enter the name: ");
                            String name = sc.next();
                            if (name.length() != 0) {
                                values.add(name);
                                fields.add("name");
                            }
                            System.out.print("Enter a surname: ");
                            String surname = sc.next();
                            if (surname.length() != 0) {
                                values.add(surname);
                                fields.add("surname");
                            }
                            System.out.print("Enter an email: ");
                            String email = sc.next();
                            if (email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                                values.add(email);
                                fields.add("email");
                            }
                            System.out.print("Enter a password: ");
                            String password = sc.next();
                            if (password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,16}$")) {
                                values.add(password);
                                fields.add("password");
                            }
                            System.out.print("Enter a degree: ");
                            String groupName = sc.next();
                            if (groupName.length() != 0) {
                                values.add(groupName);
                                fields.add("group_name");
                            }

                            studentRepository.update(ImplementationCRUD.STUDENT, id, fields, values);
                        }
                        case "2" -> {
                            System.out.println("Enter ID: ");
                            int id = sc.nextInt();
                            System.out.println("Input new values for columns (if you don't want to change the value of column, press ENTER)");
                            System.out.print("Enter the name: ");
                            String name = sc.next();
                            if (name.length() != 0) {
                                values.add(name);
                                fields.add("name");
                            }
                            System.out.print("Enter a surname: ");
                            String surname = sc.next();
                            if (surname.length() != 0) {
                                values.add(surname);
                                fields.add("surname");
                            }
                            System.out.print("Enter an email: ");
                            String email = sc.next();
                            if (email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                                values.add(email);
                                fields.add("email");
                            }
                            System.out.print("Enter a password: ");
                            String password = sc.next();
                            if (password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,16}$")) {
                                values.add(password);
                                fields.add("password");
                            }
                            System.out.print("Enter a degree: ");
                            String degree = sc.next();
                            if (degree.equals(Teacher.MASTER) || degree.equals(Teacher.PhD)) {
                                values.add(degree);
                                fields.add("degree");
                            }

                            teacherRepository.update(ImplementationCRUD.TEACHER, id, fields, values);
                        }
                        case "3" -> {
                            System.out.print("Enter ID: ");
                            int id = sc.nextInt();
                            System.out.println("Input new values for columns (if you don't want to change the value of column, press ENTER)");
                            System.out.print("Enter the name: ");
                            String name = sc.next();
                            if (name.length() != 0) {
                                values.add(name);
                                fields.add("name");
                            }
                            System.out.print("Enter a syllabus: ");
                            String syllabus = sc.next();
                            if (syllabus.length() != 0) {
                                values.add(syllabus);
                                fields.add("syllabus");
                            }
                            System.out.print("Enter a number of credits: ");
                            int creditNumber = sc.nextInt();
                            if (creditNumber >= 1) {
                                values.add(creditNumber);
                                fields.add("creditnumber");
                            }

                            subjectRepository.update(ImplementationCRUD.SUBJECT, id, fields, values);
                        }
                        case "4" -> {
                            System.out.print("Enter ID: ");
                            int id = sc.nextInt();
                            System.out.println("Input new values for columns (if you don't want to change the value of column, press ENTER)");
                            System.out.print("Enter subject ID: ");
                            int subjectId = sc.nextInt();
                            if (subjectId < 0 || subjectId >= Subject.getCurrentId()) {
                                values.add(subjectId);
                                fields.add("subject_id");
                            }
                            System.out.print("Enter student ID: ");
                            int studentId = sc.nextInt();
                            if (studentId < 0 || studentId >= User.getCurrentId()) {
                                values.add(studentId);
                                fields.add("student_id");
                            }
                            System.out.print("Enter teacher ID: ");
                            int teacherId = sc.nextInt();
                            if (teacherId < 0 || teacherId >= User.getCurrentId()) {
                                values.add(teacherId);
                                fields.add("teacher_id");
                            }
                            System.out.print("Enter grade: ");
                            Double grade = sc.nextDouble();
                            if (grade >= 0 && grade <= 100) {
                                values.add(grade);
                                fields.add("grade");
                            }
                            System.out.print("Enter attendance: ");
                            Double attendance = sc.nextDouble();
                            if (attendance >= 0 && attendance <= 100) {
                                values.add(attendance);
                                fields.add("attendance");
                            }

                            studentSubjectRepository.update(ImplementationCRUD.STUDENT_SUBJECT, id, fields, values);
                        }
                        case "5" -> {
                            System.out.print("Enter ID: ");
                            int id = sc.nextInt();
                            System.out.println("Input new values for columns (if you don't want to change the value of column, press ENTER)");
                            System.out.print("Enter subject ID: ");
                            int subjectId = sc.nextInt();
                            if (subjectId < 0 || subjectId >= Subject.getCurrentId()) {
                                values.add(subjectId);
                                fields.add("subject_id");
                            }
                            System.out.print("Enter teacher ID: ");
                            int teacherId = sc.nextInt();
                            if (teacherId < 0 || teacherId >= User.getCurrentId()) {
                                values.add(teacherId);
                                fields.add("teacher_id");
                            }

                            teacherSubjectRepository.update(ImplementationCRUD.TEACHER_SUBJECT, id, fields, values);
                        }
                        default -> throw new DatabaseRepositoryException("This relation doesn't exist.");
                    }
                }
                case "4" -> {
                    System.out.println("Choose the repository:");
                    System.out.println("1 - Student, 2 - Teacher, 3 - Subject, 4 - Student subject, 5 - Teacher subject");
                    String repositoryKey = sc.next();
                    switch (repositoryKey) {
                        case "1" -> {
                            System.out.print("Enter ID: ");
                            int id = sc.nextInt();
                            studentRepository.delete(ImplementationCRUD.STUDENT, id);
                        }
                        case "2" -> {
                            System.out.print("Enter ID: ");
                            int id = sc.nextInt();
                            teacherRepository.delete(ImplementationCRUD.TEACHER, id);
                        }
                        case "3" -> {
                            System.out.print("Enter ID: ");
                            int id = sc.nextInt();
                            subjectRepository.delete(ImplementationCRUD.SUBJECT, id);
                        }
                        case "4" -> {
                            System.out.print("Enter ID: ");
                            int id = sc.nextInt();
                            studentSubjectRepository.delete(ImplementationCRUD.STUDENT_SUBJECT, id);
                        }
                        case "5" -> {
                            System.out.print("Enter ID: ");
                            int id = sc.nextInt();
                            teacherSubjectRepository.delete(ImplementationCRUD.TEACHER_SUBJECT, id);
                        }
                        default -> throw new DatabaseRepositoryException("This relation doesn't exist.");
                    }
                }
                case "q" -> {
                    System.out.println("Terminating the application...");
                    sc.close();
                    isSession = false;
                }
                default -> throw new CRUDMenuException("This operation doesn't exist.\n");
            }
        }
    }
}