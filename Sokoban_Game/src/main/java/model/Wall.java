package model;

import java.awt.*;

/**
 * Created by Martynenko on 22.02.2016.
 */
public class Wall extends CollisionObject
{
    public Wall(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(new Color(255, 127, 39));
        graphics.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }
}
