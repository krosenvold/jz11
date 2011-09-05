package org.jz.services;

import java.util.List;

import org.junit.Test;
import org.jz.domain.CustomerId;
import org.jz.domain.PersonCustomer;
import org.jz.domain.PersonName;
import org.jz.domain.Product;
import org.jz.persistence.PersonCustomerDao;
import org.jz.persistence.StubPersonCustomerDao;

import static junit.framework.Assert.assertEquals;

/**
 * @author Kristian Rosenvold
 */
public class OrderServiceTest
{
    private final InventoryService inventoryService = new InventoryService();

    private final AccountService accountService = new AccountService();

    PersonCustomerDao personCustomerDao = new StubPersonCustomerDao();

    private final CustomerService customerService = new CustomerService( personCustomerDao );

    @Test
    public void orderVeggies()
    {
        final List<PersonCustomer> customers =
            customerService.findCustomers( new PersonName( "Kristian", "Rosenvold" ) );
        PersonCustomer customer = customers.get( 0 );
        OrderService orderService =
            new OrderService( accountService, inventoryService, customerService );
        List<Product> products = inventoryService.findProductsByName( "Broccoli", "Carrot" );
        int max = accountService.getMaxItemsForOrder( customer.getCustomerId() );
        final List<Product> orderedProducts =
            orderService.orderItems( customer.getCustomerId(), products, max );
        assertEquals( 2, orderedProducts.size() );
    }


    public void testDelete()
    {
        customerService.deleteCustomer( new CustomerId( 124 ) );
    }
}
