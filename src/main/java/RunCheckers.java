import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RunCheckers extends Application {
    private Image imageback = new Image("file:resources/checkers_board.png");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 300, 300, Color.BLACK);

        Rectangle r = new Rectangle(25,25,250,250);
        r.setFill(Color.BLUE);

        root.getChildren().add(r);
        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
