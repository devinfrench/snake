package snake;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyHandler implements EventHandler<KeyEvent> {

    private Snake snake;

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void handle(KeyEvent e) {
        if (snake == null) {
            return;
        }
        switch (e.getCode()) {
            case UP:
            case W:
                snake.setDirection(Snake.Direction.UP);
                break;
            case DOWN:
            case S:
                snake.setDirection(Snake.Direction.DOWN);
                break;
            case LEFT:
            case A:
                snake.setDirection(Snake.Direction.LEFT);
                break;
            case RIGHT:
            case D:
                snake.setDirection(Snake.Direction.RIGHT);
                break;
        }
    }
}
