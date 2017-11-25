/**
 * 
 * @author Pablo Edgar Nov 20, 2017
 *
 */
public class food {

    private snakeReptile snake = new snakeReptile();

    private int foodX, foodY;

    private final int RANDOMPOSITION = 40;

    public void createFood() {

        int location = (int) (Math.random() * RANDOMPOSITION);
        foodX = ((location * gameBoard.getDotSize()));

        location = (int) (Math.random() * RANDOMPOSITION);
        foodY = ((location * gameBoard.getDotSize()));

        if ((foodX == snake.getSnakeX(0)) && (foodY == snake.getSnakeY(0))) {
            createFood();
        }
    }

    public int getFoodX() {

        return foodX;
    }

    public int getFoodY() {
        return foodY;
    }
}
