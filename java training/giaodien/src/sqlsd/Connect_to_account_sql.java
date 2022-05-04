package sqlsd;
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

/**
 *
 * @author Admin
 */
public class Connect_to_account_sql {
    public static List<Account_sql> fillAll(){
        List<Account_sql> AccountList = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/sotien";
        String user = "root";
        String password = "";
        Connection conn = null;
        Statement statement = null;

        try{
            String sql="select * from account_table";
            statement = conn.createStatement();
            ResultSet resultset = statement.executeQuery(sql);
            while(resultset.next()){
                Account_sql account_table = new Account_sql(resultset.getInt("STT"), resultset.getString("Username"), resultset.getString("Password"));
                AccountList.add(account_table);
            }

        }catch (SQLException ex) {
            Logger.getLogger(Account_sql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Account_sql.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Account_sql.class.getName()).log(Level.SEVERE, null, ex);

                    }

                }
            }
        }
        return AccountList;
    }

}
