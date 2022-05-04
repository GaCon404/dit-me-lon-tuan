package Get_database;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import Sql_add.Account_table;

public class Get_account_table {
    public static List<Account_table> fillAll(){
        List<Account_table> AccountList = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/Account_sql";
        String user = "root";
        String password = "";
        Connection conn = null;
        Statement statement = null;
        String sql="select * from account_table";
        try{

            statement = conn.createStatement();
            ResultSet resultset = statement.executeQuery(sql);
            while(resultset.next()){
                Account_table account_table = new Account_table(resultset.getInt("STT"), resultset.getString("Username"), resultset.getString("Password"));
                AccountList.add(account_table);
            }

        }catch (SQLException ex) {
            Logger.getLogger(Account_table.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Account_table.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Account_table.class.getName()).log(Level.SEVERE, null, ex);

                    }

                }
            }
        }
        return AccountList;
    }
    public static void insert (Account_table account_table)
    {
        String url = "jdbc:mysql://localhost:3306/Account_sql";
        String user = "root";
        String password = "";
        Connection conn = null;
        Statement statement = null;
        try{
            conn = DriverManager.getConnection(url,user,password);
            String sql = "INSERT INTO account_table(username,password)VALUES(?,?)";
            statement = conn.prepareCall(sql);
            ((CallableStatement) statement).setString(2, account_table.getUsername());
            ((CallableStatement) statement).setString(3, account_table.getPassword());
            ((CallableStatement) statement).execute();
        } catch (SQLException ex) {
            Logger.getLogger(Get_account_table.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public static void update (Account_table account_table)
    {
        String url = "jdbc:mysql://localhost:3306/Account_sql";
        String user = "root";
        String password = "";
        Connection conn = null;
        Statement statement = null;
        try{
            conn = DriverManager.getConnection(url,user,password);
            String sql = "UPDATE account_table set username =?, password=?";
            statement = conn.prepareCall(sql);
            ((CallableStatement) statement).setString(2, account_table.getUsername());
            ((CallableStatement) statement).setString(3, account_table.getPassword());
            ((CallableStatement) statement).execute();
        } catch (SQLException ex) {
            Logger.getLogger(Get_account_table.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void delete (Account_table account_table)
    {
        String url = "jdbc:mysql://localhost:3306/Account_sql";
        String user = "root";
        String password = "";
        Connection conn = null;
        Statement statement = null;
        try{
            conn = DriverManager.getConnection(url,user,password);
            String sql = "DELETE FROM account_table WHERE id=?";
            statement = conn.prepareCall(sql);
            ((CallableStatement) statement).setString(2, account_table.getUsername());
            ((CallableStatement) statement).setString(3, account_table.getPassword());
            ((CallableStatement) statement).execute();
        } catch (SQLException ex) {
            Logger.getLogger(Get_account_table.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public static void   java.util.List<Account_table> findbyName(String name)
    {
        List<Account_table> AccountList = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/Account_sql";
        String user = "root";
        String password = "";
        Connection conn = null;
        Statement statement = null;
        try{
            conn = DriverManager.getConnection(url,user,password);
            String sql = "SELECT * FROM account_table WHERE username LIKE ?";
            statement = conn.prepareCall(sql);
            ((CallableStatement) statement).setString(2,"%"+name+"%");

            ResultSet resultset = ((CallableStatement) statement).executeQuery();
            while(resultset.next()){
                Sql_add.Account_table account_table = new Sql_add.Account_table(resultset.getInt("STT"), resultset.getString("Username"), resultset.getString("Password"));
                AccountList.add((Account_table) account_table);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sql_add.Account_table.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Sql_add.Account_table.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Sql_add.Account_table.class.getName()).log(Level.SEVERE, null, ex);

                    }

                }
            }
        }
        return AccountList;
        }
    }


