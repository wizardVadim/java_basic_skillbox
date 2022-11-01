package GeometryCalculator;

public class GeometryCalculator {


    private double circleRadius;

    private double p; // полупериметр
    private int a; // 1-я сторона
    private int b; // 2-я сторона
    private int c; // 3-я сторона

    private double areaOfTheTriangle;
    private double areaOfTheCircle;
    private double volumeOfTheBall;

    private boolean isTriangle;
    private String triangleBuild;



    //========================================== Возможность построения треугольника

    public void triangleBuild(int a, int b, int c){

        this.a = a;
        this.b = b;
        this.c = c;

        if (a > (b + c)){
            isTriangle = false;
        } else if (b > (a + c)) {
            isTriangle = false;
        } else if (c > (a + b)){
            isTriangle = false;
        } else {
            isTriangle = true;
        }

        if (isTriangle == true){
            triangleBuild = "Вы можете построить треугольник с заданными сторонами!";
        } else {
            triangleBuild = "К сожалению, вы не можете построить данный треугольник :(";
        }
    }

    public String getTriangleBuild() {
        return triangleBuild;
    }


    //========================================== Вычисление объема шара

    public void volumeOfTheBall(int circleRadius){

        this.circleRadius = circleRadius;

        volumeOfTheBall = ( 4 * Math.PI * Math.pow(circleRadius, 3)) / 3;
    }

    public double getVolumeOfTheBall() {
        return volumeOfTheBall;
    }


    //========================================== Вычисление площади треугольника

    public void areaOfTheTriangle(int a, int b, int c){

        this.a = a;
        this.b = b;
        this.c = c;

        p = (double) (a + b + c) / 2.0;

        areaOfTheTriangle = Math.sqrt(p * ( p - a ) * ( p - b ) * ( p - c ));
    }

    public double getAreaOfTheTriangle() {
        return areaOfTheTriangle;
    }

    //========================================== Вычисление площади круга

    public void areaOfTheCircle(int circleRadius){

        this.circleRadius = circleRadius;

        areaOfTheCircle = (Math.PI * Math.pow(circleRadius, 2));


    }

    public double getAreaOfTheCircle() {
        return areaOfTheCircle;
    }


}
