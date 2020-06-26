package data;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.util.Iterator;

public class JsonDataReader {

    private static final String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\userData.json";
    String[][] arrayJsonUsers;
    int cols = 4;
    int rows = 0;
    int rowsCount = 0;

    public String[][] getJsonData() {
        try (FileReader reader = new FileReader(filePath)) {
            JSONTokener tokener = new JSONTokener(reader);
            JSONObject object = new JSONObject(tokener);

            // get an array from the JSON object
            JSONArray users = (JSONArray) object.get("users");

            Iterator i = users.iterator();
            rows = users.length();

            arrayJsonUsers = new String[rows][cols];

            // take each value from the json array separately
            while (i.hasNext()) {
                JSONObject innerObj = (JSONObject) i.next();

                arrayJsonUsers[rowsCount][0] = (String) innerObj.get("firstName");
                arrayJsonUsers[rowsCount][1] = (String) innerObj.get("lastName");
                arrayJsonUsers[rowsCount][2] = (String) innerObj.get("email");
                arrayJsonUsers[rowsCount][3] = (String) innerObj.get("password");
                rowsCount++;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return arrayJsonUsers;
    }
}
