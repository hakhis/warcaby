package com.kodilla.checkers.graphic;

import com.kodilla.checkers.logic.Board;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class RunCheckers extends Application {
    private Image board = new Image("board.png");


    private FlowPane pawns = new FlowPane(Orientation.HORIZONTAL);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true,
                                                true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(
                board, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(58, 58, 58, 58));
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setBackground(background);
        //setting grid dimensions
        for (int n = 0; n < 8; n++)  {
            RowConstraints rowConst = new RowConstraints(100);
            ColumnConstraints colConst = new ColumnConstraints(100);
            grid.getRowConstraints().add(rowConst);
            grid.getColumnConstraints().add(colConst);
        }
        Scene scene = new Scene(grid, 1076, 1076);

        stage.setTitle("Checkers");
        stage.setScene(scene);
        stage.sizeToScene();
        Board board = new Board();
        board.init();
        Game game = new Game(board, grid);
        game.display();
        grid.setOnMouseClicked(e -> {
            double x = e.getX();
            double y = e.getY();
            int row = 100;  //temp 100 if outside the board
            int col = 100;  //temp 100 if outside the board
            int boardCorner = 58;
            int fieldWidth = 120;
            System.out.println("x=" + x + ", y=" + y);
            //columns
            for (int n = 0; n < 8; n++) {
                if (x > boardCorner + n * fieldWidth && x <= boardCorner + (n + 1) * fieldWidth) col = n;
            }
            //rows
            for (int n = 0; n < 8; n++) {
                if (y > boardCorner + n * fieldWidth && y <= boardCorner + (n + 1) * fieldWidth) row = n;
            }

            game.doClick(col, row);
            game.display();
        });
        stage.show();
    }
}
