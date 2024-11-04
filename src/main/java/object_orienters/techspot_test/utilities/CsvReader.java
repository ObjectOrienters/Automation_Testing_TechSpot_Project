package object_orienters.techspot_test.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CsvReader {

    public static Map<String, String> readCSVFile(String filePath) {
        Map<String, String> map = new HashMap<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] keyValuePair = line.split(",", -1); // Split line by comma
                if (keyValuePair.length >= 2) {
                    String key = keyValuePair[0].trim();
                    String value = keyValuePair[1].trim();
                    map.put(key, value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }
}
