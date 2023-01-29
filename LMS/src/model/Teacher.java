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
        if (level.length() != 0)
            this.level = level;
        else
            throw new IllegalArgumentException("Illegal group name format");
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        if (degree.length() != 0)
            this.degree = degree;
        else
            throw new IllegalArgumentException("Illegal degree format");
    }
}
