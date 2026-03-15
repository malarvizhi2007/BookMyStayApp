public class BookMyStayApp{

    public static void main(String[] args) {

        System.out.println("Concurrent Booking Simulation");

        BookingRequestQueue queue = new BookingRequestQueue();
        RoomInventory inventory = new RoomInventory();
        RoomAllocationService service = new RoomAllocationService();

        queue.addRequest(new Reservation("Abhi","Single"));
        queue.addRequest(new Reservation("Vannathi","Double"));
        queue.addRequest(new Reservation("Kural","Suite"));
        queue.addRequest(new Reservation("Subha","Single"));

        Thread t1 = new Thread(
                new ConcurrentBookingProcessor(queue,inventory,service)
        );

        Thread t2 = new Thread(
                new ConcurrentBookingProcessor(queue,inventory,service)
        );

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }
        catch(Exception e){
            System.out.println("Thread execution interrupted.");
        }

        System.out.println("\nRemaining Inventory:");
        System.out.println("Single: "+inventory.getRemaining("Single"));
        System.out.println("Double: "+inventory.getRemaining("Double"));
        System.out.println("Suite: "+inventory.getRemaining("Suite"));
    }
}