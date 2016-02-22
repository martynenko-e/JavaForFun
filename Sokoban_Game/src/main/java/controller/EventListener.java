package controller;

import model.Direction;

/**
 * Created by Martynenko on 22.02.2016.
 */
public interface EventListener
{
    void move(Direction direction);
    void restart();
    void startNextLevel();
    void levelCompleted(int level);
}
