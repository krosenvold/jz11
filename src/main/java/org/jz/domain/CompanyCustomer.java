package org.jz.domain;

/**
 * @author Kristian Rosenvold
 */
public class CompanyCustomer extends Customer {
    private final Company company;

    public CompanyCustomer(Company company, CustomerId customerId)
    {
        super( customerId );
        this.company = company;
    }

    @Override
    public String getDisplayName()
    {
        return company.getName();
    }
}
