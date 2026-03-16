

import java.util.HashMap;
import java.util.Map;

/**
 * InventoryManager manages room availability using a HashMap.
 */
class InventoryManager {

    // Single source of truth
    private HashMap<String, Integer> roomAvailability;

    /**
     * Constructor initializes room availability.
     */
    public InventoryManager() {
        roomAvailability = new HashMap<>();

        // Initial availability setup
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    /**
     * Retrieves current availability of a room type.
     */
    public int getAvailability(String roomType) {
        return roomAvailability.getOrDefault(roomType, 0);
    }

    /**
     * Updates room availability in a controlled manner.
     */
    public void updateAvailability(String roomType, int newCount) {
        if (newCount >= 0) {
            roomAvailability.put(roomType, newCount);
        } else {
            System.out.println("Invalid update: Availability cannot be negative.");
        }
    }

    /**
     * Displays complete inventory status.
     */
    public void displayInventory() {
        System.out.println("------ Current Room Inventory ------");
        for (Map.Entry<String, Integer> entry : roomAvailability.entrySet()) {
            System.out.println(entry.getKey() + " Rooms Available: " + entry.getValue());
        }
        System.out.println("------------------------------------");
    }
}

/**
 * Application Entry Point for Use Case 3.
 */
public class UseCase3InventorySetup {

    /**
     * Main method - Entry point of the application.
     */
    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("      Welcome to Book My Stay");
        System.out.println("======================================");
        System.out.println("Application: Hotel Booking Management System");
        System.out.println("Version: 3.0");
        System.out.println("======================================");

        // Initialize centralized inventory
        InventoryManager inventoryManager = new InventoryManager();

        // Display initial inventory
        inventoryManager.displayInventory();

        // Retrieve availability
        System.out.println("Checking availability for Single Room...");
        int singleAvailability = inventoryManager.getAvailability("Single");
        System.out.println("Single Rooms Available: " + singleAvailability);

        // Controlled update
        System.out.println("\nBooking one Single Room...");
        inventoryManager.updateAvailability("Single", singleAvailability - 1);

        // Display updated inventory
        inventoryManager.displayInventory();

        System.out.println("Inventory setup and update completed successfully.");
    }
}