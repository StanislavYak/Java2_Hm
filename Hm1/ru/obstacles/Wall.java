package ru.obstacles;
import ru.animals.*;

public class Wall implements Let {
    private float height;

    public Wall(float height) {
        this.height = height;
    }
    @Override
    public boolean doIt(Animal animal) {
        if (animal instanceof Jumpable)
            return ((Jumpable) animal).jump(height);
        else
            return false;
    }
    public float getHeight(){
        return height;
    }
}