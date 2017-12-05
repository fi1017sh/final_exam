import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    Container cp;
    private int w = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int h = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int wlo = 750, hlo = 500;

    private JPanel jpn = new JPanel(new GridLayout(8,1,5,5));
    private JPanel jpnn = new JPanel();
    private JPanel jpne = new JPanel();
    private JPanel jpns = new JPanel();
    private JPanel jpnw = new JPanel();
    private JLabel jlb = new JLabel("打地鼠", SwingConstants.CENTER);
    private JLabel jlbr = new JLabel("*●+5分", SwingConstants.CENTER);
    private JLabel jlbb = new JLabel("*●-5分", SwingConstants.CENTER);
    private JLabel jlbnot = new JLabel("*點錯格子-5分", SwingConstants.CENTER);
    private JButton jbtsim = new JButton("簡單");
    private JButton jbtmed = new JButton("中等");
    private JButton jbtdif = new JButton("困難");
    private JButton jbtexit = new JButton("EXIT");

    public MainFrame(){
        initComp();
    }
    private void initComp(){
        this.setTitle("期末專題_打地鼠遊戲");
        this.setBounds(w/2-wlo/2,h/2-hlo/2,wlo,hlo);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();

        cp.add(jpn, BorderLayout.NORTH);

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

        jpn.add(jbtdif);

        jpn.add(jbtexit);
        jbtexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}