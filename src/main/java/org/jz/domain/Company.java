package org.jz.domain;

/**
 * @author Kristian Rosenvold
 */
public class Company
{
    private final String name;
    private final int foretaksnummer;


    public Company( String name, int foretaksnummer )
    {
        this.name = name;
        this.foretaksnummer = foretaksnummer;
    }

    public String getName()
    {
        return name;
    }

    public int getForetaksnummer()
    {
        return foretaksnummer;
    }
}

