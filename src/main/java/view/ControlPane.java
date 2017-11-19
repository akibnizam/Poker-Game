package view;

import javafx.scene.layout.HBox;
import viewcontroller.PokerGameController;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.geometry.Pos;


public class ControlPane extends HBox {

    private PokerGameController cont;
    private Button startNewb;
    private Button raiseb;
    private Button callb;
    private Button foldb;
    private TextField text;

    /**
     * Constructor for ControlPane
     * @param  cont The PokerGameController to interact with
     */
    public ControlPane(PokerGameController cont) {
        this.cont = cont;


        text = new TextField();
        startNewb = new Button("Start New Game");
        raiseb = new Button("Raise");
        callb = new Button("Call");
        foldb = new Button("Fold");

        raiseb.setOnAction(e -> {
                int amount = Integer.parseInt(text.getText());
                cont.humanBet(amount);
            });

        callb.setOnAction(e -> {
                cont.humanCall();
            });

        foldb.setOnAction(e -> {
                cont.humanFold();
            });


        startNewb.setOnAction(e -> {
                cont.startNewPokerHand();
                startNewb.setVisible(false);
            });
        startNewb.setVisible(false);
        this.getChildren().addAll(text, raiseb, callb, foldb, startNewb);
        setAlignment(Pos.CENTER);
    }

    /**
     * Called whenever it becomes the player's turn again
     */
    public void playerTurn() {

        raiseb.setDisable(false);
        callb.setDisable(false);
        foldb.setDisable(false);
    }

    /**
     * Called whenever it is not player's turn again
     */
    public void notTurn() {
        raiseb.setDisable(true);
        callb.setDisable(true);
        foldb.setDisable(true);
    }

    /**
     * Method called when the round ends.
     */
    public void endOfRound() {


            // getChildren().add(startNewb);
        raiseb.setDisable(true);
        callb.setDisable(true);
        foldb.setDisable(true);
        startNewb.setVisible(true);

    }

}
