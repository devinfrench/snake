package snake;

import java.util.LinkedList;
import java.util.List;

public class Snake {

    private Direction dir;
    private LinkedList<Tile> occupied;

    public Snake(Tile head) {
        dir = Direction.RIGHT;
        occupied = new LinkedList<>();
        occupied.add(head);
    }

    public Tile getHead() {
        return occupied.peek();
    }

    public List<Tile> getTiles() {
        return occupied;
    }

    public void move() {
        move(getHead().translate(dir.getX(), dir.getY()));
    }

    private void move(Tile dest) {
        occupied.addFirst(dest);
        occupied.removeLast();
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
