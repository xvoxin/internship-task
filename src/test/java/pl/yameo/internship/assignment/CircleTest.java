package test.java.pl.yameo.internship.assignment;

import main.java.pl.yameo.internship.assignment.Circle;
import org.junit.Assert;
import org.junit.Test;

public class CircleTest {

    private static final double DELTA = 0.001;
    private static final String SHAPE_NAME = "Circle";
    private static final double PI = 3.141593;

    private static final double INITIAL_RADIUS = 4.0;
    private static final double NEW_RADIUS = 5.0;

    private static final double EXPECTED_AREA = 16.0 * PI;
    private static final double NEW_EXPECTED_AREA = 25.0 * PI;

    private static final double EXPECTED_PERIMETER = 8.0 * PI;
    private static final double NEW_EXPECTED_PERIMETER = 10 * PI;

    @Test
    public void when_circle_created_then_it_has_proper_name() {

        Circle circle = new Circle(INITIAL_RADIUS);
        Assert.assertEquals(circle.getName(), SHAPE_NAME);
    }

    @Test
    public void when_semiMajorAxis_set_then_radius_is_changed() {

        Circle circle = new Circle(INITIAL_RADIUS);
        circle.setSemiMajorAxis(NEW_RADIUS);

        Assert.assertEquals(circle.listDimensions().get(0), NEW_RADIUS, DELTA);
        Assert.assertEquals(circle.listDimensions().get(1), NEW_RADIUS, DELTA);
    }

    @Test
    public void when_semiMinorAxis_set_then_radius_is_changed() {

        Circle circle = new Circle(INITIAL_RADIUS);
        circle.setSemiMinorAxis(NEW_RADIUS);

        Assert.assertEquals(circle.listDimensions().get(0), NEW_RADIUS, DELTA);
        Assert.assertEquals(circle.listDimensions().get(1), NEW_RADIUS, DELTA);
    }

    @Test
    public void when_new_radius_is_set_then_major_and_minor_axis_are_changed() {

        Circle circle = new Circle(INITIAL_RADIUS);
        circle.setRadius(NEW_RADIUS);

        Assert.assertEquals(circle.listDimensions().get(0), NEW_RADIUS, DELTA);
        Assert.assertEquals(circle.listDimensions().get(1), NEW_RADIUS, DELTA);
    }

    @Test
    public void check_calculatePerimeter_calculateArea_should_return_proper_values(){

        Circle circle = new Circle(INITIAL_RADIUS);

        Assert.assertEquals(circle.calculateArea(), EXPECTED_AREA, DELTA);
        Assert.assertEquals(circle.calculatePerimeter(), EXPECTED_PERIMETER, DELTA);
    }

    @Test
    public void check_calculatePerimeter_calculateArea_after_change_should_return_proper_values() {

        Circle circle = new Circle(INITIAL_RADIUS);
        circle.setRadius(NEW_RADIUS);

        Assert.assertEquals(circle.calculateArea(), NEW_EXPECTED_AREA, DELTA);
        Assert.assertEquals(circle.calculatePerimeter(), NEW_EXPECTED_PERIMETER, DELTA);
    }


}
