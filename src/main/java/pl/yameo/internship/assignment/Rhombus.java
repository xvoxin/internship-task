package main.java.pl.yameo.internship.assignment;

import java.util.Arrays;
import java.util.List;

public class Rhombus implements Shape {
    private Double majorDiagonal = 0.0;
    private Double minorDiagonal = 0.0;
    private Double edge;

    public Rhombus(Double majorDiagonal, Double minorDiagonal){
        this.majorDiagonal = majorDiagonal;
        this.minorDiagonal = minorDiagonal;
        edge = calculateEdge();
    }
    @Override
    public String getName() {
        return "Rhombus";
    }

    @Override
    public List<Double> listDimensions() {
        return Arrays.asList(majorDiagonal, minorDiagonal, edge);
    }

    @Override
    public Double calculateArea() {
        return majorDiagonal * minorDiagonal / 2;
    }

    @Override
    public Double calculatePerimeter() {
        return 4 * edge;
    }

    public Double getEdge(){
        return edge;
    }

    public void setMajorDiagonal(Double major){
        majorDiagonal = major;
        edge = calculateEdge();
    }

    public void setMinorDiagonal(Double minor){
        minorDiagonal = minor;
        edge = calculateEdge();
    }

    private Double calculateEdge(){
        return Math.sqrt(Math.pow(majorDiagonal / 2, 2) + Math.pow(minorDiagonal / 2, 2));
    }
}
