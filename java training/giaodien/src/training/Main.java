package training;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String args[]) throws SQLException {
        GUI gui = new GUI();
        //khoi tao doi tuong luu tru gia tri
        JButton btnSubmit = gui.getjButton1();
        JPasswordField txtPassword = gui.getjPasswordField1();
        JTextField txtUsername = gui.getjTextField1();
        //hien thi gui
        gui.setVisible(true);
        //them nut on,exit
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //connect data base
        DBConnect connect = new DBConnect();
        //tao action cho button
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputUsername = txtUsername.getText();
                String inputPassword = "";
                char[] pass = txtPassword.getPassword();
                for (char c : pass) {
                    inputPassword += c;
                }

                String query = "SELECT password FROM admin WHERE username = " + inputUsername + "'";
                ResultSet resultSet = connect.excuteQuerySelect(query);
                if (resultSet != null) {
                    String password = "";
                    try {
                        while (resultSet.next()) {
                            password = resultSet.getString("password");
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    if (password.equals(inputPassword)) {
                        System.out.println("Successfully log in");
                    } else {
                        System.out.println("Log in failed");
                    }
                }

            }
        });

    }
}
