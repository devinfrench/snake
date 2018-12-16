package snake;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Grid {

    private static final int TILE_SIZE = 10;

    private int rows;
    private int cols;
    private Snake snake;

    public Grid(int width, int height) {
        rows = width / TILE_SIZE;
        cols = height / TILE_SIZE;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getWidth() {
        return rows * TILE_SIZE;
    }

    public int getHeight() {
        return cols * TILE_SIZE;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Tile wrap(Tile tile) {
        int x = tile.getX();
        int y = tile.getY();
        if (x >= rows) {
            x = 0;
        }
        if (y >= cols) {
            y = 0;
        }
        if (x < 0) {
            x = rows - 1;
        }
        if (y < 0) {
            y = cols - 1;
        }
        return new Tile(x, y);
    }

    public void paint(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, getWidth(), getHeight());

        gc.setFill(Color.DARKSEAGREEN);
        for (Tile tile : snake.getTiles()) {
            gc.fillRect(tile.getX() * TILE_SIZE, tile.getY() * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }
    }

    public void update() {
        snake.move();
    }

}
