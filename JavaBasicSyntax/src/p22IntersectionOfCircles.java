import java.util.Arrays;
import java.util.Scanner;

public class p22IntersectionOfCircles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Point points = new Point();
        points.setX(input[0]);
        points.setY(input[1]);

        Circle firstPoint = new Circle();
        firstPoint.setCenter(new Point());
        firstPoint.getCenter().setX(points.getX());
        firstPoint.getCenter().setY(points.getY());
        firstPoint.setRadius(input[2]);

        int[] secondInput = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Point secondPoints = new Point();
        secondPoints.setX(secondInput[0]);
        secondPoints.setY(secondInput[1]);

        Circle secondPoint = new Circle();
        secondPoint.setCenter(new Point());
        secondPoint.getCenter().setX(secondPoints.getX());
        secondPoint.getCenter().setY(secondPoints.getY());
        secondPoint.setRadius(secondInput[2]);

        double distance = CalculateDistance(firstPoint, secondPoint);

        boolean intersect = Intersect(firstPoint, secondPoint, distance);

        System.out.println(intersect ? "Yes" : "No");
    }

    private static boolean Intersect(Circle firstPoint, Circle secondPoint, double distance) {
        if (distance <= firstPoint.Radius + secondPoint.Radius)
        {
            return true;
        }

        return false;
    }

    private static double CalculateDistance(Circle firstPoint, Circle secondPoint) {
        double sideA = firstPoint.Center.X - secondPoint.Center.X;
        double sideB = firstPoint.Center.Y - secondPoint.Center.Y;
        double distance = Math.sqrt((sideA * sideA) + (sideB * sideB));

        return distance;
    }

}
