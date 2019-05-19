package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Fase extends JFrame {

	private JPanel contentPane;
	private Nuvem nuvem;
	private Thread t1;

	public Fase() {
		setTitle("Tom's Adventure");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		
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
				new Menu();
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
		
		JLabel lblFases = new JLabel("Fases");
		lblFases.setHorizontalAlignment(SwingConstants.CENTER);
		lblFases.setFont(new Font("Adventure", Font.PLAIN, 72));
		lblFases.setBounds(10, 11, 764, 84);
		lblFases.setForeground(new Color(163,112,66));
		contentPane.add(lblFases);
		
		JLabel fase1 = new JLabel("1");
		fase1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				fase1.setForeground(new Color(255, 243, 57));
			}
			
			@Override
			public void mouseExited(MouseEvent arg0){
				fase1.setForeground(new Color(59, 37, 17));
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0){
				dispose();
				new Cenario1();
			}
		});
		fase1.setBorder(BorderFactory.createLineBorder(new Color(59,37,17), 3));
		fase1.setForeground(new Color(59, 37, 17));
		fase1.setBackground(new Color(163,112,66));
		fase1.setOpaque(true);
		fase1.setHorizontalAlignment(SwingConstants.CENTER);
		fase1.setFont(new Font("Adventure", Font.PLAIN, 67));
		fase1.setBounds(168, 152, 100, 100);
		contentPane.add(fase1);
		
		JLabel fase2 = new JLabel("2");
		fase2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				fase2.setForeground(new Color(255, 243, 57));
			}
			
			@Override
			public void mouseExited(MouseEvent arg0){
				fase2.setForeground(new Color(59, 37, 17));
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0){
				new Cenario2();
				dispose();
			}
		});
		fase2.setBorder(BorderFactory.createLineBorder(new Color(59,37,17), 3));
		fase2.setForeground(new Color(59, 37, 17));
		fase2.setBackground(new Color(163,112,66));
		fase2.setOpaque(true);
		fase2.setHorizontalAlignment(SwingConstants.CENTER);
		fase2.setFont(new Font("Adventure", Font.PLAIN, 67));
		fase2.setBounds(345, 152, 100, 100);
		contentPane.add(fase2);
		
		JLabel fase3 = new JLabel("3");
		fase3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				fase3.setForeground(new Color(255, 243, 57));
			}
			
			@Override
			public void mouseExited(MouseEvent arg0){
				fase3.setForeground(new Color(59, 37, 17));
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0){
				new Cenario3();
				dispose();
			}
		});
		fase3.setOpaque(true);
		fase3.setHorizontalAlignment(SwingConstants.CENTER);
		fase3.setForeground(new Color(59, 37, 17));
		fase3.setFont(new Font("Adventure", Font.PLAIN, 67));
		fase3.setBorder(BorderFactory.createLineBorder(new Color(59,37,17), 3));
		fase3.setBackground(new Color(163, 112, 66));
		fase3.setBounds(516, 152, 100, 100);
		contentPane.add(fase3);
		contentPane.setLayout(null);
		
		Icon imagemFundo = new ImageIcon(getClass().getResource("../images/BG.png"));
		JLabel fundo = new JLabel("");
		fundo.setIcon(imagemFundo);
		fundo.setBounds(0, 0, 794, 571);
		contentPane.add(fundo);
		repaint();
		setVisible(true);
	}
}
