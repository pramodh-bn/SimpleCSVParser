package com.xyz.app.parse;


import com.xyz.app.config.Configuration;
import com.xyz.app.data.PersonVO;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BaseParser class will do the parsing of the file.
 * When it is being created, based on the configuration
 * a custom Parser will be set.
 */
public class BaseParser {
    private Configuration configuration;
    private ICustomParser parser;

    public BaseParser(Configuration configuration, ICustomParser parser) {
        this.configuration = configuration;
        this.parser = parser;
    }

    /**
     * Reads the file and parses it line by line
     * @return list of Person object
     * @throws IOException
     * @throws Exception
     */
    public ArrayList<PersonVO> getPersonDataList() throws IOException, Exception {
        ArrayList<PersonVO> personDataList = new ArrayList<PersonVO>();
        FileInputStream fileInputStream = new FileInputStream(configuration.getFilePath());
        DataInputStream in = new DataInputStream(fileInputStream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = br.readLine()) != null) {
            //Pass the line to get the PersonVO object
            personDataList.add(getPersonData(line, configuration.getDelimiter()));
        }
        br.close();
        return personDataList;
    }

    /**
     * A line from the file is passed. This method will split it into tokens
     * based on the delimiter. A custom parser is invoked which will load the
     * PersonVO object and returns it
     * @param line    line being inspected for personVO
     * @param delimiter, delimiter that separates the person properties
     * @return           PersonVO object of the user properties
     * @throws Exception
     */
    private PersonVO getPersonData(String line, String delimiter) throws Exception {
        StringTokenizer personData = new StringTokenizer(line, delimiter);
        ArrayList<String> personDataList = new ArrayList<String>();
        // Create an arraylist of all the tokens
        while (personData.hasMoreTokens()) {
            personDataList.add(personData.nextToken());
        }
        // Send it to the custom parser to parse and populate the PersonVO object
        return parser.parse(personDataList);
    }

}
