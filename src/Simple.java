import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Simple extends JFrame {

    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private int fmW=900,fmH=700,screenW= dim.width,screenH=dim.height;
    private Container cp;
    private JPanel jpset = new JPanel(new GridLayout(4,1,3,3));//按扭區
    private JPanel jpn = new JPanel(new GridLayout(5,5,3,3));//地鼠
    private JButton jbstart = new JButton("Start");
    private JButton jbexit = new JButton("Exit");
    private JLabel jlt = new JLabel("秒數");
    private JLabel jls = new JLabel("分數");
    private JButton jbs[] = new JButton[25];

    private MainFrame mainFrame;
    public Simple(MainFrame mframe){
        mainFrame = mframe;
        initComp();}

    public void initComp() {
        this.setBounds(screenW / 2 - fmW / 2, screenH / 2 - fmH / 2, fmW, fmH);
        this.setTitle("期末專題_打地鼠");
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
            jpn.add(jbs[i]);
        }
        jpset.add(jlt);

        jpset.add(jbstart);

        jpset.add(jls);

        jpset.add(jbexit);
        jbexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                mainFrame.setVisible(true);
            }
        });

    }
}