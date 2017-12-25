import java.util.Random;

public class CTest extends Thread {
    Random random = new Random();
    private int x,y;
    public CTest(){
        x = random.nextInt(25);
        try {
            sleep((int)(2000*Math.random()));
        }catch (InterruptedException e){ }
    }
    public void run(){
        y = x;
        System.out.println(x);
    }
}
