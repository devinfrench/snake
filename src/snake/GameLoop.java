package snake;

import javafx.scene.canvas.GraphicsContext;

public class GameLoop implements Runnable {

    private static final int FPS = 24;
    private static final int INTERVAL = 1000 / FPS;

    private boolean running;
    private GraphicsContext gc;
    private Grid grid;

    public GameLoop(GraphicsContext gc, Grid grid) {
        this.gc = gc;
        this.grid = grid;
        running = true;
    }

    @Override
    public void run() {
        while (running) {
            long time = System.currentTimeMillis();
            grid.update();
            grid.paint(gc);
            time = System.currentTimeMillis() - time;
            if (time < INTERVAL) {
                try {
                    Thread.sleep(INTERVAL - time);
                } catch (InterruptedException ignored) {
                }
            }
        }
    }
}
