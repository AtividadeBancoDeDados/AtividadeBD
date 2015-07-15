package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuParte2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuParte2 frame = new MenuParte2();
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
	public MenuParte2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAesParaO = new JLabel("A\u00E7\u00F5es para o Banco de Dados  Biblioteca");
		lblAesParaO.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAesParaO.setBounds(10, 11, 358, 14);
		contentPane.add(lblAesParaO);
		
		JButton btnInserirUsuario = new JButton("Inserir Usuario");
		btnInserirUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InserirUsuario tela = new InserirUsuario();
				tela.setVisible(true);
				setVisible(false);
			}
		});
		btnInserirUsuario.setBounds(10, 64, 133, 23);
		contentPane.add(btnInserirUsuario);
		
		JButton btnInserirBiblioteca = new JButton("Inserir Biblioteca");
		btnInserirBiblioteca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InserirBiblioteca tela = new InserirBiblioteca();
				tela.setVisible(true);
				setVisible(false);
			}
		});
		btnInserirBiblioteca.setBounds(10, 124, 133, 23);
		contentPane.add(btnInserirBiblioteca);
		
		JButton btnDeletarBiblioteca = new JButton("Deletar Biblioteca");
		btnDeletarBiblioteca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeletarBiblioteca tela = new DeletarBiblioteca();
				tela.setVisible(true);
				setVisible(false);
			}
		});
		btnDeletarBiblioteca.setBounds(175, 124, 144, 23);
		contentPane.add(btnDeletarBiblioteca);
		
		JButton btnDeletarUsurio = new JButton("Deletar Usu\u00E1rio");
		btnDeletarUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeletarUsuario tela = new DeletarUsuario();
				tela.setVisible(true);
				setVisible(false);
			}
		});
		btnDeletarUsurio.setBounds(175, 64, 144, 23);
		contentPane.add(btnDeletarUsurio);
		
		JButton btnAtualizarUsurio = new JButton("Atualizar Usu\u00E1rio");
		btnAtualizarUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtualizarUsuario tela = new AtualizarUsuario();
				tela.setVisible(true);
				setVisible(false);
			}
		});
		btnAtualizarUsurio.setBounds(354, 64, 149, 23);
		contentPane.add(btnAtualizarUsurio);
		
		JButton btnAtualizarBiblioteca = new JButton("Atualizar Biblioteca");
		btnAtualizarBiblioteca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtualizarBiblioteca tela = new AtualizarBiblioteca();
				tela.setVisible(true);
				setVisible(false);
			}
		});
		btnAtualizarBiblioteca.setBounds(354, 124, 149, 23);
		contentPane.add(btnAtualizarBiblioteca);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu tela = new Menu();
				tela.setVisible(true);
				setVisible(false);
			}
		});
		btnVoltar.setBounds(175, 229, 144, 23);
		contentPane.add(btnVoltar);
		
		JButton btnVisualizarEmprstimos = new JButton("Visualizar empr\u00E9stimos");
		btnVisualizarEmprstimos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisualizarEmprestimos tela = new VisualizarEmprestimos();
				tela.setVisible(true);
				setVisible(false);
			}
		});
		btnVisualizarEmprstimos.setBounds(41, 176, 180, 23);
		contentPane.add(btnVisualizarEmprstimos);
		
		JButton btnVisualizarReservas = new JButton("Usu\u00E1rios com Reservas");
		btnVisualizarReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisualizarReservas tela = new VisualizarReservas();
				tela.setVisible(true);
				setVisible(false);
			}
		});
		btnVisualizarReservas.setBounds(296, 176, 180, 23);
		contentPane.add(btnVisualizarReservas);
	}

}
