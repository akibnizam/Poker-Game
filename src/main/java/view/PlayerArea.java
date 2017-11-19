package view;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import model.Player;


public abstract class PlayerArea {

    private Pane pane;

    private Player player;

    private CardView[] cards = new CardView[2];

    private VBox vbox = new VBox(10);

    private HBox hbox = new HBox();

    private Label[] chips = new Label[2];

    private Label name;

    private Label outPlay;

    /**
     * PlayerArea's constructor
     * @param  pane   The Pane where all UI elements will be added. The type of
     * pane is decided by subclasses
     * @param  player The Player who's information will be tracked
     */
    public PlayerArea(Pane pane, Player player) {
        this.pane = pane;
        this.player = player;

        cards[0] = new CardView();
        cards[1] = new CardView();
        vbox = new VBox(5);
        String money = Integer.toString(player.getMoney());
        name = new Label(player.toString());
        chips[0] = new Label("Chips: ");
        chips[1] = new Label(money);
        hbox.getChildren().addAll(chips[0], chips[1]);
        String outPlayStr = player.getOutOfPlay() ? "Out of Play" : "";
        outPlay = new Label(outPlayStr);

        pane.getChildren().addAll(cards[0], cards[1], name, hbox);

    }

    /**
     * Getter for the Pane that contains all of the UI elements.
     * @return The Pane that contains all of the UI elements.
     */
    public Pane playerPane() {
        return pane;
    }

    /**
     * This method is called whenever an update to the UI needs to be made.
     * @param showDetails is true whenever the details of the front of the
     * cards are supposed to be shown false otherwise
     */
    public void update(boolean showDetails) {

        if (player.getCard(0) != null) {
            cards[0].setCard(player.getCard(0));
        }
        if (player.getCard(1) != null) {
            cards[1].setCard(player.getCard(1));
        }
        chips[1].setText(Integer.toString(player.getMoney()));
        if (player.getOutOfPlay()) {
            outPlay.setText("Out of Play");
            for (CardView card : cards) {
                card.hide();
            }
        } else {
            outPlay.setText("");
        }

        if (showDetails) {
            for (CardView card : cards) {
                card.show();
            }
        } else {
            for (CardView card : cards) {
                card.hideDetails();
            }
        }
    }

}
