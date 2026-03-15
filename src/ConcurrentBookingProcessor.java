public class ConcurrentBookingProcessor implements Runnable {

    private BookingRequestQueue bookingQueue;
    private RoomInventory inventory;
    private RoomAllocationService service;

    public ConcurrentBookingProcessor(
            BookingRequestQueue bookingQueue,
            RoomInventory inventory,
            RoomAllocationService service) {

        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.service = service;
    }

    @Override
    public void run() {

        while(true){

            Reservation r;

            synchronized (bookingQueue){

                if(bookingQueue.isEmpty())
                    return;

                r = bookingQueue.getNextRequest();
            }

            service.allocateRoom(r,inventory);
        }
    }
}