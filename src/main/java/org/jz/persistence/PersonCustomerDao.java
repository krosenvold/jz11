package org.jz.persistence;

import java.sql.SQLException;
import java.util.List;

import org.jz.domain.CustomerId;
import org.jz.domain.PersonCustomer;
import org.jz.domain.PersonName;

/**
 * @author Kristian Rosenvold
 */
public interface PersonCustomerDao
{
    PersonCustomer getPersonCustomer( CustomerId customerId )
        throws SQLException;

    List<PersonCustomer> findPersonCustomers( PersonName personName );

    void deleteCustomer( CustomerId customerId );

    void passivateCustomer( CustomerId customerId );

    void createPersonCustomer( PersonName personName);
}
