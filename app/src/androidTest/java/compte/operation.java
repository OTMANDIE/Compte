package compte;

import java.util.Date;

public abstract class operation {
    private int nombreOperation;
    private Date date;
    private String operation;
    private double mt;

    public operation(Date date, String operation, double mt) {
        this.nombreOperation = this.nombreOperation + 1;
        this.date = date;
        this.operation = operation;
        this.mt = mt;
    }

    public int getNombreOperation() {
        return nombreOperation;
    }

    public Date getDate() {
        return date;
    }

    public String getOperation() {
        return operation;
    }

    public double getMt() {
        return mt;
    }

}