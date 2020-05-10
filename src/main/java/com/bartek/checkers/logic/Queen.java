package com.bartek.checkers.logic;

import javafx.scene.image.Image;

public class Queen implements Figure {
    private Image whiteQueen = new Image("whitequeen.png");
    private Image blackQueen = new Image("blackqueen.png");
    private FigureColor color;

    public Queen(FigureColor color) {
        this.color = color;
    }

    @Override
    public FigureColor getColor() {
        return color;
    }

    @Override
    public Image getImage() {
        //todo:zwrócić obraz w zależosci od koloru
        return null;
    }
}
