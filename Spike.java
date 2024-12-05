import javax.swing.*;
import java.awt.*;

public class Spike{
    private int x;
    private int y;

    public Spike(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public void moveLeft(){
        x -= 2;
    }
}