package game;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Jogador extends JLabel implements Runnable{

	private int x;
	private int y;
	private int width;
	private int height;
	private int gravidade = 2;
	private int veloPulo = -2;
	private int veloY = 0;
	private int frame = 0;
	private ArrayList<JLabel> chaos = new ArrayList();
	private ArrayList<JLabel> tetos = new ArrayList();
	private ArrayList<JLabel> paredes = new ArrayList();
	private ArrayList<Comando> comandos = new ArrayList();
	private JLabel vencer = new JLabel();
	private Cenario1 c;
	private Cenario2 c2;
	private Cenario3 c3;
	private boolean isCenario1 = false;
	private boolean isCenario2 = false;
	private boolean isCenario3 = false;
	
	
	public Jogador(ArrayList<JLabel> chaos, ArrayList<JLabel> tetos, ArrayList<JLabel> paredes, ArrayList<Comando> comandos, JLabel vencer){
		setIcon(new ImageIcon(getClass().getResource("../sprites/Idle__00"+frame+".png")));
		this.chaos = chaos;
		this.tetos = tetos;
		this.paredes = paredes;
		this.comandos = comandos;
		this.vencer = vencer;
	}

	@Override
	public void run() {
		for(int i = 0; i < comandos.size(); i++){
			if(comandos.get(i).getComando_Y() == -101){
				pulo(1);
			}else{
				passos(comandos.get(i).getComando_X());
			}
			gravidade(1);
		}
		
		if(getX() == vencer.getX() && getY()+getHeight() == vencer.getY()+vencer.getHeight()){
			if(isCenario1){
				c.win();
			}else if(isCenario2){
				c2.win();
			}else if(isCenario3){
				c3.win();
			}
		}
	}
	
	public void gravidade(int dt){
		try{
			veloY = 0;
			boolean stop = false;
			while(true){
				veloY += gravidade *dt;
				this.y += veloY*dt;
				setLocation(this.x, this.y);
				setIcon(new ImageIcon(getClass().getResource("../sprites/Jump__009.png")));
				for(int i = 0; i < chaos.size(); i++){
					if(chaos.get(i).getY() <= this.y+height && getX() >= chaos.get(i).getX() && getX() < chaos.get(i).getX()+chaos.get(i).getWidth()){
						int diferenca = chaos.get(i).getY() - (this.y+height);
						if(diferenca > -50){
							this.y += diferenca;
							setLocation(this.x, this.y);
						}
						if(getY()+getHeight() == chaos.get(i).getY()){
							setIcon(new ImageIcon(getClass().getResource("../sprites/Idle__000.png")));
							stop = true;
							break;
						}
						if(i == chaos.size()-1){
							i = 0;
						}
					}
				}
				if(stop){
					break;
				}
				Thread.sleep(17);
			};
			Thread.sleep(400);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public void pulo(int dt){
		try{
			veloY = 0;
			frame = 0;
			int limiteFixo = this.y-101;
			int limite = limiteFixo;
			while(true){
				veloY += veloPulo*dt;
				this.y += veloY*dt;
				for(int i = 0; i < tetos.size(); i++){
					if(tetos.get(i).getY()+tetos.get(i).getHeight() > limite && getX() >= tetos.get(i).getX() && getX() <= tetos.get(i).getX()+tetos.get(i).getWidth()){
						limite = tetos.get(i).getY();
					}else{
						limite = limiteFixo;
					}
				}
				if(this.y > limite){
					setLocation(this.x, this.y);
				}else{
					break;
				}
				if(frame < 9){
					setIcon(new ImageIcon(getClass().getResource("../sprites/Jump__00"+frame+".png")));
				}
				Thread.sleep(17);
				frame++;
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public void passos(int direcao){
		try{
			//
			frame = 0;
			this.x = getX();
			int destinoFixo = this.x+direcao;
			int destino = destinoFixo;
			while(true){
				for(int i = 0; i < paredes.size(); i++){
					if(direcao == 100){
						if(getX() >= paredes.get(i).getX()-getWidth()){
							destino = getX();
							if(getY()+getHeight() < paredes.get(i).getY()){
								destino = destinoFixo;
							}
						}else{
							destino = destinoFixo;
						}
					}else{
						if(getX() <= paredes.get(i).getX()+paredes.get(i).getWidth()){
							destino = getX();
							if(getY()+getHeight() < paredes.get(i).getY()){
								destino = destinoFixo;
								break;
							}
							break;
						}else{
							destino = destinoFixo;
							break;
						}
					}
				}
				
				for(int i = 0 ; i < chaos.size(); i++){
					if(getX() > chaos.get(i).getX()+chaos.get(i).getWidth() && getY()+getHeight() == chaos.get(i).getY()){
						destino = getX();
					}
				}
				
				if(this.x < destino){
					this.x += 5;
					setLocation(this.x, this.y);
				}else if(this.x > destino){
					this.x -= 5;
					setLocation(this.x, this.y);
				}else{
					break;
				}
				
				if(frame <= 9){
					setSize(60,76);
					setIcon(new ImageIcon(getClass().getResource("../sprites/Run__00"+frame+".png")));
					if(frame == 9){
						frame = 0;
					}
				}
				Thread.sleep(30);	
				frame++;
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	public void setCenario1(Cenario1 cenario){
		this.c = cenario;
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
	
	public void setAtributos(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		setIcon(new ImageIcon(getClass().getResource("../sprites/Idle__000.png")));
		setBounds(x,y, width, height);
	}
}
