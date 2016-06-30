import java.awt.*;

/**
 * Created by Tom on 29.06.2016.
 */
public class Pie extends Panel {
    private int width = 300;
    private int arc[] = {0, 0, 0, 0};
    private Image image;

    public Pie(int arc[], Image image){
        int all = arc[0] + arc[1] + arc[2] + arc[3];
        this.arc[0] = arc[0] * 360 / all;
        this.arc[1] = arc[1] * 360 / all;
        this.arc[2] = arc[2] * 360 / all;
        this.arc[3] = arc[3] * 360 / all;
        this.image = image;
    }
    public void paint(Graphics graphics){
        graphics.drawImage(image, 0, 0, this);

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));

        graphics.setColor(Color.BLUE);
        graphics.fillArc((image.getWidth(this) - this.width) / 2, (image.getHeight(this) - this.width) / 2, this.width, this.width, 0, arc[0]);

        graphics.setColor(Color.RED);
        graphics.fillArc((image.getWidth(this) - this.width) / 2, (image.getHeight(this) - this.width) / 2, this.width, this.width, arc[0], arc[1]);

        graphics.setColor(Color.GREEN);
        graphics.fillArc((image.getWidth(this) - this.width) / 2, (image.getHeight(this) - this.width) / 2, this.width, this.width, arc[0] + arc[1], arc[2]);

        graphics.setColor(Color.BLACK);
        graphics.fillArc((image.getWidth(this) - this.width) / 2, (image.getHeight(this) - this.width) / 2, this.width, this.width, arc[0] + arc[1] + arc[2], arc[3]);
    }

    public Dimension getPreferredSize(){
        return new Dimension(image.getWidth(this), image.getHeight(this));
    }
}