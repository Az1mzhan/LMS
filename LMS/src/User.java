import java.util.Scanner;
abstract class User {
    private String email;
    private String password;
    private String name;
    private String surname;
    private String role;
    private int id;
    private int sessionTime = 0;

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return this.surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getRole() {
        return this.role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getSessionTime() {
        return this.sessionTime;
    }
    public void setSessionTime(int sessionTime) {
        this.sessionTime = sessionTime;
    }

    public void logIn() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your email");
        String email = sc.next();
        System.out.print("Enter your password");
        String password = sc.next();
        if (email == getEmail() && password == getPassword())
            System.out.println("You've successfully logged in!");
        sc.close();
    }
    public void signUp() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
    }
    public void sessionTimeIncrease() {
        setSessionTime(this.sessionTime + 1);
    }
    public boolean isSessionOver() {
        return (getSessionTime() >= 900);
    }
}
