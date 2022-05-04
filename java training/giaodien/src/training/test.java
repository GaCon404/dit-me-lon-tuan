package training;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class test extends JFrame {

    public static void main(String[] args)  {
        // TODO Auto-generated method stub
        test mainWindow = new test();

    }
    public test() {

        // tạo một đối tượng JPanel
        JPanel panel = new JPanel(new FlowLayout());

        // Thêm một JLabel
        JLabel label1 = new JLabel("Button 1: ");
        panel.add(label1);
        //Thêm button 1
        JButton btn1 = new JButton("Click me!");
        panel.add(btn1);
        // Thực thi ActionListener dùng lớp nặc danh
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Show a message box.
                JOptionPane.showMessageDialog(null,"I am button 1");
            }
        });

        // Thêm một JLabel
        JLabel label2 = new JLabel("Button 2: ");
        panel.add(label2);
        //Thêm button 2
        JButton btn2 = new JButton("Click me!");
        panel.add(btn2);
        // Thực thi ActionListener dùng lớp nặc danh
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Show a message box.
                JOptionPane.showMessageDialog(null,"I am button 2");
            }
        });
        // Thiết lập nội dung hiện tại cho panel
        this.setContentPane(panel);

        // thiết lập kích thước cửa sổ
        this.setSize(640, 480);
        // thiết lập thao tác đóng cửa sổ
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // cho phép cửa sổ hiển thị
        this.setVisible(true);
    }


}