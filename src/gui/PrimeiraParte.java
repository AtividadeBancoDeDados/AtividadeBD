package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;

import dominio.Resultado;
import business.Business;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;

public class PrimeiraParte extends JFrame {

	private JPanel contentPane;
	Business business = Business.getInstancia();
	private JTextArea textArea;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimeiraParte frame = new PrimeiraParte();
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
	public PrimeiraParte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 124, 520, 226);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Consulta 4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					List<Resultado> resultado =  business.consulta4();
					String textResultado = "Departamentos: \n \n";
					for (Resultado resultado2 : resultado) {
						textResultado = textResultado + resultado2.getNome() + "\n";
						
					}
					textArea.setText(textResultado);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(71, 11, 144, 23);
		contentPane.add(btnNewButton);
		
		JButton btnConsulta = new JButton("Consulta 9");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					List<Resultado> resultado =  business.consulta9();
					String textResultado = "SSN - NOME - DIFERENÇA SALARIAL \n \n";
					for (Resultado resultado2 : resultado) {
						textResultado = textResultado + resultado2.getSsn() + " - "+ resultado2.getNome()+ " - (" + resultado2.getSalario() + ") \n";
						
					}
					textArea.setText(textResultado);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConsulta.setBounds(225, 11, 152, 23);
		contentPane.add(btnConsulta);
		
		JButton btnConsulta_1 = new JButton("Consulta 12");
		btnConsulta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					List<Resultado> resultado =  business.consulta12();
					String textResultado = "SSN - NOME \n \n";
					for (Resultado resultado2 : resultado) {
						textResultado = textResultado + resultado2.getSsn() + " - "+ resultado2.getNome()+" \n";
						
					}
					textArea.setText(textResultado);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConsulta_1.setBounds(387, 11, 151, 23);
		contentPane.add(btnConsulta_1);
		
		JButton btnConsulta_2 = new JButton("Consulta 18");
		btnConsulta_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					List<Resultado> resultado =  business.consulta18();
					String textResultado = "Departamento - Media \n \n";
					for (Resultado resultado2 : resultado) {
						textResultado = textResultado + resultado2.getNome() + " - "+ resultado2.getSalario()+" \n";
						
					}
					textArea.setText(textResultado);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConsulta_2.setBounds(71, 45, 144, 23);
		contentPane.add(btnConsulta_2);
		
		JButton btnConsulta_3 = new JButton("Consulta 20");
		btnConsulta_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					List<Resultado> resultado =  business.consulta20();
					String textResultado = "SSN - Nome \n \n";
					for (Resultado resultado2 : resultado) {
						textResultado = textResultado + resultado2.getNome() + " - "+ resultado2.getSsn()+" \n";
						
					}
					textArea.setText(textResultado);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConsulta_3.setBounds(225, 45, 151, 23);
		contentPane.add(btnConsulta_3);
		
		JButton btnConsulta_4 = new JButton("Consulta 25");
		btnConsulta_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					List<Resultado> resultado =  business.consulta25();
					String textResultado = "SSN - Nome - Horas trabalhadas \n \n";
					for (Resultado resultado2 : resultado) {
						textResultado = textResultado + resultado2.getNome() + " - "+ resultado2.getSsn()+ " - "+resultado2.getHoras()+ "\n";
						
					}
					textArea.setText(textResultado);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConsulta_4.setBounds(386, 45, 152, 23);
		contentPane.add(btnConsulta_4);
		
		JButton btnConsulta_5 = new JButton("Consulta 28");
		btnConsulta_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					List<Resultado> resultado =  business.consulta28();
					String textResultado = "Número do Projeto - Nome do Projeto - Horas trabalhadas \n \n";
					for (Resultado resultado2 : resultado) {
						textResultado = textResultado + resultado2.getNumero() + " - "+ resultado2.getNome()+ " - "+resultado2.getHoras()+ "\n";
						
					}
					textArea.setText(textResultado);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConsulta_5.setBounds(72, 90, 143, 23);
		contentPane.add(btnConsulta_5);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu tela = new Menu();
				tela.setVisible(true);
				setVisible(false);
				
			}
		});
		btnVoltar.setBounds(183, 361, 143, 23);
		contentPane.add(btnVoltar);
		
	}
}
