package view;

import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import model.Board;
import model.Card;
import javafx.geometry.Pos;


public class BoardArea {

    private HBox pane;

    private Board board;

    private CardView[] cardVs = new CardView[5];

    private Label labelpot;

    /**
     * Constructor for the board's display
     * @param  board The Board object that contains data associated with the
     * board
     */
    public BoardArea(Board board) {
        this.board = board;


        pane = new HBox(20);
        cardVs[0] = new CardView();
        cardVs[1] = new CardView();
        cardVs[2] = new CardView();
        cardVs[3] = new CardView();
        cardVs[4] = new CardView();
        for (CardView cardV : cardVs) {
            pane.getChildren().add(cardV);
            cardV.hide();
        }

        String pot = Integer.toString(board.getPot());
        Label pp = new Label("Pot: ");
        HBox hbox = new HBox();
        labelpot = new Label(pot);
        hbox.getChildren().addAll(pp, labelpot);
        pane.getChildren().add(hbox);
        pane.setAlignment(Pos.CENTER);
    }

    /**
     * Getter for the HBox that all UI elements are on
     * @return the HBox that all Board UI elements are on
     */
    public HBox getPane() {
        return pane;
    }

    /**
     * Updates UI elements
     */
    public void update() {

        String potn = Integer.toString(board.getPot());
        labelpot.setText(potn);
        int numCards = board.getNumCards();
        Card[] cards = board.getCards();
        for (int i = 0; i < cards.length; i++) {
            cardVs[i].setCard(cards[i]);
        }
        // board.startNewPokerHand();

        // cards
        // board.placeCards();
        for (int i = 0; i < numCards; i++) {
            cardVs[i].setVisible(true);
        }
        for (int i = numCards; i < 5; i++) {
            cardVs[i].setVisible(false);
        }

    }

}
