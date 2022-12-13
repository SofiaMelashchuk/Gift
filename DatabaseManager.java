package desing.lab_with_design.database;
import desing.lab_with_design.sweets.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    static public List<Candy> getCandies() {
        Connection connection = getConnection();

        if (connection == null) {
            System.out.println("Can't establish connection to DB");
            return List.of();
        }

        try {
            Statement statement = connection.createStatement();
            ResultSet candiesResult = statement.executeQuery("SELECT * FROM Candy.Candy ORDER BY price DESC");
            List<Candy> preparedCandies = new ArrayList<>();
            while (candiesResult.next()) {
                Candy candy = getCandyFromResult(candiesResult);

                if (candy != null) {
                    preparedCandies.add(candy);
                }
            }

            return preparedCandies;
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    static Candy getCandyFromResult(ResultSet candiesResult) throws SQLException {
        String name = candiesResult.getString("name");
        int weight = candiesResult.getInt("weight");
        double sugar = candiesResult.getDouble("sugar");
        double price = candiesResult.getDouble("price");
        int type = candiesResult.getInt("type");

        switch (type) {
            case 0 -> {
                boolean hasCoconut = candiesResult.getBoolean("hasCoconut");
                return new CandyRaffaello(name, weight, sugar, price, hasCoconut);
            }
            case 1 -> {
                boolean hasNuts = candiesResult.getBoolean("hasNuts");
                return new CandyFerrero(name, weight, sugar, price, hasNuts);
            }
            case 2 -> {
                String chocolate = candiesResult.getString("chocolate");
                return new CandyWaffle(
                        name, weight, sugar, price,
                        Enum.valueOf(CandyWaffle.Chocolate.class, chocolate)
                );
            }
            case 3 -> {
                String figure = candiesResult.getString("figure");
                return new CandyFigure(
                        name, weight, sugar, price,
                        Enum.valueOf(CandyFigure.Figure.class, figure)
                );
            }
            case 4 -> {
                String favour = candiesResult.getString("favour");
                return new CandyLollipop(name, weight, sugar, price, favour);
            }
            case 5 -> {
                String color = candiesResult.getString("color");
                return new CandyBubblegum(name, weight, sugar, price, color);
            }
            default -> {
                return null;
            }
        }
    }
    static private Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306",
                    "root",
                    "2004"
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
