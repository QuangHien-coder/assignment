# Hệ thống quản lý sinh viên (Java Console)

Bài tập môn Lập trình Java: quản lý danh sách sinh viên bằng `ArrayList`, có menu console và xử lý ngoại lệ đầu vào.

## Video giới thiệu chức năng

👉 **Link video:** https://drive.google.com/file/d/1WacS-eBvzE59eXws0CdK2GvWhnpsLJ4n/view?usp=sharing

## Cấu trúc mã nguồn

Mã nguồn nằm trong thư mục [welcome_to_git/](welcome_to_git/):

| Lớp | Vai trò |
|---|---|
| [Student.java](welcome_to_git/Student.java) | Thực thể sinh viên: `id`, `fullName`, `email`, `phone`, `gpa` (thang 4.0); constructor, getter/setter, `displayData()` |
| [StudentController.java](welcome_to_git/StudentController.java) | Xử lý nghiệp vụ trên `ArrayList<Student>`: thêm, xem, tìm kiếm, sửa GPA, xóa, sắp xếp |
| [MainThread.java](welcome_to_git/MainThread.java) | Hàm `main`: menu dùng vòng lặp `while` + `switch-case`, chạy đến khi chọn Thoát |

## Chức năng

1. Thêm mới sinh viên (kiểm tra trùng mã, kiểm tra định dạng email và số điện thoại)
2. Hiển thị danh sách sinh viên dạng bảng
3. Tìm kiếm sinh viên theo tên (không phân biệt hoa/thường)
4. Cập nhật điểm GPA theo mã sinh viên
5. Xóa sinh viên theo mã sinh viên
6. Sắp xếp danh sách theo GPA giảm dần
7. Thoát chương trình

## Xử lý ngoại lệ

- Chống trôi lệnh: gọi `nextLine()` ngay sau `nextInt()` / `nextDouble()` để bỏ dấu Enter còn sót.
- Nhập sai định dạng số: bắt `InputMismatchException`, báo lỗi và cho nhập lại, chương trình không bị dừng.
- Không cho để trống chuỗi; GPA chỉ nhận từ 0 đến 4; menu chỉ nhận từ 1 đến 7.

## Cách chạy

```bash
javac -d out welcome_to_git/*.java
java -cp out welcome_to_git.MainThread
```
