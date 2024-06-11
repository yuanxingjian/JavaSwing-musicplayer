


import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
import java.util.Enumeration;
import java.awt.event.ActionEvent;


import javax.sound.sampled.*;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;


/**
 * Swing设置窗体背景图片
 */
public class PlayMusic {
    public int flag = 0;
    private JFrame frame;
    static boolean flag1 = false;
    static boolean flag2 = false;
    static boolean flag3 = false;
    static boolean flag4 = false;
    static int num=-1;
    static String choice=null;



    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        InitGlobalFont(new Font("宋体", Font.PLAIN, 30));  //统一设置字体
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PlayMusic window = new PlayMusic();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public PlayMusic() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        // 初始化窗体
        frame = new JFrame("袁兴健");
        frame.setBounds(500, 60, 800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        URL resource = PlayMusic.class.getClassLoader().getResource("33.png");
        Image image = new ImageIcon(resource).getImage();
        frame.setIconImage(image);

        // 按钮1
        JButton btnNewButton_1 = new JButton("点击显示图片");
        btnNewButton_1.setBounds(300, 150, 240, 50);
        frame.getContentPane().add(btnNewButton_1);

        // 按钮2
        JButton btnNewButton = new JButton("点击播放音乐");
        btnNewButton.setBounds(100, 380, 240, 50);
        frame.getContentPane().add(btnNewButton);
        //按钮3
        JButton btnNewButton2 = new JButton("点击播放视频");
        btnNewButton2.setBounds(300, 514, 240, 50);
        frame.getContentPane().add(btnNewButton2);
        //按钮4
        JButton btnNewButton3 = new JButton("点击停止播放音乐");
        btnNewButton3.setBounds(400, 334, 300, 50);
        frame.getContentPane().add(btnNewButton3);
        //按钮5
        JButton btnNewButton4 = new JButton("点击选择歌曲");
        btnNewButton4.setBounds(100, 250, 240, 50);
        frame.getContentPane().add(btnNewButton4);

        // 设置背景
        JLabel lblBackground = new JLabel(); // 创建一个标签组件对象
        URL resource1 = this.getClass().getResource("wish.jpg"); // 获取背景图片路径
        ImageIcon icon = new ImageIcon(resource1); // 创建背景图片对象
        lblBackground.setIcon(icon); // 设置标签组件要显示的图标
        lblBackground.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); // 设置组件的显示位置及大小
        frame.getContentPane().add(lblBackground); // 将组件添加到面板中
        btnNewButton_1.addActionListener(new ActionListener() {
            //单击按钮1执行的方法
            public void actionPerformed(ActionEvent e) {
                closeThis();
//创建新的窗口
                JFrame frame = new JFrame("图片");
//设置在屏幕的位置
                frame.setLocation(700, 50);
                URL resource = PlayMusic.class.getClassLoader().getResource("44.jpg");
                Image image = new ImageIcon(resource).getImage();
                frame.setIconImage(image);
// 窗体大小
                frame.setSize(835, 759);
                JLabel lblBackground2 = new JLabel(); // 创建一个标签组件对象
                URL resource1 = this.getClass().getResource("22.jpg"); // 获取背景图片路径
                ImageIcon icon = new ImageIcon(resource1); // 创建背景图片对象
                lblBackground2.setIcon(icon); // 设置标签组件要显示的图标
                lblBackground2.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); // 设置组件的显示位置及大小
                frame.getContentPane().add(lblBackground2); // 将组件添加到面板中
// 显示窗体
                frame.setVisible(true);
            }

            private void closeThis() {
//                frame.dispose();
            }
        });
        btnNewButton3.addActionListener(new ActionListener() {
            //单击按钮执行的方法
            public void actionPerformed(ActionEvent ex) {
                closeThis();
                if (flag1) {
                    flag1 = false;
                    return;
                }
                if (flag == 0 || flag1)
                    JOptionPane.showMessageDialog(null, "请先收听音乐再点击此按钮，不然无反应", "温馨提示哈哈", JOptionPane.ERROR_MESSAGE);
                flag1 = false;
            }

            private void closeThis() {
            }
        });

        btnNewButton4.addActionListener(new ActionListener() {
            //单击按钮5执行的方法
            public void actionPerformed(ActionEvent ex) {
                closeThis();
                if(flag3==true&&flag4==true)
                {
                    JOptionPane.showMessageDialog(null, "请先关闭音乐再选择歌曲", "温馨提示哈哈", JOptionPane.ERROR_MESSAGE);
                    flag4=false;
                    return;}
                flag3=true;
                choice=(String) JOptionPane.showInputDialog(null,
                        "请选择想要播放的歌曲",
                        "选择框",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new String[]{"This Wish","At All Costs","Welcome to Rosas"},
                        "This Wish");
            }

            private void closeThis() {
            }
        });

        btnNewButton.addActionListener(new ActionListener() {
            //单击按钮2执行的方法
            public void actionPerformed(ActionEvent ex) {
                closeThis();
                if (flag2 == true)
                    JOptionPane.showMessageDialog(null, "不能同时播放音乐，请先关闭音乐再点击此按钮", "温馨提示哈哈", JOptionPane.ERROR_MESSAGE);
            }

            private void closeThis() {
            }
        });
        btnNewButton.addActionListener(new ActionListener() {
            //单击按钮2执行的方法
            public void actionPerformed(ActionEvent ex) {
                if (flag == 1)
                    return;
                if(flag3==false)
                {
                    JOptionPane.showMessageDialog(null, "请先选择歌曲", "温馨提示哈哈", JOptionPane.ERROR_MESSAGE);
                 return;
                }

                closeThis();
                flag = 1;

                new Thread() {
                    public void run() {
                        try {
                            Clip bgm = null;
                            try {
                                bgm = AudioSystem.getClip();
                            } catch (LineUnavailableException e) {
                                e.printStackTrace();
                            }
                            URL url = null;
                            if(choice.equals("This Wish"))
                            url = this.getClass().getClassLoader().getResource("1.wav");
                            else if (choice.equals("At All Costs"))
                                url = this.getClass().getClassLoader().getResource("2.wav");
                            else if (choice.equals("Welcome to Rosas"))
                                url = this.getClass().getClassLoader().getResource("3.wav");
                            //InputStream is = this.getClass().getClassLoader().getResourceAsStream("33.wav");
                            AudioInputStream ais = null;
                            try {
                                ais = AudioSystem.getAudioInputStream(url);
                                ;
                            } catch (UnsupportedAudioFileException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            try {
                                bgm.open(ais);
                            } catch (LineUnavailableException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            flag4=true;
                            bgm.start();
                            if(choice.equals("This Wish"))
                            JOptionPane.showMessageDialog(null, "正在收听《This Wish》", "提示", JOptionPane.INFORMATION_MESSAGE);
                            else if(choice.equals("At All Costs"))
                                JOptionPane.showMessageDialog(null, "正在收听《At All Costs》", "提示", JOptionPane.INFORMATION_MESSAGE);
                            else if(choice.equals("Welcome to Rosas"))
                                JOptionPane.showMessageDialog(null, "正在收听《Welcome to Rosas》", "提示", JOptionPane.INFORMATION_MESSAGE);
                            flag2 = true;
                            bgm.loop(Clip.LOOP_CONTINUOUSLY);

                            Clip finalBgm = bgm;
                            flag1 = false;
                            btnNewButton3.addActionListener(new ActionListener() {
                                //单击按钮执行的方法
                                public void actionPerformed(ActionEvent ex) {
                                    closeThis();
                                    if (flag == 1) {
                                        finalBgm.close();
                                        flag = 0;
                                        flag1 = true;
                                        flag2 = false;
                                        //flag3=true;
                                        flag4=false;
//
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }

            private void closeThis() {
//                frame.dispose();
            }
        });

              btnNewButton2.addActionListener(new ActionListener() {
                    //单击按钮3执行的方法
                    public void actionPerformed(ActionEvent ex) {
                        closeThis();

                        new Thread() {
                            public void run() {
                                String absolutePath = System.getProperty("user.dir");
                                System.out.println(absolutePath);
                                Runtime r = Runtime.getRuntime();
                                try {

                                    r.exec("cmd /c start " + absolutePath + "\\jre\\src\\2.mkv");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                        }.start();

                    }

                    private void closeThis() {
//                frame.dispose();

                        //flag3 = true;
                    }
                });
    }

    /**
     * 统一设置字体，父界面设置之后，所有由父界面进入的子界面都不需要再次设置字体
     */
    private static void InitGlobalFont(Font font) {
        FontUIResource fontRes = new FontUIResource(font);
        for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements(); ) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                UIManager.put(key, fontRes);
            }
        }
    }
}