import java.util.Scanner;

public class Point {
    protected final float x;
    protected final float y;

    // Non-default constructor
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float calcDistance(Point p) {
        return x + y + p.x + p.y;
    }
}

class Point3D extends Point {
    private final float z;

    public Point3D(float x, float y, float z) {
        super(x, y); // Invokes parents' class non-default constructor
        this.z = z;
    }

    public float calcDistance(Point3D p) {
        return (float) Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2) + Math.pow(z - p.z, 2));
    }
}

class Distance {
    public static void main(String[] args) {
        Point p = new Point(1,2);
        Point d = new Point(3,4);
        System.out.println(p.calcDistance(d));
        Point3D a = new Point3D(5,5,7);
        Point3D b = new Point3D(7,8,9);
        System.out.println(a.calcDistance(b));
    }
}
