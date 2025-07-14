
interface Bookable{
    void bookRoom();
}
abstract class Room implements Bookable{
    protected String roomType;
    Room(String roomType) {
        this.roomType = roomType;
    }
    public abstract double calculatePrice(int nights);
    public String getRoomType(){
        return roomType;
    }
}

class DeluxeRoom extends Room{
    public DeluxeRoom() {
        super("Deluxe");
    }

    @Override
    public double calculatePrice(int nights) {
        return nights * 2000;
    }

    @Override
    public void bookRoom() {
        System.out.println("Deluxe Room booked successfully.");
    }
}
class SuiteRoom extends Room{
    public SuiteRoom() {
        super("Suite Room");
    }

    @Override
    public double calculatePrice(int nights) {
        return nights * 2000;
    }

    @Override
    public void bookRoom() {
        System.out.println("Suite Room room booked successfully.");
    }
}
class StandardRoom extends Room{
    public StandardRoom() {
        super("StandardRoom");
    }

    @Override
    public double calculatePrice(int nights) {
        return nights * 2000;
    }

    @Override
    public void bookRoom() {
        System.out.println("StandardRoom Room booked successfully.");
    }
}
public class HotelRoomBookingSystem {
    public static void main(String[] args) {
        Room[] rooms = {
                new DeluxeRoom(),
                new SuiteRoom(),
                new StandardRoom()
        };
        int nights = 3;
        for (Room room : rooms) {
            System.out.println("Room Type: " + room.getRoomType());
            room.bookRoom();
            System.out.println("Total Price for " + nights + " nights: Rs. " + room.calculatePrice(nights));
            System.out.println("------------------------------");
        }

    }
}

