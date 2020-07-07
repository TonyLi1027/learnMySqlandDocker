package mysqlconnection;

import java.sql.*;

public class DockerContainer {


    public static void main(String[] args){
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://192.168.99.100:3306/tablecontact";
        final String USER = "root";
        final String PASS = "password";
        final String query = "SELECT * from contacts_tbl;";
        int id = 2;

        Connection conn = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database");

            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Connected Successfully");

            Statement stmt = conn.createStatement();

            /*String updateQuery = "INSERT INTO contacts_tbl (contactID, contact_name, contact_lastname, contact_phoneNume, contact_email)" + "VALUES(3,'Deep','Li',1234567890,'haha@java.com')";
            stmt.executeUpdate(updateQuery);

            updateQuery = "INSERT INTO contacts_tbl (contactID, contact_name, contact_lastname, contact_phoneNume, contact_email)" + "VALUES(4,'Aril','Lavri',12342314,'chasl@java.com')";
            stmt.executeUpdate(updateQuery);

            updateQuery = "INSERT INTO contacts_tbl (contactID, contact_name, contact_lastname, contact_phoneNume, contact_email)" + "VALUES(5,'Taylor','Swift',17151615,'tyswift@java.com')";
            stmt.executeUpdate(updateQuery);

            updateQuery = "INSERT INTO contacts_tbl (contactID, contact_name, contact_lastname, contact_phoneNume, contact_email)" + "VALUES(6,'Nick','Ming',90233334,'slalthai@java.com')";
            stmt.executeUpdate(updateQuery);*/

            ResultSet rs = stmt.executeQuery(query);



            while(rs.next()){
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println(rs.getString(5));
            }


            //rs.close();
            //stmt.close();


        }catch (SQLException e){
            e.printStackTrace();;
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }

}
