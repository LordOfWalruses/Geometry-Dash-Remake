import java.util.ArrayList;
public class MoveLeft implements Runnable{
    private Player player;
    private ArrayList<Spike> spikeList;
    private ArrayList<Block> blockList;
    private ArrayList<Pad> padList;

    public MoveLeft( Player player, ArrayList<Spike> spikeList, ArrayList<Block> blockList, ArrayList<Pad> padList){
        this.spikeList = spikeList;
        this.player = player;
        this.blockList = blockList;
        this.padList = padList;
    }

    public void run(){
        while (true){
            if (player.alive()){
                for (int i = 0; i < spikeList.size(); i++){
                    spikeList.get(i).moveLeft();
                }

                for (int i = 0; i < blockList.size(); i++){
                    blockList.get(i).moveLeft();
                }

                for (int i = 0; i < padList.size(); i++){
                    padList.get(i).moveLeft();
                }
    
                try{Thread.sleep(10);} catch(Exception e){}
            }
        }
    }
}