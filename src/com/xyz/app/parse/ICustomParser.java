package com.xyz.app.parse;

import com.xyz.app.data.PersonVO;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * Interface for a custom parser. It would be implemented by all the Custom parsers
 */
public interface ICustomParser {
    /**
     * parse method will be implemented by all the custom parsers
     * @param personData A list of properties of a person
     * @return           populated PersonVO object
     * @throws ParseException
     */
    public PersonVO parse(ArrayList<String> personData) throws ParseException;
}
