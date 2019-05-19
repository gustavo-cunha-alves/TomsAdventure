package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Nuvem extends JLabel implements Runnable{
	
	private Icon img;
	private int x;
	private int y;
	private int velocidade;
	
	public Nuvem(int x, int y, int velo){
		img = new ImageIcon(getClass().getResource("../images/nuvem.png"));
		setLocation(x, y);
		setSize(100, 53);
		setIcon(img);
		
		this.x = x;
		this.y = y;
		this.velocidade = velo;
	}
	
	@Override
	public void run(){
		try {
			while(true){
				x = (int) getLocation().getX();
				setLocation(x - velocidade, y);
				Thread.sleep(15);
				if(x<0-getWidth()){
					setLocation(800, y);
				}
				if(x>800+getWidth()){
					setLocation(0-getWidth(), y);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
