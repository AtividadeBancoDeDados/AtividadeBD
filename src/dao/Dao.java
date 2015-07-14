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







import dominio.Resultado;
import bd.BD;

import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Dao {
	private static Dao instancia = new Dao();

	private Dao() {
	}

	private BD bd = BD.getInstancia();

	public static Dao getInstancia() {
		return instancia;
	}
	public List<Resultado> consulta4() throws SQLException {

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
	
	public List<Resultado> consulta9() throws SQLException {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Resultado resultado = new Resultado();
		List<Resultado> listaResultados = new ArrayList<Resultado>();

		try {
			connection = bd.getConnection();
			statement = connection
					.prepareStatement("(select e1.ssn, e1.pnome, avg(e2.salario)-e1.salario as diferenca_media_salario from empregado e1, empregado e2 where e1.sexo = 'M' and e2.sexo = 'M'"
							+ " group by e1.ssn) union (select e1.ssn, e1.pnome, avg(e2.salario)-e1.salario from empregado e1, empregado e2 where e1.sexo = 'F' and e2.sexo = 'F' "
							+ "group by e1.ssn);");
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				resultado.setSsn(resultSet.getString("ssn"));
				resultado.setNome(resultSet.getString("pnome"));
				resultado.setSalario(resultSet.getInt("diferenca_media_salario"));
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
	public List<Resultado> consulta12() throws SQLException {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Resultado resultado = new Resultado();
		List<Resultado> listaResultados = new ArrayList<Resultado>();

		try {
			connection = bd.getConnection();
			statement = connection
					.prepareStatement("select ssn, pnome from empregado, trabalha_em, projeto where ssn=essn and pno=pnumero and ssn not in (select ssn from empregado, trabalha_em, projeto where ssn=essn and pno= pnumero and dnum!=dno) group by pnome;");
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				resultado.setSsn(resultSet.getString("ssn"));
				resultado.setNome(resultSet.getString("pnome"));
				
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
	public List<Resultado> consulta18() throws SQLException {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Resultado resultado = new Resultado();
		List<Resultado> listaResultados = new ArrayList<Resultado>();

		try {
			connection = bd.getConnection();
			statement = connection
					.prepareStatement("select dnome, avg(e.salario) as media from departamento as d, empregado as e where d.dnumero=e.dno group by dnome;");
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				resultado.setNome(resultSet.getString("dnome"));
				resultado.setSalario(resultSet.getInt("media"));
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
	public List<Resultado> consulta25() throws SQLException {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Resultado resultado = new Resultado();
		List<Resultado> listaResultados = new ArrayList<Resultado>();

		try {
			connection = bd.getConnection();
			statement = connection
					.prepareStatement("select ssn, pnome, sum(horas) as horas_trabalhadas from empregado, trabalha_em where essn=ssn group by ssn having horas_trabalhadas > 35;");
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				resultado.setNome(resultSet.getString("pnome"));
				resultado.setSsn(resultSet.getString("ssn"));
				resultado.setHoras(resultSet.getInt("horas_trabalhadas"));
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
	public List<Resultado> consulta20() throws SQLException {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Resultado resultado = new Resultado();
		List<Resultado> listaResultados = new ArrayList<Resultado>();

		try {
			connection = bd.getConnection();
			statement = connection
					.prepareStatement("select distinct ssn, pnome from empregado, dependente where essn = ssn and (parentesco = 'FILHO' or parentesco = 'FILHA')");
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				resultado.setNome(resultSet.getString("pnome"));
				resultado.setSsn(resultSet.getString("ssn"));
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
	public List<Resultado> consulta28() throws SQLException {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Resultado resultado = new Resultado();
		List<Resultado> listaResultados = new ArrayList<Resultado>();

		try {
			connection = bd.getConnection();
			statement = connection
					.prepareStatement("select pno, pjnome, avg(horas) as media from trabalha_em, projeto where pno=pnumero group by pno");
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				resultado.setNome(resultSet.getString("pjnome"));
				resultado.setHoras(resultSet.getDouble("media"));
				resultado.setNumero(resultSet.getInt("pno"));
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
	
}
