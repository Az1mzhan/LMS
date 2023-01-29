package model;

public class Subject {
    private String name;
    private String syllabus;
    private int creditNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() != 0)
            this.name = name;
        else
            throw new IllegalArgumentException("Illegal name format");
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        if (syllabus.length() != 0)
            this.syllabus = syllabus;
        else
            throw new IllegalArgumentException("Illegal syllabus format");
    }

    public int getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(int creditNumber) {
        if (creditNumber >= 0)
            this.creditNumber = creditNumber;
        else
            throw new ArithmeticException("Number should be equal or greater than zero");
    }
}
