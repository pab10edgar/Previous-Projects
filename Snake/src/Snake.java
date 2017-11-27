import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 
 * @author Pablo Edgar Nov 20, 2017
 *
 */

public class Snake implements Locatable {

    private enum Direction {
        UP, DOWN, LEFT, RIGHT
    };

    Deque<Point> snake;
    Direction direction;
    
    public Snake(Point head) {
        snake = new ArrayDeque<>();
        snake.addFirst(head);
    }
    
    public void changeDirection(String str) {
        if (str.equalsIgnoreCase("u")) {
            direction = Direction.UP;
        } else if (str.equalsIgnoreCase("d")) {
            direction = Direction.DOWN;
        } else if (str.equalsIgnoreCase("l")) {
            direction = Direction.LEFT;
        } else if(str.equalsIgnoreCase("r")) {
            direction = Direction.RIGHT;
        }
    }

    public void move() {

        Point head = snake.peekFirst();

        switch (direction) {
        case UP:
            head = new Point(head.getX(), head.getY() - 1);
            break;
        case DOWN:
            head = new Point(head.getX(), head.getY() + 1);
            break;
        case LEFT:
            head = new Point(head.getX() - 1, head.getY());
            break;
        case RIGHT:
            head = new Point(head.getX() + 1, head.getY());
            break;
        }

        snake.pollLast();
        snake.addFirst(head);
    }

    public boolean checkCollision(List<Wall> walls) {

        for (Wall wall : walls) {
            if (wall.contains(snake.peekFirst())) {
                return true;
            }
        }

        boolean hitSelf = false;
        Point head = snake.pollFirst();
        if (snake.contains(head)) {
            hitSelf = true;
        }
        snake.addFirst(head);

        return hitSelf;
    }
    
    public boolean contains(Point p) {
        return snake.contains(p);
    }

    public Point getHead() {
        return snake.peekFirst();
    }

    public void eatFood() {

        Point tail = snake.pollLast();
        Point next = snake.peekLast();

        Point ext;
        if (next.getX() > tail.getX()) {
            ext = new Point(tail.getX() - 1, tail.getY());
        } else if (next.getX() < tail.getX()) {
            ext = new Point(tail.getX() + 1, tail.getY());
        } else if (next.getY() > tail.getY()) {
            ext = new Point(tail.getX(), tail.getY() - 1);
        } else {
            ext = new Point(tail.getX(), tail.getY() + 1);
        }

        snake.addLast(tail);
        snake.addLast(ext);

    }

}
