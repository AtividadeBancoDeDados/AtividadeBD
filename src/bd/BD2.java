package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.sgta.usuario.dao.UsuarioDAO;

public class BD2 {
	private static BD2 instancia = new BD2();

	private BD2() {
	}

	private BD2 bd;

	public static BD2 getInstancia() {
		return instancia;
	}
	
	private static Connection con;
	
	private static Connection conexao = null;
	private static Statement statement;
	private static ResultSet resultSet = null;
	private static String stringSQL = null;

	public static ResultSet getResultSet() {
		return resultSet;
	}

	public static void setResultSet(ResultSet resultSet) {
		BD2.resultSet = resultSet;
	}

	/**
	 * ABRE CONEX�O COM COM BANCO
	 */
	public static Connection getConnection() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return conexao = DriverManager.getConnection(
					"jdbc:mysql://localhost/biblioteca", "root", "root"); 
		}  catch (ClassNotFoundException e) {    
            throw new SQLException(e.getMessage());  
		}
	}

	/**
	 * FECHA CONEX�O COM COM BANCO
	 */
	public static void fecharConecaoMySQL() {
		try {
			conexao.close();
		} catch (Exception erro) {
			System.out.println("MYSQL Erro(fechar): " + erro);
		}
	}

	/**
	 * RESULTADO DA CONSULTA NO BANCO
	 */
	public static ResultSet queryMySQL(String qry) {
		try {
			statement = conexao.createStatement();
			stringSQL = qry;
			setResultSet(statement.executeQuery(stringSQL));
			getResultSet().first();
			return getResultSet();
		} catch (Exception erro) {
			System.out.println("MYSQL Erro: " + erro);
			return null;
		}
	}
}
