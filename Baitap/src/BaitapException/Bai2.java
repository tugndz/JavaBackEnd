package BaitapException;

import java.util.Scanner;

public class Bai2 {
    public static int divide(int a, int b) throws ArithmeticException {
        if (b == 0){
            throw new ArithmeticException("Không thể chia cho 0");
        }
        return a / b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Nhập số a: ");
            int a = Integer.parseInt(sc.nextLine());
            System.out.print("Nhập số b: ");
            int b = Integer.parseInt(sc.nextLine());
            int result = divide(a, b);
            System.out.println("Kết quả phân số: "+ result);
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Bạn phải nhập số nguyên!");
        } catch (ArithmeticException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } finally {
            System.out.println("Chương trình kết thúc");
        }


    }
}
