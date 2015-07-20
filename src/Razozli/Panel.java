package Razozli;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.MouseEvent;
        import java.awt.event.MouseListener;

/**
 * Created by panasyuk on 18.07.2015.
 */
public class Panel extends JPanel{
    private int cp = 0;
    private int x = 100;
    private int y = 200;

    public Panel() {
        JFrame panel = new JFrame("Crazzy Ball!!");
        panel.setMinimumSize(new Dimension(800, 600));
        panel.setLocation(300, 100);
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jp = makePanel();

        panel.getContentPane().add(jp);
        panel.setVisible(true);
        panel.pack();
        repaint();

    }


    private JPanel makePanel() {
        JPanel jp = new JPanel();
        jp.setLayout(new GridBagLayout());

        JPanel a = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (cp == 0) {
                    g.setColor(Color.BLUE);
                    g.fillOval(x, y, 150, 150);
                } else {
                    cp = 1;
                    repaint();
                    g.fillOval(-x, -y, 150, 150);
                }
                repaint();
            }
        };
        a.setPreferredSize(new Dimension(400, 600));
        JPanel b = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (cp == 1) {
                    g.setColor(Color.BLUE);
                    g.fillOval(x, y, 150, 150);
                } else {
                    cp = 0;
                    repaint();
                    g.fillOval(-x, -y, 150, 150);
                }
                repaint();
            }
        };
        b.setPreferredSize(new Dimension(400, 600));
        JLabel bb = new JLabel();
        b.add(bb);


        a.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("AAAAAAAAAAAAAAAAA");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                cp = 1;
                System.out.println("+++++++++++++++++++");

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        b.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("BBBBBBBBBB");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                cp = 0;
                System.out.println("---------------");

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        jp.add(a);
        jp.add(b);

        return jp;
    }

    public static void main(String[] args) {
        Panel p = new Panel();
    }
}