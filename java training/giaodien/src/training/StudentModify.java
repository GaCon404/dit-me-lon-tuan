package training;

import java.awt.dnd.DragGestureEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentModify {
    public static List<Student> fillAll() {
        List<Student> studentlist = new ArrayList<>();

        //lay tat ca danh sach sv
        String url = "jdbc:postgresql://localhost:5432/LoginAccount";
        String username = "postgres";
        String password = "12345678";
        Statement statement = null;
        Connection connection = null;
        try {
            connection  = DriverManager.getConnection(url, username, password);

            //query
            String sql="SELECT * FROM student";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Student std = new Student()
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}