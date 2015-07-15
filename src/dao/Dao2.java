package dao;

import java.awt.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;









import dominio.Cadastro;
import dominio.Resultado;
import bd.BD;
import bd.BD2;

import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Dao2 {
	private static Dao2 instancia = new Dao2();

	private Dao2() {
	}

	private BD2 bd = BD2.getInstancia();

	public static Dao2 getInstancia() {
		return instancia;
	}
	public List<Resultado> consulta4() throws SQLException {// Deixei aqui para poder usar como exemplos

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Resultado resultado = new Resultado();
		List<Resultado> listaResultados = new ArrayList<Resultado>();

		try {
			connection = bd.getConnection();
			statement = connection
					.prepareStatement("select dnome from departamento where dnumero in (select dnumero from dept_localizacoes where dlocalizacao='Houston')");
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				resultado.setNome(resultSet.getString("dnome"));
				listaResultados.add(resultado);
				
				resultado = new Resultado();

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resultSet.close();
			bd.fecharConecaoMySQL();
		}

		return listaResultados;
	}
	
	public void inserirUsuario(Cadastro cadastro) throws SQLException {
		try {
			Connection con = bd.getConnection();
			PreparedStatement prepared = con
					.prepareStatement("insert into usuario(NomeUsu,CodUsu) values (?,?);");
			prepared.setString(1, cadastro.getNome());
			prepared.setInt(2, cadastro.getCodigo());
			
			prepared.execute();

			bd.fecharConecaoMySQL();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void inserirBiblioteca(Cadastro cadastro) throws SQLException {
		try {
			Connection con = bd.getConnection();
			PreparedStatement prepared = con
					.prepareStatement("insert into biblioteca(NomeBib,CodBib) values (?,?);");
			prepared.setString(1, cadastro.getNome());
			prepared.setInt(2, cadastro.getCodigo());
			
			prepared.execute();

			bd.fecharConecaoMySQL();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void atualizarUsuario(Cadastro cadastro, Cadastro novoCadastro) throws SQLException {
		try {
			Connection con = bd.getConnection();
			PreparedStatement prepared = con
					.prepareStatement("update usuario set NomeUsu = ? where NomeUsu = ?;");
			prepared.setString(1, novoCadastro.getNome());
			prepared.setString(2, cadastro.getNome());
			
			prepared.execute();

			bd.fecharConecaoMySQL();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void atualizarBiblioteca(Cadastro cadastro, Cadastro novoCadastro) throws SQLException {
		try {
			Connection con = bd.getConnection();
			PreparedStatement prepared = con
					.prepareStatement("update biblioteca set NomeBib = ? where NomeBib = ?;");
			prepared.setString(1, novoCadastro.getNome());
			prepared.setString(2, cadastro.getNome());
			
			prepared.execute();

			bd.fecharConecaoMySQL();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deletarUsuario(Cadastro cadastro) throws SQLException {
		try {
			Connection con = bd.getConnection();
			PreparedStatement prepared = con
					.prepareStatement("delete from usuario where CodUsu= ? ;");
			
			prepared.setInt(1, cadastro.getCodigo());
			
			prepared.execute();

			bd.fecharConecaoMySQL();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deletarBiblioteca(Cadastro cadastro) throws SQLException {
		try {
			Connection con = bd.getConnection();
			PreparedStatement prepared = con
					.prepareStatement("delete from biblioteca where CodBib= ? ;");
			
			prepared.setInt(1, cadastro.getCodigo());
			
			prepared.execute();

			bd.fecharConecaoMySQL();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Cadastro> usuariosReserva() throws SQLException {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Cadastro resultado = new Cadastro();
		List<Cadastro> listaResultados = new ArrayList<Cadastro>();

		try {
			connection = bd.getConnection();
			statement = connection
					.prepareStatement("select * from usuarios_com_reserva");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				resultado.setNome(resultSet.getString("NomeUsu"));
				listaResultados.add(resultado);
				
				resultado = new Cadastro();

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resultSet.close();
			bd.fecharConecaoMySQL();
		}

		return listaResultados;
	}
	
	public List<Cadastro> emprestimos() throws SQLException {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Cadastro resultado = new Cadastro();
		List<Cadastro> listaResultados = new ArrayList<Cadastro>();

		try {
			connection = bd.getConnection();
			statement = connection
					.prepareStatement("select * from emprestimos");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				resultado.setNome(resultSet.getString("NomeUsu"));
				resultado.setNome2(resultSet.getString("TituloObra"));
				listaResultados.add(resultado);
				
				resultado = new Cadastro();

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resultSet.close();
			bd.fecharConecaoMySQL();
		}

		return listaResultados;
	}
}
