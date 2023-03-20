import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Client extends Thread{
    public static void main(String[] args) throws InterruptedException {
        new Graphics();
    }
    public void run() {
        Graphics.frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_A)
                    Graphics.label.setLocation(Graphics.label.getX() + 25, Graphics.label.getY());
                else if (e.getKeyCode() == KeyEvent.VK_D)
                    Graphics.label.setLocation(Graphics.label.getX() - 25, Graphics.label.getY());
            }
        });
    }
}
class Graphics extends Thread{
public static JFrame frame;
public static JLabel label;
    Graphics() throws InterruptedException {
         frame = new JFrame();
        frame.setSize(1280, 720);
        frame.setLayout(null);
        ImageIcon i = new ImageIcon("src/h.jpg");
        label = new JLabel(i);
        label.setBounds(0,0,6492,4340);

        Client g = new Client();
        g.start();

        ImageIcon k = new ImageIcon("src/amongusred.jpg");
        JLabel p = new JLabel(k);
        label.setLocation(label.getX()-1000, label.getY()-1000);
        p.setBounds(300,200,500,500);
        frame.add(p);

        frame.add(label);
        frame.setVisible(true);



        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W)
                    label.setLocation(label.getX(), label.getY() + 25);
                else if (e.getKeyCode() == KeyEvent.VK_S)
                    label.setLocation(label.getX(), label.getY() - 25);
            }
        });
    }

}