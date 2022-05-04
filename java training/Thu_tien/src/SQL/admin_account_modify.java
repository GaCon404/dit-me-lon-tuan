package SQL;
import Table.admin_account;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class admin_account_modify {

    public static List<admin_account> findAll(){
        List<admin_account> admin_accountList = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/account";
        String password = "";
        String user = "root";
        Connection connection = null;
        Statement statement = null;


        try {

            connection = DriverManager.getConnection(url,user,password);
            //quety
            String sql = "select * from admin";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            //lay tat ca gia tri trong quy thieu nhi
            while(resultSet.next()){
                admin_account ad_ac = new admin_account(resultSet.getInt("stt"),
                        resultSet.getString("name"),resultSet.getInt("so_cccd"),
                        resultSet.getInt("phone_number"),resultSet.getString("username"),
                        resultSet.getString("password"));
                admin_accountList.add(ad_ac);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }

        //ket thuc
        return admin_accountList;
    }


    public static void insert(admin_account ad_ac){

        String url = "jdbc:mysql://localhost:3306/account";
        String password = "";
        String user = "root";
        Connection connection = null;
        PreparedStatement statement = null;


        try {

            connection = DriverManager.getConnection(url,user,password);
            //quety
            String sql = "insert into admin(name,so_cccd,phone_number,username,password) values (?,?,?,?,?) ";


            statement = connection.prepareCall(sql);

            statement.setString(1,ad_ac.getName());
            statement.setInt(2,ad_ac.getCccd());
            statement.setInt(3,ad_ac.getPhone_number());
            statement.setString(4,ad_ac.getUsername());
            statement.setString(5,ad_ac.getPassword());

            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }

    }
    public static void update(admin_account ad_ac){

        String url = "jdbc:mysql://localhost:3306/account";
        String password = "";
        String user = "root";
        Connection connection = null;
        PreparedStatement statement = null;


        try {

            connection = DriverManager.getConnection(url,user,password);
            //quety
            String sql = "update admin set password = ? where so_cccd =?";

            statement = connection.prepareCall(sql);

            statement.setString(1,ad_ac.getPassword());
            statement.setInt(2,ad_ac.getCccd());




            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }

    }

    public static void delete(int so_cccd){
        String url = "jdbc:mysql://localhost:3306/account";
        String password = "";
        String user = "root";
        Connection connection = null;
        PreparedStatement statement = null;


        try {
            connection = DriverManager.getConnection(url,user,password);
            String sql = "delete from admin where so_cccd = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1,so_cccd);
            statement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static List<admin_account> findbyName(String name){
        List<admin_account> admin_accountList = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/account";
        String password = "";
        String user = "root";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(url,user,password);
            String sql="select * from admin where name like ?";
            statement=connection.prepareCall(sql);
            statement.setString(1,"%"+name+"%");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                admin_account ad_ac = new admin_account(resultSet.getInt("stt"),
                        resultSet.getString("name"),resultSet.getInt("so_cccd"),
                        resultSet.getInt("phone_number"),resultSet.getString("username"),
                        resultSet.getString("password"));
                admin_accountList.add(ad_ac);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }


        return admin_accountList;
    }


    public static List<admin_account> findbyID(int so_cccd){
        List<admin_account> admin_accountList = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/account";
        String password = "";
        String user = "root";
        Connection connection = null;
        //dua du lieu tu ngoai vao thi dung prepared
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(url,user,password);
            String sql="select * from admin where so_cccd like ?";
            statement=connection.prepareCall(sql);
            statement.setInt(1,so_cccd );
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                admin_account ad_ac = new admin_account(resultSet.getInt("stt"),
                        resultSet.getString("name"),resultSet.getInt("so_cccd"),
                        resultSet.getInt("phone_number"),resultSet.getString("username"),
                        resultSet.getString("password"));
                admin_accountList.add(ad_ac);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }


        return admin_accountList;
    }



    public int CheckID(int so_cccd){
        int dem=0;

        String url = "jdbc:mysql://localhost:3306/account";
        String password = "";
        String user = "root";
        Connection connection = null;
        //dua du lieu tu ngoai vao thi dung prepared
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(url,user,password);
            String sql="select * from admin where ho_khau_id like ?";
            statement=connection.prepareCall(sql);
            statement.setInt(1,so_cccd );
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                dem++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }

        return dem;


    }

    public int CheckSDT(int phone_number){
        int dem=0;

        String url = "jdbc:mysql://localhost:3306/account";
        String password = "";
        String user = "root";
        Connection connection = null;
        //dua du lieu tu ngoai vao thi dung prepared
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(url,user,password);
            String sql="select * from admin where phone_number like ?";
            statement=connection.prepareCall(sql);
            statement.setInt(1,phone_number );
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                dem++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }

        return dem;


    }

}
