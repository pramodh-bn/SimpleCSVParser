package com.xyz.app.parse;

import com.xyz.app.data.PersonVO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Custom parser for the Space( ) separated data in the following format
 * is loaded into an arraylist and passed here.
 * LastName FirstName MiddleInitial Gender DateOfBirth FavoriteColor
 */
public class SpaceCustomParser implements ICustomParser {
    /**
     * Custom parser for the Space( ) separated data in the following format
     * is loaded into an arraylist and passed here.
     * LastName FirstName MiddleInitial Gender DateOfBirth FavoriteColor
     * @param personData A list of properties of a person
     * @return
     * @throws ParseException
     */

    @Override
    public PersonVO parse(ArrayList<String> personData) throws ParseException {
        return new PersonVO(personData.get(0).trim(), personData.get(1).trim(), personData.get(3).trim().substring(0, 1), (new SimpleDateFormat("MM-dd-yyyy")).parse(personData.get(4).trim()), personData.get(5).trim(), personData.get(2).trim());
    }
}
