package BaitapException;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Nhập một số nguyên: ");
            String input = scanner.nextLine();
            int number = Integer.parseInt(input);

            if (number < 0) {
                throw new IllegalArgumentException("Không thể tính căn bậc hai của số âm.");
            }

            double result = Math.sqrt(number);
            System.out.println("Căn bậc hai của " + number + " là: " + result);

        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Bạn phải nhập số nguyên!");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } finally {
            System.out.println("Chương trình kết thúc");
        }
    }
}