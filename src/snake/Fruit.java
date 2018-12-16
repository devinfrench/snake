package snake;

import java.util.Random;

public class Fruit {

    private Random random;
    private Grid grid;
    private Tile tile;

    public Fruit(Grid grid) {
        this.grid = grid;
        random = new Random();
        respawn();
    }

    public Tile getTile() {
        return tile;
    }

    public void respawn() {
        tile = getRandomTile();
    }

    private Tile getRandomTile() {
        return new Tile(random.nextInt(grid.getRows()), random.nextInt(grid.getCols()));
    }

}
