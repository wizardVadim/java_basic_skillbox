public class ArithmeticCalculator {
    private int firstValue;
    private int secondValue;
    private int result;

    public ArithmeticCalculator(int firstValue, int secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public void calclate(Operation type) { // Вбить тип операции

        if(type == Operation.ADD){ // Сложение
            result = firstValue + secondValue;
        }

        if(type == Operation.SUBTRACT){ // Вычитание (Второе число из первого)
            result = firstValue - secondValue;
        }

        if(type == Operation.MULTIPLY){ // Умножение
            result = firstValue * secondValue;
        }

        if(type == Operation.DIVISION){
            result = firstValue / secondValue; // Деление (Первое число делится на второе)
        }

        System.out.println("Результат: " + result);

    }
}
