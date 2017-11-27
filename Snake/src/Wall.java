/**
 * 
 * @author Pablo Edgar Nov 20, 2017
 *
 */

public class Wall {

    boolean vertical; // vertical or horizontal
    Point p1; // upper left
    Point p2; // lower right

    public Wall(Point p1, Point p2) {

        this.p1 = p1;
        this.p2 = p2;
        vertical = (p1.getX() == p2.getX());
    }

    public boolean contains(Point p) {

        int x = p.getX();
        int y = p.getY();

        if (vertical) {
            return x == p1.getX() && y >= p1.getY() && y <= p2.getY();
        } else {
            return y == p1.getY() && x >= p1.getX() && x <= p2.getX();
        }
    }

}
