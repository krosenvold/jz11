package org.jz.persistence;

import org.jz.domain.CustomerId;

/**
 * @author Kristian Rosenvold
 */
public class StubAccountDao implements AccountDao
{
    @Override
    public int getCreditLimit( CustomerId customerId )
    {
        return 10000;
    }
}
