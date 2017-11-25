/**
 * 
 * @author Pablo Edgar Nov 20, 2017
 *
 */
public class Food {

    private Snake snake1 = new Snake();

    private int foodX, foodY;

    private final int RANDOMPOSITION = 40;

    public void createFood() {

        int location = (int) (Math.random() * RANDOMPOSITION);
        foodX = ((location * gameBoard.getDotSize()));

        location = (int) (Math.random() * RANDOMPOSITION);
        foodY = ((location * gameBoard.getDotSize()));

        if ((foodX == snake1.getSnakeX(0)) && (foodY == snake1.getSnakeY(0))) {
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
