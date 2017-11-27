/**
 * 
 * @author Pablo Edgar Nov 25, 2017
 *
 */
public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Point)) {
            return false;
        }
        Point that = (Point) o;
        return this.x == that.x && this.y == that.y;
    }
}