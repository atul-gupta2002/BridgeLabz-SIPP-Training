package Level01;

public class HostelBooking {
    String guestName;
    String roomType;
    int nights;

    public HostelBooking(){
        guestName="unknown";
        roomType="unknown";
        nights=0;
    }
    public HostelBooking(String guestName,String roomType,int nights){
        this.guestName=guestName;
        this.roomType=roomType;
        this.nights=nights;
    }

    public HostelBooking(HostelBooking other){
        this.guestName=other.guestName;
        this.roomType=other.roomType;
        this.nights=other.nights;

    }
    public void Display(){
        System.out.println("Name is :"+guestName);
        System.out.println("Room-type is :"+ roomType);
        System.out.println("Nights :"+nights);
    }

    public static void main(String[] args) {
        HostelBooking h1 = new HostelBooking("Atul","Deluxe",2);
        HostelBooking h2 = new HostelBooking(h1);
        System.out.println("Original Person:");
        h1.Display();

        System.out.println("\nCopied Person:");
        h2.Display();
    }

}
