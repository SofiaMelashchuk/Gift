package desing.lab_with_design.sweets;

import desing.lab_with_design.database.DatabaseManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Candy implements Serializable {
    protected final String name;
    public int weight;
    protected double sugar;
    protected double price;

    public static List<Candy> getAvailableSweets() {

//        List<Candy> availableSweets = new ArrayList<>();
//        availableSweets.add(0, new CandyRaffaello("0. Raffaello", 5, 0.74, 8.5, true));
//        availableSweets.add(1, new CandyFerrero("1. Ferrero", 6, 0.85, 9, true));
//        availableSweets.add(2, new CandyWaffle("2. Jack Milk", 20, 0.8, 12, CandyWaffle.Chocolate.milk));
//        availableSweets.add(3, new CandyWaffle("3. Jack Dark", 20, 0.75, 12, CandyWaffle.Chocolate.dark));
//        availableSweets.add(4, new CandyFigure("4. Nicholas", 25, 0.67, 20, CandyFigure.Figure.nicholas));
//        availableSweets.add(5, new CandyFigure("5. Snow Maiden", 23, 0.69, 20, CandyFigure.Figure.snowMaiden));
//        availableSweets.add(6, new CandyLollipop("6. Chupachups Orange", 12, 0.9, 5, "orange"));
//        availableSweets.add(7, new CandyLollipop("7. Chupachups Cherry", 12, 0.95, 5, "cherry"));
//        availableSweets.add(8, new CandyBubblegum("8. Gum Berry", 5, 0.7, 3, "pink"));
//        availableSweets.add(9, new CandyBubblegum("9. Gum Mint", 5, 0.6, 3, "mint"));
        return DatabaseManager.getCandies();
    }
    @Override
    public String toString() {
        return "\nCandy: " + name + ", Weight: " + weight + ", Sugar: " + sugar + ", Price: " + price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) { this.weight = weight; }

    public double getSugar() {
        return sugar;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public Candy(String name, int weight, double sugar, double price) {
        this.name = name;
        this.weight = weight;
        this.sugar = sugar;
        this.price = price;
    }
}
