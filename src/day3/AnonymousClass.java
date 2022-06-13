package day3;

class AnonymousDemo {
    public static void main(String[] args) {

        Shape triangle = new Shape(4, 9, 7) {
            public void calArea() {
                calPerimeter();
                float s = perimeter/2;
                float a = s * (s-dim1) * (s-dim2) * (s-dim3);

                area = (float) Math.sqrt( a );
            }

            public void calPerimeter() {
                perimeter = dim1 + dim2 + dim3;
            }
        };

        triangle.calPerimeter();
        triangle.calArea();

        System.out.println("Area of triangle = "+triangle.getArea());
        System.out.println("Perimeter of triangle = "+triangle.getPerimeter());

    }
}