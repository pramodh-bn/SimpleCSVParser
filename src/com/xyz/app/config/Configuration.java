package com.xyz.app.config;

/**
 * Configuration holds the configuration information of the application
 * like location of file, dateFormat, delimiter and format of data.
 * dataFormat is not used at the moment. It is a place holder.
 */
public class Configuration {
    private String filePath;
    private String dateFormat;
    private String delimiter;
    private String dataFormat;

    public Configuration(String filePath, String delimiter, String dataFormat, String dateFormat) {
        this.filePath = filePath;
        this.dateFormat = dateFormat;
        this.delimiter = delimiter;
        this.dataFormat = dataFormat;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String getDataFormat() {
        return dataFormat;
    }
}
