package business;

import java.sql.SQLException;
import java.util.List;

import dao.Dao;
import dao.Dao2;
import dominio.Cadastro;
import dominio.Resultado;



public class Business2 {
	private Dao2 dao = Dao2.getInstancia();

	public Dao2 getDao() {
		return dao;
	}

	private static Business2 instancia = new Business2();

	private Business2() {
	}

	public static Business2 getInstancia() {
		return instancia;
	}

	public void inserirUsuario(Cadastro cadastro) throws SQLException{
		dao.inserirUsuario(cadastro);
	}
	public void inserirBiblioteca(Cadastro cadastro) throws SQLException{
		dao.inserirBiblioteca(cadastro);
	}
	public void atualizarUsuario(Cadastro cadastro, Cadastro novoCadastro) throws SQLException{
		dao.atualizarUsuario(cadastro, novoCadastro);
	}
	public void atualizarBiblioteca(Cadastro cadastro, Cadastro novoCadastro) throws SQLException{
		dao.atualizarBiblioteca(cadastro, novoCadastro);
	}
	public void deletarUsuario(Cadastro cadastro) throws SQLException {
		dao.deletarUsuario(cadastro);
	}
	public void deletarBiblioteca(Cadastro cadastro) throws SQLException {
		dao.deletarBiblioteca(cadastro);
	}
	public List<Cadastro> usuariosReserva() throws SQLException {
		return dao.usuariosReserva();
	}
	public List<Cadastro> emprestimos() throws SQLException {
		return dao.emprestimos();
	}
}
