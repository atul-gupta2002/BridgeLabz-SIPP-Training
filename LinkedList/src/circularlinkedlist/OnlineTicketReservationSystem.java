package circularlinkedlist;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket head = null;
    private Ticket tail = null;

    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);

        if (head == null) {
            head = tail = newTicket;
            tail.next = head;
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }

        System.out.println("Ticket added successfully for " + customerName);
    }
    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = head;
        Ticket previous = tail;
        boolean found = false;

        do {
            if (current.ticketId == ticketId) {
                found = true;
                break;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("Ticket ID not found.");
            return;
        }

        if (current == head && current == tail) {
            head = tail = null;
        } else if (current == head) {
            head = head.next;
            tail.next = head;
        } else if (current == tail) {
            tail = previous;
            tail.next = head;
        } else {
            previous.next = current.next;
        }

        System.out.println("Ticket ID " + ticketId + " removed successfully.");
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        System.out.println("\n--- Booked Tickets ---");
        Ticket temp = head;
        do {
            printTicket(temp);
            temp = temp.next;
        } while (temp != head);
        System.out.println("------------------------\n");
    }

    public void searchTicket(String keyword) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        boolean found = false;
        Ticket temp = head;

        System.out.println("\n--- Search Results ---");
        do {
            if (temp.customerName.equalsIgnoreCase(keyword) || temp.movieName.equalsIgnoreCase(keyword)) {
                printTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tickets found for: " + keyword);
        }
        System.out.println("------------------------\n");
    }

    public void totalTickets() {
        if (head == null) {
            System.out.println("Total tickets: 0");
            return;
        }

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Total tickets booked: " + count);
    }


    private void printTicket(Ticket t) {
        System.out.println("Ticket ID: " + t.ticketId +
                ", Customer: " + t.customerName +
                ", Movie: " + t.movieName +
                ", Seat: " + t.seatNumber +
                ", Time: " + t.bookingTime);
    }
}
public class  OnlineTicketReservationSystem {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(101, "Alice", "Oppenheimer", "A1", "12:30 PM");
        system.addTicket(102, "Bob", "Oppenheimer", "A2", "12:30 PM");
        system.addTicket(103, "Charlie", "Dune", "B1", "3:00 PM");

        system.displayTickets();

        system.searchTicket("Oppenheimer");
        system.searchTicket("Bob");

        system.removeTicket(102);
        system.displayTickets();

        system.totalTickets();
    }
}


