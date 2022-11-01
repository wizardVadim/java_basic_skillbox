import org.checkerframework.checker.units.qual.C;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Movements movements = new Movements("src/test/resources/movementList.csv");
        System.out.println("Сумма расходов: " + movements.getExpenseSum() + " руб.");
        System.out.println("Сумма расходов: " + movements.getIncomeSum() + " руб.");
        System.out.println("\n" + "Сумма расходов по организациям:" + "\n"
                + movements.expenseSumFromOrganizations());

    }


}
