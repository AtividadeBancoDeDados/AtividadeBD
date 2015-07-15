package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import business.Business2;
import dominio.Cadastro;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class AtualizarBiblioteca extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	Business2 business = Business2.getInstancia();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarBiblioteca frame = new AtualizarBiblioteca();
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
	public AtualizarBiblioteca() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAtualizarBiblioteca = new JLabel("Atualizar Biblioteca");
		lblAtualizarBiblioteca.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAtualizarBiblioteca.setBounds(10, 11, 163, 14);
		contentPane.add(lblAtualizarBiblioteca);
		
		JLabel lblNewLabel = new JLabel("Nome antigo");
		lblNewLabel.setBounds(10, 65, 93, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomeNovo = new JLabel("Nome novo");
		lblNomeNovo.setBounds(10, 114, 93, 14);
		contentPane.add(lblNomeNovo);
		
		textField = new JTextField();
		textField.setBounds(98, 62, 313, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(98, 111, 313, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String antigoNome = textField.getText().toString();
				String novoNome = textField_1.getText().toString(); 
				Cadastro antigoCadastro = new Cadastro();
				Cadastro novoCadastro = new Cadastro();
				antigoCadastro.setNome(antigoNome);
				novoCadastro.setNome(novoNome);
				try {
					business.atualizarBiblioteca(antigoCadastro, novoCadastro);
					JOptionPane.showMessageDialog(null, "Biblioteca atualizada",
							"ATENÇÃO!!", JOptionPane.DEFAULT_OPTION);
					MenuParte2 nova = new MenuParte2();
					nova.setVisible(true);
					setVisible(false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro! Tente novamente mais tarde!",
							"ATENÇÃO!!", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnAtualizar.setBounds(82, 179, 115, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuParte2 tela = new MenuParte2();
				tela.setVisible(true);
				setVisible(false);
			}
		});
		btnVoltar.setBounds(232, 179, 115, 23);
		contentPane.add(btnVoltar);
	}

}
