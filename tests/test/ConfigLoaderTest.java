package test;

import com.xyz.app.config.ConfigLoader;
import com.xyz.app.config.Configuration;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by dyanna on 2/20/14.
 */
public class ConfigLoaderTest {
    @Test
    public void testPropertiesFileExists() throws Exception {
        InputStream input = null;
        try {
            input = new FileInputStream("config.properties");
            Assert.assertNotNull("input is not null", input);
        } catch(IOException ex) {
            throw ex;
        }
    }

    @Test
    public void testAppConfigLoadWorks() throws Exception {
        ArrayList<Configuration> configs = ConfigLoader.loadConfiguration();
        Assert.assertNotNull("configs is not null", configs);
        Assert.assertEquals("data format contains l", true, configs.get(0).getDataFormat().contains("l"));
    }

}
