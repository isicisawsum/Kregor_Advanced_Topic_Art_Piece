import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;


class Surface extends JPanel {
    private void doRings(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        Random rnd = new Random();

        //drawing rings
        g2d.setColor(new Color(0,0,rnd.nextInt(150) + 106));

        BasicStroke bs = new BasicStroke(rnd.nextInt(1) + 2);

        int rndSize = rnd.nextInt(25) + 5;//rnd size for each circle

        g2d.setStroke(bs);
        g2d.drawOval(rnd.nextInt(500),rnd.nextInt(500),rndSize,rndSize);

    }

    private void doLines(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Random rnd = new Random();

        g2d.setColor(new Color(0,rnd.nextInt(200),0));

        g2d.drawLine(250,250,rnd.nextInt(500),rnd.nextInt(500));
    }

    private void doFish(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Random rnd = new Random();

        //drawing fish
        g2d.setColor(new Color(rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256)));

        BasicStroke bs = new BasicStroke(rnd.nextInt(6) + 2);

        //int rndSize = rnd.nextInt(50) + 5;//rnd size for each circle

        g2d.setStroke(bs);
        //g2d.drawOval(rnd.nextInt(500),rnd.nextInt(500),rnd.nextInt(10) + 25,rnd.nextInt(5) + 10);
        g2d.fill(new Ellipse2D.Double(
                rnd.nextInt(500),
                rnd.nextInt(500),
                rnd.nextInt(50) + 25,
                rnd.nextInt(25) + 10
        ));
    }

    private void doFloor(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(new Color(236, 210, 131));

        g2d.fill(new Rectangle2D.Double(0,430,500,50));
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        for(int i = 0; i < 200; i++){
            doLines(g);
        }
        for(int i = 0; i < 250; i++){
            doRings(g);
        }
        for(int i = 0; i < 25; i++){
            doFish(g);
        }
        doFloor(g);
    }
}

public class BasicShapesEx extends JFrame {

    public BasicShapesEx() {

        initUI();
    }

    private void initUI() {

        add(new Surface());

        setTitle("Art Piece");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                BasicShapesEx ex = new BasicShapesEx();
                ex.setVisible(true);
            }
        });
    }
}