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

import dominio.Cadastro;
import business.Business2;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class AtualizarUsuario extends JFrame {

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
					AtualizarUsuario frame = new AtualizarUsuario();
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
	public AtualizarUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAtualizarUsurio = new JLabel("Atualizar Usu\u00E1rio");
		lblAtualizarUsurio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAtualizarUsurio.setBounds(10, 11, 244, 14);
		contentPane.add(lblAtualizarUsurio);
		
		JLabel lblNomeAntigo = new JLabel("Nome antigo");
		lblNomeAntigo.setBounds(10, 61, 100, 14);
		contentPane.add(lblNomeAntigo);
		
		JLabel lblNovoNome = new JLabel("Novo nome");
		lblNovoNome.setBounds(10, 115, 100, 14);
		contentPane.add(lblNovoNome);
		
		textField = new JTextField();
		textField.setBounds(103, 58, 292, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(103, 112, 292, 20);
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
					business.atualizarUsuario(antigoCadastro, novoCadastro);
					JOptionPane.showMessageDialog(null, "Usuário atualizado",
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
		btnAtualizar.setBounds(103, 177, 112, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuParte2 tela = new MenuParte2();
				tela.setVisible(true);
				setVisible(false);
			}
		});
		btnVoltar.setBounds(248, 177, 112, 23);
		contentPane.add(btnVoltar);
	}

}
