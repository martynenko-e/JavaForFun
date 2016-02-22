package model;

import java.awt.*;

/**
 * Created by Martynenko on 22.02.2016.
 */
public class Home extends GameObject
{
    public Home(int x, int y)
    {
        super(x, y);
        this.setHeight(2);
        this.setWidth(2);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(new Color(255, 0, 0));
        graphics.drawOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }
}
