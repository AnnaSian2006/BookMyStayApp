

import java.util.HashMap;
import java.util.Map;

/**
 * Abstract Room domain class.
 */
abstract class Room {

    protected String roomType;
    protected double pricePerNight;

    public Room(String roomType, double pricePerNight) {
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void displayDetails(int availability) {
        System.out.println("----------------------------------");
        System.out.println("Room Type: " + roomType);
        System.out.println("Price Per Night: ₹" + pricePerNight);
        System.out.println("Available Rooms: " + availability);
    }
}

/**
 * Concrete Room Types
 */
class SingleRoom extends Room {
    public SingleRoom() {
        super("Single", 2500.0);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double", 4000.0);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite", 7500.0);
    }
}

/**
 * Centralized Inventory Manager
 */
class InventoryManager {

    private HashMap<String, Integer> availabilityMap;

    public InventoryManager() {
        availabilityMap = new HashMap<>();
        availabilityMap.put("Single", 5);
        availabilityMap.put("Double", 0);  // Out of stock
        availabilityMap.put("Suite", 2);
    }

    // Read-only method
    public int getAvailability(String roomType) {
        return availabilityMap.getOrDefault(roomType, 0);
    }

    // Write method (Not used in search)
    public void updateAvailability(String roomType, int newCount) {
        if (newCount >= 0) {
            availabilityMap.put(roomType, newCount);
        }
    }

    // Expose read-only view
    public Map<String, Integer> getAllAvailability() {
        return availabilityMap;
    }
}

/**
 * Room Search Service (Read-Only Layer)
 */
class RoomSearchService {

    private InventoryManager inventoryManager;

    public RoomSearchService(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    public void displayAvailableRooms(Room[] rooms) {

        System.out.println("\nSearching Available Rooms...\n");

        for (Room room : rooms) {

            int availableCount = inventoryManager.getAvailability(room.getRoomType());

            // Display only if availability > 0
            if (availableCount > 0) {
                room.displayDetails(availableCount);
            }
        }

        System.out.println("----------------------------------");
        System.out.println("Search completed (Read-Only Operation)");
    }
}

/**
 * Application Entry Point
 */
public class UseCase4RoomSearch {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("      Welcome to Book My Stay");
        System.out.println("======================================");
        System.out.println("Application: Hotel Booking Management System");
        System.out.println("Version: 4.0");
        System.out.println("======================================");

        // Centralized inventory
        InventoryManager inventoryManager = new InventoryManager();

        // Room domain objects
        Room[] rooms = {
            new SingleRoom(),
            new DoubleRoom(),
            new SuiteRoom()
        };

        // Read-only search service
        RoomSearchService searchService = new RoomSearchService(inventoryManager);

        // Perform search
        searchService.displayAvailableRooms(rooms);

        System.out.println("\nProgram executed successfully.");
    }
}