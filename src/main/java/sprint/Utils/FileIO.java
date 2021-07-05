package sprint.Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class FileIO {
    public static  Properties prop;

    public static Properties initProperties() {
        if (prop == null) {
            prop = new Properties();
            try {
                FileInputStream file = new FileInputStream("src/test/resources/testData/config.properties");
                prop.load(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return prop;
    }
}
