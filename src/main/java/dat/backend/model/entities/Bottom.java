package dat.backend.model.entities;

public class Bottom
{
    private int idBottom;
    private String name;
    private int price;

    public Bottom(int idBottom, String name, int price)
    {
        this.idBottom = idBottom;
        this.name = name;
        this.price = price;
    }

    public int getIdBottom()
    {
        return idBottom;
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
