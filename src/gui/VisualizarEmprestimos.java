package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextArea;

import business.Business2;
import dominio.Cadastro;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;

public class VisualizarEmprestimos extends JFrame {

	private JPanel contentPane;
	Business2 business = Business2.getInstancia();
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarEmprestimos frame = new VisualizarEmprestimos();
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
	public VisualizarEmprestimos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVisualizaoDeEmprstimos = new JLabel("Visualiza\u00E7\u00E3o de Empr\u00E9stimos");
		lblVisualizaoDeEmprstimos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVisualizaoDeEmprstimos.setBounds(10, 11, 320, 14);
		contentPane.add(lblVisualizaoDeEmprstimos);
		
		JButton btnVisualizar = new JButton("Visualizar empr\u00E9stimos");
		btnVisualizar.setBounds(10, 36, 480, 23);
		contentPane.add(btnVisualizar);
		btnVisualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					List<Cadastro> resultado =  business.emprestimos();
					String textResultado = "Usuário  -  Livro emprestado: \n \n";
					for (Cadastro resultado2 : resultado) {
						textResultado = textResultado + resultado2.getNome() + "  -  "+ resultado2.getNome2() +"\n";
						
					}
					textArea.setText(textResultado);
					
				} catch (SQLException e1) {
					textArea.setText("Não possui resultados");
					e1.printStackTrace();
				}
				
			}
		});
		
		textArea = new JTextArea();
		textArea.setBounds(10, 84, 480, 186);
		contentPane.add(textArea);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuParte2 tela = new MenuParte2();
				tela.setVisible(true);
				setVisible(false);
			}
		});
		btnVoltar.setBounds(201, 281, 116, 23);
		contentPane.add(btnVoltar);
	}

}
