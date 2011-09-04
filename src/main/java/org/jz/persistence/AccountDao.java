package org.jz.persistence;

import org.jz.domain.CustomerId;

/**
 * @author Kristian Rosenvold
 */
public interface AccountDao
{
    int getCreditLimit( CustomerId customerId );
}
