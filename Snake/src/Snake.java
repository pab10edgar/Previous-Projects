import java.util.Timer;

/**
 * 
 * @author Pablo Edgar Nov 20, 2017
 *
 */

public class Snake {

    private int snakeSize = 3;

    public Snake() {

    }

    private final int[] x = new int[gameBoard.getAllDots()];
    private final int[] y = new int[gameBoard.getAllDots()];

    // Stores direction of our snake
    private boolean movingLeft = false;
    private boolean movingRight = false;
    private boolean movingUp = false;
    private boolean movingDown = false;

    public int getSnakeX(int index) {
        return x[index];
    }

    public int getSnakeY(int index) {
        return y[index];
    }

    public void setSnakeX(int i) {
        x[0] = i;
    }

    public void setSnakeY(int i) {
        y[0] = i;
    }

    public boolean isMovingLeft() {
        return movingLeft;
    }

    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    public boolean isMovingUp() {
        return movingUp;
    }

    public void setMovingUp(boolean movingUp) {
        this.movingUp = movingUp;
    }

    public boolean isMovingDown() {
        return movingDown;
    }

    public void setMovingDown(boolean movingDown) {
        this.movingDown = movingDown;
    }

    public int getSnakeSize() {
        return snakeSize;
    }

    public void setSnakeSize(int j) {
        snakeSize = j;
    }

    public void move() {
        for (int i = snakeSize; i > 0; i--) {

            // Moves the joints of the snake 'up the chain'
            // Meaning, the joint of the snake all move up one
            x[i] = x[(i - 1)];
            y[i] = y[(i - 1)];
        }

        // Moves snake to the left
        if (movingLeft) {
            x[0] -= Board.getDotSize();
        }

        // To the right
        if (movingRight) {
            x[0] += gameBoard.getDotSize();
        }

        // Down
        if (movingDown) {
            y[0] += gameBoard.getDotSize();
        }

        // And finally up
        if (movingUp) {
            y[0] -= gameBoard.getDotSize();
        }

    }

    public boolean checkCollision() {

        boolean endGame = false;

        // If the snake hits its' own joints..
        for (int i = this.getSnakeSize(); i > 0; i--) {

            // Snake cant intersect with itself if it's not larger than 5
            if ((i > 5) && (this.getSnakeX(0) == this.getSnakeX(i)
                    && (this.getSnakeY(0) == this.getSnakeY(i)))) {
                endGame = true; // then the game ends
            }
        }

        // If the snake intersects with the board edges..
        if (this.getSnakeY(0) >= BOARDHEIGHT) {
            endGame = true;
        }

        if (snake.getSnakeY(0) < 0) {
            endGame = true;
        }

        if (snake.getSnakeX(0) >= BOARDWIDTH) {
            endGame = true;
        }

        if (snake.getSnakeX(0) < 0) {
            endGame = true;
        }

        return endGame;
    }
    
    public void initializeSnake() {
        for (int i = 0; i < this.getSnakeSize(); i++) {
            this.setSnakeX(Board.getWidth() / 2);
            snake.setSnakeY(Board.getHeight() / 2);
        }
    }

}
