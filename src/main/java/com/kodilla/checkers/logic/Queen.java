package com.kodilla.checkers.logic;

import javafx.scene.image.Image;

public class Queen implements Figure {
    private Image whiteQueen = new Image("whitequeen.png");
    private Image blackQueen = new Image("blackqueen.png");
    private Image highLight = new Image("highlighted_placeholder.png");

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
        if (clicked) {
            return highLight;
        } else if (color == FigureColor.BLACK) {
            return blackQueen;
        } else {
            return whiteQueen;
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
