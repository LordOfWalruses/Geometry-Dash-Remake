public class Animate implements Runnable{
    
    private Screen s;
    public Animate(Screen s){
        this.s = s;
    }

    public void run(){
        while (true){
            s.repaint();
        }
    }
    
}