
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager<Task> manager = new TaskManager<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Thêm công việc vào Stack");
            System.out.println("2. Xem công việc trên cùng Stack");
            System.out.println("3. Xóa công việc trên cùng Stack (Pop)");
            System.out.println("4. Undo (Redo công việc vừa pop)");
            System.out.println("5. Kiểm tra Stack rỗng");
            System.out.println("6. Thêm công việc vào Queue");
            System.out.println("7. Xem công việc đầu Queue");
            System.out.println("8. Lấy công việc đầu Queue (Poll)");
            System.out.println("9. Kiểm tra Queue rỗng");
            System.out.println("10. Xử lý công việc ưu tiên cao nhất trong Queue");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    Task task1 = inputTask(scanner);
                    manager.pushToStack(task1);
                    System.out.println("Đã thêm vào Stack.");
                    break;
                case 2:
                    System.out.println("Trên cùng Stack: " + manager.peekStack());
                    break;
                case 3:
                    System.out.println("Pop Stack: " + manager.popFromStack());
                    break;
                case 4:
                    System.out.println("Redo Stack: " + manager.redo());
                    break;
                case 5:
                    System.out.println("Stack rỗng? " + manager.isStackEmpty());
                    break;
                case 6:
                    Task task2 = inputTask(scanner);
                    manager.addToQueue(task2);
                    System.out.println("Đã thêm vào Queue.");
                    break;
                case 7:
                    System.out.println("Đầu Queue: " + manager.peekQueue());
                    break;
                case 8:
                    System.out.println("Poll Queue: " + manager.pollFromQueue());
                    break;
                case 9:
                    System.out.println("Queue rỗng? " + manager.isQueueEmpty());
                    break;
                case 10:
                    Task highest = manager.processHighestPriorityTaskInQueue();
                    if (highest != null) {
                        System.out.println("Công việc ưu tiên nhất: " + highest);
                    } else {
                        System.out.println("Queue rỗng hoặc không phải kiểu Task.");
                    }
                    break;
                case 0:
                    System.out.println("Kết thúc chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static Task inputTask(Scanner scanner) {
        System.out.print("Nhập tên công việc: ");
        String name = scanner.nextLine();
        System.out.print("Nhập độ ưu tiên (số nguyên, càng nhỏ càng ưu tiên): ");
        int priority = Integer.parseInt(scanner.nextLine());
        return new Task(name, priority);
    }
}