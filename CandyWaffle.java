package desing.lab_with_design.sweets;

public class CandyWaffle extends Candy{
    public enum Chocolate {
        dark,
        milk
    };
    Chocolate chocolate;
    public CandyWaffle(String name, int weight, double sugar, double price, Chocolate chocolate) {
        super(name, weight, sugar, price);
        this.chocolate = chocolate;
    }
    @Override
    public String toString() {
        return super.toString() + ", Chocolate: " + chocolate;
    }
}
