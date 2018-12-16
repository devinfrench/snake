package snake;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;

    private GraphicsContext graphics;
    private KeyHandler keyHandler;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        graphics = canvas.getGraphicsContext2D();
        canvas.setFocusTraversable(true);
        keyHandler = new KeyHandler();
        canvas.setOnKeyPressed(keyHandler);
        root.getChildren().add(canvas);
        stage.setResizable(false);
        stage.setTitle("Snake");
        stage.setOnCloseRequest(e -> System.exit(0));
        stage.setScene(new Scene(root));
        stage.show();

        Grid grid = new Grid(WIDTH, HEIGHT);
        Snake snake = new Snake(grid, new Tile(grid.getRows() / 2, grid.getCols() / 2));
        Fruit fruit = new Fruit(grid);
        grid.setSnake(snake);
        grid.setFruit(fruit);
        keyHandler.setSnake(snake);
        GameLoop loop = new GameLoop(graphics, grid);
        (new Thread(loop)).start();
    }
}
