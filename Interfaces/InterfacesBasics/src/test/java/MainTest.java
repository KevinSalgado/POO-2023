import mx.uv.fiee.iinf.poo.Circle;
import mx.uv.fiee.iinf.poo.Rectangle;
import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void CircleTest () throws CloneNotSupportedException {
        Circle circle1 = new Circle (10, 10, 50);
        Circle circle2 = new Circle (10, 10, 50);

        //Assert.assertEquals (0, circle1.compareTo (circle2));
        //Assert.assertEquals (true, circle1.equals(circle2));
        Assert.assertEquals (circle1, circle1.clone ());
    }

    @Test
    public void RectangleTest () throws CloneNotSupportedException {
        Rectangle rectangle1 = new Rectangle (10, 10, 20, 20);
        Rectangle rectangle2 = new Rectangle (10, 10, 20, 20);

        Assert.assertEquals (0, rectangle1.compareTo (rectangle2));
        Assert.assertEquals (rectangle1, rectangle2);
        Assert.assertEquals (rectangle1, rectangle1.clone ());
    }

}
