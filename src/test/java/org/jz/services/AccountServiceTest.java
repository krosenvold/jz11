package org.jz.services;

import org.junit.Test;
import org.jz.domain.CreditRanking;
import org.jz.domain.CustomerId;
import org.jz.domain.PersonCustomer;
import org.jz.domain.PersonName;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * @author Kristian Rosenvold
 */
public class AccountServiceTest
{
    private final AccountService accountService = new AccountService();
    private final CustomerId high_credit = new CustomerId( 3000 );
    private final CustomerService customerService = new CustomerService();


    private final CustomerId id = new CustomerId( 123 );


    @Test
    public void testGetCreditLimit()
    {
        final int creditLimit = accountService.getCreditLimit( id, 2000 );
        assertEquals( 17, creditLimit);
    }

    @Test
    public void testWithMax()
    {
        final int creditLimit = accountService.getCreditLimit( high_credit, 2000 );
        assertEquals( 2000, creditLimit);
    }


    @Test
    public void findCreditRanking(){
        final PersonCustomer customer = customerService.findCustomer( new PersonName( "Kristian", "Rosenvold" ) );
        final CreditRanking creditRanking = accountService.getCreditRanking( customer );
        assertTrue( creditRanking.hasCreditFor( 345f ) );

    }

}
