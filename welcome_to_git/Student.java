package welcome_to_git;

public class Student{
    // Lop Student khoi tao doi tuong sinh vien voi cac thong tin ve ho
    private String id;
    private String fullName;
    private String email;
    private String phone;
    private double gpa;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    // Constructor co tham so truyen vao 
    public Student(String id, String fullName, String email, String phone, double gpa) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.gpa = gpa;
    }
    // Constructor default.
    public Student() {
    }
    // In thong tin sinh vien tren mot dong dang bang
    public void displayData() {
        System.out.printf("%-10s | %-25s | %-25s | %-12s | %4.2f%n", id, fullName, email, phone, gpa);
    }
    
}
