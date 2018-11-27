package nobroker;

public class VendingMachine
{
    private int coin;
    private int value ;

    public int getCoin()
    {
        return coin;
    }


    public void setCoin( int coin ) throws Exception
    {
        if( coin != 1 || coin != 5 || coin != 10 || coin != 25)
            throw new Exception("Please insert either 1, 5, 10 or 25 cents");
        else {
            this.coin = coin;
            this.value += coin;
        }

    }

    public VendingMachineResponse buy(Product product, int[] coins ) throws Exception
    {
        for(int coin : coins){
            this.setCoin( coin );
        }

        if(product.getCost() - this.value > 0)
            throw new Exception(" Insufficient amount ");
        else return new VendingMachineResponse(product, (this.value - product.getCost()));
    }



}
