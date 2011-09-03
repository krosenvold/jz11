package org.jz.domain;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Kristian Rosenvold
 */
public class AddressTest
{
    @Test
    public void testGetPostalCode()
        throws Exception
    {
        Address address = new Address( 1200 );
        assertEquals( 1200, address.getPostalCode() );
    }
}
