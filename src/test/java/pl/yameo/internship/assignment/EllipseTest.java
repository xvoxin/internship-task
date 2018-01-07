package test.java.pl.yameo.internship.assignment;

import main.java.pl.yameo.internship.assignment.Ellipse;
import org.junit.Assert;
import org.junit.Test;

public class EllipseTest {

    private static final double DELTA = 0.001;
    private static final String SHAPE_NAME = "Ellipse";
    private static final double PI = 3.141593;

    private static final double INITIAL_SEMIMAJOR = 4.0;
    private static final double INITIAL_SEMIMINOR = 6.0;

    private static final double NEW_SEMIMAJOR = 5.0;
    private static final double NEW_SEMIMINOR = 8.0;


    private static final double EXPECTED_AREA = 24.0 * PI;
    private static final double NEW_EXPECTED_AREA = 40 * PI;

    private static final double EXPECTED_PERIMETER = 10.10102051 * PI;
    private static final double NEW_EXPECTED_PERIMETER = 13.1754448 * PI;

    @Test
    public void when_ellipse_created_then_it_has_proper_name() {

        Ellipse ellipse = new Ellipse(INITIAL_SEMIMAJOR, INITIAL_SEMIMINOR);
        Assert.assertEquals(ellipse.getName(), SHAPE_NAME);
    }

    @Test
    public void when_semiMajorAxis_set_then_proper_axis_are_returned() {

        Ellipse ellipse = new Ellipse(INITIAL_SEMIMAJOR, INITIAL_SEMIMINOR);
        ellipse.setSemiMajorAxis(NEW_SEMIMAJOR);

        Assert.assertEquals(ellipse.listDimensions().get(0), NEW_SEMIMAJOR, DELTA);
        Assert.assertEquals(ellipse.listDimensions().get(1), INITIAL_SEMIMINOR, DELTA);
    }

    @Test
    public void when_semiMinorAxis_set_then_proper_axes_are_returned() {

        Ellipse ellipse = new Ellipse(INITIAL_SEMIMAJOR, INITIAL_SEMIMINOR);
        ellipse.setSemiMinorAxis(NEW_SEMIMINOR);

        Assert.assertEquals(ellipse.listDimensions().get(0), INITIAL_SEMIMAJOR, DELTA);
        Assert.assertEquals(ellipse.listDimensions().get(1), NEW_SEMIMINOR, DELTA);
    }

    @Test
    public void check_calculatePerimeter_calculateArea_should_return_proper_values(){

        Ellipse ellipse = new Ellipse(INITIAL_SEMIMAJOR, INITIAL_SEMIMINOR);

        Assert.assertEquals(ellipse.calculateArea(), EXPECTED_AREA, DELTA);
        Assert.assertEquals(ellipse.calculatePerimeter(), EXPECTED_PERIMETER, DELTA);
    }

    @Test
    public void check_calculatePerimeter_calculateArea_after_change_should_return_proper_values() {

        Ellipse ellipse = new Ellipse(INITIAL_SEMIMAJOR, INITIAL_SEMIMINOR);
        ellipse.setSemiMajorAxis(NEW_SEMIMAJOR);
        ellipse.setSemiMinorAxis(NEW_SEMIMINOR);

        Assert.assertEquals(ellipse.calculateArea(), NEW_EXPECTED_AREA, DELTA);
        Assert.assertEquals(ellipse.calculatePerimeter(), NEW_EXPECTED_PERIMETER, DELTA);
    }


}
