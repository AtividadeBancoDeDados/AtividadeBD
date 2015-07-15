package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Atividade 2\u00AA VA Fundamento de Banco de Dados");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 504, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblAlunos = new JLabel("Alunos:");
		lblAlunos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAlunos.setBounds(10, 48, 67, 14);
		contentPane.add(lblAlunos);
		
		JLabel lblAntonioJorgeFerreira = new JLabel("Antonio Jorge Ferreira Delgado Filho");
		lblAntonioJorgeFerreira.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAntonioJorgeFerreira.setBounds(66, 48, 379, 14);
		contentPane.add(lblAntonioJorgeFerreira);
		
		JLabel lblBrenoFerysFerreira = new JLabel("Breno Ferys Ferreira da Silva");
		lblBrenoFerysFerreira.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBrenoFerysFerreira.setBounds(66, 66, 379, 14);
		contentPane.add(lblBrenoFerysFerreira);
		
		JLabel lblEdvanJa = new JLabel("Edvan Joaquim Soares J\u00FAnior");
		lblEdvanJa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEdvanJa.setBounds(66, 87, 379, 14);
		contentPane.add(lblEdvanJa);
		
		JButton btnResultadosDa = new JButton("Resultados da 1\u00AA Parte \r\n / Consultas SQL");
		btnResultadosDa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrimeiraParte tela = new PrimeiraParte();
				tela.setVisible(true);
				setVisible(false);
			}
		});
		btnResultadosDa.setBounds(10, 145, 264, 125);
		contentPane.add(btnResultadosDa);
		
		JButton btnNewButton = new JButton("2\u00AA Parte");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuParte2 tela = new MenuParte2();
				tela.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(284, 147, 230, 123);
		contentPane.add(btnNewButton);
	}
}
