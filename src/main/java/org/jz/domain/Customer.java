package org.jz.domain;

/**
 * @author Kristian Rosenvold
 */
public abstract class Customer
{
    private final CustomerId customerId;

    protected Customer( CustomerId customerId )
    {
        this.customerId = customerId;
    }

    public boolean isCompanyCustomer(){
        return this instanceof  CompanyCustomer;
    }

    public boolean isPersonCustomer(){
        return this instanceof  PersonCustomer;
    }

    public CustomerId getCustomerId()
    {
        return customerId;
    }

    public abstract String getDisplayName();
}
