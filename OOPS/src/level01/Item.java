package level01;

public class Item {
    int ItemCode;
    String ItemName;
    double price;

    Item(int ItemCode,String ItemName,double price){
        this.ItemCode = ItemCode;
        this.ItemName = ItemName;
        this.price = price;
    }

    public void Display(){
        System.out.println("ItemCode is : "+ItemCode);
        System.out.println("ItemName is : "+ItemName);
        System.out.println("Price is : "+price);
    }
    double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    public static void main(String[] args) {
        Item it = new Item(23345,"Cake",40);
        it.Display();
        int qty=4;
        System.out.println("The total cost is : "+it.calculateTotalCost(qty));

    }

}
