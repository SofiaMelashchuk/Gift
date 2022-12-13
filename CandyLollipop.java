package desing.lab_with_design.sweets;

public class CandyLollipop extends Candy {
    public String favour;

    public String getFavour() {
        return favour;
    }

    public void setFavour(String favour) {
        this.favour = favour;
    }

    public CandyLollipop(String name, int weight, double sugar, double price, String favour) {
        super(name, weight, sugar, price);
        this.favour = favour;
    }

    @Override
    public String toString() {
        return super.toString() + ", Favour: " + favour;
    }
}
