
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class AddListFromDB {
    AdminList newlist = new AdminList();

    public List<AdminList> AddListFromDB() {
        List<AdminList> adminList = new ArrayList<>();


        Statement statement = null;
        Connection conn = null;
        DBConnect dbConnect = new DBConnect();
        String url = dbConnect.getUrl();
        String user = dbConnect.getUser();
        String password = dbConnect.getPassword();

        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn == null) {
                System.out.println("Successfully connected.");
                String sql = "SELECT * FROM bang1";
                //Allicate a 'Statement' object in the Connection
                statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    AdminList list = new AdminList(resultSet.getInt("admin_id"), resultSet.getString("username"), resultSet.getString("password"));
                    adminList.add(newlist);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return adminList;
    }
   public static void insert(AdminList bang1)
   {
       PreparedStatement statement = null;
       Connection conn = null;
       DBConnect dbConnect = new DBConnect();
       String url = dbConnect.getUrl();
       String user = dbConnect.getUser();
       String password = dbConnect.getPassword();
       String sql = "INSERT INTO bang1 (username,password) VALUES (?,?)";

       try {
           statement = conn.prepareCall(sql);
           statement.setString(1, bang1.getUsername());
           statement.setString(2,bang1.getPassword());
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
   }
}