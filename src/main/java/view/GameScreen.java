package view;

import javafx.scene.layout.BorderPane;
import viewcontroller.PokerGameController;


public class GameScreen extends BorderPane {
    private HorizontalPlayer playerTop;
    private HorizontalPlayer playerBot;
    private VerticalPlayer playerLeft;
    private VerticalPlayer playerRight;
    private BoardArea boardArea;
    private PlayerArea[] players;
    /**
     * GameScreen's constructor
     * @param controller The PokerGameController to interact with
     */
    public GameScreen(PokerGameController controller) {

        playerTop = new HorizontalPlayer(controller.getTopPlayer());
        playerBot = new HorizontalPlayer(controller.getBottomPlayer());
        playerLeft = new VerticalPlayer(controller.getLeftPlayer());
        playerRight = new VerticalPlayer(controller.getRightPlayer());
        boardArea = new BoardArea(controller.getBoard());

        setTop(playerTop.playerPane());
        setBottom(playerBot.playerPane());
        setLeft(playerLeft.playerPane());
        setRight(playerRight.playerPane());
        setCenter(boardArea.getPane());

        players = new PlayerArea[4];
        players[0] = playerBot;
        players[1] = playerRight;
        players[2] = playerTop;
        players[3] = playerLeft;
    }
    /**
     * This method is called whenever normal updates to the UI need to be made.
     */
    public void updatesMade() {
        for (int i = 1; i < 4; i++) {
            players[i].update(false);
        }
        playerBot.update(true);
        boardArea.update();
    }

    /**
     * This method is called whenever a round of poker ends
     */
    public void endOfRound() {
        for (PlayerArea aPlayer : players) {
            aPlayer.update(true);
        }
        boardArea.update();
    }

}
