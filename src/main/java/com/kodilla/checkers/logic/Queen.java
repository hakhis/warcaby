package com.kodilla.checkers.logic;

import javafx.scene.image.Image;

public class Queen implements Figure {
    private Image whiteQueen = new Image("whitequeen.png");
    private Image blackQueen = new Image("blackqueen.png");
    private Image highLightWhiteQueen = new Image("highlightedWhiteQueen.png");
    private Image highLightBlackQueen = new Image("highlightedBlackQueen.png");

    private FigureColor color;
    private boolean clicked;

    public Queen(FigureColor color) {
        this.color = color;
        clicked = false;
    }

    @Override
    public FigureColor getColor() {
        return color;
    }

    @Override
    public Image getImage() {
        if (clicked && color == FigureColor.BLACK) {
            return highLightBlackQueen;
        } else if (clicked && color == FigureColor.WHITE) {
            return highLightWhiteQueen;
        } else if (!clicked && color == FigureColor.WHITE) {
            return whiteQueen;
        } else {
            return blackQueen;
        }
    }

    @Override
    public boolean isClicked() {
        return clicked;
    }

    @Override
    public void setClicked() {
        if (clicked) clicked = false;
        else clicked = true;
    }
}
