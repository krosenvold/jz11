package org.jz.services;

import org.jz.domain.CustomerId;
import org.jz.domain.Order;
import org.jz.domain.Product;
import org.jz.persistence.AccountDao;

/**
 * @author Kristian Rosenvold
 */
public class AccountService {

    private final AccountDao accountDao = new AccountDao();

    public Order createOrder(CustomerId authenticatedCustomer) {
        return null;
    }

    public void orderItem(Order order, Product product) {
    }

    public int getMaxItemsForOrder( CustomerId customerId )
    {
        return 17;
    }

    public int getCreditLimit( CustomerId Id, int systemMaxCredit){
        final int creditLimit = accountDao.getCreditLimit( Id );
        return creditLimit > systemMaxCredit ? systemMaxCredit : creditLimit;
    }
}
