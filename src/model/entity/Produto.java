package model.entity;

import java.util.GregorianCalendar;

public class Produto {
	private Long codigo;
	private String descricao;
	private Integer categoriaProduto;
	private String marca;
	private String tamroupa1; 
	private Integer tamroupa2;
	private Integer tamCalcado;
	private Double valor;
	private double percentualDesconto;
	private String parcelamento;
	private String destaque;
	private GregorianCalendar dataInicioComercializacao;
	private Long qtdEstoque; 
	private String pathFoto1;
	private String pathFoto2;
	private String pathFoto3;
	private String pathFoto4;
		
	/* Construtor Vazio */
	
	public Produto() {
		super();
	}

	public Produto(Long codigo, String descricao, Integer categoriaProduto, String marca, String tamroupa1,
			Integer tamroupa2, Integer tamCalcado, Double valor, double percentualDesconto, String parcelamento,
			String destaque, GregorianCalendar dataInicioComercializacao, Long qtdEstoque, String pathFoto1,
			String pathFoto2, String pathFoto3, String pathFoto4) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.categoriaProduto = categoriaProduto;
		this.marca = marca;
		this.tamroupa1 = tamroupa1;
		this.tamroupa2 = tamroupa2;
		this.tamCalcado = tamCalcado;
		this.valor = valor;
		this.percentualDesconto = percentualDesconto;
		this.parcelamento = parcelamento;
		this.destaque = destaque;
		this.dataInicioComercializacao = dataInicioComercializacao;
		this.qtdEstoque = qtdEstoque;
		this.pathFoto1 = pathFoto1;
		this.pathFoto2 = pathFoto2;
		this.pathFoto3 = pathFoto3;
		this.pathFoto4 = pathFoto4;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", categoriaProduto=" + categoriaProduto
				+ ", marca=" + marca + ", tamroupa1=" + tamroupa1 + ", tamroupa2=" + tamroupa2 + ", tamCalcado="
				+ tamCalcado + ", valor=" + valor + ", percentualDesconto=" + percentualDesconto + ", parcelamento="
				+ parcelamento + ", destaque=" + destaque + ", dataInicioComercializacao=" + dataInicioComercializacao
				+ ", qtdEstoque=" + qtdEstoque + ", pathFoto1=" + pathFoto1 + ", pathFoto2=" + pathFoto2
				+ ", pathFoto3=" + pathFoto3 + ", pathFoto4=" + pathFoto4 + "]";
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCategoriaProduto() {
		return categoriaProduto;
	}

	public void setCategoriaProduto(Integer categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTamroupa1() {
		return tamroupa1;
	}

	public void setTamroupa1(String tamroupa1) {
		this.tamroupa1 = tamroupa1;
	}

	public Integer getTamroupa2() {
		return tamroupa2;
	}

	public void setTamroupa2(Integer tamroupa2) {
		this.tamroupa2 = tamroupa2;
	}

	public Integer getTamCalcado() {
		return tamCalcado;
	}

	public void setTamCalcado(Integer tamCalcado) {
		this.tamCalcado = tamCalcado;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public String getParcelamento() {
		return parcelamento;
	}

	public void setParcelamento(String parcelamento) {
		this.parcelamento = parcelamento;
	}

	public String getDestaque() {
		return destaque;
	}

	public void setDestaque(String destaque) {
		this.destaque = destaque;
	}

	public GregorianCalendar getDataInicioComercializacao() {
		return dataInicioComercializacao;
	}

	public void setDataInicioComercializacao(GregorianCalendar dataInicioComercializacao) {
		this.dataInicioComercializacao = dataInicioComercializacao;
	}

	public Long getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Long qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public String getPathFoto1() {
		return pathFoto1;
	}

	public void setPathFoto1(String pathFoto1) {
		this.pathFoto1 = pathFoto1;
	}

	public String getPathFoto2() {
		return pathFoto2;
	}

	public void setPathFoto2(String pathFoto2) {
		this.pathFoto2 = pathFoto2;
	}

	public String getPathFoto3() {
		return pathFoto3;
	}

	public void setPathFoto3(String pathFoto3) {
		this.pathFoto3 = pathFoto3;
	}

	public String getPathFoto4() {
		return pathFoto4;
	}

	public void setPathFoto4(String pathFoto4) {
		this.pathFoto4 = pathFoto4;
	}
	
}
