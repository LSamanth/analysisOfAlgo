package nobroker;

public enum Product
{
    Coke(25), Pepsi(35), Soda(45);

    private int cost;

    Product( int cost )
    {
        this.cost = cost;
    }

    public int getCost()
    {
        return cost;
    }

}
