package model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Martynenko on 22.02.2016.
 */
public class GameObjects
{
    private Set<Wall> walls;
    private Set<Box> boxes;
    private Set<Home> homes;
    private Player player;

    public GameObjects(Set<Wall> walls, Set<Box> boxes, Set<Home> homes, Player player)
    {
        this.walls = walls;
        this.boxes = boxes;
        this.homes = homes;
        this.player = player;
    }

    public Set<Wall> getWalls()
    {
        return walls;
    }

    public Set<Box> getBoxes()
    {
        return boxes;
    }

    public Set<Home> getHomes()
    {
        return homes;
    }

    public Player getPlayer()
    {
        return player;
    }

    public Set<GameObject> getAll() {
        HashSet<GameObject> gameObjects = new HashSet<>();
        gameObjects.addAll(getBoxes());
        gameObjects.addAll(getHomes());
        gameObjects.addAll(getWalls());
        gameObjects.add(getPlayer());
        return gameObjects;
    }
}
