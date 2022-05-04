import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String args[]) throws SQLException {
        PRJGUI prjgui = new PRJGUI();
        LoginGUI gui = new LoginGUI();
        loginfailed loginfailed = new loginfailed();
        addgui add = new addgui();


        JTextField getusername = add.getjTextField1();
        JTextField getpass = add.getjTextField2();
        JButton btnSubmit3 = prjgui.getjButton1();
        JButton btnSubmit4 = prjgui.getjButton2();
        JButton btnSubmit2 = loginfailed.getjButton1();
        //khoi tao doi tuong luu tru gia tri
        JButton btnSubmit1 = gui.getjButton1();
        JPasswordField txtPassword = gui.getjPasswordField1();
        JTextField txtUsername = gui.getjTextField1();
        //hien thi gui
        gui.setVisible(true);
        //them nut on,exit
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //connect data base
        DBConnect connect = new DBConnect();
        //tao action cho button
        btnSubmit1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputUsername = txtUsername.getText();
                String inputPassword = "";
                char[] pass = txtPassword.getPassword();
                for (char c : pass) {
                    inputPassword += c;
                }

                String query = "SELECT password FROM admin WHERE username = '" + inputUsername + "'";
                ResultSet resultSet = connect.executeQuerySelect(query);
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
                        gui.setVisible(false);
                        prjgui.setVisible(true);
                        btnSubmit3.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String inputUsername =
                            }
                        });
                    } else {
                        loginfailed.setVisible(true);
                        btnSubmit2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                loginfailed.setVisible(false);
                                gui.setVisible(true);
                            }
                        });

                    }
                }

            }
        });

    }

}