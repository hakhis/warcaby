package com.kodilla.checkers.graphic;

import com.kodilla.checkers.logic.Board;
import com.kodilla.checkers.logic.Figure;
import com.kodilla.checkers.logic.None;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;


public class Game {
    private final Board board;
    private final GridPane grid;

    public Game(Board board, GridPane grid) {
        this.board = board;
        this.grid = grid;
    }

    public void display() {
        grid.getChildren().clear();
        //setting pawns images
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
        System.out.println("column: " + x + ", row " + y);
        //todo: skonsultowac z mentorem po zrobiniu poprzednich todo
    }
}
