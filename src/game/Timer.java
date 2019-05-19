package game;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Timer extends JLabel implements Runnable{
	
	private int tempo;
	private Cenario1 c1;
	private Cenario2 c2;
	private Cenario3 c3;
	private boolean isCenario1 = false;
	private boolean isCenario2 = false;
	private boolean isCenario3 = false;

	public Timer(int tempo){
		this.tempo = tempo;
	}
	
	@Override
	public void run() {
		try{
			while(tempo > 0){
				tempo--;
				setText(String.valueOf(tempo));
				Thread.sleep(1000);
			}
			if(isCenario1){
				c1.restart();
			}else if(isCenario2){
				c2.restart();
			}else if(isCenario3){
				c3.restart();
			}
			JOptionPane.showMessageDialog(null, "Que pena! O tempo acabou ;(");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public double getTempo(){
		return tempo;
	}
	
	public void setTempo(int tempo){
		this.tempo = tempo;
	}
	
	public void setCenario1(Cenario1 cenario){
		this.c1 = cenario;
		isCenario1 = true;
		isCenario2 = false;
		isCenario3 = false;
	}
	
	public void setCenario2(Cenario2 cenario){
		this.c2 = cenario;
		isCenario1 = false;
		isCenario2 = true;
		isCenario3 = false;
	}
	
	public void setCenario3(Cenario3 cenario){
		this.c3 = cenario;
		isCenario1 = false;
		isCenario2 = false;
		isCenario3 = true;
	}
	
}
