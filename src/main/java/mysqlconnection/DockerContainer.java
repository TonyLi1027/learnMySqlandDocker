package mysqlconnection;

import java.sql.*;

public class DockerContainer {


    public static void main(String[] args){
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://192.168.99.100:3306/tablecontact";
        final String USER = "root";
        final String PASS = "password";
        final String query = "SELECT * from contacts_tbl;";

        Connection conn = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database");

            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Connected Successfully");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
            }

            rs.close();
            stmt.close();


        }catch (SQLException e){
            e.printStackTrace();;
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
