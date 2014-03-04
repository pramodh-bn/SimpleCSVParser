package com.xyz.app.data;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 * A value object which holds the information about
 * a person found in the files
 */
public class PersonVO implements Comparable<PersonVO> {
    private String firstName;
    private String lastName;
    private String gender;
    private Date dateOfBirth;
    private String color;
    private String middleInitial;

    public PersonVO(String lastName, String firstName, String gender, Date dateOfBirth, String color, String middleInitial) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.color = color;
        this.middleInitial = middleInitial;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getColor() {
        return color;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    /**
     * @return String representation according to the format Last Name, First Name, Gender, Date Of Birth, Favorite Color
     */
    @Override
    public String toString() {
        return getLastName().trim() + " " + getFirstName().trim() + " " + getGenderFull().trim() + " " + getDateOfBirthString() + " " + getColor().trim();
    }

    @Override
    public int compareTo(PersonVO other) {
        return other.getLastName().compareTo(this.getLastName());
    }

    /**
     * @return gender string Male or Female based on value of gender
     *
     */
    private String getGenderFull() {
        if (gender.equalsIgnoreCase("F"))
            return "Female";
        else
            return "Male";
    }

    /**
     * @return date of birth in the format M/d/yyyy
     */
    private String getDateOfBirthString() {
        return new SimpleDateFormat("M/d/yyyy").format(dateOfBirth);
    }

    /**
     * Custom comparator for ordering based on Date of Birth
     */
    public static Comparator<PersonVO> PersonDateOfBirthComparator = new Comparator<PersonVO>() {
        @Override
        public int compare(PersonVO person1, PersonVO person2) {
            return person1.getDateOfBirth().compareTo(person2.getDateOfBirth());
        }
    };

    /**
     * Custom comparator for ordering based on Gender and Last Name
     */
    public static Comparator<PersonVO> PersonGenderComparator = new Comparator<PersonVO>() {
        @Override
        public int compare(PersonVO person1, PersonVO person2) {
            int comp = person1.getGender().compareTo(person2.getGender());
            if (comp == 0) {
                return person1.getLastName().compareTo(person2.getLastName());
            }
            return comp;
        }
    };

}
