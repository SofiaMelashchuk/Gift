package desing.lab_with_design.gift;
import desing.lab_with_design.sweets.Candy;
import java.util.*;
import java.io.Serializable;

public class Gift implements Serializable {
    List<Candy> candies = new ArrayList<>();
    public void addCandy(Candy candy) {
        candies.add(candy);
    }
    public List<Candy> getCandies() {
        return candies;
    }
}



















//    public enum FormingGift {
//        addToGift("1"),
//        removeFromGift("2"),
//        changeCount("3");
//        private final String forming;
//        FormingGift(String s) {
//            forming = s;
//        }
//    }
//    FormingGift forming;
//
//    public Gift(FormingGift forming) {
//        this.forming = forming;
//    }

//}
