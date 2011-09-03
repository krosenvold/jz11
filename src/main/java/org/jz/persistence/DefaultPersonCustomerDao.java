package org.jz.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.jz.domain.CustomerId;
import org.jz.domain.PersonCustomer;
import org.jz.domain.PersonName;

/**
 * @author Kristian Rosenvold
 */
public class DefaultPersonCustomerDao
    implements PersonCustomerDao
{
    private final DataSource dataSource;

    public DefaultPersonCustomerDao( DataSource dataSource )
    {
        this.dataSource = dataSource;
    }

    @Override
    public PersonCustomer getPersonCustomer( CustomerId customerId )
        throws SQLException
    {
        final Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement( "SELECT firstname, lastname from CUSTOMER WHERE CUSTOMERID=?" );
        stmt.setInt( 1, customerId.getId() );

        ResultSet rs = stmt.executeQuery();
        if ( rs.next() )
        {
            final String firstName = rs.getString( 1 );
            final String lastName = rs.getString( 2 );
            final PersonCustomer personCustomer =
                new PersonCustomer( new PersonName( firstName, lastName ), customerId );
            if ( rs.next() )
            {
                throw new IllegalStateException( "There are multiple customers for id " + customerId.getId() );
            }
            return personCustomer;
        }
        return null;

    }

    @Override
    public void createPersonCustomer( PersonName personName )
    {
        try
        {
            final Connection conn = getConnection();
            PreparedStatement stmt =
                conn.prepareStatement( "insert into CUSTOMER  (firstname, lastname) VALUES (?,?)" );
            stmt.setString( 1, personName.getFirstName() );
            stmt.setString( 2, personName.getLastName() );
            stmt.executeUpdate();
        }
        catch ( SQLException e )
        {
            throw new RuntimeException( e );
        }

    }

    public Connection getConnection()
        throws SQLException
    {
        return dataSource.getConnection();
    }


    @Override
    public List<PersonCustomer> findPersonCustomers( PersonName personName )
    {

        final Connection conn;
        try
        {
            List<PersonCustomer> result = new ArrayList<PersonCustomer>();
            conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                "SELECT CUSTOMERID,FIRSTNAME, LASTNAME from CUSTOMER WHERE FIRSTNAME LIKE ? and LASTNAME LIKE ?" );
            stmt.setString( 1, personName.getFirstName() );
            stmt.setString( 2, personName.getLastName() );

            ResultSet rs = stmt.executeQuery();
            while ( rs.next() )
            {
                final int id = rs.getInt( 1 );
                final String firstName = rs.getString( 2 );
                final String lastName = rs.getString( 3 );
                CustomerId customerId = new CustomerId( id );
                final PersonCustomer personCustomer =
                    new PersonCustomer( new PersonName( firstName, lastName ), customerId );
                result.add( personCustomer );
            }
            return result;
        }
        catch ( SQLException e )
        {
            throw new RuntimeException( e );
        }
    }

    @Override
    public void deleteCustomer( CustomerId customerId )
    {

        final Connection conn;
        try
        {
            conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement( "DELETE from CUSTOMER WHERE CUSTOMERID=?" );
            stmt.setInt( 1, customerId.getId() );
            stmt.executeUpdate();
        }
        catch ( SQLException e )
        {
            throw new RuntimeException( e );
        }
    }

    @Override
    public void passivateCustomer( CustomerId customerId )
    {
        final Connection conn;
        try
        {
            conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement( "UPDATE CUSTOMER SET PASSIVE=1 WHERE CUSTOMERID=?" );
            stmt.setInt( 1, customerId.getId() );
            stmt.executeUpdate();
        }
        catch ( SQLException e )
        {
            throw new RuntimeException( e );
        }
    }

}
