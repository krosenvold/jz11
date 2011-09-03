package org.jz.services;

import java.util.List;

import org.junit.Test;
import org.jz.domain.CreditRanking;
import org.jz.domain.CustomerId;
import org.jz.domain.PersonCustomer;
import org.jz.domain.PersonName;
import org.jz.persistence.PersonCustomerDao;
import org.jz.persistence.StubPersonCustomerDao;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * @author Kristian Rosenvold
 */
public class AccountServiceTest
{
    private final AccountService accountService = new AccountService();
    private final CustomerId high_credit = new CustomerId( 3000 );
    PersonCustomerDao personCustomerDao = new StubPersonCustomerDao();
    private final CustomerService customerService = new CustomerService( personCustomerDao );


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
        final List<PersonCustomer> customers = customerService.findCustomers(
            new PersonName( "Kristian", "Rosenvold" ) );
        final CreditRanking creditRanking = accountService.getCreditRanking( customers.get( 0) );
        assertTrue( creditRanking.hasCreditFor( 345f ) );

    }

}
