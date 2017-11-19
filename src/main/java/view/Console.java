package view;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.Label;


public class Console extends ScrollPane {

    private static Console instance;
    private Label myLabel;

    /**
     * Console's constructor. Set's the static instance variable.
     */
    public Console() {
        instance = this;

        myLabel = new Label();
        myLabel.setWrapText(true);
        instance.setHbarPolicy(ScrollBarPolicy.NEVER);
        instance.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        instance.setContent(myLabel);
        instance.setFitToWidth(true);
        instance.setPrefHeight(200);
    }

    /**
     * Add's text to the top of the console. (Doesn't get rid of
     * text that is already there!)
     * @param newText is the text to add to the top of the console
     */
    public void addText(String newText) {

        String oldText = myLabel.getText();
        myLabel.setText(newText + "\n" + oldText);
    }

    /**
     * Clears the console of any text
     */
    public void clear() {

        myLabel.setText(null);
    }

    /**
     * Static method that adds a message into the current
     * {@value  instance}
     * @param message The message to add
     */
    public static void putMessage(String message) {
        instance.addText(message);
    }

    /**
     * Clears the console of the current {@value instance}
     */
    public static void clearLog() {
        instance.clear();
    }
}
