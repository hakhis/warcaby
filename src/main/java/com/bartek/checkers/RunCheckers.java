package com.bartek.checkers;

import com.bartek.checkers.logic.Board;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RunCheckers extends Application {
    private Image board = new Image("board.png");


    private FlowPane pawns = new FlowPane(Orientation.HORIZONTAL);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true,
                                                true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(board, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                                                                BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(5.5);
        grid.setVgap(5.5);
        grid.setBackground(background);
        Scene scene = new Scene(grid, 920, 920, Color.BLUE);

        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        Board board = new Board();
        board.init();
        Game game = new Game(board, grid);
        game.display();
        grid.setOnMouseClicked(e -> {
            System.out.println(e.getX() + "," + e.getY());
            int x = 0;
            int y = 0;
            //todo: przeliczyć x i y z pixeli na numer pola

            game.doClick(x, y);
            game.display();
        });
        primaryStage.show();
    }
}
