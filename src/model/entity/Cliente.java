package model.entity;

import java.util.GregorianCalendar;

public class Cliente extends Usuario {
	
	private Long cpf;	
	private GregorianCalendar dtNasc; 
	private String sexo;
	private String telefone;
	private String celular;
	private Integer tpEndereco;
	private String cep;
	private String endereco;
	private Integer numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;		
	private String infref;
	
	/*Construtor Vazio*/	
	public Cliente() {
		super();
	}

	/*Construtor Cheio - sem a superclasse*/
	public Cliente(Long cpf, GregorianCalendar dtNasc, String sexo, String telefone, String celular, Integer tpEndereco,
			String cep, String endereco, Integer numero, String complemento, String bairro, String cidade,
			String estado, String infref) {
		super();
		this.cpf = cpf;
		this.dtNasc = dtNasc;
		this.sexo = sexo;
		this.telefone = telefone;
		this.celular = celular;
		this.tpEndereco = tpEndereco;
		this.cep = cep;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.infref = infref;
	}


	/*Construtor Cheio - com a superClass*/
	public Cliente(String email, String nome, String senha, String perfil, GregorianCalendar dtCadastro, Long cpf,
			GregorianCalendar dtNasc, String sexo, String telefone, String celular,
			Integer tpEndereco, String cep, String endereco, Integer numero, String complemento,
			String bairro,String cidade, String estado, String infref) {
		super(email, nome, senha, perfil, dtCadastro);
		this.cpf = cpf;
		this.dtNasc = dtNasc;
		this.sexo = sexo;
		this.telefone = telefone;
		this.celular = celular;
		this.tpEndereco = tpEndereco;
		this.cep = cep;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.infref = infref;
	}
	
	/* Método toString */
	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", dtNasc=" + dtNasc + ", sexo=" + sexo + ", telefone=" + telefone + ", celular="
				+ celular + ", tpEndereco=" + tpEndereco + ", cep=" + cep + ", endereco=" + endereco + ", numero="
				+ numero + ", complemento=" + complemento + ", bairro=" + bairro + ", cidade=" + cidade + ", estado="
				+ estado + ", infref=" + infref + "]";
	}

	/* Getters e Setters*/
	
	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public GregorianCalendar getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(GregorianCalendar dtNasc) {
		this.dtNasc = dtNasc;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Integer getTpEndereco() {
		return tpEndereco;
	}

	public void setTpEndereco(Integer tpEndereco) {
		this.tpEndereco = tpEndereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getInfref() {
		return infref;
	}

	public void setInfref(String infref) {
		this.infref = infref;
	}
			
}
