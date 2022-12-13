package desing.lab_with_design.sweets;

public class CandyFerrero extends Candy {
    public boolean isNuts;
    public CandyFerrero(String name, int weight, double sugar, double price, boolean isNuts) {
        super(name, weight, sugar, price);
        this.isNuts = isNuts;
    }
    public void setNuts(boolean nuts) {
        isNuts = nuts;
    }
    public void getNuts() {
        if(isNuts)
            System.out.println("nuts are inside");
        else
            System.out.println("nuts are not inside(((");
    }
    @Override
    public String toString() {
        return super.toString() + ", Nuts inside: " + isNuts;
    }
}
