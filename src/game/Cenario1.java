package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Cenario1 extends JFrame {

	private JPanel contentPane;
	public JPanel painel1;
	public JPanel painel2;
	private Nuvem nuvem;
	private Thread t1;
	private Jogador jogador;
	private Timer timer;
	private Thread threadTimer;
	public Thread threadJogador;
	private JLabel lblchao;
	private ArrayList<JLabel> chaos = new ArrayList();
	private ArrayList<JLabel> tetos = new ArrayList();
	private ArrayList<JLabel> paredes = new ArrayList();
	private ArrayList<Comando> comandos = new ArrayList();
	private JLabel lblparede;
	private JLabel lblparede2;	
	private boolean deuStart = false;
	
	public Cenario1(){
		init();
	}
	
	public void init(){
		setTitle("Tom's Adventure");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 700);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		contentPane.setLayout(null);
		
		areaComandos();
		
		lblchao = new JLabel("");
		lblchao.setBounds(46, 436, 655, 20);
		contentPane.add(lblchao);
		chaos.add(lblchao);

		JLabel vencer = new JLabel("");
		vencer.setBounds(740, 261, 46, 76);
		contentPane.add(vencer);
		
		jogador = new Jogador(chaos, tetos, paredes, comandos, vencer);
		jogador.setAtributos(50, 360, 50, 76);
		jogador.setSize(50,76);
		jogador.setCenario1(this);
		threadJogador = new Thread(jogador);
		contentPane.add(jogador);
		
		timer = new Timer(15);
		timer.setText("15");
		timer.setForeground(new Color(59, 37, 17));
		timer.setHorizontalAlignment(SwingConstants.CENTER);
		timer.setFont(new Font("Adventure", Font.PLAIN, 67));
		timer.setBounds(10, 11, 774, 84);
		timer.setCenario1(this);
		threadTimer = new Thread(timer);
		contentPane.add(timer);
		
		JLabel btnVoltar = new JLabel("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnVoltar.setForeground(new Color(255, 243, 57));
			}
			
			@Override
			public void mouseExited(MouseEvent arg0){
				btnVoltar.setForeground(new Color(59, 37, 17));
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0){
				dispose();
				new Fase();
			}
		});
		btnVoltar.setBorder(BorderFactory.createLineBorder(new Color(59,37,17), 3));
		btnVoltar.setForeground(new Color(59, 37, 17));
		btnVoltar.setBackground(new Color(163,112,66));
		btnVoltar.setOpaque(true);
		btnVoltar.setHorizontalAlignment(SwingConstants.CENTER);
		btnVoltar.setFont(new Font("Adventure", Font.PLAIN, 25));
		btnVoltar.setBounds(21, 11, 125, 38);
		contentPane.add(btnVoltar);
		
		JLabel lblchao2 = new JLabel("");
		lblchao2.setBounds(599, 337, 195, 14);
		contentPane.add(lblchao2);
		chaos.add(lblchao2);
		
		lblparede = new JLabel("");
		lblparede.setBounds(10, 324, 40, 112);
		paredes.add(lblparede);
		contentPane.add(lblparede);
		
		lblparede2 = new JLabel("");
		lblparede2.setBounds(700, 360, 46, 76);
		paredes.add(lblparede2);
		contentPane.add(lblparede2);
		
		JLabel lblteto = new JLabel("");
		lblteto.setBounds(46, 318, 100, 20);
		tetos.add(lblteto);
		contentPane.add(lblteto);
		
		nuvem = new Nuvem(300, 100, -2);
		t1 = new Thread(nuvem);
		t1.start();
		contentPane.add(nuvem);
		
		nuvem = new Nuvem(800, 50, 2);
		t1 = new Thread(nuvem);
		t1.start();
		contentPane.add(nuvem);
		
		Icon imagemFundo = new ImageIcon(getClass().getResource("../images/cenario1.jpg"));
		JLabel fundo = new JLabel("");
		fundo.setIcon(imagemFundo);
		fundo.setBounds(0, 0, 794, 571);
		contentPane.add(fundo);
		
		//AÇÃO DO TECLADO
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(timer.getTempo() > 14){
					if(arg0.getKeyCode() == 39){
						//DIREITA
						painel1.add(new Comando(100));
						comandos.add(new Comando(100));
						threadJogador.interrupt();
					}else if(arg0.getKeyCode() == 37){
						//ESQUERDA
						painel1.add(new Comando(-100));
						comandos.add(new Comando(-100));
						threadJogador.interrupt();
					}else if(arg0.getKeyCode() == 38){
						//PULAR
						painel1.add(new Comando(-101));
						comandos.add(new Comando(-101));
						threadJogador.interrupt();
					}
					painel1.updateUI();
				}
			}
		});
		
		JOptionPane.showMessageDialog(null, "Olá Visitante! Na primeira fase do game teste os comandos"
				+ " e se familiarize com eles, ajude o pequeno Tom a chegar até a placa quadrada!");
		
		setVisible(true);
	}
	
	public void areaComandos(){
		painel1 = new JPanel();
		painel1.setBounds(0, 571, 600, 100);
		painel1.setBackground(new Color(33,33,33));
		contentPane.add(painel1);
		painel1.setLayout(new GridLayout());
		
		painel2 = new JPanel();
		painel2.setBounds(600, 571, 200, 100);
		contentPane.add(painel2);
		painel2.setLayout(null);
		painel2.setBackground(new Color(55,55,55));
		
		JLabel lblPlay = new JLabel("");
		lblPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblPlay.setLocation(0 , -3);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0){
				lblPlay.setLocation(0, 0);
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0){
				play();
			}
		});
		lblPlay.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlay.setIcon(new ImageIcon(Cenario1.class.getResource("/images/play.png")));
		lblPlay.setBounds(0, 0, 100, 100);
		painel2.add(lblPlay);
		
		JLabel lblStop = new JLabel("");
		
		lblStop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblStop.setLocation(100, -3);
			}
			
			@Override
			public void mouseExited(MouseEvent e){
				lblStop.setLocation(100, 0);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				restart();
			}
		});
		lblStop.setIcon(new ImageIcon(Cenario1.class.getResource("/images/stop2.png")));
		lblStop.setHorizontalAlignment(SwingConstants.CENTER);
		lblStop.setBounds(100, 0, 90, 100);
		painel2.add(lblStop);
		
	}
	
	public void play(){
		threadTimer.start();
		threadJogador.start();
	}
	
	public void restart(){
		jogador.setLocation(50, 360);
		jogador.setAtributos(50, 360, 50, 76);
		timer.setText("15");
		timer.setTempo(15);
		painel1.removeAll();
		painel1.updateUI();
		threadTimer.interrupt();
		threadJogador.interrupt();
		comandos.clear();
		threadTimer = new Thread(timer);
		threadJogador = new Thread(jogador);
	}
	
	public void win(){
		comandos.clear();
		chaos.clear();
		tetos.clear();
		paredes.clear();
		threadTimer.interrupt();
		JOptionPane.showMessageDialog(null, "Muito Bem! Agora vamos para próxima fase!");
		Fase f = new Fase();
		dispose();
	}
}
