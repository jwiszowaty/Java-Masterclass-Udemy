package Inheritance;

public class Point {
    private int x, y;

    public Point() {
    }
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public double distance(int x, int y) {
        int xDiff = x - this.x;
        int yDiff = y - this.y;
        return Math.sqrt((xDiff) * (xDiff) + (yDiff) * (yDiff));
    }
    public double distance(Point a) {
        return distance(a.x, a.y);
    }
    public double distance() {
        return distance(0,0);
    }
}
