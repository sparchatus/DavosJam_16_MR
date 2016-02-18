package graphics;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public GamePanel(){
        this.setBackground(Color.PINK);
    }
    @Override
    protected void paintComponent(Graphics g){
        g.setColor(new Color(0xffe4e1));
        g.drawRect(0, 0, this.getWidth(), this.getHeight());
        g.drawLine(0, 0, 150, 200);
    }
}
