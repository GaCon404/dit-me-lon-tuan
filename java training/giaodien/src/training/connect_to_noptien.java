package training;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.LinkedList;

/**
 *
 * @author Admin
 */
public class connect_to_noptien {
    private int tong;

    public int getTong() {
        return tong;
    }

    public void setTong(int tong) {
        this.tong = tong;
    }

    String url = "jdbc:mysql://localhost:3306/sotien";
    String user = "root";
    String password = "";
    Connection conn = null;
    Statement statement = null;
    String sql = "select * from sotien";
    public connect_to_noptien(){
        setTong(0);
        LinkedList<Integer> list = new LinkedList<Integer>();

        try{
            conn = DriverManager.getConnection(url,user,password);
            statement = conn.createStatement();
            ResultSet resultset = statement.executeQuery(sql);
            while(resultset.next()){

                list.add(resultset.getInt("sotien"));



            }
        }catch (SQLException ex) {
            Logger.getLogger(connect_to_noptien.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(connect_to_noptien.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(connect_to_noptien.class.getName()).log(Level.SEVERE, null, ex);

                    }

                }
            }
        }
        for (int i = 0; i < list.size(); i++){
            tong+=list.get(i);
        }

    }

}
