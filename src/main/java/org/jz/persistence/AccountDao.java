package org.jz.persistence;

import org.jz.domain.CustomerId;

/**
 * @author Kristian Rosenvold
 */
public class AccountDao
{
    public static CustomerId high_credit = new CustomerId( 3000 );
    public int getCreditLimit( CustomerId customerId){
        if (customerId.equals( high_credit )){
            return 200000;
        }
        return 17;
    }

}
