package it.polimi.shapes;

import org.junit.Assert;
import org.junit.Test;

public class RectangleTest {

    @Test
    public void getHeightTest() {
        Rectangle r = new Rectangle(10, 3);

        Assert.assertEquals(3, r.getHeight(), 0.0);
    }

    @Test
    public void getAreaTest() {
        Rectangle r = new Rectangle(10, 3);

        Assert.assertEquals(30, r.getArea(), 0.0);
    }

    @Test
    public void getPerimeterTest() {
        Rectangle r = new Rectangle(10, 3);

        Assert.assertEquals(26, r.getPerimeter(), 0.0);
    }

}
