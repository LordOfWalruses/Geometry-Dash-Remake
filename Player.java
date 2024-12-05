public class Player implements Runnable{
    private int y;
    private int velocity;
    private String gameMode;
    private boolean alive;
    private int ground;

    public Player(int y, String gm){
        this.y = y;
        velocity = 0;
        gameMode = gm;
        alive = true;
        ground = 0;
    }

    public void kill(){
        alive = false;
        setVelocity(0);
    }

    public void setGround(int g){
        ground = g;
    }

    public boolean alive(){
        return alive;
    }

    public void setVelocity(int v){
        velocity = v;
    }

    public int getVelocity(){
        return velocity;
    }

    public int getGround(){
        return ground;
    }

    public String getGameMode(){
        return gameMode;
    }

    public void setY(int Y){
        y = Y;
    }

    public int getX(){
        return 100;
    }
    
    public int getY(){
        return y;
    }

    public void run(){
        while (true){
            if (gameMode.equals("cube") && alive){
                if (velocity != 0){ //if going up or down
                    for (int i = 0; i < Math.abs(velocity); i++){
                        if (y != ground + 30 || velocity > 0){
                            if (velocity > 0){y++;}
                            else {y--;}
                            if (y != ground + 30){
                                try {Thread.sleep(((int)30/Math.abs(velocity)));} catch(Exception e){}
                            }
                        }
                        else {
                            break;
                        }
                    }
                    velocity -= 1;
                }
                else if (y != ground + 30){ //if velocity is 0, it's in the air
                    velocity -= 1;
                    try {Thread.sleep(30);} catch(Exception e){}
                }
                if (y == ground + 30 && velocity != 0){
                    velocity = 0;
                }
            }
            try{Thread.sleep(1);} catch(Exception e){}
        }
    }
}