package test.java.pl.yameo.internship.assignment;

import main.java.pl.yameo.internship.assignment.Rectangle;
import main.java.pl.yameo.internship.assignment.Square;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class SquareTest {

	private static final double DELTA = 0.001;
	private static final String SHAPE_NAME = "Square";

	private static final double INITIAL_DIMENSION = 7.0;

	private static final double NEW_DIMENSION = 5.0;
	private static final double NEW_EDGE_LENGTH = 5.0;

	private static final double EXPECTED_AREA = 49.0;
	private static final double NEW_EXPECTED_AREA = 25.0;

	private static final double EXPECTED_PERIMETER = 28.0;
	private static final double NEW_EXPECTED_PERIMETER = 20.0;

	@Test
	public void when_square_created_then_it_has_proper_name() {

		Square square = new Square(INITIAL_DIMENSION);
		Assert.assertEquals(square.getName(), SHAPE_NAME);
	}

	@Test
	public void when_height_set_then_dimension_is_changed() {

		Square square = new Square(INITIAL_DIMENSION);
		square.setHeight(NEW_EDGE_LENGTH);

		Assert.assertEquals(square.listDimensions().get(0), NEW_EDGE_LENGTH, DELTA);
		Assert.assertEquals(square.listDimensions().get(1), NEW_EDGE_LENGTH, DELTA);
	}

	@Test
	public void when_width_set_then_dimension_is_changed() {

		Square square = new Square(INITIAL_DIMENSION);
		square.setWidth(NEW_EDGE_LENGTH);

		Assert.assertEquals(square.listDimensions().get(0), NEW_EDGE_LENGTH, DELTA);
		Assert.assertEquals(square.listDimensions().get(1), NEW_EDGE_LENGTH, DELTA);
	}

	@Test
	public void when_width_set_then_new_dimension_is_returned() {

		Square square = new Square(INITIAL_DIMENSION);
		square.setDimension(NEW_EDGE_LENGTH);

		Assert.assertEquals(square.listDimensions().get(0), NEW_EDGE_LENGTH, DELTA);
		Assert.assertEquals(square.listDimensions().get(1), NEW_EDGE_LENGTH, DELTA);
	}

	@Test
	public void check_calculatePerimeter_calculateArea_should_return_proper_values(){

		Square square = new Square(INITIAL_DIMENSION);

		Assert.assertEquals(square.calculateArea(), EXPECTED_AREA, DELTA);
		Assert.assertEquals(square.calculatePerimeter(), EXPECTED_PERIMETER, DELTA);
	}

	@Test
	public void check_calculatePerimeter_calculateArea_after_change_should_return_proper_values() {

		Square square = new Square(INITIAL_DIMENSION);

		square.setDimension(NEW_DIMENSION);

		Assert.assertEquals(square.calculateArea(), NEW_EXPECTED_AREA, DELTA);
		Assert.assertEquals(square.calculatePerimeter(), NEW_EXPECTED_PERIMETER, DELTA);
	}

	@Ignore("This fails with the most obvious rectangle rule. Something is wrong.")
	@Test
	public void when_rectangle_width_is_halved_then_its_area_is_halved() {

		Rectangle square = new Square(INITIAL_DIMENSION);
		Assert.assertEquals(square.calculateArea(), EXPECTED_AREA, DELTA);

		square.setWidth(INITIAL_DIMENSION / 2);
		Assert.assertEquals(square.calculateArea(), EXPECTED_AREA / 2, DELTA);
	}
}
