import java.io.*;

public class FilePersistenceService {

    public void saveInventory(RoomInventory inventory, String filePath) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            for (String roomType : inventory.getInventory().keySet()) {

                int count = inventory.getInventory().get(roomType);

                writer.write(roomType + "=" + count);
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving inventory.");
        }
    }

    public void loadInventory(RoomInventory inventory, String filePath) {

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("No valid inventory data found. Starting fresh.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("=");

                String roomType = parts[0];
                int count = Integer.parseInt(parts[1]);

                inventory.setInventory(roomType, count);
            }

        } catch (Exception e) {
            System.out.println("No valid inventory data found. Starting fresh.");
        }
    }
}