package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
    // load the file data from the folder
    public static Properties userDate = LoadProperties(
            System.getProperty("user.dir") + "\\src\\main\\java\\properties\\userdata");

    private static Properties LoadProperties(String path) {
        Properties pro = new Properties();
        // stream for reading file
        try {
            FileInputStream stream = new FileInputStream(path);
            pro.load(stream);
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
        return pro;
    }
}
