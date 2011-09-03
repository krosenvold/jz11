package org.jz.domain;

/**
 * @author Kristian Rosenvold
 */
public class Address
{
    private final int postalCode;

    public Address( int postalCode )
    {
        this.postalCode = postalCode;
    }

    public int getPostalCode()
    {
        return postalCode;
    }
}
