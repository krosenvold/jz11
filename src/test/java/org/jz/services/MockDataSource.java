package org.jz.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Kristian Rosenvold
 */
public class MockDataSource
{
    static DataSource createDatasourceMock()
    {
        try
        {
            ResultSet resultSet = mock( ResultSet.class );
            when( resultSet.next() ).thenReturn( true );
            when( resultSet.getInt( 1 )).thenReturn( 234 );
            when( resultSet.getString( 2 ) ).thenReturn( "Kristian" );
            when( resultSet.getString( 3 ) ).thenReturn( "Rosenvold" );
            final PreparedStatement statement = mock( PreparedStatement.class );
            when( statement.executeQuery() ).thenReturn( resultSet );
            Connection conn = mock( Connection.class );
            when( conn.prepareStatement( anyString() ) ).thenReturn( statement );
            final DataSource mock = mock( DataSource.class );
            when( mock.getConnection() ).thenReturn( conn );
            return mock;
        }
        catch ( SQLException e )
        {
            throw new RuntimeException(  e );
        }
    }
}
