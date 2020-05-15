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
    }

    @Override
    public FigureColor getColor() {
        return color;
    }

    @Override
    public Image getImage() {
        if (color == FigureColor.BLACK) return blackQueen;
        else return whiteQueen;
        /*if (color == FigureColor.BLACK) return blackQueen;
        else if (color == FigureColor.WHITE) return whiteQueen;
        else return null;*/
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
