package GeometryCalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int codeNum;

        System.out.println("1 - Вычисление площади круга; 2 - Вычисление площади треугольника;" +
                " 3 - Вычисление объема шара; 4 - Возможно ли построить заданный треугольник?");


        GeometryCalculator geometryCalculator = new GeometryCalculator();

        while (true) {

            System.out.println("Ввод: ");

            codeNum = new Scanner(System.in).nextInt();

            if (codeNum == 1){

                int circleRadius;

                System.out.println("Введите радиус круга: ");
                circleRadius = new Scanner(System.in).nextInt();

                geometryCalculator.areaOfTheCircle(circleRadius);
                System.out.println(geometryCalculator.getAreaOfTheCircle());
            }

            if (codeNum == 2){

                int a;
                int b;
                int c;

                System.out.println("Введите стороны треугольника: ");

                a = new Scanner(System.in).nextInt();
                b = new Scanner(System.in).nextInt();
                c = new Scanner(System.in).nextInt();

                geometryCalculator.areaOfTheTriangle(a, b , c);
                System.out.println(geometryCalculator.getAreaOfTheTriangle());

            }

            if (codeNum == 3){

                int circleRadius;

                System.out.println("Введите радиус круга: ");
                circleRadius = new Scanner(System.in).nextInt();

                geometryCalculator.volumeOfTheBall(circleRadius);
                System.out.println(geometryCalculator.getVolumeOfTheBall());

            }

            if (codeNum == 4){

                int a;
                int b;
                int c;

                System.out.println("Введите стороны треугольника: ");

                a = new Scanner(System.in).nextInt();
                b = new Scanner(System.in).nextInt();
                c = new Scanner(System.in).nextInt();

                geometryCalculator.triangleBuild(a, b ,c);
                System.out.println(geometryCalculator.getTriangleBuild());

            }


        }

    }

}
