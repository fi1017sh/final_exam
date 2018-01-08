import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Simple extends JFrame {
    private ImagePanel jpn = new ImagePanel();
    private int imgW, imgH;

    //-------滑鼠
    private Image image   = new ImageIcon("wood.png").getImage();
    private Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(image,new Point(0,0), "knock");
    private Image Cursor = new ImageIcon("wooddown.png").getImage();
    private Cursor mouseCursor = Toolkit.getDefaultToolkit().createCustomCursor(Cursor,new Point(0,0), "knock");

    //-------頁面設定
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private int fmW=900,fmH=700,screenW= dim.width,screenH=dim.height;
    private Container cp;
    private JPanel jpset = new JPanel(new GridLayout(5,1,3,3));//按扭區
    private JPanel jpmou = new JPanel(new GridLayout(5,5,3,3));//地鼠

    //-------按鈕區
    private int s= 60;//秒數
    private JLabel jlt = new JLabel(" 秒數  "+s+"   ");
    private int sc = 0, a = 5;//分數
    private JLabel jls = new JLabel(" 分數  "+sc+"  ");

    private JLabel jlbempty = new JLabel();//空值

    private JButton jbstart = new JButton("Start");
    private JButton jbexit = new JButton("Exit");

    //-------地鼠區
    private JButton jbs[] = new JButton[25];
    private Timer t1;
    private Timer t2;
    private Timer t3;
    private Random ran = new Random();
    int x;
    private ImageIcon img = new ImageIcon("mousered.png");

    //-------彈出框
    JFrame f=new JFrame();
    String input;

    private MainFrame mainFrame;
    public Simple(MainFrame mframe){
        mainFrame = mframe;
        initComp();
    }

    public void initComp() {
        //------彈出框
        f.setSize(0,0);
        f.setLocationRelativeTo(null);
        Container cp=f.getContentPane();
        cp.setLayout(null);
        f.setVisible(true);

        input=JOptionPane.showInputDialog("請輸入姓名");
        JOptionPane.showMessageDialog(f,"您的姓名為 : " + input);


        //-----滑鼠改變
        this.setCursor(cursor);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                setCursor(mouseCursor);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setCursor(cursor);
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });

        jbexit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                setCursor(mouseCursor);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setCursor(cursor);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        jbstart.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                setCursor(mouseCursor);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setCursor(cursor);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //-----介面設定

        imgW = jpn.getImgWidth();
        imgH = jpn.getImgHeight();
//        this.setBounds(screenW / 2 - fmW / 2, screenH / 2 - fmH / 2, fmW, fmH);
        this.setBounds(screenW / 2 - fmW / 2, screenH / 2 - fmH / 2, imgW, imgH+20);
        this.setResizable(false);//禁止縮放視窗
        this.setTitle("簡單");
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainFrame.setVisible(true);
                dispose();
                t1.stop();
                t2.stop();
                t3.stop();
            }
        });

        //-----版面
        cp = this.getContentPane();
        cp.add(jpn,BorderLayout.CENTER);
        jpn.setLayout(new BorderLayout(3,3));
        jpn.add(jpset,BorderLayout.EAST);
        jpn.add(jpmou,BorderLayout.CENTER);
        jpset.setOpaque(false);
        jpmou.setOpaque(false);

        //-----地鼠按鈕+滑鼠改變
        for(int i =0; i<25 ;i++) {
            jbs[i] = new JButton();
            jbs[i].setIcon(null);
            jbs[i].setEnabled(false);
            jbs[i].setOpaque(false);
            jbs[i].setBorder(null);
            jpmou.add(jbs[i]);
            jbs[i].addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {
                    setCursor(mouseCursor);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    setCursor(cursor);
                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
        }
        //-----按鈕區設定
        jpset.add(jlt);
        jlt.setFont(new Font("Time New Romans", Font.BOLD, 25));


        jpset.add(jls);
        jls.setFont(new Font("Time New Romans", Font.BOLD, 25));

        jpset.add(jlbempty);
        jpset.add(jbstart);
        jpset.add(jbexit);

        jbexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                mainFrame.setVisible(true);
                t1.stop();
                t2.stop();
                t3.stop();
            }
        });

        jbstart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0; i<25; i++) {
                    jbs[i].setOpaque(false);
                    jbs[i].setBorder(null);
                    jbs[i].setContentAreaFilled(false);
                }
                t1.start();
            }
        });

        //-----Timer

        t1 = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(s>0) {
                    s--;
                    jlt.setText(" 秒數  "+s+"   ");
                    t2.start();
                    if(s<59)
                        t3.start();
                }
                else {
                    jlt.setText(Integer.toString(s));
                    for(int i=0; i<25; i++) {
                        jbs[i].setEnabled(false);
                        jbs[i].setOpaque(false);
                        jbs[i].setBorder(null);
                        jbs[i].setContentAreaFilled(false);
                        jbs[i].setIcon(null);
                    }
                    t2.stop();
                    t3.stop();
                    JOptionPane.showMessageDialog(f,input+" :\n您獲得"+Integer.toString(sc)+"分",
                            "得分", JOptionPane.PLAIN_MESSAGE,
                            new ImageIcon("wood.png"));
                    t1.stop();
                }
            }
        });

        t2 = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x = ran.nextInt(25);
                jbs[x].setIcon(img);
                jbs[x].setEnabled(true);
                for(int i=0;i<25;i++) {
                    if (jbs[i].getIcon() == img) {
                        jbs[i].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                sc = sc+a;
                                jls.setText(" 分數  "+sc+"  ");
                                jbs[x].setIcon(null);
                                jbs[x].setEnabled(false);
                            }
                        });
                    }
                }

            }
        });



        t3 = new Timer(1995, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    jbs[x].setIcon(null);
                    jbs[x].repaint();
                    jbs[x].setEnabled(false);
            }
        });

    }


    //-----背景

    class ImagePanel extends JPanel{
        private BufferedImage image;
        private int imgW,imgH;

        public ImagePanel() {
            try {
                image = ImageIO.read(new File("backone.png"));
                imgW = image.getWidth();
                imgH = image.getHeight();
            } catch (IOException ex) {
                javax.swing.JOptionPane.showMessageDialog(this, "IOException" + ex.toString());
            }
        }
         @Override
         protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(image, 0, 0, null);
        }
        public int getImgWidth(){
             return imgW;
        }
        public int getImgHeight(){
            return imgH;
        }
    }

}