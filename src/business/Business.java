package business;

import java.sql.SQLException;
import java.util.List;

import dao.Dao;
import dominio.Resultado;



public class Business {
	private Dao dao = Dao.getInstancia();

	public Dao getDao() {
		return dao;
	}

	private static Business instancia = new Business();

	private Business() {
	}

	public static Business getInstancia() {
		return instancia;
	}

	public List<Resultado> consulta4() throws SQLException{
		return dao.consulta4();
	}
	
	public List<Resultado> consulta9() throws SQLException{
		return dao.consulta9();
	}
	public List<Resultado> consulta12() throws SQLException{
		return dao.consulta12();
	}
	public List<Resultado> consulta18() throws SQLException{
		return dao.consulta18();
	}
	public List<Resultado> consulta20() throws SQLException{
		return dao.consulta20();
	}
	public List<Resultado> consulta25() throws SQLException{
		return dao.consulta25();
	}
	public List<Resultado> consulta28() throws SQLException{
		return dao.consulta28();
	}
}
