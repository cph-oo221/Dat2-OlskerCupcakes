package dat.backend.model.entities;

import java.sql.Timestamp;
import java.util.Objects;

public class Receipt
{
    private int iduser;
    private Timestamp timeOfOrder;
    private Boolean completed;
    private int idReceipt;

    public Receipt(int idReceipt, int iduser, Timestamp timeOfOrder, Boolean completed) {
        this.idReceipt = idReceipt;
        this.iduser = iduser;
        this.timeOfOrder = timeOfOrder;
        this.completed = completed;
    }

    public Receipt(int iduser, boolean completed)
    {
        // TESTING CONSTRUCTOR
        this.iduser = iduser;
        this.completed = completed;
    }

    public int getiduser()
    {
        return iduser;
    }

    public Timestamp getTimeOfOrder()
    {
        return timeOfOrder;
    }

    public boolean getCompleted()
    {
        return completed;
    }

    public int getIdReceipt()
    {
        return idReceipt;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return Objects.equals(iduser, receipt.iduser) && Objects.equals(timeOfOrder, receipt.timeOfOrder) && Objects.equals(completed, receipt.completed);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(iduser, timeOfOrder, completed);
    }

    @Override
    public String toString()
    {
        return "Receipt{" +
                "iduser=" + iduser +
                ", timeOfOrder=" + timeOfOrder +
                ", completed=" + completed +
                ", idReceipt=" + idReceipt +
                '}';
    }
}
