package day3;

/*There are different types of shapes such as Circle, Rectangle, Triangle.
Every shape has it's area and perimeter. Create appropriate classes using inheritance
in such a way that each class will implement method to find area and perimeter of shape.*/

abstract class Shape {
    protected float dim1, dim2, dim3, area, perimeter;

    public Shape(float dim1, float dim2, float dim3) {
        this.dim1 = dim1;
        this.dim2 = dim2;
        this.dim3 = dim3;
    }

    abstract public void calArea();

    public abstract void calPerimeter();

    public float getArea() {
        return area;
    }

    public float getPerimeter() {
        return perimeter;
    }
}

class Rectangle extends Shape {
    public Rectangle(float length, float breadth) {
        super(length, breadth, 0);
    }

    public void calArea() {
        area = dim1 * dim2;
    }

    public void calPerimeter() {
        perimeter = 2 * ( dim1 + dim2);
    }

    public float getLength() {
        return dim1;
    }

    public float getBreadth() {
        return dim2;
    }
}

class Circle extends Shape {
    public Circle(float radius) {
        super(radius, 0, 0);
    }

    public void calArea() {
        area = (float) (Math.PI * dim1 * dim1);
    }

    public void calPerimeter() {
        perimeter = (float) (2 * Math.PI * dim1);
    }

    public float getRadius() {
        return dim1;
    }
}

class Triangle extends Shape {
    public Triangle(float base, float height, float side3) {
        super(base, height, side3);
    }

    public void calArea() {
        area = (dim1 * dim2) / 2;
    }

    public void calPerimeter() {
        perimeter = dim1 + dim2 + dim3;
    }

    public float getBase() {
        return dim1;
    }

    public float getHeight() {
        return dim2;
    }

    public float getSide3() {
        return dim3;
    }
}

class ShapesApp {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(4, 8);
        r.calArea();
        r.calPerimeter();
        System.out.println("Area of Rectangle with length = "+r.getLength() +" and breadth = "+r.getBreadth() +" is "+r.getArea());
        System.out.println("Perimeter of Rectangle with length = "+r.getLength() +" and breadth = "+r.getBreadth() +" is "+r.getPerimeter());

        Circle c = new Circle(4);
        c.calArea();
        c.calPerimeter();
        System.out.println("Area of Circle with radius = "+c.getRadius() +" is "+c.getArea());
        System.out.println("Perimeter of Circle with radius = "+c.getRadius() +" is "+c.getPerimeter());

        Triangle t = new Triangle(2, 3, 1);
        t.calArea();
        t.calPerimeter();
        System.out.println("Area of Triangle with base = "
                + t.getBase()
                + " and height = "
                + t.getHeight()
                + " is "
                + t.getArea());

        System.out.println("Perimeter of Triangle with side 1 = "
                + t.getBase()
                + " and side2 = "
                + t.getHeight()
                + " and side3 = "
                + t.getSide3()
                + " is "
                + t.getPerimeter());


        Shape triangle = new Shape(3,5,7) {
            @Override
            public void calArea() {
                area = (dim1 * dim2) / 2;
                printArea();
            }

            @Override
            public void calPerimeter() {
                perimeter = dim1 + dim2 + dim3;
                printPerimeter();
            }

            public void printArea() {
                System.out.println("Area of Triangle with base = "
                        + t.getBase()
                        + " and height = "
                        + t.getHeight()
                        + " is "
                        + t.getArea());
            }

            public void printPerimeter() {
                System.out.println("Perimeter of Triangle with side 1 = "
                        + t.getBase()
                        + " and side2 = "
                        + t.getHeight()
                        + " and side3 = "
                        + t.getSide3()
                        + " is "
                        + t.getPerimeter());
            }
        };

        triangle.calArea();
        triangle.calPerimeter();
    }
}
