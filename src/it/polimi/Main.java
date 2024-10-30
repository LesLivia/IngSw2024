package it.polimi;

import it.polimi.shapes.Circle;
import it.polimi.shapes.Rectangle;
import it.polimi.shapes.Square;

public class Main {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(10.0, 3.3);
        Square s = new Square(2.7);
        Circle c = new Circle(5.0);

        System.out.println(r.getArea());
        System.out.println(s.getArea());
        System.out.println(c.getArea());

        Circle sh = new Circle(10.0);

        System.out.println(sh.getArea());

        r.scale(2);
        System.out.println(r.getArea());

        s.scale(2);
        System.out.println(s.getArea());

    }
}