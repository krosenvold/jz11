package org.jz.services;

/**
 * @author Kristian Rosenvold
 */
public class OrderServiceTest
{
    private final InventoryService inventoryService = new InventoryService();
    private final AccountService accountService = new AccountService();

    public void orderItems(){

        OrderService orderService = new OrderService(accountService, inventoryService);

    }
}
