import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;



















/*
*public class insert {
   * DBConnect connect = new DBConnect();
    *String query = "SELECT password FROM admin WHERE username = '" + inputUsername + "'";
   * ResultSet resultSet = connect.excuteQuerySelect(query);
  *  public static List<Hokhau> findAll() {
 *       List<Hokhau> HokhauList = new ArrayList<>();
*
*
 *       try {
*
          *  ResultSet resultset = statement.executeQuery(sql);
           * while (resultset.next()) {
          *      Hokhau hokhau = new Hokhau(resultset.getInt("admin_id"), resultset.getString("username"), resultset.getString("password");
         *       HokhauList.add(hokhau);
        *    }
       * } catch (SQLException ex) {
         *   Logger.getLogger(sql.class.getName()).log(Level.SEVERE, null, ex);
        *} finally {
         *   if (statement != null) {
        *        try {
       *             statement.close();
        *        } catch (SQLException ex) {
      *             Logger.getLogger(sql.class.getName()).log(Level.SEVERE, null, ex);
        *        }
     *           if (connect != null) {
    *                try {
   *                     connect.close();
  *                  } catch (SQLException ex) {
 *                       Logger.getLogger(sql.class.getName()).log(Level.SEVERE, null, ex);
*
 *                   }
*
   *             }
  *          }
 *       }
*
 *       return HokhauList;
*
 *   }
*
 *   public static void insert(Hokhau hokhau) {
*
*
 *       connectection  = null;
*        PreparedStatement statement = null;
        *try {
       *     connect = DriverManager.getconnectection(url, user, password);
      *      String sql = "insert into hokhau(fullname,address,email,phoneNumber) values(?,?,?,?)";
     *       statement = connect.prepareCall(sql);
    *        statement.setString(1, hokhau.getFullname());
   *         statement.setString(2, hokhau.getAddress());
  *          statement.setString(3, hokhau.getEmail());
 *           statement.setString(4, hokhau.getPhoneNumber());
            statement.execute();
*
   *     } catch (SQLException ex) {
  *          Logger.getLogger(sql.class.getName()).log(Level.SEVERE, null, ex);
 *       }
*
 *   }
*
*}
*/