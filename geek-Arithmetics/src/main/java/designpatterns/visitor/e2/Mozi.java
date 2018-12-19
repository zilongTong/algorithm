package designpatterns.visitor.e2;
/**
 *
 * @author Smile.Wu
 * @version 2015-10-19
 */
public class Mozi {
	public void ride(Horse h) {  
		h.run();
        System.out.println("骑马");  
    }  
  
    public void ride(WhiteHorse wh) { 
    	wh.run();
        System.out.println("骑白马");  
    }  
  
    public void ride(BlackHorse bh) {  
    	bh.run();
        System.out.println("骑黑马");  
    }  
  
    public static void main(String[] args) {  
        Horse wh = new WhiteHorse();  
        Horse bh = new BlackHorse();  
        Mozi mozi = new Mozi();  
        mozi.ride(wh);  
        mozi.ride(bh);  
    }  
  
}
