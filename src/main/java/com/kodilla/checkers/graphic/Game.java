package com.kodilla.checkers.graphic;

import com.kodilla.checkers.logic.Board;
import com.kodilla.checkers.logic.Figure;
import com.kodilla.checkers.logic.FigureColor;
import com.kodilla.checkers.logic.None;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


public class Game {
    private final Board board;
    private final GridPane grid;
    private FigureColor turn;
    private int oldX = - 1;
    private int oldY = - 1;

    public Game(Board board, GridPane grid) {
        this.board = board;
        this.grid = grid;
        turn = FigureColor.WHITE;
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
        if (oldX == -1) {
            Figure figure = board.getFigure(x, y);
            if (figure.getColor() == turn) {
                figure.setClicked();
                oldX = x;
                oldY = y;
            }
        } else {
            if (board.move(oldX, oldY, x, y)) {
                switchTurn();
                board.getFigure(x, y).setClicked();
            } else {
                board.getFigure(oldX, oldY).setClicked();
            }
            oldX = -1;
            oldY = -1;
        }
        System.out.println("column: " + x + ", row " + y);
        display();
    }

    private void switchTurn() {
        if (turn == FigureColor.WHITE) turn = FigureColor.BLACK;
        else turn = FigureColor.WHITE;
    }
}
