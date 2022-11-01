import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main
{
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String password = "19092002VizarD";

        Map<String, String> courses = new HashMap<>();

        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT course_name," +
                    " COUNT(subscription_date)/MAX(MONTH(subscription_date)) AS middle_subscriptions_per_month" +
                    " FROM purchaselist GROUP BY course_name;");

            while (resultSet.next()) {
                courses.put(resultSet.getString("course_name"),
                        resultSet.getString("middle_subscriptions_per_month"));
            }

            System.out.println(courses);

            connection.close();
            statement.close();
            resultSet.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
