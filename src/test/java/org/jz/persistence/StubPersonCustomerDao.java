package org.jz.persistence;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.jz.domain.CustomerId;
import org.jz.domain.PersonCustomer;
import org.jz.domain.PersonName;
import org.jz.services.CustomerServiceTest;

/**
 * @author Kristian Rosenvold
 */
public class StubPersonCustomerDao
    implements PersonCustomerDao
{
    @Override
    public PersonCustomer getPersonCustomer( CustomerId customerId )
        throws SQLException
    {
        if ( customerId.equals( CustomerServiceTest.deletePassivated ) )
        {
            return null;
        }
        return new PersonCustomer( new PersonName( "Freddy", "Stub" ), customerId );
    }

    @Override
    public List<PersonCustomer> findPersonCustomers( PersonName personName )
    {
        return Arrays.asList(
            new PersonCustomer( personName, new CustomerId( personName.hashCode() ) ) );
    }

    @Override
    public void deleteCustomer( CustomerId customerId )
    {
    }

    @Override
    public void passivateCustomer( CustomerId customerId )
    {
    }

    @Override
    public void createPersonCustomer( PersonName personName )
    {
    }
}
