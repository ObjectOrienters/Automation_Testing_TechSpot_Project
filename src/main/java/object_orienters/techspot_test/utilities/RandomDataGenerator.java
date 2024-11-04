package object_orienters.techspot_test.utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomDataGenerator {

    public static String getRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            result.append(characters.charAt(index));
        }

        return result.toString();
    }

    public static String getRandomEmail() {
        return getRandomString(8) + "@testing.com";
    }

    public static void writeDataToCSV(String filePath, String username, String email) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("username,").append(username).append("\n");
            writer.append("name,").append("testUser").append("\n");
            writer.append("email,").append(email).append("\n");
            writer.append("password,").append("123456").append("\n");
            System.out.println("Data has been written to the CSV file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to the CSV file: " + e.getMessage());
        }
    }
}
