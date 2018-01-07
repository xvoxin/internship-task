package main.java.pl.yameo.internship.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle implements Shape {
	private Double edgeA = 0.0;
	private Double edgeB = 0.0;
	private Double edgeC = 0.0;


	public Triangle(Double edgeA, Double edgeB, Double edgeC) {

		Double[] edges = new Double[] {edgeA, edgeB, edgeC};
		Arrays.sort(edges);

		if(edges[0] + edges[1] <= edges[2]){

			System.err.println("Triangle with these edges cannot exist!");
			throw new IllegalArgumentException();
		}
		else{
			this.edgeA = edgeA;
			this.edgeB = edgeB;
			this.edgeC = edgeC;
		}
	}

	@Override
	public String getName() {
		return "Triangle";
	}

	@Override
	public final List<Double> listDimensions() {
		return Arrays.asList(edgeA, edgeB, edgeC);
	}

	@Override
	public final Double calculateArea() {
		Double halfPerimeter = calculatePerimeter() / 2;
		return Math.sqrt(halfPerimeter * (halfPerimeter - edgeA) * (halfPerimeter - edgeB) * (halfPerimeter - edgeC));
	}

	@Override
	public final Double calculatePerimeter() {
		return edgeA + edgeB + edgeC;
	}

	public void setEdgeA(Double edgeA) {
		this.edgeA = edgeA;
	}

	public void setEdgeB(Double edgeB) {
		this.edgeB = edgeB;
	}

	public void setEdgeC(Double edgeC) {
		this.edgeC = edgeC;
	}
}
