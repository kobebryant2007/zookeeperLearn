import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by liangnan on 17-1-12.
 */

public class ReadConfigFile {
    @Test
    public void readAddress(){
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("testAddress.properties");
        Properties prop = new Properties();
        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s = prop.getProperty("ELONG_INTERFACE_ADDRESS");
        System.out.println(s);
    }
}
