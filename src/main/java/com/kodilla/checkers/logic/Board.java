package com.kodilla.checkers.logic;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<BoardRow> rows = new ArrayList<>();
    int hitX = -1;
    int hitY = -1;

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

    public void setClassic () {
        //black pawns
        setFigure(1, 0, new Pawn(FigureColor.BLACK));
        setFigure(3, 0, new Pawn(FigureColor.BLACK));
        setFigure(5, 0, new Pawn(FigureColor.BLACK));
        setFigure(7, 0, new Pawn(FigureColor.BLACK));

        setFigure(0, 1, new Pawn(FigureColor.BLACK));
        setFigure(2, 1, new Pawn(FigureColor.BLACK));
        setFigure(4, 1, new Pawn(FigureColor.BLACK));
        setFigure(6, 1, new Pawn(FigureColor.BLACK));

        setFigure(1, 2, new Pawn(FigureColor.BLACK));
        setFigure(3, 2, new Pawn(FigureColor.BLACK));
        setFigure(5, 2, new Pawn(FigureColor.BLACK));
        setFigure(7, 2, new Pawn(FigureColor.BLACK));

        //white pawns
        setFigure(0, 5, new Pawn(FigureColor.WHITE));
        setFigure(2, 5, new Pawn(FigureColor.WHITE));
        setFigure(4, 5, new Pawn(FigureColor.WHITE));
        setFigure(6, 5, new Pawn(FigureColor.WHITE));

        setFigure(1, 6, new Pawn(FigureColor.WHITE));
        setFigure(3, 6, new Pawn(FigureColor.WHITE));
        setFigure(5, 6, new Pawn(FigureColor.WHITE));
        setFigure(7, 6, new Pawn(FigureColor.WHITE));

        setFigure(0, 7, new Pawn(FigureColor.WHITE));
        setFigure(2, 7, new Pawn(FigureColor.WHITE));
        setFigure(4, 7, new Pawn(FigureColor.WHITE));
        setFigure(6, 7, new Pawn(FigureColor.WHITE));
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
    }

    public void setTest() {
        setFigure(3, 6, new Pawn(FigureColor.BLACK));
        setFigure(5, 6, new Pawn(FigureColor.BLACK));
        setFigure(2, 1, new Pawn(FigureColor.WHITE));
        setFigure(4, 1, new Pawn(FigureColor.WHITE));
    }

    public boolean move(int oldX, int oldY, int x, int y) {
        boolean result = inNormalMoveValid(oldX, oldY, x, y);
        Figure figure = getFigure(oldX, oldY);
        if (result) {
            makeQueen(oldX, oldY, x, y, figure);
        } else {
            result = isMoveWithHitValid(oldX, oldY, x, y);
            if (result) {
                makeQueen(oldX, oldY, x, y, figure);
                removeFigureBefore(oldX, oldY, x, y);
            }
        }
        return result;
    }

    private void makeQueen(int oldX, int oldY, int x, int y, Figure figure) {
        if (canBeQueen(y, figure)) {
            setFigure(x, y, new Queen(figure.getColor()));
            getFigure(x, y).setClicked();
        } else {
            setFigure(x, y, figure);
        }
        setFigure(oldX, oldY, new None());
    }

    private boolean canBeQueen(int y, Figure figure) {
        boolean result = figure instanceof Pawn;
        if (figure.getColor() == FigureColor.BLACK) {
            result = result && y == 7;
        } else {
            result = result && y == 0;
        }
        return result;
    }

    private void removeFigureBefore(int oldX, int oldY, int x, int y) {
        if (hitX != -1 && hitY != -1) {
            hitX = (oldX < x) ? x - 1 : x + 1;
            hitY = (oldY < y) ? y - 1 : y + 1;
            setFigure(hitX, hitY, new None());
            hitX = -1;
            hitY = -1;
        }
    }

    private boolean isMoveWithHitValid(int oldX, int oldY, int x, int y) {
        boolean result = emptyTargetField(x, y);
        Figure figure = getFigure(oldX, oldY);
        if (figure instanceof Queen) {
            result = result && isMoveDiagonal(oldX, oldY, x, y);
            result = result && isQueenWayEmpty(oldX, oldY, x, y);
        } else {
            result = result && goodDirection(oldX, oldY, y);
            result = result && (Math.abs(oldX - x) == 2 && Math.abs(oldY - y) == 2);
            hitX = (oldX < x) ? x - 1 : x + 1;
            hitY = (oldY < y) ? y - 1 : y + 1;
            Figure hitFigure = getFigure(hitX, hitY);
            result = result && !(hitFigure instanceof None);
            result = result && hitFigure.getColor() != figure.getColor();
        }
        return result;
    }

    private boolean isQueenWayEmpty(int oldX, int oldY, int x, int y) {
        boolean result = true;
        int dY = (y > oldY) ? 1 : -1;
        int dX = (x > oldX) ? 1 : -1;
        int steps = Math.abs(y - oldY) - 2;
        int currX = oldX;
        int currY = oldY;
        for (int n = 1; n <= steps; n++) {
            currX = currX + dX;
            currY = currY + dY;
            result = result && getFigure(currX, currY) instanceof None;
        }
        Figure figure = getFigure(x - dX, y - dY);
        hitX = x - dX;
        hitY = y - dY;
        result = result && (! (figure instanceof None)) && figure.getColor() != getFigure(oldX, oldY).getColor();
        return result;
    }

    private boolean inNormalMoveValid(int oldX, int oldY, int x, int y) {
        Figure figure = getFigure(oldX, oldY);
        if (figure instanceof Pawn) {
            return isPawnMoveProper(oldX, oldY, x, y);
        } else {
            return isQueenMoveProper(oldX, oldY, x, y);
        }
    }

    private boolean isQueenMoveProper(int oldX, int oldY, int x, int y) {
        boolean result = isMoveDiagonal(oldX, oldY, x, y);
        result = result && emptyTargetField(x, y);
        result = result && isWayEmpty(oldX, oldY, x, y);
        return result;
    }

    private boolean isWayEmpty(int oldX, int oldY, int x, int y) {
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

    private boolean isPawnMoveProper(int oldX, int oldY, int x, int y) {
        boolean result = true;
        result = result && emptyTargetField(x, y);
        result = result && goodDirection(oldX, oldY, y);
        result = result && isMoveDiagonal(oldX, oldY, x, y);
        result = result && Math.abs(oldX - x) == 1;
        return result;
    }

    private boolean emptyTargetField(int x, int y) {
        return getFigure(x, y) instanceof None;
    }

    private boolean isMoveDiagonal(int oldX, int oldY, int x, int y) {
        return Math.abs(oldX - x) == Math.abs(oldY - y);
    }

    private boolean goodDirection(int oldX, int oldY, int y) {
        Figure figure = getFigure(oldX, oldY);
        return (figure.getColor() == FigureColor.WHITE) ? y < oldY : y > oldY;
    }
}
