import java.sql.*;
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
public class DBConnect {

    //Allocate a database 'Connection' object
    private  String url = "jdbc:mysql://localhost:3306/admin";
    private  String user = "root";
    private  String password = "";
    Statement statement = null;
    Connection conn = null;


    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DBConnect() {

        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Successfully connected.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ResultSet executeQuerySelect(String queryStatement) {
        ResultSet resultSet = null;
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(queryStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public boolean excuteQueryUpdate(String queryStatement) {
        int result = 0;
        try {
            statement = conn.createStatement();
            result = statement.executeUpdate(queryStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result > 0;
    }
    }



