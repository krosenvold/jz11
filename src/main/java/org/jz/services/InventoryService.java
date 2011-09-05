package org.jz.services;

import java.util.ArrayList;
import java.util.List;

import org.jz.domain.Product;

/**
 * @author <a href="mailto:kristian@zenior.no">Kristian Rosenvold</a>
 */
public class InventoryService
{
    public void remove( Product product )
    {
    }

    public List<Product> findProductsByName( String... productNames )
    {
        List<Product> result = new ArrayList<Product>();
        for ( String productName : productNames )
        {
            result.add( new Product( productName ) );
        }
        return result;
    }
}
