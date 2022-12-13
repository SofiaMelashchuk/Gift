package desing.lab_with_design.file;
import desing.lab_with_design.gift.Gift;
import java.io.*;

public class FileManager {
    static String fileName = "gift.txt";

    public static void writeGiftToFile(Gift gift) {
        try {
            FileOutputStream fout = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fout);

            out.writeObject(gift);
            out.flush();
            out.close();
        } catch (IOException e) {
            System.out.print("Unable to write file: " + e.getLocalizedMessage());
        }
    }

    public static Gift getGiftFromFile() {
        Gift gift = new Gift();

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            gift = (Gift) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.print("You don't have any history.");
        }

        return gift;
    }
}

