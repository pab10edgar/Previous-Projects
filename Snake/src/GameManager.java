import java.io.IOException;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Pablo Edgar Nov 20, 2017
 * 
 */
public class GameManager {

    private int size;
    private Path p;

    Food food1 = new Food();
    Snake snake1 = new Snake();
    Wall wall1 = new Wall(p);
    Board board1 = new Board();

    public GameManager() {
    }

    GameManager(int size, Path p) {
        this.size = size;
        this.p = p;
    }

    public void makeBoard() {

        
    }

    public void addSnake() {

        // Create our snake's body
        for (int i = 0; i < snake1.getSnakeSize(); i++) {
            snake1.setSnakeX(BOARDWIDTH / 2);
            snake1.setSnakeY(BOARDHEIGHT / 2);
        }

        // Start off our snake moving right
        snake1.setMovingRight(true);
    }

    public void addFood() {
        food1.createFood();
    }

    @Override
    public String toString() {
        return null;

    }

    public void updatePosition() {

    }

    public boolean checkForCollision() {
        return false;

    }

}
