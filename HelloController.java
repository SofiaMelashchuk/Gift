package desing.lab_with_design;
import desing.lab_with_design.file.FileManager;
import desing.lab_with_design.gift.Gift;
import desing.lab_with_design.sweets.Candy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class HelloController {
    @FXML
    private Button createButton;
    @FXML
    private Button helpButton;
    @FXML
    private Button historyButton;
    @FXML
    private Button exitButton;
    @FXML
    private Button weightButton;
    private List<Candy> selectedCandies = new ArrayList<>();

    @FXML
    protected void onCreateButtonClick() {
        createButton.getScene().setRoot(createGiftView());
    }

    @FXML
    protected void onHelpButtonClick() {
        helpButton.getScene().setRoot(helpView());
    }

    @FXML
    protected void onHistoryButtonClick() {
        historyButton.getScene().setRoot(historyView());
    }
    @FXML
    protected void onWeightButtonClick() {
        weightButton.getScene().setRoot(weightView());
    }

    @FXML
    protected void onExitButtonClick() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
    protected VBox weightView() {
        VBox weightLayout = new VBox(20);
        weightLayout.setAlignment(Pos.CENTER);

        var weight = selectedCandies.stream()
                .map(Candy::getWeight)
                .reduce(Integer::sum)
                .orElse(0)
                .toString();

        Text weightText = new Text("Weight of your gift is " + weight + " grams!");
        weightText.setTextAlignment(TextAlignment.CENTER);
        weightText.setWrappingWidth(400);

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            backButton.getScene().setRoot(createButton.getParent());
        });

        weightLayout.getChildren().addAll(weightText, backButton);

        return weightLayout;
    }

    protected VBox helpView() {
        VBox helpLayout = new VBox(20);
        helpLayout.setAlignment(Pos.CENTER);
        BackgroundImage backgroundImage = new BackgroundImage(new Image("C:\\Users\\sofi9\\Desktop\\lab_with_design\\src\\main\\resources\\picture\\fon.png", true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Text helpText = new Text("""
                In this program you can create your NewYearGift
                Firstly you should choose candies and then program will show you
                candies sorted by price and weight of your gift! 
                Press Ctrl to choose candies. Follow hints on the display
                and do choice what you want to do next step. Have a tasty luck!"""
        );
        helpText.setTextAlignment(TextAlignment.CENTER);
        helpText.setWrappingWidth(400);

        helpLayout.setBackground(new Background(backgroundImage));

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            backButton.getScene().setRoot(createButton.getParent());
        });

        helpLayout.getChildren().addAll(helpText, backButton);

        return helpLayout;
    }

    protected VBox createGiftView() {
        VBox mainLayout = new VBox(20);
        mainLayout.setAlignment(Pos.CENTER);

        ObservableList<Candy> candyList = FXCollections.observableArrayList(Candy.getAvailableSweets());

        ListView<Candy> listView = new ListView<>();
        listView.getItems().addAll(candyList);

        Button selectButton = new Button("Select");
        Button backButton = new Button("Back");

        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        selectButton.setOnAction(e -> {
            List<Candy> selectedIndices = listView.getSelectionModel().getSelectedItems();

            selectedCandies = new ArrayList<>();
            selectedCandies.addAll(selectedIndices);

            Gift gift = new Gift();
            selectedCandies.forEach(gift::addCandy);

            FileManager.writeGiftToFile(gift);

            selectButton.getScene().setRoot(giftView());
        });

        backButton.setOnAction(e -> {
            backButton.getScene().setRoot(createButton.getParent());
        });

        mainLayout.getChildren().setAll(listView, selectButton, backButton);

        return mainLayout;
    }

    private VBox giftView() {
        VBox mainLayout = new VBox(20);
        mainLayout.setAlignment(Pos.CENTER);

        ObservableList<Candy> candyList = FXCollections.observableArrayList(selectedCandies);

        ListView<Candy> listView = new ListView<>();
        listView.getItems().addAll(candyList);

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> backButton.getScene().setRoot(createGiftView()));

        Button weightButton = new Button("Weight");
        weightButton.setOnAction(e -> weightButton.getScene().setRoot(weightView()));

        mainLayout.getChildren().setAll(listView, weightButton, backButton);

        return mainLayout;
    }

    private VBox historyView() {
        VBox mainLayout = new VBox(20);
        mainLayout.setAlignment(Pos.CENTER);

        ObservableList<Candy> candyList = FXCollections.observableArrayList(FileManager.getGiftFromFile().getCandies());

        if (candyList.isEmpty()) {
            Text emptyText = new Text("Your history is empty");
            emptyText.setWrappingWidth(280);
            emptyText.setTextAlignment(TextAlignment.CENTER);

            mainLayout.getChildren().add(emptyText);
        } else {
            ListView<Candy> listView = new ListView<>();
            listView.getItems().addAll(candyList);

            mainLayout.getChildren().add(listView);
        }

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> backButton.getScene().setRoot(createButton.getParent()));

        mainLayout.getChildren().add(backButton);

        return mainLayout;
    }
}