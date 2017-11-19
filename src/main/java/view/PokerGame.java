package view;

import javafx.scene.Scene;
import javafx.application.Application;
import javafx.stage.Stage;
import viewcontroller.PokerGameController;
import javafx.scene.layout.BorderPane;
import viewcontroller.GameState;



public class PokerGame extends Application {

    private static Stage primaryStage;
    private PokerGameController controller;
    private static GameScreen gameScreen;
    private ControlPane controlPane;
    private Scene mainScene;
    private BorderPane layout;
    private Console gameConsole;
    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     * @param ps The primary Stage
     */
    public void start(Stage ps) {
        primaryStage = ps;
        ps.setTitle("Extreme Poker");
        ps.setScene(new Scene(new StartScreen(this)));
        ps.show();
        // ps.setPrefHeight(900);
        // ps.setPrefWidth(1500);
    }

    /**
     * Starts the Game
     * This is called by StartScreen whenever it is done and the GameScreen,
     * ControlPane, and Console should be displayed
     * @param name The name of the human player
     */
    public void startGame(String name) {
        layout = new BorderPane();
        gameConsole = new Console();
        controller = new PokerGameController(this, name);
        controlPane = new ControlPane(controller);
        gameScreen = new GameScreen(controller);

        layout.setTop(gameScreen);
        layout.setCenter(controlPane);
        layout.setBottom(gameConsole);
        layout.setPrefHeight(500);
        primaryStage.setHeight(500);
        primaryStage.setHeight(1000);
        layout.setPrefWidth(1000);
        primaryStage.setTitle("Extreme Poker");
        primaryStage.setScene(new Scene(layout));

        controller.start();
        updatesMade();
    }

    /**
     * This is called by PokerGameController whenever updates are made. You
     * must handle updating the UI here.
     */
    public void updatesMade() {
        gameScreen.updatesMade();
        GameState gameState = controller.getState();
        if (gameState == GameState.DONE) {
            gameScreen.endOfRound();
            controlPane.endOfRound();
        }
        if (gameState == GameState.HUMAN_BET) {
            controlPane.playerTurn();
        } else if (gameState == GameState.AI_BET) {
            controlPane.notTurn();
        } else if (gameState == GameState.DONE) {
            controlPane.endOfRound();
            gameScreen.endOfRound();
        }
    }

    /**
     * This is the main method that launches the javafx application
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
