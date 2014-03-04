package com.xyz.app.control;

import com.xyz.app.config.ConfigLoader;
import com.xyz.app.config.Configuration;
import com.xyz.app.data.PersonVO;
import com.xyz.app.parse.BaseParser;
import com.xyz.app.parse.CustomParserFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The Controller class loads the configuration from config.properties
 * located in the root of the application.
 * Based on the configuration it will create parsers
 * and appropriate custom parsers and gets the person data
 * from the main parser.
 */
public class Controller {
    /**
     * This method will load the configuration from the config.properties
     * file and creates parsers based on the configuration information
     * @throws IOException
     * @throws Exception
     */
    public static void doTheJob() throws IOException, Exception {
        ArrayList<PersonVO> persons = new ArrayList<PersonVO>();
        for (Configuration config : ConfigLoader.loadConfiguration()) {
            // Based on the each configuration inject the custom parser to the base parser
            // Add the returned lists to persons list
            persons.addAll(new BaseParser(config, CustomParserFactory.getInstance().getParser(config)).getPersonDataList());
        }
        System.out.println("Output 1:");
        // Sort based on Gender and Last Name
        Collections.sort(persons, PersonVO.PersonGenderComparator);
        for (PersonVO person : persons) {
            System.out.println(person);
        }
        System.out.println("\nOutput 2:");
        // Sort based on Date of Birth
        Collections.sort(persons, PersonVO.PersonDateOfBirthComparator);
        for (PersonVO person : persons) {
            System.out.println(person);
        }
        System.out.println("\nOutput 3:");
        //sort based on descending order of Last Name
        Collections.sort(persons);
        for (PersonVO person : persons) {
            System.out.println(person);
        }
    }


}
