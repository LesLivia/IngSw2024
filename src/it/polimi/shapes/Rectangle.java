package it.polimi.shapes;

public class Rectangle extends Shape {
    public double base;
    protected double height;

    public Rectangle(double b, double h) {
        this.base = b;
        this.height = h;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    @Override
    public double getArea() {
        return base * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (base + height);
    }

}
