package org.jz.domain;

/**
 * @author Kristian Rosenvold
 */
public class CreditRanking
{

    public boolean hasCreditFor(float amount){
        return true;
    }
    public static CreditRanking forPrivateCustomers(){
        return new CreditRanking();
    }

    public static CreditRanking forCompanyCustomer(String ranking){
        return new CreditRanking();
    }
}
