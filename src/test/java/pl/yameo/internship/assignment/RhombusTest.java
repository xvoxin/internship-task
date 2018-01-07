package test.java.pl.yameo.internship.assignment;

import main.java.pl.yameo.internship.assignment.Rhombus;
import main.java.pl.yameo.internship.assignment.Square;
import org.junit.Assert;
import org.junit.Test;

public class RhombusTest {
    private static final double DELTA = 0.001;
    private static final double MAJOR_DIAGONAL = 8.0;
    private static final double MINOR_DIAGONAL = 6.0;
    private static final double EXPECTED_EDGE = 5.0;

    private static final double NEW_MAJOR_DIAGONAL = 24.0;
    private static final double NEW_EXPECTED_EDGE_1 = 12.37; //very, very rounded

    private static final double NEW_MINOR_DIAGONAL = 10.0;
    private static final double NEW_EXPECTED_EDGE_2 = 13.0;

    private static final String SHAPE_NAME = "Rhombus";
    private static final double EXPCETED_AREA_1 = 24.0;
    private static final double EXPECTED_AREA_2 = 120.0;

    private static final double EXPECTED_PERIMETER_1 = 20.0;
    private static final double EXPECTED_PERIMETER_2 = 52.0;

    @Test
    public void when_rhombus_created_then_it_has_proper_name() {

        Rhombus rhombus = new Rhombus(MAJOR_DIAGONAL, MINOR_DIAGONAL);
        Assert.assertEquals(rhombus.getName(), SHAPE_NAME);
    }

    @Test
    public void when_rhombus_created_ten_it_have_proper_edge(){

        Rhombus rhombus = new Rhombus(MAJOR_DIAGONAL, MINOR_DIAGONAL);
        Assert.assertEquals(rhombus.getEdge(), EXPECTED_EDGE, DELTA);
    }

    @Test
    public void when_minorDiagonal_is_changed_then_edge_changed_too(){

        Rhombus rhombus = new Rhombus(MAJOR_DIAGONAL, MINOR_DIAGONAL);
        rhombus.setMajorDiagonal(NEW_MAJOR_DIAGONAL);
        Assert.assertEquals(rhombus.getEdge(), NEW_EXPECTED_EDGE_1, DELTA);
    }

    @Test
    public void when_minorDiagonal_and_majorDiagonal_are_changed_then_edge_changed_too(){
        Rhombus rhombus = new Rhombus(MAJOR_DIAGONAL, MINOR_DIAGONAL);
        rhombus.setMajorDiagonal(NEW_MAJOR_DIAGONAL);
        rhombus.setMinorDiagonal(NEW_MINOR_DIAGONAL);

        Assert.assertEquals(rhombus.getEdge(), NEW_EXPECTED_EDGE_2, DELTA);
    }

    @Test
    public void check_calculateArea_and_calculatePerimeter_should_return_proper_values(){
        Rhombus rhombus = new Rhombus(MAJOR_DIAGONAL, MINOR_DIAGONAL);
        Assert.assertEquals(rhombus.calculateArea(), EXPCETED_AREA_1, DELTA);
        Assert.assertEquals(rhombus.calculatePerimeter(), EXPECTED_PERIMETER_1, DELTA);
    }

    @Test
    public void check_calculateArea_and_calculatePerimeter_should_return_proper_values_after_changes(){
        Rhombus rhombus = new Rhombus(MAJOR_DIAGONAL, MINOR_DIAGONAL);
        rhombus.setMajorDiagonal(NEW_MAJOR_DIAGONAL);
        rhombus.setMinorDiagonal(NEW_MINOR_DIAGONAL);

        Assert.assertEquals(rhombus.calculateArea(), EXPECTED_AREA_2, DELTA);
        Assert.assertEquals(rhombus.calculatePerimeter(), EXPECTED_PERIMETER_2, DELTA);
    }
}
