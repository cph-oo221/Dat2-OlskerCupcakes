package dat.backend.model.entities;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bottom bottom = (Bottom) o;
        return idBottom == bottom.idBottom && price == bottom.price && Objects.equals(name, bottom.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBottom, name, price);
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
