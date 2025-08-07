import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TaskManager<T> {
    private Stack<T> taskStack;
    private Queue<T> taskQueue;
    private Stack<T> redoStack;

    public TaskManager() {
        this.taskStack = new Stack<>();
        this.taskQueue = new LinkedList<>();
        this.redoStack = new Stack<>();
    }

    // Stack methods
    public void pushToStack(T task) {
        taskStack.push(task);
    }

    public T peekStack() {
        if (taskStack.isEmpty()) return null;
        return taskStack.peek();
    }

    public T popFromStack() {
        if (taskStack.isEmpty()) return null;
        T task = taskStack.pop();
        redoStack.push(task); // Lưu vào redoStack khi pop
        return task;
    }

    public boolean isStackEmpty() {
        return taskStack.isEmpty();
    }

    // Queue methods
    public void addToQueue(T task) {
        taskQueue.add(task);
    }

    public T peekQueue() {
        if (taskQueue.isEmpty()) return null;
        return taskQueue.peek();
    }

    public T pollFromQueue() {
        if (taskQueue.isEmpty()) return null;
        return taskQueue.poll();
    }

    public boolean isQueueEmpty() {
        return taskQueue.isEmpty();
    }

    // Redo method for Stack
    public T redo() {
        if (redoStack.isEmpty()) return null;
        T task = redoStack.pop();
        taskStack.push(task);
        return task;
    }

    // Process highest priority task in Queue (chỉ áp dụng cho Task)
    public T processHighestPriorityTaskInQueue() {
        if (taskQueue.isEmpty()) return null;
        if (!(taskQueue.peek() instanceof Task)) return null;

        Task highest = (Task) taskQueue.peek();
        for (T t : taskQueue) {
            Task task = (Task) t;
            if (task.getPriority() < highest.getPriority()) {
                highest = task;
            }
        }

        // Loại bỏ task ưu tiên nhất khỏi queue
        Queue<T> tempQueue = new LinkedList<>();
        boolean removed = false;
        while (!taskQueue.isEmpty()) {
            T t = taskQueue.poll();
            if (!removed && ((Task) t).equals(highest)) {
                removed = true;
                continue;
            }
            tempQueue.add(t);
        }
        taskQueue = tempQueue;
        return (T) highest;
    }
}