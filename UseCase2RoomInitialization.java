
abstract class Room {

    protected int roomNumber;
    protected double pricePerNight;
    protected boolean isAvailable;

    /**
     * Constructor to initialize common room attributes.
     */
    public Room(int roomNumber, double pricePerNight, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.isAvailable = isAvailable;
    }

    /**
     * Abstract method to return room type.
     */
    public abstract String getRoomType();

    /**
     * Displays room details.
     */
    public void displayRoomDetails() {
        System.out.println("-----------------------------------");
        System.out.println("Room Type: " + getRoomType());
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Price Per Night: ₹" + pricePerNight);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Booked"));
    }
}

/**
 * Concrete class representing a Single Room.
 */
class SingleRoom extends Room {

    public SingleRoom(int roomNumber, double pricePerNight, boolean isAvailable) {
        super(roomNumber, pricePerNight, isAvailable);
    }

    @Override
    public String getRoomType() {
        return "Single Room";
    }
}

/**
 * Concrete class representing a Double Room.
 */
class DoubleRoom extends Room {

    public DoubleRoom(int roomNumber, double pricePerNight, boolean isAvailable) {
        super(roomNumber, pricePerNight, isAvailable);
    }

    @Override
    public String getRoomType() {
        return "Double Room";
    }
}

/**
 * Concrete class representing a Suite Room.
 */
class SuiteRoom extends Room {

    public SuiteRoom(int roomNumber, double pricePerNight, boolean isAvailable) {
        super(roomNumber, pricePerNight, isAvailable);
    }

    @Override
    public String getRoomType() {
        return "Suite Room";
    }
}

/**
 * Application Entry Point for Use Case 2.
 */
public class UseCase2RoomInitialization {

    /**
     * Main method - Entry point of the application.
     */
    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("      Welcome to Book My Stay");
        System.out.println("======================================");
        System.out.println("Application: Hotel Booking Management System");
        System.out.println("Version: 2.0");
        System.out.println("======================================");

        // Initialize room objects
        SingleRoom singleRoom = new SingleRoom(101, 2500.0, true);
        DoubleRoom doubleRoom = new DoubleRoom(201, 4000.0, false);
        SuiteRoom suiteRoom = new SuiteRoom(301, 7500.0, true);

        // Display room details
        singleRoom.displayRoomDetails();
        doubleRoom.displayRoomDetails();
        suiteRoom.displayRoomDetails();

        System.out.println("-----------------------------------");
        System.out.println("Room initialization completed successfully.");
    }
}