package test.java.pl.yameo.internship.assignment;

import main.java.pl.yameo.internship.assignment.Triangle;
import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

	private static final Double DELTA = 0.001;

	private static final Double INITIAL_EDGE_A = 3.0;
	private static final Double INITIAL_EDGE_B = 4.0;
	private static final Double INITIAL_EDGE_C = 5.0;

	private static final Double NEW_EDGE_A = 6.0;
	private static final Double NEW_EDGE_C = 8.0;

	private static final Double EXPECTED_AREA = 6.0;
	private static final Double EXPECTED_PERIMETER = 12.0;

	private static final Double NEW_EXPECTED_AREA = 11.619;
	private static final Double NEW_EXPECTED_PERIMETER = 18.0;

	@Test
	public void when_triangle_is_created_then_proper_dimensions_are_returned() {

		Triangle triangle = new Triangle(INITIAL_EDGE_A, INITIAL_EDGE_B, INITIAL_EDGE_C);

		Assert.assertEquals(INITIAL_EDGE_A, triangle.listDimensions().get(0), 0.0001);
		Assert.assertEquals(INITIAL_EDGE_B, triangle.listDimensions().get(1), 0.0001);
		Assert.assertEquals(INITIAL_EDGE_C, triangle.listDimensions().get(2), 0.0001);
	}

	//@Ignore("Not checked.")
	@Test(expected = IllegalArgumentException.class)
	public void when_impossible_triangle_is_created_then_exception_is_thrown() {

		new Triangle(INITIAL_EDGE_A, 1.0, INITIAL_EDGE_C);
	}

	@Test
	public void check_calculateArea_and_calculatePerimeter_should_return_proper_values(){

		Triangle triangle = new Triangle(INITIAL_EDGE_A, INITIAL_EDGE_B, INITIAL_EDGE_C);

		Assert.assertEquals(triangle.calculateArea(), EXPECTED_AREA, DELTA);
		Assert.assertEquals(triangle.calculatePerimeter(), EXPECTED_PERIMETER, DELTA);
	}

	@Test
	public void check_calculateArea_and_calculatePerimeter_after_changes_should_return_proper_values(){

		Triangle triangle = new Triangle(INITIAL_EDGE_A, INITIAL_EDGE_B, INITIAL_EDGE_C);

		triangle.setEdgeA(NEW_EDGE_A);
		triangle.setEdgeC(NEW_EDGE_C);

		Assert.assertEquals(triangle.calculateArea(), NEW_EXPECTED_AREA, DELTA);
		Assert.assertEquals(triangle.calculatePerimeter(), NEW_EXPECTED_PERIMETER, DELTA);
	}

	@Test
	public void when_triangle_was_changed_then_proper_dimensions_are_returned() {

		Triangle triangle = new Triangle(INITIAL_EDGE_A, INITIAL_EDGE_B, INITIAL_EDGE_C);

		triangle.setEdgeA(NEW_EDGE_A);
		triangle.setEdgeC(NEW_EDGE_C);

		Assert.assertEquals(NEW_EDGE_A, triangle.listDimensions().get(0), DELTA);
		Assert.assertEquals(INITIAL_EDGE_B, triangle.listDimensions().get(1), DELTA);
		Assert.assertEquals(NEW_EDGE_C, triangle.listDimensions().get(2), DELTA);
	}

}
