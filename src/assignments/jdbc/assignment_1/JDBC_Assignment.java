package assignments.jdbc.assignment_1;
import java.sql.*;

public class JDBC_Assignment {
    public static void main(String[] args){
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/norton_final_project",
                    "root",
                    "chph9771@gmail.com"
            );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM my_data");

            while (resultSet.next()){ //retrieve rows of table my_data
                System.out.println(" ID: " + resultSet.getInt( "id") + " -> Note:  " + resultSet.getString("noted"));

            }
            System.out.println("Connected to Database Successfully 😊👍🏾");
        }catch (SQLException e){
            System.out.println("Database error occurred 🤦‍♂️🥹");
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Error Code: " + e.getErrorCode());
        }catch (Exception e){
            System.out.println("Database Connection error 👈🏾🥹" + e.getMessage());
        }
    }
}
