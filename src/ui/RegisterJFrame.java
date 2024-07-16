package ui;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static ui.LoginJFrame.allUsers;

public class RegisterJFrame extends JFrame implements MouseListener {
    JButton reset = new JButton();
    JButton register = new JButton();
    JTextField password1 = new JTextField();
    JTextField password2 = new JTextField();
    JTextField username = new JTextField();

    public RegisterJFrame() {
        init();
    }

    public void init() {
        this.setSize(430, 370);
        this.setTitle("Rigister");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);

        JLabel usernameText = new JLabel(new ImageIcon("image/register/注册用户名.png"));
        usernameText.setBounds(56, 135, 77, 17);
        this.getContentPane().add(usernameText);

        //2.添加用户名输入框

        username.setBounds(135, 134, 200, 30);
        this.getContentPane().add(username);

        //3.添加密码文字
        JLabel passwordText = new JLabel(new ImageIcon("image/register/注册密码.png"));
        passwordText.setBounds(70, 175, 62, 16);
        this.getContentPane().add(passwordText);

        //4.密码输入框

        password1.setBounds(135, 175, 200, 30);
        this.getContentPane().add(password1);
        JLabel passwordText1 = new JLabel(new ImageIcon("image/register/再次输入密码.png"));
        passwordText1.setBounds(30, 215, 102, 16);
        this.getContentPane().add(passwordText1);

        //4.密码输入框

        password2.setBounds(135, 215, 200, 30);
        this.getContentPane().add(password2);

        //5.添加登录按钮
        reset.setBounds(80, 270, 128, 47);
        reset.setIcon(new ImageIcon("image/register/重置按钮.png"));
        //去除按钮的默认边框
        reset.setBorderPainted(false);
        //去除按钮的默认背景
        reset.setContentAreaFilled(false);
        reset.addMouseListener(this);
        this.getContentPane().add(reset);

        //6.添加注册按钮
        register.setBounds(210, 270, 128, 47);
        register.setIcon(new ImageIcon("image/register/注册按钮.png"));
        //去除按钮的默认边框
        register.setBorderPainted(false);
        //去除按钮的默认背景
        register.setContentAreaFilled(false);
        register.addMouseListener(this);
        this.getContentPane().add(register);
        ImageIcon bg = new ImageIcon("image/register/background.png");
        JLabel background = new JLabel(bg);
        background.setBounds(0, 0, 437, 390);
        this.add(background);


        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object obj = e.getSource();
        if (obj == reset) {
            password1.setText("");
            password2.setText("");
            username.setText("");
        } else {
            String name = username.getText();
            String pass1 = password1.getText();
            String pass2 = password2.getText();
            if (name.length() == 0 || pass1.length() == 0 || pass2.length() == 0) {
                showJDialog("Empty input");
            } else if (!pass1.equals(pass2)) {
                showJDialog("The first password does not match the second one.");
            } else {
                allUsers.add(new User(name, pass1));
                this.setVisible(false);
                new LoginJFrame();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == reset) {
            reset.setIcon(new ImageIcon("image/register/重置按下.png"));
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon("image/register/注册按下.png"));
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == reset) {
            reset.setIcon(new ImageIcon("image/register/重置按钮.png"));
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon("image/register/注册按钮.png"));
        }
    }

    public void showJDialog(String s) {
        JDialog jd = new JDialog();
        jd.setSize(400, 150);
        jd.setAlwaysOnTop(true);
        jd.setLocationRelativeTo(null);
        jd.setModal(true);
        JLabel warning = new JLabel(s);
        warning.setBounds(0, 0, 400, 150);
        jd.add(warning);
        jd.setVisible(true);
    }
}
