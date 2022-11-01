package ru.skillbox;

import java.util.Scanner;

public class Cargo {

    private final int volume;
    private final int weight;
    private final String deliveryAddress;
    private final boolean coup;
    private final String registrationNumber;
    private final boolean fragility;


    public Cargo(int volume, int weight, String deliveryAddress, boolean coup, String registrationNumber, boolean fragility) {
        this.volume = volume;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.coup = coup;
        this.registrationNumber = registrationNumber;
        this.fragility = fragility;
        System.out.println("Объем: " + volume + "\n"
                + "Вес: " + weight + "\n"
                + "Адрес доставки: " + deliveryAddress + "\n"
                + "Можно переворачивать? " + coup + "\n"
                + "Номер регистрации: " + registrationNumber + "\n"
                + "Хрупкий? " + fragility);
    }

    public Cargo setDimensions() {
        System.out.println("Введите длину груза: ");
        int lenght = new Scanner(System.in).nextInt();
        System.out.println("Введите ширину груза: ");
        int width = new Scanner(System.in).nextInt();
        System.out.println("Введите высоту груза: ");
        int height = new Scanner(System.in).nextInt();
        Dimensions dimensions = new Dimensions(lenght, width, height);
        dimensions.calculatingTheVolume();
        return new Cargo(dimensions.getVolume(), weight, deliveryAddress, coup, registrationNumber, fragility);
    }

    public Cargo setWeight(int weight) {
        return new Cargo(volume, weight, deliveryAddress, coup, registrationNumber, fragility);
    }

    public Cargo setDeliveryAddress(String deliveryAddress) {
        return new Cargo(volume, weight, deliveryAddress, coup, registrationNumber, fragility);
    }

    public int getVolume() {
        return volume;
    }

    public int getWeight() {
        return weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public boolean isCoup() {
        return coup;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean isFragility() {
        return fragility;
    }



}
