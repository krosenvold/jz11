package org.jz.domain;

/**
 * @author Kristian Rosenvold
 */
public class PersonName
{
    private final String firstName;

    private final String lastName;

    public PersonName( String firstName, String lastName )
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getFullName()
    {
        return firstName + " " + lastName;
    }
}
