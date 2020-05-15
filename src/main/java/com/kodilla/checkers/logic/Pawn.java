package com.kodilla.checkers.logic;

import javafx.scene.image.Image;

public class Pawn implements Figure{
    private Image whitePawn = new Image("whitepawn.png");
    private Image blackPawn = new Image("blackpawn.png");
    private Image highLight = new Image("highlighted_placeholder.png");

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
        if (clicked) return highLight; else
        if (color == FigureColor.BLACK) return blackPawn;
        else return whitePawn;
        /*if (color == FigureColor.BLACK) return blackPawn;
        else if (color == FigureColor.WHITE) return whitePawn;
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
