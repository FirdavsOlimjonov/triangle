package com.epam.rd.autotasks.triangle;

class Triangle {
    Point a;
    Point b;
    Point c;
    double ab;
    double ac;
    double bc;
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;

        initialOrThrow();
    }

    private void initialOrThrow() {
        ab = Math.sqrt(Math.pow((b.getX()-a.getX()),2)+Math.pow((b.getY()-a.getY()),2));
        ac = Math.sqrt(Math.pow((c.getX()-a.getX()),2)+Math.pow((c.getY()-a.getY()),2));
        bc = Math.sqrt(Math.pow((b.getX()-c.getX()),2)+Math.pow((b.getY()-c.getY()),2));

        if ((ab + ac) <= bc || (ab + bc) <= ac || (bc + ac) <= ab)
            throw new IllegalArgumentException();
    }

    public double area() {
        double p = (ab + ac + bc)/2;
        return Math.sqrt(p*(p-ac)*(p-ab)*(p-bc));
    }

    public Point centroid(){
        double x = (a.getX()+b.getX()+c.getX())/3;
        double y = (a.getY()+b.getY()+c.getY())/3;

        return new Point(x,y);
    }

    public static void main(String[] args) {
        Point point1 = new Point(0,0);
        Point point2 = new Point(4,0);
        Point point3 = new Point(0,3);

        Triangle triangle = new Triangle(point1,point2,point3);
        System.out.println(triangle.area());
    }
}
