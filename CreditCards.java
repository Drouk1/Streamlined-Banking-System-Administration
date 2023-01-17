import java.util.HashMap;

public class CreditCards extends BankProducts {
    private double commissionRate;
    private double maxAmountOfMovement;
    private double maxAnnualAmmount;
    int cards_num = 0;

    public CreditCards(int code, int number, int afm, String type, String describe, double commissionRate,
            double maxAmountOfMovement, double maxAnnualAmmount) {
        super(code, number, afm, type, describe);
        this.commissionRate = commissionRate;
        this.maxAmountOfMovement = maxAmountOfMovement;
        this.maxAnnualAmmount = maxAnnualAmmount;
    }

    public CreditCards() {

    }

    HashMap<Integer, CreditCards> CreditCardMap = new HashMap<Integer, CreditCards>();

    void addCreditCards(CreditCards info) {
        CreditCardMap.put(getCode(), info);
        cards_num++;
    }

    public String toString() {
        return "Code: " + getCode() + "\nNumber: " + getNumber() + "\nAFM: " + getAfm() + "\nCommision Rate: "
                + this.commissionRate + "\nMax amount of movement: " + this.maxAmountOfMovement
                + "\nMax annual ammount: " + this.maxAnnualAmmount;
    }

    public void ainTA2() {
        System.out.println(CreditCardMap);
    }

    public double getmaxAmountOfMovement() {
        return this.maxAmountOfMovement;
    }

    public double getmaxAnnualAmmount() {
        return this.maxAnnualAmmount;
    }

    public double getCommisionRate() {
        return this.commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public void setMaxAmountOfMovement(double maxAmountOfMovement) {
        this.maxAmountOfMovement = maxAmountOfMovement;
    }

    public void setMaxAnnualAmmount(double maxAnnualAmmount) {
        this.maxAnnualAmmount = maxAnnualAmmount;
    }

}