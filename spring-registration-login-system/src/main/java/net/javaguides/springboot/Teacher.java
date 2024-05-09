
package net.javaguides.springboot;

public class Teacher {
    // Thuộc tính của giáo viên
    private String hoTen;
    private String boMon;

    // Phương thức khởi tạo
    public Teacher(String hoTen, String boMon) {
        this.hoTen = hoTen;
        this.boMon = boMon;
    }

    // Phương thức để hiển thị thông tin
    public void hienThiThongTin() {
        System.out.println("Họ và tên: " + hoTen);
        System.out.println("Bộ môn: " + boMon);
    }

    public static void main(String[] args) {
        // Tạo đối tượng giáo viên
        Teacher giaoVien = new Teacher("Nguyễn Văn A", "Toán học");

        // Hiển thị thông tin giáo viên
        giaoVien.hienThiThongTin();
    }
}
