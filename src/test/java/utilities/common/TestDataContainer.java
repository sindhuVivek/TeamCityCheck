package utilities.common;

// Selenium imports
import java.util.HashMap;

public class TestDataContainer extends Driver {

    //Create public accessible hashmap
    public static HashMap<String, String> dataMap;

    //Sets the datamap to the value.
    public static void setDataMap(String key, String value) {

        if(dataMap == null) {

            dataMap = new HashMap<>();

        }

        dataMap.put(key, value);

    }


    //Returns the value stored in the data map
    public static String getDataMap(String key) {

        return dataMap.get(key);

    }


    //Clears the map if needed.
    public static void clearMap() {

        dataMap = null;

    }


    //Checks if the keys exists in the hashmap.
    public static Boolean checkIfKeyExists(String key) {

        Boolean keyExists = false;

        if (dataMap.containsKey(key)) {

            keyExists = true;

        } else if (!dataMap.containsKey(key)) {

            keyExists = false;

        }

        return keyExists;

    }

}