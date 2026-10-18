package welcome_to_git;

import java.util.Scanner;

/**
 * Lop MainThread: hien thi menu va dieu huong chuc nang.
 */
public class MainThread {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentController controller = new StudentController(scanner);
        int choice = 0;
        while (choice != 7) {
            System.out.println("==================================================");
            System.out.println("        HE THONG QUAN LY SINH VIEN");
            System.out.println("==================================================");
            System.out.println("1. Them moi sinh vien");
            System.out.println("2. Hien thi danh sach sinh vien");
            System.out.println("3. Tim kiem sinh vien theo ten");
            System.out.println("4. Cap nhat diem GPA theo ma sinh vien");
            System.out.println("5. Xoa sinh vien theo ma sinh vien");
            System.out.println("6. Sap xep danh sach sinh vien theo GPA giam dan");
            System.out.println("7. Thoat chuong trinh");
            System.out.println("==================================================");
            choice = controller.inputInt("Vui long chon chuc nang (1-7): ");

            switch (choice) {
                case 1:
                    controller.addStudent();
                    break;
                case 2:
                    controller.printStudentList();
                    break;
                case 3:
                    controller.searchStudentByName();
                    break;
                case 4:
                    controller.updateStudentGpa();
                    break;
                case 5:
                    controller.deleteStudent();
                    break;
                case 6:
                    controller.sortStudentsByGpaDescending();
                    break;
                case 7:
                    System.out.println("Cam on ban da su dung chuong trinh. Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon tu 1 den 7!");
                    break;
            }

            // Dung lai cho nguoi dung xem ket qua, bam Enter moi hien lai menu
            if (choice != 7) {
                System.out.println();
                System.out.print("Nhan Enter de tiep tuc...");
                scanner.nextLine();
                System.out.print("\033[H\033[2J"); // Xoa man hinh de menu hien lai gon gang
                System.out.flush();
            }
        }

        scanner.close();
    }
}
