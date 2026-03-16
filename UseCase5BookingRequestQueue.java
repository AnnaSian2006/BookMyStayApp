

import java.util.LinkedList;
import java.util.Queue;

/**
 * Represents a booking request made by a guest.
 */
class BookingRequest {

    private String guestName;
    private String requestedRoomType;

    public BookingRequest(String guestName, String requestedRoomType) {
        this.guestName = guestName;
        this.requestedRoomType = requestedRoomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRequestedRoomType() {
        return requestedRoomType;
    }

    public void displayRequest() {
        System.out.println("Guest: " + guestName +
                " | Requested Room: " + requestedRoomType);
    }
}

/**
 * Handles booking request intake using FIFO Queue.
 */
class BookingRequestManager {

    private Queue<BookingRequest> requestQueue;

    public BookingRequestManager() {
        requestQueue = new LinkedList<>();
    }

    /**
     * Accept a booking request (No allocation happens here).
     */
    public void acceptRequest(BookingRequest request) {
        requestQueue.offer(request);
        System.out.println("Booking request accepted for " + request.getGuestName());
    }

    /**
     * Display all pending booking requests in FIFO order.
     */
    public void displayPendingRequests() {

        System.out.println("\n------ Pending Booking Requests (FIFO Order) ------");

        for (BookingRequest request : requestQueue) {
            request.displayRequest();
        }

        System.out.println("---------------------------------------------------");
    }

    /**
     * Returns queue size (for monitoring load).
     */
    public int getQueueSize() {
        return requestQueue.size();
    }
}

/**
 * Application Entry Point
 */
public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("      Welcome to Book My Stay");
        System.out.println("======================================");
        System.out.println("Application: Hotel Booking Management System");
        System.out.println("Version: 5.0");
        System.out.println("======================================");

        BookingRequestManager requestManager = new BookingRequestManager();

        // Accept booking requests (simulated guest input)
        requestManager.acceptRequest(new BookingRequest("Anita", "Single"));
        requestManager.acceptRequest(new BookingRequest("Rahul", "Suite"));
        requestManager.acceptRequest(new BookingRequest("Meera", "Double"));

        // Display pending requests (No inventory touched)
        requestManager.displayPendingRequests();

        System.out.println("Total Requests in Queue: " + requestManager.getQueueSize());

        System.out.println("\nAll requests stored successfully.");
        System.out.println("No room allocation performed at this stage.");
    }
}