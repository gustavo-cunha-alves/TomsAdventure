package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;

public class Menu extends JFrame {

	private JPanel contentPane;
	private Nuvem nuvem;
	private Thread t1;
	private Musica musica;

	public Menu() {
		setTitle("Tom's Adventure");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Icon imagemFundo = new ImageIcon(getClass().getResource("../images/BG.png"));
		Icon imgPlayButton = new ImageIcon(getClass().getResource("../images/playButton2.png"));
		JLabel lblPlayButton = new JLabel("");
		lblPlayButton.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseEntered(MouseEvent arg0) {
				lblPlayButton.setHorizontalAlignment(SwingConstants.LEFT);
				lblPlayButton.setLocation(304, 195);
			}
			
			public void mouseExited(MouseEvent arg0) {
				lblPlayButton.setHorizontalAlignment(SwingConstants.RIGHT);
				lblPlayButton.setLocation(304, 204);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				new Fase();
			}
		});
		
		
		JLabel lblWestGame = new JLabel("Tom's Adventures");
		lblWestGame.setForeground(new Color(163,112,66));
		lblWestGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblWestGame.setFont(new Font("Adventure", Font.PLAIN, 99));
		lblWestGame.setBounds(10, 11, 774, 167);
		contentPane.add(lblWestGame);
		
		lblPlayButton.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPlayButton.setIcon(imgPlayButton);
		lblPlayButton.setBounds(304, 205, 200, 121);
		contentPane.add(lblPlayButton);
		
		nuvem = new Nuvem(658, 200, 1);
		t1 = new Thread(nuvem);
		t1.start();
		contentPane.add(nuvem);
		
		nuvem = new Nuvem(300, 100, -2);
		t1 = new Thread(nuvem);
		t1.start();
		contentPane.add(nuvem);
		
		nuvem = new Nuvem(0, 150, -1);
		t1 = new Thread(nuvem);
		t1.start();
		contentPane.add(nuvem);
		
		nuvem = new Nuvem(800, 50, 2);
		t1 = new Thread(nuvem);
		t1.start();
		contentPane.add(nuvem);
		
		JLabel fundo = new JLabel("");
		fundo.setIcon(imagemFundo);
		fundo.setBounds(0, 0, 794, 571);
		contentPane.add(fundo);
		setVisible(true);
	}

	public void tocar(){
		musica = new Musica();
	}
}