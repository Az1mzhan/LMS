package model.entities;

public class Subject {
    private int id;
    private String name;
    private String syllabus;
    private int creditNumber;

    public Subject(int id, String name, String syllabys, int creditNumber) {
        this.id=id;
        this.name=name;
        this.syllabus=syllabys;
        this.creditNumber=creditNumber;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + name + '\'' +
                ", syllabus='" + syllabus + '\'' +
                ", creditNumber=" + creditNumber+"\n";
    }

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
