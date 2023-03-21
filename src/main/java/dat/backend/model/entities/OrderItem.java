package dat.backend.model.entities;

public class OrderItem
{
    private Bottom bottom;
    private Top top;
    private int amount;


    public OrderItem(Bottom bottom, Top top, int amount)
    {
        this.bottom = bottom;
        this.top = top;
        this.amount = amount;
    }

    public Bottom getBottom()
    {
        return bottom;
    }

    public Top getTop()
    {
        return top;
    }

    public int getAmount()
    {
        return amount;
    }

    @Override
    public String toString()
    {
        return bottom.getName() + " + " + top.getName() + " Amount: " + amount;
    }
}
