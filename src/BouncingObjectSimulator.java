import java.awt.geom.Rectangle2D;

public class BouncingObjectSimulator {

    private double x = 0;
    private double y = 0;
    private double dx = 2;
    private double dy = 2;
    public static final double CIRCLE_RADIUS = 3;

    public void move(Rectangle2D bounds) // Rectangle dimensions are the movement boundaries.
    {
        var rbounds = bounds.getMaxX();
        var lbounds = bounds.getMinX();
        var tbounds = bounds.getMaxY();
        var bbounds = bounds.getMinY();
        this.x += this.dx;
        this.y += this.dx;
        if (rbounds <= this.x || lbounds >= this.x){ // These conditions being 'or equal' makes more sense to me.
            this.dx = -this.dx;
        }
        if (tbounds <= this.y || bbounds >= this.y){
            this.dy = -this.dy;
        }
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }
}