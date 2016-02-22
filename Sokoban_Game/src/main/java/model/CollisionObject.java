package model;

/**
 * Created by Martynenko on 22.02.2016.
 */
public abstract class CollisionObject extends GameObject
{
    public CollisionObject(int x, int y)
    {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        boolean result = false;
        switch (direction) {
            case RIGHT:
                if(this.getX() + Model.FIELD_SELL_SIZE == gameObject.getX() && this.getY() == gameObject.getY())
                    result = true;
                break;
            case LEFT:
                if(this.getX() - Model.FIELD_SELL_SIZE == gameObject.getX() && this.getY() == gameObject.getY())
                    result = true;
                break;
            case UP:
                if(this.getX() == gameObject.getX() && this.getY() - Model.FIELD_SELL_SIZE == gameObject.getY())
                    result = true;
                break;
            case DOWN:
                if(this.getX() == gameObject.getX() && this.getY() + Model.FIELD_SELL_SIZE == gameObject.getY())
                    result =  true;
                break;
        }
        return result;
    }
}
