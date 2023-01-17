import java.util.ArrayList;

public class BankProducts {
    private int code;
    private int number;
    private int afm;
    private ArrayList<BankProducts> bankProducts = new ArrayList<BankProducts>();
    private String type = null;
    private String describe = null;

    public BankProducts(int code, int number, int afm, String type, String describe) {
        this.code = code;
        this.number = number;
        this.afm = afm;
        this.type = type;
        this.describe = describe;

    }

    public BankProducts() {

    }

    public BankProducts(BankProducts source) {
        this.code = source.code;
        this.number = source.number;
        this.afm = source.afm;

    }

    public int getAfm() {
        return this.afm;
    }

    public int getCode() {
        return this.code;
    }

    public int getNumber() {
        return this.number;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setAfm(int afm) {
        this.afm = afm;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

}

