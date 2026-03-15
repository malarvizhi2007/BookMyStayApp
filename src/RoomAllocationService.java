public class RoomAllocationService {

    public void allocateRoom(Reservation r, RoomInventory inventory){

        String roomId = inventory.allocateRoom(r.getRoomType());

        if(roomId!=null){

            System.out.println(
                    "Booking confirmed for Guest: "
                            + r.getGuestName()
                            + ", Room ID: "
                            + roomId
            );
        }
    }
}