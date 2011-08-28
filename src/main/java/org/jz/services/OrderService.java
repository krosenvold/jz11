package org.jz.services;

/**
 * @author Kristian Rosenvold
 */
public class OrderService
{
    private final AccountService accountService;

    private final CustomerService customerService;

    public OrderService( AccountService accountService, CustomerService customerService )
    {
        this.accountService = accountService;
        this.customerService = customerService;
    }


}
