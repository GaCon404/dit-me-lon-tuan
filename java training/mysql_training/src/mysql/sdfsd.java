package mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class sdfsd {/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

    /**
     *
     * @author Son Nguyen
     */
    public class sql {

        public static List<Hokhau> findAll() {
            List<Hokhau> HokhauList = new ArrayList<>();

            String url = "jdbc:mysql://localhost:3306/hokhau";
            var user = "root";
            var password = "";
            Connection conn = null;
            Statement statement = null;
            try {
                conn = DriverManager.getConnection(url, user, password);
                String sql = "select * from hokhau";
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

            return HokhauList;

        }

        public static void insert(Hokhau hokhau) {

            String url = "jdbc:mysql://localhost:3306/hokhau";
            var user = "root";
            var password = "";

            Connection conn = null;
            PreparedStatement statement = null;
            try {
                conn = DriverManager.getConnection(url, user, password);
                String sql = "insert into hokhau(fullname,address,email,phoneNumber) values(?,?,?,?)";
                statement = conn.prepareCall(sql);
                statement.setString(1, hokhau.getFullname());
                statement.setString(2, hokhau.getAddress());
                statement.setString(3, hokhau.getEmail());
                statement.setString(4, hokhau.getPhoneNumber());
                statement.execute();

            } catch (SQLException ex) {
                Logger.getLogger(sql.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        public static void update(Hokhau hokhau) {

            String url = "jdbc:mysql://localhost:3306/hokhau";
            var user = "root";
            var password = "";

            Connection conn = null;
            PreparedStatement statement = null;
            try {
                conn = DriverManager.getConnection(url, user, password);
                String sql = "update hokhau set fullname=? ,address=?,email=?,phoneNumber=?";
                statement = conn.prepareCall(sql);
                statement.setString(1, hokhau.getFullname());
                statement.setString(2, hokhau.getAddress());
                statement.setString(3, hokhau.getEmail());
                statement.setString(4, hokhau.getPhoneNumber());
                statement.setInt(5, hokhau.getId());
                statement.execute();

            } catch (SQLException ex) {
                Logger.getLogger(sql.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        public static void delete(int id) {

            String url = "jdbc:mysql://localhost:3306/hokhau";
            var user = "root";
            var password = "";

            Connection conn = null;
            PreparedStatement statement = null;
            try {
                conn = DriverManager.getConnection(url, user, password);
                String sql = "delete from hokhau where id=?";
                statement = conn.prepareCall(sql);
                statement.setInt(1, id);
                statement.execute();

            } catch (SQLException ex) {
                Logger.getLogger(sql.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        public static void insert(HoKhau hokhau) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public static List<Hokhau> findbyName(String fullname) {
            List<Hokhau> HokhauList = new ArrayList<>();

            String url = "jdbc:mysql://localhost:3306/hokhau";
            var user = "root";
            var password = "";
            Connection conn = null;
            PreparedStatement statement = null;
            try {
                conn = DriverManager.getConnection(url, user, password);
                String sql = "select * from hokhau where fullname like ?";
                statement.setString(1, "%" + fullname + "%");
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
            return HokhauList;
        }
    }

}
