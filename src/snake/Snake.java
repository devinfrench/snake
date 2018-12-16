package snake;

public class Snake {

    private int x;
    private int y;
    private Direction dir;
    private int length;

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
        dir = Direction.RIGHT;
        length = 1;
    }

    private void setDirection(Direction dir) {
        switch (dir) {
            case UP:
                if (length <= 1 || this.dir != Direction.DOWN) {
                    this.dir = dir;
                }
                break;
            case DOWN:
                if (length <= 1 || this.dir != Direction.UP) {
                    this.dir = dir;
                }
                break;
            case LEFT:
                if (length <= 1 || this.dir != Direction.RIGHT) {
                    this.dir = dir;
                }
                break;
            case RIGHT:
                if (length <= 1 || this.dir != Direction.LEFT) {
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
