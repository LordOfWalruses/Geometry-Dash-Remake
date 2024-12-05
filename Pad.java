public class Pad{ //for yellow pad set velocity to 16
    private int x;
    private int y;
    private Player player;
    private String type;

    public Pad (int x, int y, Player player, String type){
        this.x = x;
        this.y = y;
        this.player = player;
        this.type = type;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getWidth(){
        return 30;
    }

    public int getHeight(){
        return 5;
    }

    public void moveLeft(){
        x -= 2;
    }

    public String getType(){
        return type;
    }
}