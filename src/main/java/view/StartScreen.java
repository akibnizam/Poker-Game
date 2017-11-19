package view;

import javafx.scene.layout.StackPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextInputDialog;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.util.Optional;


public class StartScreen extends StackPane {

    // Path to the image file for the background
    private static final String BACK_LOCATION = "File:./src/main/res"
        + "/poker-game-background.png";

    /**
     * StartScreen's constructor
     * @param cont The PokerGame to interact with
     */
    public StartScreen(PokerGame cont) {

        Image i = new Image(BACK_LOCATION);
        ImageView imgV = new ImageView(i);
        Button bt = new Button("Start New Game");
        VBox btBox = new VBox(20);
        btBox.getChildren().add(bt);
        btBox.setAlignment(Pos.BOTTOM_LEFT);
        btBox.setPadding(new Insets(80, 80, 80, 80));
        imgV.setFitHeight(500);
        imgV.setFitWidth(1000);

        getChildren().addAll(imgV, btBox);
        bt.setOnAction(e -> {
                TextInputDialog tt = new TextInputDialog();
                tt.setTitle("New Game");
                tt.setContentText("Enter your name: ");
                tt.setHeaderText("Confirmation");
                Optional<String> st = tt.showAndWait();
                if (st.isPresent()) {
                    cont.startGame(st.get());
                }
            });
    }

}
