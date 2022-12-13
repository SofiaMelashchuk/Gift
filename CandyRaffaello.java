package desing.lab_with_design.sweets;

public class CandyRaffaello extends Candy {
    public boolean isCoconut;
    public CandyRaffaello(String name, int weight, double sugar, double price, boolean isCoconut) {
        super(name, weight, sugar, price);
        this.isCoconut = isCoconut;
    }
    public void setCoconut(boolean coconut) {
        isCoconut = coconut;
    }
    public void getCoconut() {
        if(isCoconut)
            System.out.println("coconut is inside");
        else
            System.out.println("coconut is not inside(((");
    }
    @Override
    public String toString() {
        return super.toString() + ", Coconut inside: " + isCoconut;
    }
}
