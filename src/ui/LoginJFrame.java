package ui;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class LoginJFrame extends JFrame implements MouseListener {
    static ArrayList<User> allUsers = new ArrayList<>();

    static {
        allUsers.add(new User("admin", "admin"));
    }

    JButton login = new JButton();
    JButton register = new JButton();
    JTextField username = new JTextField();
    JTextField password = new JTextField();


    public LoginJFrame() {
        init();
    }

    public void init() {
        this.setSize(430, 420);
        this.setTitle("Login");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);

        JLabel usernameText = new JLabel(new ImageIcon("image/login/用户名.png"));
        usernameText.setBounds(56, 135, 47, 17);
        this.getContentPane().add(usernameText);

        //2.添加用户名输入框

        username.setBounds(135, 134, 200, 30);
        this.getContentPane().add(username);

        //3.添加密码文字
        JLabel passwordText = new JLabel(new ImageIcon("image/login/密码.png"));
        passwordText.setBounds(70, 195, 32, 16);
        this.getContentPane().add(passwordText);

        //4.密码输入框

        password.setBounds(135, 195, 200, 30);
        this.getContentPane().add(password);

        //5.添加登录按钮
        login.setBounds(80, 270, 128, 47);
        login.setIcon(new ImageIcon("image/login/登录按钮.png"));
        //去除按钮的默认边框
        login.setBorderPainted(false);
        //去除按钮的默认背景
        login.setContentAreaFilled(false);
        login.addMouseListener(this);
        this.getContentPane().add(login);

        //6.添加注册按钮
        register.setBounds(210, 270, 128, 47);
        register.setIcon(new ImageIcon("image/login/注册按钮.png"));
        //去除按钮的默认边框
        register.setBorderPainted(false);
        //去除按钮的默认背景
        register.setContentAreaFilled(false);
        register.addMouseListener(this);
        this.getContentPane().add(register);
        ImageIcon bg = new ImageIcon("image/login/background.png");
        JLabel background = new JLabel(bg);
        background.setBounds(0, 0, 437, 390);
        this.add(background);


        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object obj = e.getSource();
        if (obj == login) {

            String usernameInput = username.getText();
            String passwordInput = password.getText();

            User userInfo = new User(usernameInput, passwordInput);

            if (usernameInput.length() == 0 || passwordInput.length() == 0) {
                showJDialog("Username or password can not be empty");
            } else if (contains(userInfo)) {

                this.setVisible(false);
                new GameJFrame();
            } else {
                showJDialog("Wrong username or password ");
            }

        } else {
            this.setVisible(false);
            new RegisterJFrame();
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
        if (e.getSource() == login) {
            login.setIcon(new ImageIcon("image/login/登录按下.png"));
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon("image/login/注册按下.png"));
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == login) {
            login.setIcon(new ImageIcon("image/login/登录按钮.png"));
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon("image/login/注册按钮.png"));
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

    public boolean contains(User userInput) {
        for (int i = 0; i < allUsers.size(); i++) {
            User rightUser = allUsers.get(i);
            if (userInput.getUsername().equals(rightUser.getUsername()) && userInput.getPassword().equals(rightUser.getPassword())) {
                //有相同的代表存在，返回true，后面的不需要再比了
                return true;
            }
        }
        //循环结束之后还没有找到就表示不存在
        return false;
    }

}
