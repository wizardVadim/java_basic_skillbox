public class Arithmetic {
    private int firstValue;
    private int secondValue;

    public Arithmetic(int firstValue, int secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public int amount() {
        return firstValue + secondValue;
    }

    public int multiplication() {
        return firstValue * secondValue;
    }

    public int maximumValue() {
        if (firstValue > secondValue) {
            return firstValue;
        } else {
            return secondValue;
        }
    }

    public int minimumValue() {
        if (firstValue < secondValue) {
            return firstValue;
        } else {
            return secondValue;
        }
    }
}