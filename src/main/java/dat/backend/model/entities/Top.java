package dat.backend.model.entities;

public class Top
{
    private int idTop;
    private String name;
    private int price;

    public Top(int idTop, String name, int price)
    {
        this.idTop = idTop;
        this.name = name;
        this.price = price;
    }

    public int getIdTop()
    {
        return idTop;
    }

    public String getName()
    {
        return name;
    }

    public int getPrice()
    {
        return price;
    }
}
