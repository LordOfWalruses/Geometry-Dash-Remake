import java.util.ArrayList;
public class BlockDetection implements Runnable{
    private ArrayList<Block> blockList;
    private Player player;
    private boolean under;

    public BlockDetection(ArrayList<Block> blockList, Player player){
        this.blockList = blockList;
        this.player = player;
    }

    public void run(){
        while (true){
            for (int i = 0; i < blockList.size(); i++){
                Block block = blockList.get(i);
    
                if (player.getX() < block.getX()+30 && player.getX() > block.getX()-30){
                    if (block.getY() <= player.getY()-30 && block.getY() > player.getY()-35){
                        under = true;
                        player.setGround(block.getY());
                        try{Thread.sleep(1);} catch(Exception e){}
                    }
                    else if (player.getY() > block.getY()-30 && player.getY() <= block.getY()){
                        player.kill();
                    }
                }
            }
            if (!under){
                player.setGround(0);
            }
            under = false;
            try{Thread.sleep(1);} catch(Exception e){}
        }
    }
}