package Phone;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static final Scanner SC = new Scanner(System.in);
    private static final PhoneManager manager = new PhoneManager();
    private static final NumberFormat VND = NumberFormat.getInstance(new Locale("vi", "VN"));

    public static void main(String[] args) {
        while (true) {
            try {
                showMenu();
                int choice = readInt("Chọn chức năng: ");
                switch (choice) {
                    case 1 -> handleAddNewPhone();
                    case 2 -> handleAddOldPhone();
                    case 3 -> handleList();
                    case 4 -> handlePromote();
                    case 5 -> handleFindById();
                    case 6 -> handleSumTotal();
                    case 0 -> { System.out.println("Tạm biệt!"); return; }
                    default -> System.out.println("Lựa chọn không hợp lệ. Hãy nhập lại!");
                }
            } catch (Exception e) {
                // Bất kỳ lỗi nào không lường trước: không crash, hiển thị ngắn gọn
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
            }
            System.out.println();
        }
    }

    // ===== Menu & handlers =====
    private static void showMenu() {
        System.out.println("===== QUẢN LÝ ĐIỆN THOẠI =====");
        System.out.println("1. Thêm điện thoại mới");
        System.out.println("2. Thêm điện thoại cũ");
        System.out.println("3. Xem danh sách");
        System.out.println("4. Giảm giá tất cả (%)");
        System.out.println("5. Tìm theo mã");
        System.out.println("6. Tổng tiền hàng (theo totalPrice)");
        System.out.println("0. Thoát");
    }

    private static void handleAddNewPhone() {
        try {
            String name = readNonEmpty("Tên: ");
            long price = readLong("Giá niêm yết: ", 0, Long.MAX_VALUE);
            int warranty = readInt("Bảo hành (tháng): ", 0, Integer.MAX_VALUE);
            String os = readNonEmpty("Hệ điều hành: ");
            String brand = readNonEmpty("Hãng: ");
            int qty = readInt("Số lượng: ", 0, Integer.MAX_VALUE);

            NewPhone p = new NewPhone(name, price, warranty, os, brand, qty);
            manager.add(p);
            System.out.println("Đã thêm: " + p);
        } catch (InvalidDataException e) {
            System.out.println("Dữ liệu không hợp lệ: " + e.getMessage());
        }
    }

    private static void handleAddOldPhone() {
        try {
            String name = readNonEmpty("Tên: ");
            long price = readLong("Giá niêm yết: ", 0, Long.MAX_VALUE);
            int warranty = readInt("Bảo hành (tháng): ", 0, Integer.MAX_VALUE);
            String os = readNonEmpty("Hệ điều hành: ");
            String brand = readNonEmpty("Hãng: ");
            int battery = readInt("Phần trăm pin (0..100): ", 0, 100);

            OldPhone p = new OldPhone(name, price, warranty, os, brand, battery);
            manager.add(p);
            System.out.println("Đã thêm: " + p);
        } catch (InvalidDataException e) {
            System.out.println("Dữ liệu không hợp lệ: " + e.getMessage());
        }
    }

    private static void handleList() {
        if (manager.list().isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        manager.sortByTotalPriceDesc();
        for (Phone p : manager.list()) System.out.println(p);
    }

    private static void handlePromote() {
        double percent = readDouble("Nhập % giảm giá cho tất cả: ", 0, 100);
        manager.promoteAll(percent);
        System.out.println("Đã áp dụng giảm giá " + percent + "%.");
    }

    private static void handleFindById() {
        String id = readNonEmpty("Nhập mã (VD: DTM000): ");
        manager.findById(id).ifPresentOrElse(
                p -> System.out.println("Tìm thấy: " + p),
                () -> System.out.println("Không tìm thấy mã: " + id)
        );
    }

    private static void handleSumTotal() {
        long sum = manager.sumTotalPrice();
        System.out.println("Tổng tiền hàng: " + fmtVND(sum));
    }

    // ===== Input helpers (bọc try-catch & lặp lại đến khi hợp lệ) =====

    private static String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = SC.nextLine();
            if (s != null && !s.trim().isEmpty()) return s.trim();
            System.out.println("Không được để trống, hãy nhập lại.");
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String line = SC.nextLine().trim();
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ.");
            }
        }
    }

    private static int readInt(String prompt, int min, int max) {
        while (true) {
            int v = readInt(prompt);
            if (v < min || v > max) {
                System.out.println("Giá trị phải trong [" + min + ", " + max + "].");
            } else return v;
        }
    }

    private static long readLong(String prompt, long min, long max) {
        while (true) {
            System.out.print(prompt);
            try {
                String line = SC.nextLine().trim();
                long v = Long.parseLong(line);
                if (v < min || v > max) {
                    System.out.println("Giá trị phải trong [" + min + ", " + max + "].");
                } else return v;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ.");
            }
        }
    }

    private static double readDouble(String prompt, double min, double max) {
        while (true) {
            System.out.print(prompt);
            try {
                String line = SC.nextLine().trim();
                double v = Double.parseDouble(line);
                if (v < min || v > max) {
                    System.out.println("Giá trị phải trong [" + min + ", " + max + "].");
                } else return v;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số thực hợp lệ.");
            }
        }
    }

    private static String fmtVND(long v) {
        return VND.format(v) + " đ";
    }
}
