import models.Point;
import models.Shape;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyApplication {
    public static void main(String[] args) {
        generateRandomCoordinates("points.txt", 10);
        List<Point> points = readPointsFromFile("points.txt");

        if (points != null && points.size() >= 3) {
            Shape shape = new Shape(points);

            double perimeter = shape.calculatePerimeter();
            double longestSide = shape.getLongestSide();
            double averageSide = shape.getAverageSide();

            System.out.println("Perimeter: " + perimeter);
            System.out.println("Long Side: " + longestSide);
            System.out.println("Average Side: " + averageSide);
        } else {
            System.out.println("There are not enough points to build a shape.");
        }
    }

    private static void generateRandomCoordinates(String fileName, int numberOfPoints) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            Random random = new Random();
            for (int i = 0; i < numberOfPoints; i++) {
                double x = random.nextDouble() * 100;
                double y = random.nextDouble() * 100;
                writer.write(x + " " + y);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Point> readPointsFromFile(String fileName) {
        List<Point> points = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] coordinates = line.split(" ");
                if (coordinates.length == 2) {
                    double x = Double.parseDouble(coordinates[0]);
                    double y = Double.parseDouble(coordinates[1]);
                    points.add(new Point(x, y));
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return points;
    }
}


