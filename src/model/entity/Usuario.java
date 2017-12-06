package model.entity;

import java.util.GregorianCalendar;

public class Usuario {
	private String email;
	private String nome;
	private String senha;
	private String perfil;
	private GregorianCalendar dtCadastro;
	
	
	/* Construtor vazio */
	public Usuario() {
		super();
	}
	
	/* Construtor cheio */
	public Usuario(String email, String nome, String senha, String perfil, GregorianCalendar dtCadastro) {
		super();
		this.email = email;
		this.nome = nome;
		this.senha = senha;
		this.perfil = perfil;
		this.dtCadastro = dtCadastro;
	}

	/* Método toString*/
	@Override
	public String toString() {
		return "Usuario [email=" + email + ", nome=" + nome + ", senha=" + senha + ", perfil=" + perfil
				+ ", dtCadastro=" + dtCadastro + "]";
	}

	/* Getters e Setters*/
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public GregorianCalendar getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(GregorianCalendar dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
}
