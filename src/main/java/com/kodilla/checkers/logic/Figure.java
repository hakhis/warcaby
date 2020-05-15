package com.kodilla.checkers.logic;

import javafx.scene.image.Image;

public interface Figure {
    FigureColor getColor();
    Image getImage();
    boolean isClicked();
    void setClicked();
}
