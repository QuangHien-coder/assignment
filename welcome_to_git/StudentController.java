package welcome_to_git;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Lop StudentController: xu ly nghiep vu tren danh sach sinh vien.
 */
public class StudentController {
    private ArrayList<Student> studentList = new ArrayList<>();
    private Scanner scanner;

    public StudentController(Scanner scanner) {
        this.scanner = scanner;
    }

    // 1. Nhap thong tin va them sinh vien moi (kiem tra trung ma)
    public void addStudent() {
        System.out.println("--- THEM MOI SINH VIEN ---");
        String id = inputString("Nhap ma sinh vien: ");
        if (findById(id) != null) {
            System.out.println("Ma sinh vien " + id + " da ton tai!");
            return;
        }
        String fullName = inputString("Nhap ho ten: ");
        String email = inputRegex("Nhap email: ", "^[\\w.+-]+@[\\w-]+(\\.[\\w-]+)+$",
                "Email khong hop le, vi du: an@gmail.com");
        String phone = inputRegex("Nhap so dien thoai: ", "^0\\d{9}$",
                "SDT phai gom 10 so va bat dau bang 0!");
        double gpa = inputDouble("Nhap GPA (0 - 4): ", 0, 4);
        studentList.add(new Student(id, fullName, email, phone, gpa));
        System.out.println("Them sinh vien thanh cong!");
    }

    // 2. In danh sach tat ca sinh vien
    public void printStudentList() {
        System.out.println("--- DANH SACH SINH VIEN ---");
        if (studentList.isEmpty()) {
            System.out.println("Danh sach sinh vien dang trong.");
            return;
        }
        printHeader();
        for (Student student : studentList) {
            student.displayData();
        }
    }

    // 3. Tim kiem sinh vien theo ten (khong phan biet hoa/thuong)
    public void searchStudentByName() {
        System.out.println("--- TIM KIEM SINH VIEN THEO TEN ---");
        String keyword = inputString("Nhap ten can tim: ").toLowerCase();
        boolean found = false;
        for (Student student : studentList) {
            if (student.getFullName().toLowerCase().contains(keyword)) {
                if (!found) {
                    printHeader();
                }
                student.displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay sinh vien nao.");
        }
    }

    // 4. Tim sinh vien theo ma va cap nhat GPA
    public void updateStudentGpa() {
        System.out.println("--- CAP NHAT DIEM GPA ---");
        Student student = findById(inputString("Nhap ma sinh vien: "));
        if (student == null) {
            System.out.println("Khong tim thay sinh vien.");
            return;
        }
        System.out.println("GPA hien tai: " + student.getGpa());
        student.setGpa(inputDouble("Nhap GPA moi (0 - 4): ", 0, 4));
        System.out.println("Cap nhat GPA thanh cong!");
    }

    // 5. Tim sinh vien theo ma va xoa khoi danh sach
    public void deleteStudent() {
        System.out.println("--- XOA SINH VIEN ---");
        Student student = findById(inputString("Nhap ma sinh vien: "));
        if (student == null) {
            System.out.println("Khong tim thay sinh vien.");
            return;
        }
        studentList.remove(student);
        System.out.println("Da xoa sinh vien " + student.getId());
    }

    // 6. Sap xep danh sach giam dan theo GPA
    public void sortStudentsByGpaDescending() {
        studentList.sort(Comparator.comparingDouble(Student::getGpa).reversed());
        System.out.println("Da sap xep danh sach theo GPA giam dan.");
        printStudentList();
    }

    // Tim sinh vien theo ma, tra ve null neu khong co
    private Student findById(String id) {
        for (Student student : studentList) {
            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }
        return null;
    }

    private void printHeader() {
        System.out.printf("%-10s | %-25s | %-25s | %-12s | %4s%n", "Ma SV", "Ho ten", "Email", "SDT", "GPA");
    }

    // Nhap chuoi, khong cho phep de trong
    public String inputString(String message) {
        while (true) {
            System.out.print(message);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Khong duoc de trong, vui long nhap lai!");
        }
    }

    // Nhap chuoi va kiem tra theo regex, sai thi nhap lai
    public String inputRegex(String message, String regex, String error) {
        while (true) {
            String value = inputString(message);
            if (value.matches(regex)) {
                return value;
            }
            System.out.println(error);
        }
    }

    // Nhap so nguyen, bat loi sai dinh dang
    public int inputInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                int value = scanner.nextInt();
                scanner.nextLine(); // Xoa dau Enter con sot lai sau nextInt() de tranh troi lenh
                return value;
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Bo du lieu sai de khong bi lap vo han
                System.out.println("Sai dinh dang, vui long nhap so nguyen!");
            }
        }
    }

    // Nhap so thuc trong khoang [min, max], bat loi sai dinh dang
    public double inputDouble(String message, double min, double max) {
        while (true) {
            System.out.print(message);
            try {
                double value = scanner.nextDouble();
                scanner.nextLine(); // Xoa dau Enter con sot lai sau nextDouble() de tranh troi lenh
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Gia tri phai tu " + min + " den " + max + "!");
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Bo du lieu sai de khong bi lap vo han
                System.out.println("Sai dinh dang, vui long nhap so!");
            }
        }
    }
}
