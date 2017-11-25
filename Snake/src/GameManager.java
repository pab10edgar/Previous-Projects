
/**
 * @author Pablo Edgar Nov 20, 2017
 * 
 */
public class GameManager {

    private int size;

    GameManager() {
    }

    GameManager(int size) {
        this.size = size;
    }

    public void addWall() {

    }

    public void addSnake() {

    }

    public void addFood() {
        food food1 = new food();
        food1.createFood();
    }

    snakeReptile snake1 = new snakeReptile();
    gameBoard board1 = new gameBoard();
    wall wall1 = new wall();

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
