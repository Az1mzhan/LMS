import java.util.ArrayList;
public class Student extends User {
    private String group;
    private double attendance;
    private ArrayList<Double> midGrades;
    private ArrayList<Double> midGradeWeights;
    private ArrayList<Double> endGrades;
    private ArrayList<Double> endGradesWeights;

    public String getGroup() {
        return this.group;
    }
    public void setGroup(String group) {
        this.group = group;
    }
    public double getAttendance() {
        return this.attendance;
    }
    public void setAttendance(double attendance) {
        this.attendance = attendance;
    }
//    double regMid();
//    double redEnd();
//    double regTermAverage();
//    boolean isFinal();
//    double finalExam();
//    double totalGpa();
}