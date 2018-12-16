package snake;

import java.util.LinkedList;
import java.util.List;

public class Snake {

    private Grid grid;
    private Direction dir;
    private LinkedList<Tile> occupied;
    private boolean alive;

    public Snake(Grid grid, Tile head) {
        this.grid = grid;
        occupied = new LinkedList<>();
        occupied.add(head);
        alive = true;
    }

    public Tile getHead() {
        return occupied.peek();
    }

    public List<Tile> getTiles() {
        return occupied;
    }

    public boolean isAlive() {
        return alive;
    }

    public void move() {
        if (dir == null) {
            return;
        }
        Tile dest = grid.wrap(getHead().translate(dir.getX(), dir.getY()));
        alive = !occupied.contains(dest);
        occupied.addFirst(dest);
        occupied.removeLast();
    }

    public void extend() {
        Tile ext = grid.wrap(getHead().translate(dir.getX(), dir.getY()));
        alive = !occupied.contains(ext);
        occupied.addFirst(ext);
    }

    public void setDirection(Direction dir) {
        switch (dir) {
            case UP:
                if (occupied.size() <= 1 || this.dir != Direction.DOWN) {
                    this.dir = dir;
                }
                break;
            case DOWN:
                if (occupied.size() <= 1 || this.dir != Direction.UP) {
                    this.dir = dir;
                }
                break;
            case LEFT:
                if (occupied.size() <= 1 || this.dir != Direction.RIGHT) {
                    this.dir = dir;
                }
                break;
            case RIGHT:
                if (occupied.size() <= 1 || this.dir != Direction.LEFT) {
                    this.dir = dir;
                }
                break;
        }
    }

    public enum Direction {
        UP(0, -1),
        DOWN(0, 1),
        LEFT(-1, 0),
        RIGHT(1, 0);

        private int x;
        private int y;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
