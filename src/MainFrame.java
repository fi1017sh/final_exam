import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainFrame extends JFrame{
    Container cp;
    private int w = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int h = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int wlo = 750, hlo = 500;

    private JPanel jpn = new JPanel(new GridLayout(8,1,5,5));
    private JPanel jpnn = new JPanel();//空值
    private JPanel jpne = new JPanel();//空值
    private JPanel jpns = new JPanel();//空值
    private JPanel jpnw = new JPanel();//空值
    private JLabel jlb = new JLabel("打地鼠", SwingConstants.CENTER);
    private JLabel jlbr = new JLabel("*●+5分", SwingConstants.CENTER);
    private JLabel jlbb = new JLabel("*●-5分", SwingConstants.CENTER);
    private JLabel jlbnot = new JLabel("*點錯格子-5分", SwingConstants.CENTER);
    private JButton jbtsim = new JButton("簡單");
    private JButton jbtmed = new JButton("中等");
    private JButton jbtdif = new JButton("困難");
    private JButton jbtexit = new JButton("EXIT");

    //--------滑鼠
    private Image image   = new ImageIcon("wood.png").getImage();
    private Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(image,new Point(0,0), "knock");
    private Image Cursor = new ImageIcon("wooddown.png").getImage();
    private Cursor mouseCursor = Toolkit.getDefaultToolkit().createCustomCursor(Cursor,new Point(0,0), "knock");


    public MainFrame(){
        initComp();
    }
    private void initComp(){
        //-----滑鼠改變
        this.setCursor(cursor);
        this.addMouseListener(new MouseListener() {
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

        jbtsim.addMouseListener(new MouseListener() {
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
        jbtmed.addMouseListener(new MouseListener() {
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
        jbtdif.addMouseListener(new MouseListener() {
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
        jbtexit.addMouseListener(new MouseListener() {
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
        this.setTitle("期末專題_打地鼠");
        this.setBounds(w/2-wlo/2,h/2-hlo/2,wlo,hlo);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();


        //-----頁面
        cp.add(jpnn, BorderLayout.NORTH);
        jpnn.setPreferredSize(new Dimension(wlo, 30));
        cp.add(jpn, BorderLayout.CENTER);
        cp.add(jpne, BorderLayout.EAST);
        jpne.setPreferredSize(new Dimension(80, hlo));
        cp.add(jpns, BorderLayout.SOUTH);
        jpns.setPreferredSize(new Dimension(wlo, 20));
        cp.add(jpnw, BorderLayout.WEST);
        jpnw.setPreferredSize(new Dimension(80, hlo));

        jpn.add(jlb);
        jlb.setFont(new Font("微軟正黑體", Font.BOLD, 50));
        jpn.add(jlbr);
        jlbr.setForeground(Color.red);
        jpn.add(jlbb);
        jlbb.setForeground(Color.blue);
        jpn.add(jlbnot);

        jpn.add(jbtsim);
        jbtsim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Simple sim = new Simple(MainFrame.this);
                sim.setVisible(true);
                MainFrame.this.setVisible(false);
            }
        });
        jpn.add(jbtmed);
        jbtmed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medium med = new medium(MainFrame.this);
                med.setVisible(true);
                MainFrame.this.setVisible(false);
            }
        });

        jpn.add(jbtdif);
        jbtdif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                difficult dif = new difficult(MainFrame.this);
                dif.setVisible(true);
                MainFrame.this.setVisible(false);
            }
        });

        jpn.add(jbtexit);
        jbtexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}