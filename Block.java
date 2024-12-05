public class Block{
    private int x;
    private int y;

    public Block(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void moveLeft(){
        x -= 2;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}