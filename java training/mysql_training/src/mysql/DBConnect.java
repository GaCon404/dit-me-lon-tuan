package mysql;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

import User.Hokhau;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import view.HoKhau;


public class DBConnect {

//connect to data base

    private static Statement statement = null;
    private static Connection connection = null;
    private final String url = "jdbc:mysql://localhost:3306/admin";
    private final String user = "root";
    private final String password = "";

    public DBConnect() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Successfully connected.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public ResultSet excuteQuerySelect(String queryStatement) {
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public boolean excuteQueryUpdate(String queryStatement) {
        int result = 0;
        try {
            statement = connection.createStatement();
            result = statement.executeUpdate(queryStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result > 0;
    }

    /*try {
                Connection conn = DriverManager.getConnection(url, user, password);
                System.out.println("Ket noi thanh cong");
                System.out.println(conn.getCatalog());
            } catch (SQLException ex) {
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);

            }



    //add table
        try {
        String sql = "select * from admin";
        statement = conn.createStatement();
        ResultSet resultset = statement.executeQuery(sql);
        while (resultset.next()) {
            Hokhau hokhau = new Hokhau(resultset.getInt("id"), resultset.getString("fullname"), resultset.getString("address"),
                    resultset.getString("email"), resultset.getString("phoneNumber"));
            HokhauList.add(hokhau);
        }
    } catch (SQLException ex) {
        Logger.getLogger(sql.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(sql.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(sql.class.getName()).log(Level.SEVERE, null, ex);

                }

            }
        }
    }
    }
*/
}