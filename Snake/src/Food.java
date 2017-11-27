import java.util.Random;

/**
 * 
 * @author Pablo Edgar Nov 20, 2017
 *
 */

public class Food {

    Point point;

    public Food(Point p) {
        this.point = p;
    }

    public boolean contains(Point p) {
        return p.equals(point);
    }

}
