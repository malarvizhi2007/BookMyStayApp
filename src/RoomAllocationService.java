import java.util.*;

/**
 * ==========================================================
 * CLASS - RoomAllocationService
 * ==========================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * This class confirms booking requests
 * and safely assigns rooms.
 *
 * @version 6.0
 */

public class RoomAllocationService {

    /** Stores all allocated room IDs to prevent duplicates. */
    private Set<String> allocatedRoomIds;

    /** Maps room types to their assigned room IDs. */
    private Map<String, Set<String>> assignedRoomsByType;

    /** Initializes allocation tracking structures. */
    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    /**
     * Confirms a booking request and allocates a room.
     */
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {

        String roomType = reservation.getRoomType();
        int available = inventory.getAvailability(roomType);

        if (available <= 0) {
            System.out.println("No rooms available for " + roomType);
            return;
        }

        String roomId = generateRoomId(roomType);

        allocatedRoomIds.add(roomId);

        assignedRoomsByType
                .computeIfAbsent(roomType, k -> new HashSet<>())
                .add(roomId);

        inventory.updateAvailability(roomType, available - 1);

        System.out.println(
                "Booking confirmed for Guest: "
                        + reservation.getGuestName()
                        + ", Room ID: "
                        + roomId
        );
    }

    /**
     * Generates a unique room ID.
     */
    private String generateRoomId(String roomType) {

        int nextNumber = assignedRoomsByType
                .getOrDefault(roomType, new HashSet<>())
                .size() + 1;

        return roomType + "-" + nextNumber;
    }
}