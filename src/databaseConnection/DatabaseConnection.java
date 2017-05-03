package databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by User on 12/14/2016.
 */
public class DatabaseConnection {

       String url = "jdbc:mysql://localhost:3306/marksheet";
        String username="root";
        String password="";
    Connection connection=null;
    public  DatabaseConnection(){
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            connection= DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement getPreparedStatement(String query){

        PreparedStatement pstm=null;
        try {
            pstm= connection.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pstm;

    }

}
