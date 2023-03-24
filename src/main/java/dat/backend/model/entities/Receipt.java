package dat.backend.model.entities;

import java.sql.Timestamp;
import java.util.Objects;

public class Receipt
{
    private int iduser;
    private Timestamp timeOfOrder;
    private boolean complete;
    private int idReceipt;

    public Receipt(int idReceipt, int iduser, Timestamp timeOfOrder, Boolean complete) {
        this.idReceipt = idReceipt;
        this.iduser = iduser;
        this.timeOfOrder = timeOfOrder;
        this.complete = complete;
    }

    public Receipt(int iduser, boolean complete)
    {
        // TESTING CONSTRUCTOR
        this.iduser = iduser;
        this.complete = complete;
    }

    public int getiduser()
    {
        return iduser;
    }

    public Timestamp getTimeOfOrder()
    {
        return timeOfOrder;
    }

    public boolean getcomplete()
    {
        return complete;
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
        return Objects.equals(iduser, receipt.iduser) && Objects.equals(timeOfOrder, receipt.timeOfOrder) && Objects.equals(complete, receipt.complete);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(iduser, timeOfOrder, complete);
    }

    @Override
    public String toString()
    {
        return "Receipt{" +
                "iduser=" + iduser +
                ", timeOfOrder=" + timeOfOrder +
                ", complete=" + complete +
                ", idReceipt=" + idReceipt +
                '}';
    }
}
