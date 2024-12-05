import java.util.ArrayList;
public class SpikeDetection implements Runnable{
    private ArrayList<Spike> spikeList;
    private Player player;

    public SpikeDetection(ArrayList<Spike> spikeList, Player player){
        this.spikeList = spikeList;
        this.player = player;
    }

    public void run(){
        while(true){
            for (int i = 0; i < spikeList.size(); i++){
                if (100 > spikeList.get(i).getX()-30+10 && 100 < spikeList.get(i).getX()+30 - 10){
                    int playerY = player.getY();
                    int spikeY = spikeList.get(i).getY();

                    if (playerY < spikeY+30-10 && playerY > spikeY-30){
                        player.kill();
                    }
                }
            }
            try{Thread.sleep(1);} catch(Exception e){}
        }
    }
}