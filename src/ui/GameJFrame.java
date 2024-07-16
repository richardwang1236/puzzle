package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    JMenuItem replayItem = new JMenuItem("Restart");
    JMenuItem reloginItem = new JMenuItem("Sign out");
    JMenuItem closeItem = new JMenuItem("Close");
    JMenuItem accountItem = new JMenuItem("Website");
    JMenuItem helpItem = new JMenuItem("Help");
    JMenuItem animal = new JMenuItem("Animal");
    JMenuItem girl = new JMenuItem("Girl");
    JMenuItem sport = new JMenuItem("Sports");
    int step = 0;
    int[][] data = new int[4][4];
    int x = 0;
    int y = 0;
    int[] arr_animal = {1, 2, 3, 4, 5, 6, 7, 8};
    int[] arr_girl = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    int[] arr_sport = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    String path;

    int[][] win = new int[][]{{1, 5, 9, 13},
            {2, 6, 10, 14},
            {3, 7, 11, 15},
            {4, 8, 12, 0}};

    public GameJFrame() {
        init();
        init_path("Animal");
        initdata();
        initmenu();
        initimage();

        this.setVisible(true);
    }

    private void initmenu() {
        JMenuBar jMenuBar = new JMenuBar();
        JMenu functionJMenu = new JMenu("Function");
        JMenu aboutJMenu = new JMenu("About");
        JMenu sub = new JMenu("Change Picture");
        functionJMenu.add(sub);
        functionJMenu.add(replayItem);
        functionJMenu.add(reloginItem);
        functionJMenu.add(closeItem);
        aboutJMenu.add(accountItem);
        aboutJMenu.add(helpItem);
        sub.add(animal);
        sub.add(girl);
        sub.add(sport);
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);
        this.setJMenuBar(jMenuBar);
        replayItem.addActionListener(this);
        reloginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        helpItem.addActionListener(this);
        animal.addActionListener(this);
        girl.addActionListener(this);
        sport.addActionListener(this);

    }

    public void init() {
        this.setTitle("Puzzle Game");
        this.setSize(610, 680);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        this.addKeyListener(this);
    }

    public void init_path(String s) {
        Random r1 = new Random();
        if (s == "Animal") {
            int randomIndex = r1.nextInt(arr_animal.length);
            int index = arr_animal[randomIndex];
            path = "image/animal/animal" + index + "/";
        } else if (s == "Girl") {
            int randomIndex = r1.nextInt(arr_girl.length);
            int index = arr_girl[randomIndex];
            path = "image/girl/girl" + index + "/";

        } else {
            int randomIndex = r1.nextInt(arr_sport.length);
            int index = arr_sport[randomIndex];
            path = "image/sport/sport" + index + "/";
        }

    }

    public void initdata() {
        int[] tem = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random r = new Random();
        for (int i = 0; i < tem.length; i++) {
            int index = r.nextInt(tem.length);
            int tem_num = tem[index];
            tem[index] = tem[i];
            tem[i] = tem_num;
        }
        for (int i = 0; i < tem.length; i++) {
            data[i / 4][i % 4] = tem[i];
            if (tem[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
        }
    }

    public void initimage() {
        this.getContentPane().removeAll();
        if (win()) {
            ImageIcon win = new ImageIcon("image/win.png");
            JLabel win1 = new JLabel(win);
            win1.setBounds(203, 283, 197, 73);
            this.add(win1);
        }
        JLabel step_num = new JLabel("Step:" + step);
        step_num.setBounds(450, 10, 100, 50);
        Font currentFont = step_num.getFont();
        step_num.setFont(currentFont.deriveFont(24.0f));
        this.add(step_num);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = data[i][j];
                ImageIcon icon = new ImageIcon(path + num + ".jpg");
                JLabel jLabel = new JLabel(icon);
                jLabel.setBounds((105 * i) + 83, (105 * j) + 134, 105, 105);
                jLabel.setBorder(new BevelBorder(0));
                this.add(jLabel);
            }

        }
        ImageIcon bg = new ImageIcon("image/background.png");
        JLabel background = new JLabel(bg);
        background.setBounds(40, 40, 508, 560);
        this.add(background);
        this.getContentPane().repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (win()) {
            return;
        }
        if (code == 65) {
            this.getContentPane().removeAll();
            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.add(all);
            ImageIcon bg = new ImageIcon("image/background.png");
            JLabel background = new JLabel(bg);
            background.setBounds(40, 40, 508, 560);
            this.add(background);
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //up down left right 38 40 37 39
        int code = e.getKeyCode();
        if (win()) {
            return;
        }
        if (code == 37) {
            if (x == 3) {
                return;
            }
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            step++;
            initimage();
        } else if (code == 39) {
            if (x == 0) {
                return;
            }
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            step++;
            initimage();
        } else if (code == 38) {
            if (y == 3) {
                return;
            }
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            step++;
            initimage();
        } else if (code == 40) {
            if (y == 0) {
                return;
            }
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            step++;
            initimage();
        } else if (code == 65) {
            initimage();
        } else if (code == 87) {
            data = new int[][]{{1, 5, 9, 13},
                    {2, 6, 10, 14},
                    {3, 7, 11, 15},
                    {4, 8, 12, 0}};
            initimage();
        }

    }

    public boolean win() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != win[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == replayItem) {
            step = 0;
            initdata();
            initimage();
        } else if (obj == closeItem) {
            System.exit(0);
        } else if (obj == accountItem) {
            JDialog jDialog = new JDialog();
            JLabel web = new JLabel(new ImageIcon("image/about.png"));
            web.setBounds(0, 0, 258, 258);
            jDialog.add(web);
            jDialog.setSize(344, 344);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setModal(true);
            jDialog.setVisible(true);
        } else if (obj == helpItem) {
            JDialog jDialog1 = new JDialog();
            JLabel help = new JLabel(new ImageIcon("image/help.png"));
            help.setBounds(0, 0, 900, 500);
            jDialog1.add(help);
            jDialog1.setSize(900, 500);
            jDialog1.setAlwaysOnTop(true);
            jDialog1.setLocationRelativeTo(null);
            jDialog1.setModal(true);
            jDialog1.setVisible(true);

        } else if (obj == girl) {
            init_path("Girl");
            initdata();
            initimage();

        } else if (obj == animal) {
            init_path("Animal");
            initdata();
            initimage();

        } else if (obj == sport) {
            init_path("Sport");
            initdata();
            initimage();

        } else {
            this.setVisible(false);
            new LoginJFrame();
        }
    }
}

