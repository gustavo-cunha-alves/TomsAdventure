package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

public class Cenario3 extends JFrame {

	private JPanel contentPane;
	public JPanel painel1;
	public JPanel painel2;
	private Nuvem nuvem;
	private Timer timer;
	private Thread t1;
	private Thread threadTimer;
	private Jogador jogador;
	public Thread threadJogador;
	private JLabel lblchao;
	private ArrayList<JLabel> chaos = new ArrayList();
	private ArrayList<JLabel> tetos = new ArrayList();
	private ArrayList<JLabel> paredes = new ArrayList();
	private ArrayList<Comando> comandos = new ArrayList();
	private JLabel lblparede;
	private JLabel lblparede2;

	public Cenario3() {
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
		
		lblchao = new JLabel("");
		lblchao.setBounds(0, 136, 99, 20);
		contentPane.add(lblchao);
		chaos.add(lblchao);
		
		JLabel lblchao2 = new JLabel("");
		lblchao2.setBounds(100, 335, 150, 14);
		contentPane.add(lblchao2);
		chaos.add(lblchao2);
		
		JLabel lblchao3 = new JLabel("");
		lblchao3.setBounds(200, 238, 99, 14);
		contentPane.add(lblchao3);
		chaos.add(lblchao3);
		
		JLabel lblchao4 = new JLabel("");
		lblchao4.setBounds(300, 336, 150, 14);
		contentPane.add(lblchao4);
		chaos.add(lblchao4);
		
		JLabel lblchao5 = new JLabel("");
		lblchao5.setBounds(400, 237, 150, 14);
		contentPane.add(lblchao5);
		chaos.add(lblchao5);
		
		JLabel lblchao6 = new JLabel("");
		lblchao6.setBounds(500, 135, 150, 14);
		contentPane.add(lblchao6);
		chaos.add(lblchao6);
		
		JLabel lblchao7 = new JLabel("");
		lblchao7.setBounds(653, 285, 393, 14);
		contentPane.add(lblchao7);
		chaos.add(lblchao7);

		JLabel vencer = new JLabel("");
		vencer.setBounds(755, 209, 46, 76);
		contentPane.add(vencer);
		
		
		jogador = new Jogador(chaos, tetos, paredes, comandos, vencer);
		jogador.setAtributos(0, 60, 50, 76);
		jogador.setSize(50,76);
		jogador.setCenario3(this);
		threadJogador = new Thread(jogador);
		contentPane.add(jogador);
		
		timer = new Timer(12);
		timer.setText("12");
		timer.setForeground(new Color(59, 37, 17));
		timer.setHorizontalAlignment(SwingConstants.CENTER);
		timer.setFont(new Font("Adventure", Font.PLAIN, 67));
		timer.setBounds(10, 11, 774, 84);
		timer.setCenario3(this);
		threadTimer = new Thread(timer);
		contentPane.add(timer);
		
		Icon imagemFundo = new ImageIcon(getClass().getResource("../images/cenario3.jpg"));
		JLabel fundo = new JLabel("");
		fundo.setIcon(imagemFundo);
		fundo.setBounds(0, 0, 794, 571);
		contentPane.add(fundo);
		
		//AÇÃO DO TECLADO
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(timer.getTempo() > 8){
					if(arg0.getKeyCode() == 39){
						//DIREITA
						painel1.add(new Comando(100));
						comandos.add(new Comando(100));
					}else if(arg0.getKeyCode() == 37){
						//ESQUERDA
						painel1.add(new Comando(-100));
						comandos.add(new Comando(-100));
					}else if(arg0.getKeyCode() == 38){
						//PULAR
						painel1.add(new Comando(-101));
						comandos.add(new Comando(-101));
					}
					painel1.updateUI();
				}
			}
		});
		JOptionPane.showMessageDialog(null, "Prepare-se para o desafio final! Achas que é capaz de resolve-lo?");
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
		jogador.setLocation(0, 60);
		jogador.setAtributos(0, 60, 50, 76);
		painel1.removeAll();
		painel1.updateUI();
		timer.setTempo(12);
		timer.setText("12");
		threadJogador.interrupt();
		threadTimer.interrupt();
		comandos.clear();
		threadJogador = new Thread(jogador);
		threadTimer = new Thread(timer);
	}
	
	public void win(){
		threadTimer.interrupt();
		JOptionPane.showMessageDialog(null, "Parabéns! Você Completou todos os desafios!");
		new Menu();
		dispose();
	}

}
