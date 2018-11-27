package nobroker;

public class VendingMachineResponse
{
   private Product product;
   private int change;


    public VendingMachineResponse( Product product, int change )
    {
        this.product = product;
        this.change = change;
    }


    public Product getProduct()
    {
        return product;
    }


    public void setProduct( Product product )
    {
        this.product = product;
    }


    public int getChange()
    {
        return change;
    }


    public void setChange( int change )
    {
        this.change = change;
    }


    @Override public String toString()
    {
        return "VendingMachineResponse{" + "product=" + product + ", change=" + change + '}';
    }
}
