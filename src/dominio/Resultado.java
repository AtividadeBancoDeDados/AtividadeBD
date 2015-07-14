package dominio;

public class Resultado {
	private String nome;
	private String ssn;
	private int salario;
	private int horas;
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
	public int getHoras() {
		return this.horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	

}
