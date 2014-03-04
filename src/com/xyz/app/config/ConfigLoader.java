package com.xyz.app.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.StringTokenizer;

/**
 * ConfigLoader class loads the configuration information from config.properties file
 * located at the root of the application.
 */
public class ConfigLoader {
    /**
     * Reads config.properties located at the root of the application and loads
     * file properties to a configuration object.
     * @return A list of configuration
     * @throws IOException
     * @throws Exception
     */
    public static ArrayList<Configuration> loadConfiguration() throws IOException, Exception {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("config.properties");
            prop.load(input);
            // Get the count of files. This will help determine the number of files to parse
            int count = Integer.parseInt(prop.getProperty("fileCount"));
            ArrayList<Configuration> configurations = new ArrayList<Configuration>(3);
            for (int i = 1; i <= count; i++) {
                // Property string "filei" where i = 0 to count
                String configString = prop.getProperty("file" + i);
                ArrayList<String> configuration = new ArrayList<String>();
                StringTokenizer configTokenizer = new StringTokenizer(configString, "\\");
                // Create a List based on the filei entry using StringTokenizer
                while (configTokenizer.hasMoreTokens()) {
                    configuration.add(configTokenizer.nextToken());
                }
                // Create a Configuration and add it to the configuration list
                configurations.add(new Configuration(prop.getProperty("filepath") + configuration.get(0), configuration.get(1), configuration.get(2), configuration.get(3)));
            }
            return configurations;
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException io) {
                    io.printStackTrace();
                }
            }
        }
        return null;
    }

}
