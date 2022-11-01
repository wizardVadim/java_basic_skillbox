package ru.skillbox;

import java.util.Scanner;

public class Dimensions {


    private int length; //cm
    private int width; //cm
    private int height; //cm
    private int volume; //cm^2

    public int getVolume() {
        return volume;
    }

    public Dimensions(int length, int width, int height) {
        this.length = length;
        this.height = height;
        this.width = width;
    }


    public void calculatingTheVolume() {
        volume = length * width * height;
    }


}
