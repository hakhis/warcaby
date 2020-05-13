package com.kodilla.checkers.logic;

import javafx.scene.image.Image;

public class None implements Figure {
    @Override
    public FigureColor getColor() {
        return FigureColor.NONE;
    }

    @Override
    public Image getImage() {
        return null;
    }
}
