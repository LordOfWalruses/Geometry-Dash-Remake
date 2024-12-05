import java.util.ArrayList;
public class PadDetection implements Runnable{
    Player player;
    ArrayList<Pad> padList;

    public PadDetection(ArrayList<Pad> padList, Player player){
        this.player = player;
        this.padList = padList;
    }

    public void run(){
        while (true){
            for (int i = 0; i < padList.size(); i++){
                if (player.getX() > padList.get(i).getX()-30 && player.getX() < padList.get(i).getX() + padList.get(i).getWidth()){
                    if (player.getY() > padList.get(i).getY()-padList.get(i).getHeight() && player.getY() < padList.get(i).getY() + 30){
                        player.setVelocity(16);
                    }
                }
            }
        }
    }

}