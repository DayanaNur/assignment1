package models;
import java.util.List;

public class Shape {
    private List<Point> points;

    public Shape(List<Point> points) {
        this.points = points;
    }

    public double calculatePerimeter() {
        double perimeter = 0.0;
        int size = points.size();

        for (int i = 0; i < size; i++) {
            Point currentPoint = points.get(i);
            Point nextPoint = points.get((i + 1) % size); // замыкаем фигуру
            perimeter += currentPoint.distanceTo(nextPoint);
        }

        return perimeter;
    }

    public double getLongestSide() {
        double longestSide = 0.0;

        for (int i = 0; i < points.size(); i++) {
            Point currentPoint = points.get(i);
            Point nextPoint = points.get((i + 1) % points.size());

            double sideLength = currentPoint.distanceTo(nextPoint);
            if (sideLength > longestSide) {
                longestSide = sideLength;
            }
        }

        return longestSide;
    }

    public double getAverageSide() {
        double totalLength = 0.0;
        int size = points.size();

        for (int i = 0; i < size; i++) {
            Point currentPoint = points.get(i);
            Point nextPoint = points.get((i + 1) % size);
            totalLength += currentPoint.distanceTo(nextPoint);
        }

        return totalLength / size;
    }

    public void addPoint(Point point) {
    }
}