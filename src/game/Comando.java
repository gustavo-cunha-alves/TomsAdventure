package game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Comando extends JLabel{
	
	//UM PASSO PRA DIREITA 100 X
	//UM PASSO PRA ESQUERDA -100 X
	//PULAR -50 Y
	
	private int comando_x;
	private int comando_y;
	
	public Comando(int comando){
		switch(comando){
			case -100:
				this.comando_x = comando;
				this.comando_y = 0;
				setIcon(new ImageIcon(getClass().getResource("../images/left-arrow.png")));
			break;
			case 100:
				this.comando_x = comando;
				this.comando_y = 0;
				setIcon(new ImageIcon(getClass().getResource("../images/right-arrow.png")));
			break;
			case -101:
				this.comando_y = comando;
				this.comando_x = 0;
				setIcon(new ImageIcon(getClass().getResource("../images/up-arrow.png")));
			break;
		}
		setSize(50,50);
		setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	public int getComando_X(){
		return this.comando_x;
	}
	
	public int getComando_Y(){
		return this.comando_y;
	}
	
}
