import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Pablo Edgar Nov 20, 2017
 * 
 */
public class GameManager {
    
    private static final long SEED = 9151092839L;
    private final Random random = new Random(SEED);

    private int width;
    private int height;

    ArrayList<Wall> walls;
    Snake snake;
    Food food;
    boolean endGame;

    public GameManager(String filename) {

        try {

            endGame = false;
            Scanner sc = new Scanner(new File(filename));

            String dimensions = sc.nextLine();
            String[] tokens = dimensions.split(" ");
            width = Integer.parseInt(tokens[0]);
            height = Integer.parseInt(tokens[1]);

            walls = new ArrayList<>();

            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                tokens = str.split(" ");
                Point p1 = new Point(Integer.parseInt(tokens[0]),
                        Integer.parseInt(tokens[1]));
                Point p2 = new Point(Integer.parseInt(tokens[2]),
                        Integer.parseInt(tokens[3]));

                walls.add(new Wall(p1, p2));
            }
            
            boolean validLocation;
            Point head;
            do {
                validLocation = true;
                head = new Point(random.nextInt(width), random.nextInt(height));
                for (Wall wall : walls) {
                    if (wall.contains(head)) {
                        validLocation = false;
                    }
                }
            } while (!validLocation);
            
            // Add snake
            snake = new Snake(head);
            
            // Add food
            food = generateFood();

            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    private Food generateFood() {
        Point p;
        boolean validLocation;
        do {
            validLocation = true;
            p = new Point(random.nextInt(width), random.nextInt(height));
            for (Wall wall : walls) {
                if (wall.contains(p)) {
                    validLocation = false;
                }
            }
            if (snake.contains(p)) {
                validLocation = false;
            }
        } while (!validLocation);   
        return new Food(p);
    }
    
    public void controlSnake() {
        Scanner scanner = new Scanner(System.in);
        snake.changeDirection(scanner.next());
        scanner.close();
    }

    public void updateFrame(){
        snake.move();
        
        endGame = snake.checkCollision(walls);
        
        if(food.contains(snake.getHead())){
            snake.eatFood();
            food = generateFood();
        }
    }
    
    public boolean gameEnded() {
        return endGame;
    }


    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();
        
        for (int i = 0; i < height; i++) {
            point: for (int j = 0; j < width; j++) {
                Point p = new Point(j, i);
                for (Wall wall : walls) {
                    if (wall.contains(p)) {
                        str.append("X");
                        continue point;
                    }
                }
                if (snake.contains(p)) {
                    str.append("s");
                } else if (food.contains(p)) {
                    str.append("f");
                } else {
                    str.append(".");
                }
            }
            str.append("\n");
        }

        return str.toString();
    }

}