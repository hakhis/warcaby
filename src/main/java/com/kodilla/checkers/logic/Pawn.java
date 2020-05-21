package com.kodilla.checkers.logic;

import javafx.scene.image.Image;

public class Pawn implements Figure{
    private Image whitePawn = new Image("whitepawn.png");
    private Image blackPawn = new Image("blackpawn.png");
    private Image highLightWhitePawn = new Image("highlightedWhitePawn.png");
    private Image highLightBlackPawn = new Image("highlightedBlackPawn.png");

    private FigureColor color;
    private boolean clicked;

    public Pawn(FigureColor color) {
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
            return highLightBlackPawn;
        } else if (clicked && color == FigureColor.WHITE) {
            return highLightWhitePawn;
        } else if (!clicked && color == FigureColor.WHITE) {
            return whitePawn;
        } else {
            return blackPawn;
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
