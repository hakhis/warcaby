package com.bartek.checkers.logic;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<BoardRow> rows = new ArrayList<>();

    public Board() {
        for (int n=0; n<8; n++)
            rows.add(new BoardRow());
    }

    public Figure getFigure(int col, int row) {
        return rows.get(row).getCols().get(col);
    }

    public void setFigure(int col, int row, Figure figure) {
        rows.get(row).getCols().set(col, figure);
    }

    public void init() {
        setFigure(0, 0, new Pawn(FigureColor.BLACK));
        setFigure(0, 0, new Pawn(FigureColor.BLACK));
        setFigure(0, 0, new Pawn(FigureColor.BLACK));
        setFigure(0, 0, new Pawn(FigureColor.BLACK));
        setFigure(0, 0, new Pawn(FigureColor.BLACK));
        setFigure(0, 0, new Pawn(FigureColor.BLACK));
        setFigure(0, 0, new Pawn(FigureColor.BLACK));
        setFigure(0, 0, new Pawn(FigureColor.BLACK));
        //todo: uzupełnić
    }
}
