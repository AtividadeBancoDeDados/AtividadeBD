package dominio;

public class Resultado {
	private String nome;
	private String ssn;
	private int salario;
	private double horas;
	private int numero;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSsn() {
		return this.ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public int getSalario() {
		return this.salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	public double getHoras() {
		return this.horas;
	}
	public void setHoras(double horas) {
		this.horas = horas;
	}
	public int getNumero() {
		return this.numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	

}
