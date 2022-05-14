package com.aps.bethstore.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Estoque implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEstoque;
	private String tamProduto;
	private Integer qtdProduto;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "id_produto")
	@MapsId
	private Produto produto;

	public Estoque() {

	}

	public Estoque(Integer idEstoque, String tamProduto, Integer qtdProduto, Produto produto) {
		super();
		this.idEstoque = idEstoque;
		this.tamProduto = tamProduto;
		this.qtdProduto = qtdProduto;
		this.produto = produto;
	}

	public Integer getIdEstoque() {
		return idEstoque;
	}

	public void setIdEstoque(Integer idEstoque) {
		this.idEstoque = idEstoque;
	}

	public String getTamProduto() {
		return tamProduto;
	}

	public void setTamProduto(String tamProduto) {
		this.tamProduto = tamProduto;
	}

	public Integer getQtdProduto() {
		return qtdProduto;
	}

	public void setQtdProduto(Integer qtdProduto) {
		this.qtdProduto = qtdProduto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
