package ru.skillbox;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Введите длину груза: ");
        int lenght = new Scanner(System.in).nextInt();
        System.out.println("Введите ширину груза: ");
        int width = new Scanner(System.in).nextInt();
        System.out.println("Введите высоту груза: ");
        int height = new Scanner(System.in).nextInt();
        Dimensions dimensions = new Dimensions(lenght, width, height);
        dimensions.calculatingTheVolume();

        Cargo cargo = new Cargo(dimensions.getVolume(), 10, "New-York", true, "12190301a", true);

        cargo.setDimensions();

        cargo.setWeight(156);

        cargo.setDeliveryAddress("Moscow");


    }
}
