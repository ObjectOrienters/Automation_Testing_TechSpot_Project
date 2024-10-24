package org.example.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CsvReader {

    public static Map<String, String> readSpecificUser(String filePath, int userIndex) {
        String line = "";
        String splitBy = ",";
        int currentIndex = 0;
        Map<String, String> credentials = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Skip the header row
            br.readLine();

            // Read the file line by line to find the specific user
            while ((line = br.readLine()) != null) {
                if (currentIndex == userIndex - 1) { // userIndex - 1 because user 1 is at index 0
                    String[] userData = line.split(splitBy);
                    credentials.put("username", userData[0]);
                    credentials.put("password", userData[1]);
                    break;
                }
                currentIndex++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return credentials;
    }
}
