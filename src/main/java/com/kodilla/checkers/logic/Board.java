package com.kodilla.checkers.logic;

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
        //black row 0
        /*for (int nrow = 0; nrow < 2; nrow++) {
            for (int ncol = 0; ncol < 8; ncol++) {
                setFigure(ncol, nrow, new Pawn(FigureColor.BLACK));
            }
        }*/
        setFigure(0, 0, new Pawn(FigureColor.BLACK));
        setFigure(1, 0, new Pawn(FigureColor.BLACK));
        setFigure(2, 0, new Pawn(FigureColor.BLACK));
        setFigure(3, 0, new Pawn(FigureColor.BLACK));
        setFigure(4, 0, new Pawn(FigureColor.BLACK));
        setFigure(5, 0, new Pawn(FigureColor.BLACK));
        setFigure(6, 0, new Pawn(FigureColor.BLACK));
        setFigure(7, 0, new Pawn(FigureColor.BLACK));
        //black row 1
        setFigure(0, 1, new Pawn(FigureColor.BLACK));
        setFigure(1, 1, new Pawn(FigureColor.BLACK));
        setFigure(2, 1, new Pawn(FigureColor.BLACK));
        setFigure(3, 1, new Pawn(FigureColor.BLACK));
        setFigure(4, 1, new Pawn(FigureColor.BLACK));
        setFigure(5, 1, new Pawn(FigureColor.BLACK));
        setFigure(6, 1, new Pawn(FigureColor.BLACK));
        setFigure(7, 1, new Pawn(FigureColor.BLACK));
        //white row 6
        /*for (int nrow = 6; nrow < 8; nrow++) {
            for (int ncol = 0; ncol < 8; ncol++) {
                setFigure(ncol, nrow, new Pawn(FigureColor.WHITE));
            }
        }*/
        setFigure(0, 6, new Pawn(FigureColor.WHITE));
        setFigure(1, 6, new Pawn(FigureColor.WHITE));
        setFigure(2, 6, new Pawn(FigureColor.WHITE));
        setFigure(3, 6, new Pawn(FigureColor.WHITE));
        setFigure(4, 6, new Pawn(FigureColor.WHITE));
        setFigure(5, 6, new Pawn(FigureColor.WHITE));
        setFigure(6, 6, new Pawn(FigureColor.WHITE));
        setFigure(7, 6, new Pawn(FigureColor.WHITE));
        //white row 7
        setFigure(0, 7, new Pawn(FigureColor.WHITE));
        setFigure(1, 7, new Pawn(FigureColor.WHITE));
        setFigure(2, 7, new Pawn(FigureColor.WHITE));
        setFigure(3, 7, new Pawn(FigureColor.WHITE));
        setFigure(4, 7, new Pawn(FigureColor.WHITE));
        setFigure(5, 7, new Pawn(FigureColor.WHITE));
        setFigure(6, 7, new Pawn(FigureColor.WHITE));
        setFigure(7, 7, new Pawn(FigureColor.WHITE));
        //empty board
        /*for (int nrow = 2; nrow < 6; nrow++) {
            for (int ncol = 0; ncol < 8; ncol++) {
                setFigure(ncol, nrow, new None());
            }
        }*/
    }
}
