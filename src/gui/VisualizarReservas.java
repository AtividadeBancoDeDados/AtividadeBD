package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import business.Business2;
import dominio.Cadastro;
import dominio.Resultado;

public class VisualizarReservas extends JFrame {

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
					VisualizarReservas frame = new VisualizarReservas();
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
	public VisualizarReservas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuriosComReservas = new JLabel("Usu\u00E1rios com reservas");
		lblUsuriosComReservas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuriosComReservas.setBounds(10, 11, 386, 14);
		contentPane.add(lblUsuriosComReservas);
		
		JButton btnNewButton = new JButton("Visualizar usu\u00E1rios com reservas");
		btnNewButton.setBounds(10, 36, 458, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					List<Cadastro> resultado =  business.usuariosReserva();
					String textResultado = "Usuários com reserva: \n \n";
					for (Cadastro resultado2 : resultado) {
						textResultado = textResultado + resultado2.getNome() + "\n";
						
					}
					textArea.setText(textResultado);
					
				} catch (SQLException e1) {
					textArea.setText("Não possui resultados");
					e1.printStackTrace();
				}
				
			}
		});
		
		textArea = new JTextArea();
		textArea.setBounds(10, 70, 458, 197);
		contentPane.add(textArea);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuParte2 tela = new MenuParte2();
				tela.setVisible(true);
				setVisible(false);
			}
		});
		btnVoltar.setBounds(194, 272, 112, 23);
		contentPane.add(btnVoltar);
	}

}
