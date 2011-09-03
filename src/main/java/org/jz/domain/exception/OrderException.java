package org.jz.domain.exception;

/**
 * @author Kristian Rosenvold
 */
public class OrderException  extends RuntimeException
{
    public OrderException( String message )
    {
        super( message );
    }
}
