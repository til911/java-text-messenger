package Logic;

import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class SaveManager {

    private static JSONObject userJson = GetJsonFrom("user.json");

    // Save new Users hashed password and name to json and write to file
    // Overwrites last registered user
    public static void SaveUser(String name, String passwordHash) {
        // write user data to json
        userJson.put("name", name);
        userJson.put("passwordHash", passwordHash);

        // Write json to file
        WriteJsonTo("user.json", userJson);
    }

    // Returns null if user does not exist
    public static String GetUserPasswordHash(String name) {
        if (userJson.getString("name").equals(name)) {
            return userJson.getString("passwordHash");
        }
        return null;
    }

    public static String GetUserName(){
        return userJson.getString("name");
    }

    private static JSONObject GetJsonFrom(String path) {
        try {
            String fileContent = Files.readString(Path.of(path));
            return new JSONObject(fileContent);
        } catch (IOException e) {
            System.err.println("Couldn't parse json from path: " + path);
            e.printStackTrace();
        }
        return null;
    }

    private static void WriteJsonTo(String path, JSONObject jsonObject) {
        // Write json to file
        try {
            FileWriter file = new FileWriter(path);
            file.write(jsonObject.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
