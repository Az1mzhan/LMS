package model;

public class Teacher extends User {
    private String level;
    private String degree;

    public Teacher(int id, String name, String surname, String email, String password, UserRole role, String level, String degree) {
        super(id, name, surname, email, password, role);
        setRole(UserRole.TEACHER);
        this.level = level;
        this.degree = degree;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
