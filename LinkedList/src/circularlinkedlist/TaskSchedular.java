package circularlinkedlist;

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head = null;
    private Task tail = null;
    private Task current = null;

    public void addAtBeginning(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }

    public void addAtEnd(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    public void addAtPosition(int pos, int id, String name, int priority, String dueDate) {
        if (pos <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (pos == 1) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }

        Task newTask = new Task(id, name, priority, dueDate);
        Task temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        newTask.next = temp.next;
        temp.next = newTask;

        if (temp == tail) {
            tail = newTask;
        }

        tail.next = head;
    }

    public void removeById(int id) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }

        if (head == tail && head.taskId == id) {
            head = tail = null;
            System.out.println("Task with ID " + id + " removed.");
            return;
        }

        if (head.taskId == id) {
            head = head.next;
            tail.next = head;
            System.out.println("Task with ID " + id + " removed.");
            return;
        }

        Task temp = head;
        while (temp.next != head && temp.next.taskId != id) {
            temp = temp.next;
        }

        if (temp.next == head) {
            System.out.println("Task ID not found.");
            return;
        }

        if (temp.next == tail) {
            tail = temp;
        }

        temp.next = temp.next.next;
        tail.next = head;

        System.out.println("Task with ID " + id + " removed.");
    }

    public void viewCurrentTask() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        if (current == null)
            current = head;

        System.out.println("Current Task -> ID: " + current.taskId + ", Name: " + current.taskName +
                ", Priority: " + current.priority + ", Due Date: " + current.dueDate);

        current = current.next;
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        System.out.println("Task List:");
        Task temp = head;
        do {
            System.out.println("ID: " + temp.taskId + ", Name: " + temp.taskName +
                    ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks to search.");
            return;
        }

        boolean found = false;
        Task temp = head;
        do {
            if (temp.priority == priority) {
                System.out.println("Found -> ID: " + temp.taskId + ", Name: " + temp.taskName +
                        ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No task found with priority: " + priority);
    }
}

public class TaskSchedular {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addAtEnd(1, "Write Report", 2, "2025-07-10");
        scheduler.addAtBeginning(2, "Check Emails", 3, "2025-07-08");
        scheduler.addAtPosition(2, 3, "Team Meeting", 1, "2025-07-09");

        scheduler.displayAllTasks();

        System.out.println("\n-- Rotating Tasks --");
        scheduler.viewCurrentTask();
        scheduler.viewCurrentTask();
        scheduler.viewCurrentTask();

        System.out.println("\n-- Search by Priority --");
        scheduler.searchByPriority(2);

        System.out.println("\n-- Remove Task ID 3 --");
        scheduler.removeById(3);

        scheduler.displayAllTasks();
    }
}
