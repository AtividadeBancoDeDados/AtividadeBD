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

public class DeletarBiblioteca extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	Business2 business = Business2.getInstancia();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletarBiblioteca frame = new DeletarBiblioteca();
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
	public DeletarBiblioteca() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeletarBiblioteca = new JLabel("Deletar Biblioteca");
		lblDeletarBiblioteca.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDeletarBiblioteca.setBounds(10, 11, 291, 14);
		contentPane.add(lblDeletarBiblioteca);
		
		JLabel lblCodigoDaBiblioteca = new JLabel("C\u00F3digo da Biblioteca");
		lblCodigoDaBiblioteca.setBounds(10, 63, 145, 14);
		contentPane.add(lblCodigoDaBiblioteca);
		
		textField = new JTextField();
		textField.setBounds(137, 60, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigo = Integer.valueOf(textField.getText().toString());
				Cadastro cadastro = new Cadastro();
				cadastro.setCodigo(codigo);
				try {
					business.deletarBiblioteca(cadastro);
					JOptionPane.showMessageDialog(null, "Biblioteca excluída",
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
		btnDeletar.setBounds(66, 143, 120, 23);
		contentPane.add(btnDeletar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuParte2 tela = new MenuParte2();
				tela.setVisible(true);
				setVisible(false);
			}
		});
		btnVoltar.setBounds(222, 143, 120, 23);
		contentPane.add(btnVoltar);
	}

}
