package org.jz.persistence;

import org.jz.domain.CustomerId;

/**
 * @author Kristian Rosenvold
 */
public class DefaultAccountDao
    implements AccountDao
{
    public static CustomerId high_credit = new CustomerId( 3000 );

    @Override
    public int getCreditLimit( CustomerId customerId )
    {
        if ( customerId.equals( high_credit ) )
        {
            return 200000;
        }
        return 17;
    }

}
