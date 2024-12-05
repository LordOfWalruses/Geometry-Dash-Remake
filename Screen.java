import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;


public class Screen extends JPanel implements ActionListener,KeyListener{
    private Player player;
    private Animate animate;
    public static int SIZE = 30;
    private ArrayList<Spike> spikeList;
    private ArrayList<Block> blockList;
    private ArrayList<Pad> padList;

    public Screen(){
        this.setFocusable(true);
        addKeyListener(this);
        this.setLayout(null);

        spikeList = new ArrayList<Spike>();
        spikeList.add(new Spike(30 * 30,1 * 30));
        spikeList.add(new Spike(31 * 30,1 * 30));
        spikeList.add(new Spike(32 * 30,1 * 30));

        blockList = new ArrayList<Block>();
        blockList.add(new Block(31 * 30, 1 * 30));
        blockList.add(new Block(32 * 30, 1 * 30));
        blockList.add(new Block(33 * 30, 1 * 30));
        blockList.add(new Block(34 * 30, 1 * 30));
        blockList.add(new Block(35 * 30, 1 * 30));
        blockList.add(new Block(39 * 30, 3 * 30));
        blockList.add(new Block(43 * 30, 5 * 30));
        blockList.add(new Block(47 * 30, 7 * 30));
        blockList.add(new Block(51 * 30, 9 * 30));

        padList = new ArrayList<Pad>();
        padList.add(new Pad(55 * 30, 0 * 30 + 5, player, "yellow"));


        player = new Player(30,"cube");
        Thread t1 = new Thread(player);
        t1.start();

        Animate animate = new Animate(this);
        Thread t2 = new Thread(animate);
        t2.start();

        SpikeDetection sd = new SpikeDetection(spikeList, player);
        Thread t3 = new Thread(sd);
        t3.start();

        MoveLeft ml = new MoveLeft(player, spikeList, blockList, padList);
        Thread t4 = new Thread(ml);
        t4.start();

        BlockDetection bd = new BlockDetection(blockList, player);
        Thread t5 = new Thread(bd);
        t5.start();

        PadDetection pd = new PadDetection(padList, player);
        Thread t6 = new Thread(pd);
        t6.start();
    }

    public Dimension getPreferredSize(){
		return new Dimension(1200, 800);
	}

	public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(new Color(50,50,50));
        g.fillRect(100,800-player.getY(),30,30);

        for (int i = 0; i < spikeList.size(); i++){
            int x = spikeList.get(i).getX();
            int y = 800-spikeList.get(i).getY();

            g.setColor(new Color(255,0,0));
            g.fillRect(x+10, y+10, 10, 20);

            g.setColor(new Color(0,0,0));
            g.fillPolygon(new int[] {x, x+15,x+30}, new int[] {y+30, y, y+30}, 3);
        }

        for (int i = 0; i < blockList.size(); i++){
            int x = blockList.get(i).getX();
            int y = 800-blockList.get(i).getY();

            g.setColor(new Color(0,0,0));
            g.fillRect(x, y, 30, 30);
        }

        for (int i = 0; i < padList.size(); i++){
            int x = padList.get(i).getX();
            int y = 800-padList.get(i).getY();

            if (padList.get(i).getType().equals("yellow")){
                g.setColor(new Color(255,255,0));
            }
            g.fillRect(x, y, 30, 5);
        }
    }

    public void actionPerformed(ActionEvent e){

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 38){ // up
            if (player.getY() == player.getGround() + 30 && player.getGameMode().equals("cube")){
                player.setVelocity(11);
            }
        }
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}


}