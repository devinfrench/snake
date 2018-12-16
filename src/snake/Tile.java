package snake;

public class Tile {

    private int x;
    private int y;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tile) {
            Tile other = (Tile) obj;
            return other.x == x && other.y == y;
        }
        return false;
    }
}
