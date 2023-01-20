public class CreditCardMovement {
    private int code;
    private double movementWorth;
    private String reason;
    private int emplCode;

    // Constructor

    public CreditCardMovement(int code, Double movementWorth, String reason, int emplCode) {
        this.code = code;
        this.movementWorth = movementWorth;
        this.emplCode = emplCode;
        this.reason = reason;
    }

    public CreditCardMovement() {

    }

    // Getters

    public int getCode() {
        return this.code;
    }

    public double getMovementWorth() {
        return this.movementWorth;
    }

    public String getReason() {
        return this.reason;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setEmplCode(int emplCode) {
        this.emplCode = emplCode;
    }

    public void setMovementWorth(double movementWorth) {
        this.movementWorth = movementWorth;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    // Copy Constructor

    public CreditCardMovement(CreditCardMovement source) {
        this.code = source.code;
        this.movementWorth = source.movementWorth;
        this.reason = source.reason;
    }

    public String toString() {
        return "Code: " + getCode() + "\nMovement worth: " + getMovementWorth() + "\nReason: " + getReason();
    }
}
