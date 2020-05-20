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
        //black rows
        for (int nrow = 0; nrow < 2; nrow++) {
            for (int ncol = 0; ncol < 8; ncol++) {
                setFigure(ncol, nrow, new Pawn(FigureColor.BLACK));
            }
        }
        //white rows
        for (int nrow = 6; nrow < 8; nrow++) {
            for (int ncol = 0; ncol < 8; ncol++) {
                setFigure(ncol, nrow, new Pawn(FigureColor.WHITE));
            }
        }
        //empty board
        /*for (int nrow = 2; nrow < 6; nrow++) {
            for (int ncol = 0; ncol < 8; ncol++) {
                setFigure(ncol, nrow, new None());
            }
        }*/
    }

    public boolean move(int oldX, int oldY, int x, int y) {
        boolean result = isCommonMoveValid(oldX, oldY, x, y);
        result = result && inNormalMoveValid(oldX, oldY, x, y);
        Figure figure = getFigure(oldX, oldY);
        if (result) {
            setFigure(x, y, figure);
            setFigure(oldX, oldY, new None());
        } else {
            result = isMoveWithHitValid(oldX, oldY, x, y);
            if (result) {
                setFigure(x, y, figure);
                setFigure(oldX, oldY, new None());
                removeFigureBefore(oldX, oldY, x, y);
            }
        }
        return result;
    }

    private void removeFigureBefore(int oldX, int oldY, int x, int y) {
        //todo usuniecie poprzedniej figury
    }

    private boolean isMoveWithHitValid(int oldX, int oldY, int x, int y) {
        boolean result = true;
        Figure figure = getFigure(oldX, oldY);
        result = result && (goodDirection(oldX, oldY, y) || figure instanceof Queen);
        result = result && emptyTargetField(x, y);
        result = result && Math.abs(oldX - x) == 2;
        //todo sprawdzenie bicia
        return result;
    }

    private boolean inNormalMoveValid(int oldX, int oldY, int x, int y) {
        Figure figure = getFigure(oldX, oldY);
        if (figure instanceof Pawn) {
            return isPawnMoveProper(oldX, x);
        } else {
            return isQueenMoveProper(oldX, oldY, x, y);
        }
    }

    private boolean isCommonMoveValid(int oldX, int oldY, int x, int y) {
        boolean result = true;
        result = result && emptyTargetField(x, y);
        result = result && goodDirection(oldX, oldY, y);
        result = result && isMoveDiagonal(oldX, oldY, x, y);
        return result;
    }

    private boolean isQueenMoveProper(int oldX, int oldY, int x, int y) {
        boolean result = true;
        int dY = (y > oldY) ? 1 : -1;
        int dX = (x > oldX) ? 1 : -1;
        int currX = oldX;

        for (int currY = oldY + dY; currY != y; currY+=dY) {
            currX += dX;
            result = result && (getFigure(currX, currY) instanceof None);
        }

        return result;
    }

    private boolean isPawnMoveProper(int oldX, int x) {
        return Math.abs(oldX - x) == 1;
    }

    private boolean emptyTargetField(int x, int y) {
        return getFigure(x, y) instanceof None;
    }

    private boolean isMoveDiagonal(int oldX, int oldY, int x, int y) {
        return Math.abs(oldX - x) == Math.abs(oldY - y);
    }

    private boolean goodDirection(int oldX, int oldY, int y) {
        Figure figure = getFigure(oldX, oldY);
        return (figure instanceof Queen) || (figure.getColor() == FigureColor.WHITE) ? y < oldY : y > oldY;
    }
}
