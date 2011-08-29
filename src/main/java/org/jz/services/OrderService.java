package org.jz.services;

import org.jz.domain.CustomerId;
import org.jz.domain.Order;
import org.jz.domain.Product;

import java.util.List;

/**
 * @author Kristian Rosenvold
 */
public class OrderService
{
    private final AccountService accountService;

    private final InventoryService inventoryService;

    public OrderService(AccountService accountService, InventoryService inventoryService)
    {
        this.accountService = accountService;
        this.inventoryService = inventoryService;
    }

    public void orderItems(CustomerId authenticatedCustomer, List<Product> products){
        final Order order = accountService.createOrder(authenticatedCustomer);
        for (Product product : products) {
            inventoryService.remove( product);
            accountService.orderItem( order, product);
        }
    }
}
