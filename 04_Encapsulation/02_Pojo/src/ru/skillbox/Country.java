package ru.skillbox;

public class Country {

    private String name;
    private int sizePopulation;
    private int square; //m^2
    private String nameCapital;
    private boolean outSea;

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSizePopulation() {
        return sizePopulation;
    }

    public void setSizePopulation(int sizePopulation) {
        this.sizePopulation = sizePopulation;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public String getNameCapital() {
        return nameCapital;
    }

    public void setNameCapital(String nameCapital) {
        this.nameCapital = nameCapital;
    }

    public boolean isOutSea() {
        return outSea;
    }

    public void setOutSea(boolean outSea) {
        this.outSea = outSea;
    }
}
