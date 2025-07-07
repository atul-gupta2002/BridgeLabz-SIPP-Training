package circularlinkedlist;

class Process {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime = 0;
    int turnAroundTime = 0;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    public void addProcess(int id, int burstTime, int priority) {
        Process newProcess = new Process(id, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        Process temp = head;
        System.out.println("Current Processes:");
        do {
            System.out.println("PID: " + temp.processId + ", BT: " + temp.burstTime + ", RT: " + temp.remainingTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
    public void simulateScheduling() {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int time = 0;
        Process current = head;
        Process prev = tail;

        while (head != null) {
            if (current.remainingTime > 0) {
                int execTime = Math.min(current.remainingTime, timeQuantum);
                current.remainingTime -= execTime;
                time += execTime;

                // Update waiting and turnaround times for other processes
                Process temp = head;
                do {
                    if (temp != current && temp.remainingTime > 0) {
                        temp.waitingTime += execTime;
                    }
                    temp = temp.next;
                } while (temp != head);

                System.out.println("Time: " + time + " | Executed PID: " + current.processId + " | Remaining: " + current.remainingTime);
                displayProcesses();

                // If current process finished, remove it
                if (current.remainingTime == 0) {
                    current.turnAroundTime = time;
                    System.out.println("Process PID " + current.processId + " completed.");

                    if (current == head && current == tail) {
                        head = tail = null;
                        break;
                    } else if (current == head) {
                        head = head.next;
                        tail.next = head;
                        prev.next = head;
                        current = head;
                    } else if (current == tail) {
                        tail = prev;
                        tail.next = head;
                        current = head;
                    } else {
                        prev.next = current.next;
                        current = current.next;
                    }
                } else {
                    prev = current;
                    current = current.next;
                }
            } else {
                current = current.next;
            }
        }

        System.out.println("\n--- All processes completed ---");
        calculateAverageTimes();
    }
    private void calculateAverageTimes() {
        int totalWT = 0, totalTAT = 0, count = 0;

        Process temp = head;
        do {
            if (temp == null) break;
            totalWT += temp.waitingTime;
            totalTAT += temp.turnAroundTime;
            count++;
            temp = temp.next;
        } while (temp != head && temp != null);

        System.out.println("Average Waiting Time: " + (double) totalWT / count);
        System.out.println("Average Turnaround Time: " + (double) totalTAT / count);
    }
}
public class RoundRobinScheduling  {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(4); // Set time quantum to 4 units

        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 3);

        System.out.println("Initial Process Queue:");
        scheduler.displayProcesses();

        System.out.println("\n--- Starting Round Robin Scheduling ---");
        scheduler.simulateScheduling();
    }
}

