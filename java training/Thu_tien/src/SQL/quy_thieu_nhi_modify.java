package SQL;
import Table.quy_thieu_nhi;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class quy_thieu_nhi_modify {

    public static List<quy_thieu_nhi> findAll(){
        List<quy_thieu_nhi> quy_thieu_nhiList = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/danh_sach_dong_gop";
        String password = "";
        String user = "root";
        Connection connection = null;
        Statement statement = null;


        try {

            connection = DriverManager.getConnection(url,user,password);
            //quety
            String sql = "select * from quy_thieu_nhi";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            //lay tat ca gia tri trong quy thieu nhi
            while(resultSet.next()){
                quy_thieu_nhi qtn = new quy_thieu_nhi(resultSet.getInt("stt"),resultSet.getInt("ho_khau_id"),resultSet.getString("ten_chu_ho"),resultSet.getInt("so_dien_thoai"),resultSet.getInt("tien_quy_thieu_nhi"));
                quy_thieu_nhiList.add(qtn);
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
        return quy_thieu_nhiList;
    }


public static void insert(quy_thieu_nhi qtn){

    String url = "jdbc:mysql://localhost:3306/danh_sach_dong_gop";
    String password = "";
    String user = "root";
    Connection connection = null;
    PreparedStatement statement = null;


    try {

        connection = DriverManager.getConnection(url,user,password);
        //quety
        String sql = "insert into quy_thieu_nhi(ho_khau_id,  ten_chu_ho,so_dien_thoai,  tien_quy_thieu_nhi) values (?,?,?,?) ";


        statement = connection.prepareCall(sql);

        statement.setInt(1,qtn.getHo_khau_id());
        statement.setString(2,qtn.getTen_chu_ho());
        statement.setInt(3,qtn.getSo_dien_thoai());
        statement.setInt(4,qtn.getTien_quy_thieu_nhi());

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
    public static void update(quy_thieu_nhi qtn){

        String url = "jdbc:mysql://localhost:3306/danh_sach_dong_gop";
        String password = "";
        String user = "root";
        Connection connection = null;
        PreparedStatement statement = null;


        try {

            connection = DriverManager.getConnection(url,user,password);
            //quety
            String sql = "update quy_thieu_nhi set ho_khau_id =?, ten_chu_ho = ?,so_dien_thoai=?, tien_quy_thieu_nhi =? ";

            statement = connection.prepareCall(sql);

            statement.setInt(1,qtn.getHo_khau_id());
            statement.setString(2,qtn.getTen_chu_ho());
            statement.setInt(3,qtn.getSo_dien_thoai());
            statement.setInt(4,qtn.getTien_quy_thieu_nhi());

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

public static void delete(int ho_khau_id){
    String url = "jdbc:mysql://localhost:3306/danh_sach_dong_gop";
    String password = "";
    String user = "root";
    Connection connection = null;
    PreparedStatement statement = null;


    try {
            connection = DriverManager.getConnection(url,user,password);
            String sql = "delete from quy_thieu_nhi where ho_khau_id = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1,ho_khau_id);
            statement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

public static List<quy_thieu_nhi> findbyName(String ten_chu_ho){
        List<quy_thieu_nhi> quy_thieu_nhiList = new ArrayList<>();

    String url = "jdbc:mysql://localhost:3306/danh_sach_dong_gop";
    String password = "";
    String user = "root";
    Connection connection = null;
    PreparedStatement statement = null;

    try {
        connection = DriverManager.getConnection(url,user,password);
        String sql="select * from quy_thieu_nhi where ten_chu_ho like ?";
        statement=connection.prepareCall(sql);
        statement.setString(1,"%"+ten_chu_ho+"%");
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            quy_thieu_nhi qtn = new quy_thieu_nhi(resultSet.getInt("stt"),
                    resultSet.getInt("ho_khau_id"),resultSet.getString("ten_chu_ho"),
                    resultSet.getInt("so_dien_thoai"),resultSet.getInt("tien_quy_thieu_nhi"));
        quy_thieu_nhiList.add(qtn);
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


    return quy_thieu_nhiList;
}


    public static List<quy_thieu_nhi> findbyID(int ho_khau_id){
        List<quy_thieu_nhi> quy_thieu_nhiList = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/danh_sach_dong_gop";
        String password = "";
        String user = "root";
        Connection connection = null;
        //dua du lieu tu ngoai vao thi dung prepared
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(url,user,password);
            String sql="select * from quy_thieu_nhi where ho_khau_id like ?";
            statement=connection.prepareCall(sql);
            statement.setInt(1,ho_khau_id );
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                quy_thieu_nhi qtn = new quy_thieu_nhi(resultSet.getInt("stt"),resultSet.getInt("ho_khau_id"),resultSet.getString("ten_chu_ho"),resultSet.getInt("so_dien_thoai"),resultSet.getInt("tien_quy_thieu_nhi"));
                quy_thieu_nhiList.add(qtn);
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


        return quy_thieu_nhiList;
    }



    public int CheckID(int ho_khau_id){
        int dem=0;

        String url = "jdbc:mysql://localhost:3306/danh_sach_dong_gop";
        String password = "";
        String user = "root";
        Connection connection = null;
        //dua du lieu tu ngoai vao thi dung prepared
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(url,user,password);
            String sql="select * from quy_thieu_nhi where ho_khau_id like ?";
            statement=connection.prepareCall(sql);
            statement.setInt(1,ho_khau_id );
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
