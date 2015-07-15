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

public class InserirBiblioteca extends JFrame {

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
					InserirBiblioteca frame = new InserirBiblioteca();
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
	public InserirBiblioteca() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInserirBiblioteca = new JLabel("Inserir Biblioteca");
		lblInserirBiblioteca.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInserirBiblioteca.setBounds(10, 11, 251, 14);
		contentPane.add(lblInserirBiblioteca);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(10, 55, 74, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 101, 46, 14);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(67, 52, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 98, 323, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigo = Integer.valueOf(textField.getText().toString());
				String nome = textField_1.getText().toString(); 
				Cadastro cadastro = new Cadastro();
				cadastro.setCodigo(codigo);
				cadastro.setNome(nome);
				try {
					business.inserirBiblioteca(cadastro);
					JOptionPane.showMessageDialog(null, "Biblioteca inserida",
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
		btnInserir.setBounds(64, 176, 116, 23);
		contentPane.add(btnInserir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuParte2 tela = new MenuParte2();
				tela.setVisible(true);
				setVisible(false);
			}
		});
		btnVoltar.setBounds(221, 176, 116, 23);
		contentPane.add(btnVoltar);
	}

}
