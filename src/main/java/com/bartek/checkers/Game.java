package com.bartek.checkers;

import com.bartek.checkers.logic.Board;
import com.bartek.checkers.logic.Figure;
import com.bartek.checkers.logic.None;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


public class Game {
    private final Board board;
    private final GridPane grid;

    public Game(Board board, GridPane grid) {
        this.board = board;
        this.grid = grid;
    }

    public void display() {
        grid.getChildren().clear();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Figure figure = board.getFigure(col, row);
                if (!(figure instanceof None)) {
                    ImageView imageView = new ImageView(figure.getImage());
                    grid.add(imageView, col, row);
                }
            }
        }
    }

    public void doClick(int x, int y) {
        //todo: skonsultowac z mentorem po zrobiniu poprzednich todo
    }
}
