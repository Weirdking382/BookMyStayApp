public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" Welcome to Book My Stay");
        System.out.println(" Hotel Booking Management System");
        System.out.println(" Version: v1.0");
        System.out.println("=================================\n");

        Room standard = new StandardRoom(10);
        Room deluxe = new DeluxeRoom(5);
        Room suite = new SuiteRoom(2);

        System.out.println("Available Room Types:\n");

        standard.displayRoomDetails();
        deluxe.displayRoomDetails();
        suite.displayRoomDetails();

        System.out.println("Thank you for using Book My Stay!");
    }
}

abstract class Room {

    protected String roomType;
    protected double pricePerNight;
    protected int availableRooms;

    public Room(String roomType, double pricePerNight, int availableRooms) {
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.availableRooms = availableRooms;
    }

    public void displayRoomDetails() {
        System.out.println("Room Type: " + roomType);
        System.out.println("Price per Night: ₹" + pricePerNight);
        System.out.println("Available Rooms: " + availableRooms);
        System.out.println("---------------------------------");
    }
}

class StandardRoom extends Room {

    public StandardRoom(int availableRooms) {
        super("Standard Room", 2000, availableRooms);
    }
}

class DeluxeRoom extends Room {

    public DeluxeRoom(int availableRooms) {
        super("Deluxe Room", 3500, availableRooms);
    }
}

class SuiteRoom extends Room {

    public SuiteRoom(int availableRooms) {
        super("Suite Room", 6000, availableRooms);
    }
}