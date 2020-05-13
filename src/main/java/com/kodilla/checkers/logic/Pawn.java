package com.kodilla.checkers.logic;

import javafx.scene.image.Image;

public class Pawn implements Figure{
    private Image whitePawn = new Image("whitepawn.png");
    private Image blackPawn = new Image("blackpawn.png");

    private FigureColor color;

    public Pawn(FigureColor color) {
        this.color = color;
    }

    @Override
    public FigureColor getColor() {
        return color;
    }

    @Override
    public Image getImage() {
        if (color == FigureColor.BLACK) return blackPawn;
        else return whitePawn;
        /*if (color == FigureColor.BLACK) return blackPawn;
        else if (color == FigureColor.WHITE) return whitePawn;
        else return null;*/
    }
}
