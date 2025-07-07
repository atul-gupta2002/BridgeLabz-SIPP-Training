package singlylinkedlist;

class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    private Item head = null;

    // Add at beginning
    public void addAtBeginning(String name, int id, int qty, double price) {
        Item newItem = new Item(name, id, qty, price);
        newItem.next = head;
        head = newItem;
    }

    // Add at end
    public void addAtEnd(String name, int id, int qty, double price) {
        Item newItem = new Item(name, id, qty, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newItem;
    }

    // Add at position (1-based index)
    public void addAtPosition(int position, String name, int id, int qty, double price) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtBeginning(name, id, qty, price);
            return;
        }
        Item newItem = new Item(name, id, qty, price);
        Item temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++)
            temp = temp.next;
        if (temp == null) {
            System.out.println("Position out of range.");
            return;
        }
        newItem.next = temp.next;
        temp.next = newItem;
    }

    // Remove by ID
    public void removeById(int id) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item removed with ID: " + id);
            return;
        }

        Item temp = head;
        while (temp.next != null && temp.next.itemId != id)
            temp = temp.next;

        if (temp.next == null) {
            System.out.println("Item ID not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item removed with ID: " + id);
        }
    }

    // Update quantity by ID
    public void updateQuantity(int id, int newQty) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated for Item ID: " + id);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Search by ID
    public void searchById(int id) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found with ID: " + id);
    }

    // Search by Name
    public void searchByName(String name) {
        Item temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found)
            System.out.println("No item found with name: " + name);
    }

    // Calculate total inventory value
    public void calculateTotalValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: Rs " + total);
    }

    // Sort by Name or Price
    public void sort(String by, boolean ascending) {
        head = mergeSort(head, by, ascending);
        System.out.println("Inventory sorted by " + by + " in " + (ascending ? "ascending" : "descending") + " order.");
    }

    private Item mergeSort(Item head, String by, boolean ascending) {
        if (head == null || head.next == null)
            return head;

        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;

        Item left = mergeSort(head, by, ascending);
        Item right = mergeSort(nextOfMiddle, by, ascending);

        return sortedMerge(left, right, by, ascending);
    }

    private Item sortedMerge(Item a, Item b, String by, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;

        Item result;
        boolean condition;
        if (by.equalsIgnoreCase("name"))
            condition = ascending ? a.itemName.compareToIgnoreCase(b.itemName) < 0 : a.itemName.compareToIgnoreCase(b.itemName) > 0;
        else
            condition = ascending ? a.price < b.price : a.price > b.price;

        if (condition) {
            result = a;
            result.next = sortedMerge(a.next, b, by, ascending);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, by, ascending);
        }
        return result;
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;

        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Display all items
    public void displayAll() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("Inventory Items:");
        Item temp = head;
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    private void displayItem(Item item) {
        System.out.println("ID: " + item.itemId + ", Name: " + item.itemName + ", Qty: " + item.quantity + ", Price: Rs " + item.price);
    }
}
    public class InventoryManagementSystem {
        public static void main(String[] args) {
            Inventory inventory = new Inventory();

            inventory.addAtEnd("Laptop", 101, 10, 55000);
            inventory.addAtBeginning("Mouse", 102, 50, 400);
            inventory.addAtPosition(2, "Keyboard", 103, 30, 800);

            inventory.displayAll();

            System.out.println("\n--- Update Quantity ---");
            inventory.updateQuantity(101, 8);
            inventory.searchById(101);

            System.out.println("\n--- Search By Name ---");
            inventory.searchByName("Keyboard");

            System.out.println("\n--- Total Inventory Value ---");
            inventory.calculateTotalValue();

            System.out.println("\n--- Sort by Name Ascending ---");
            inventory.sort("name", true);
            inventory.displayAll();

            System.out.println("\n--- Sort by Price Descending ---");
            inventory.sort("price", false);
            inventory.displayAll();

            System.out.println("\n--- Remove Item ID 102 ---");
            inventory.removeById(102);
            inventory.displayAll();
        }
    }



