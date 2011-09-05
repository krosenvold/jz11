package org.jz.domain;

/**
 * @author <a href="mailto:kristian@zenior.no">Kristian Rosenvold</a>
 */
public class Product
{
    private final String productName;

    public Product( String productName )
    {
        this.productName = productName;
    }

    public String getProductName()
    {
        return productName;
    }
}
