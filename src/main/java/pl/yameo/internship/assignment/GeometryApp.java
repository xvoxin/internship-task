package main.java.pl.yameo.internship.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeometryApp {
	private Reader reader;
	private List<Shape> shapes = new ArrayList<>();

	public GeometryApp() {
		reader = new Reader();
	}

	public void start() {
		boolean run = true;
		while (run) {
			run = run();
		}
	}

	private boolean run() {
		System.out.println("Choose action:");
		System.out.println("1) Create new shape");
		System.out.println("2) List existing shapes");
		System.out.println("3) Modify one of the shapes from the list");
		System.out.println("0) Exit");

		int option = reader.readInteger();
		if (option == 0) {
			return false;
		} else if (option == 1) {
			Shape newShape = createNewShape();
			if (newShape != null) {
				shapes.add(newShape);
			}
		} else if (option == 2) {
			listShapes();
		} else if (option == 3) {
			modifyShape();
		}

		return true;
	}

	private Shape createNewShape() {
		System.out.println("Choose shape to create:");
		System.out.println("1) Ellipse");
		System.out.println("2) Rectangle");
		System.out.println("3) Circle");
		System.out.println("4) Square");
		System.out.println("5) Triangle");
		System.out.println("0) Back");
		int option = reader.readInteger();

	 	if (option == 1) {
			return createNewEllipse();
		} else if (option == 2) {
			return createNewRectangle();
		} else if (option == 3) {
			return createNewCircle();
		} else if (option == 4) {
			return createNewSquare();
		} else if (option == 5) {
			return createNewTriangle();
		} else {
	 		return null;
		}
	}

	private void listShapes() {
		System.out.println("====== LIST OF SHAPES ======");
		shapes.forEach(shape -> {
			System.out.print(shape.getName() + " with dimensions: ");
			System.out.print(shape.listDimensions() + "; ");
			System.out.print("Area: " + shape.calculateArea() + "; ");
			System.out.println("Perimeter: " + shape.calculatePerimeter());
		});
		System.out.println("============================");
	}

	private void modifyShape() {
		listShapes();
		System.out.println("Please choose the index of the shape you want to modify (1-" + shapes.size() + "): ");
		int index = reader.readInteger();
		Shape activeShape = shapes.get(index - 1);
		List<Double> oldDimensions = activeShape.listDimensions();
		Double oldPerimeter = activeShape.calculatePerimeter();
		Double oldArea = activeShape.calculateArea();

		System.out.print(activeShape.getName() + " with dimensions: ");
		System.out.print(oldDimensions + "; ");
		System.out.print("Area: " + oldArea + "; ");
		System.out.println("Perimeter: " + oldPerimeter);

		if (activeShape instanceof Ellipse) {
			System.out.println("Please provide two semi-axis lengths (major, minor):");
			((Ellipse) activeShape).setSemiMajorAxis(reader.readDouble());
			((Ellipse) activeShape).setSemiMinorAxis(reader.readDouble());
		} else if (activeShape instanceof Circle) {
			System.out.println("Please provide the radius for the circle:");
			((Circle) activeShape).setRadius(reader.readDouble());
		} else if (activeShape instanceof Square) {
			System.out.println("Please provide the edge length:");
			((Square) activeShape).setDimension(reader.readDouble());
		} else if (activeShape instanceof Rectangle) {
			System.out.println("Please provide two edge lengths (height, width):");
			((Rectangle) activeShape).setHeight(reader.readDouble());
			((Rectangle) activeShape).setWidth(reader.readDouble());
		} else if (activeShape instanceof Triangle) {
			System.out.println("Please provide three edge lengths:");
			((Triangle) activeShape).setEdgeA(reader.readDouble());
			((Triangle) activeShape).setEdgeB(reader.readDouble());
			((Triangle) activeShape).setEdgeC(reader.readDouble());
		}

		System.out.println("Old shape: ");
		System.out.print(activeShape.getName() + " with dimensions: ");
		System.out.print(oldDimensions + "; ");
		System.out.print("Area: " + oldArea + "; ");
		System.out.println("Perimeter: " + oldPerimeter);
		System.out.println("============================");
		System.out.println("New shape: ");
		System.out.print(activeShape.getName() + " with dimensions: ");
		System.out.print(activeShape.listDimensions() + "; ");
		System.out.print("Area: " + activeShape.calculateArea() + "; ");
		System.out.println("Perimeter: " + activeShape.calculatePerimeter());
		System.out.println("============================");

	}

	private Ellipse createNewEllipse() {
		System.out.println("Please provide two semi-axis lengths (major, minor):");
		return new Ellipse(reader.readDouble(), reader.readDouble());
	}

	private Rectangle createNewRectangle() {
		System.out.println("Please provide two edge lengths (height, width):");
		return new Rectangle(reader.readDouble(), reader.readDouble());
	}

	private Circle createNewCircle() {
		System.out.println("Please provide the radius for the circle:");
		return new Circle(reader.readDouble());
	}

	private Square createNewSquare() {
		System.out.println("Please provide the edge length:");
		return new Square(reader.readDouble());
	}

	private Triangle createNewTriangle() {
		System.out.println("Please provide three edge lengths:");
		return new Triangle(reader.readDouble(), reader.readDouble(), reader.readDouble());
	}
}
