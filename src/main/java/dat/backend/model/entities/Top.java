package dat.backend.model.entities;

import java.util.Objects;

public class Top {
    private int idTop;
    private String name;
    private int price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Top top = (Top) o;
        return idTop == top.idTop && price == top.price && Objects.equals(name, top.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTop, name, price);
    }

    public Top(int idTop, String name, int price)
    {
        this.idTop=idTop;
        this.name=name;
        this.price=price;
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
