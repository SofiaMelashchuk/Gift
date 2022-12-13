package desing.lab_with_design.sweets;

public class CandyFigure extends Candy {
    public enum Figure {
        snowMaiden,
        nicholas
    };
    Figure figure;
    public CandyFigure(String name, int weight, double sugar, double price, Figure figure) {
        super(name, weight, sugar, price);
        this.figure = figure;
    }
    @Override
    public String toString() {
        return super.toString() + ", Figure: " + figure;
    }
}
