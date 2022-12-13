package desing.lab_with_design.sweets;

public class CandyBubblegum extends Candy{
    public String color;

    public String getColor() {
       return color;
    }
    public void setColor(String color) {
       this.color = color;
    }
    public CandyBubblegum(String name, int weight, double sugar, double price, String color) {
        super(name, weight, sugar, price);
        this.color = color;
    }
    @Override
    public String toString() {
        return super.toString() + ", Color: " + color;
    }
}
