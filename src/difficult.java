import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class difficult extends JFrame {

    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private int fmW=900,fmH=700,screenW= dim.width,screenH=dim.height;
    private Container cp;
    private JPanel jpset = new JPanel(new GridLayout(5,2,3,3));//按扭區
    private JPanel jpn = new JPanel(new GridLayout(5,5,3,3));//地鼠
    private JButton jbstart = new JButton("Start");
    private JButton jbexit = new JButton("Exit");
    private JLabel jlt = new JLabel("秒數");
    private int s= 60;//秒數
    private int sc = 0;//分數
    private JLabel jlbs = new JLabel();//秒數
    private JLabel jlbempty = new JLabel();//空值
    private JLabel jlbempty2 = new JLabel();//空值
    private JLabel jlbempty3 = new JLabel();//空值
    private JLabel jlbempty4 = new JLabel();//空值
    private JLabel jls = new JLabel("分數");
    private JLabel jlbsc = new JLabel(); //分數
    private JButton jbs[] = new JButton[25];
    private Timer t1;
    private boolean flag = false;

    private MainFrame mainFrame;
    public difficult(MainFrame mframe){
        mainFrame = mframe;
        initComp();}

    public void initComp() {
        this.setBounds(screenW / 2 - fmW / 2, screenH / 2 - fmH / 2, fmW, fmH);
        this.setTitle("困難");
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainFrame.setVisible(true);
                dispose();
            }
        });
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        cp.add(jpset,BorderLayout.EAST);
        cp.add(jpn,BorderLayout.CENTER);
        for(int i =0; i<25 ;i++) {
            jbs[i] = new JButton("");
            jbs[i].setEnabled(flag);
            jpn.add(jbs[i]);

        }
        jpset.add(jlt);
        jpset.add(jlbs);
        jlbs.setText(Integer.toString(s));
        jlt.setFont(new Font("Time New Romans", Font.BOLD, 20));
        jlbs.setFont(new Font("Time New Romans", Font.BOLD, 32));

        jpset.add(jls);
        jpset.add(jlbsc);
        jlbsc.setText(Integer.toString(sc));

        jpset.add(jlbempty);
        jpset.add(jlbempty2);
        jpset.add(jlbempty3);
        jpset.add(jlbempty4);
        jpset.add(jbstart);
        jpset.add(jbexit);
        jbexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                mainFrame.setVisible(true);
            }
        });

        jbstart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = true;
                for(int i=0; i<25; i++) {
                    jbs[i].setEnabled(flag);
                    jbs[i].setOpaque(true);
                }
                t1.start();
            }
        });

        t1 = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s--;
                jlbs.setText(Integer.toString(s));
            }
        });

    }
}