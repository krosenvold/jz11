package org.jz.domain;

/**
 * @author <a href="mailto:kristian@zenior.no">Kristian Rosenvold</a>
 */
public class CustomerId
{

    private final int id;

    public CustomerId( int id )
    {
        this.id = id;
    }

    @Override
    public boolean equals( Object o )
    {
        if ( this == o )
        {
            return true;
        }
        if ( o == null || getClass() != o.getClass() )
        {
            return false;
        }

        CustomerId that = (CustomerId) o;

        if ( id != that.id )
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        return id;
    }

    public int getId()
    {
        return id;
    }
}
