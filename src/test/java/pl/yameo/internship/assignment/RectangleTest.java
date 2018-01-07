package test.java.pl.yameo.internship.assignment;

import main.java.pl.yameo.internship.assignment.Rectangle;
import org.junit.Assert;
import org.junit.Test;

public class RectangleTest {

    private static final double DELTA = 0.001;
    private static final String SHAPE_NAME = "Rectangle";

    private static final double INITIAL_HEIGHT = 7.0;
    private static final double INITIAL_WIDTH = 4.0;

    private static final double NEW_HEIGHT = 5.0;
    private static final double NEW_WIDTH = 18.0;

    private static final double EXPECTED_AREA = 28.0;
    private static final double NEW_EXPECTED_AREA = 90.0;

    private static final double EXPECTED_PERIMETER = 22.0;
    private static final double NEW_EXPECTED_PERIMETER = 46.0;


    @Test
    public void when_rectangle_created_then_it_has_proper_name() {

        Rectangle rectangle = new Rectangle(INITIAL_HEIGHT, INITIAL_WIDTH);
        Assert.assertEquals(rectangle.getName(), SHAPE_NAME);
    }

    @Test
    public void when_height_set_then_proper_dimensions_are_returned() {

        Rectangle rectangle = new Rectangle(INITIAL_HEIGHT, INITIAL_WIDTH);
        rectangle.setHeight(NEW_HEIGHT);

        Assert.assertEquals(rectangle.listDimensions().get(0), NEW_HEIGHT, DELTA);
        Assert.assertEquals(rectangle.listDimensions().get(1), INITIAL_WIDTH, DELTA);
    }

    @Test
    public void when_width_set_then_proper_dimensions_are_returned() {

        Rectangle rectangle = new Rectangle(INITIAL_HEIGHT, INITIAL_WIDTH);
        rectangle.setWidth(NEW_WIDTH);

        Assert.assertEquals(rectangle.listDimensions().get(0), INITIAL_HEIGHT, DELTA);
        Assert.assertEquals(rectangle.listDimensions().get(1), NEW_WIDTH, DELTA);
    }

    @Test
    public void check_calculatePerimeter_calculateArea_should_return_proper_values(){

        Rectangle rectangle = new Rectangle(INITIAL_HEIGHT, INITIAL_WIDTH);

        Assert.assertEquals(rectangle.calculateArea(), EXPECTED_AREA, DELTA);
        Assert.assertEquals(rectangle.calculatePerimeter(), EXPECTED_PERIMETER, DELTA);
    }

    @Test
    public void check_calculatePerimeter_calculateArea_after_change_should_return_proper_values() {

        Rectangle rectangle = new Rectangle(INITIAL_HEIGHT, INITIAL_WIDTH);

        rectangle.setHeight(NEW_HEIGHT);
        rectangle.setWidth(NEW_WIDTH);

        Assert.assertEquals(rectangle.calculateArea(), NEW_EXPECTED_AREA, DELTA);
        Assert.assertEquals(rectangle.calculatePerimeter(), NEW_EXPECTED_PERIMETER, DELTA);
    }

    @Test
    public void when_rectangle_width_is_halved_then_its_area_is_halved() {

        Rectangle rectangle = new Rectangle(INITIAL_HEIGHT, INITIAL_WIDTH);
        rectangle.setWidth(INITIAL_WIDTH / 2);

        Assert.assertEquals(rectangle.calculateArea(), EXPECTED_AREA / 2, DELTA);
    }
}
