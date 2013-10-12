package br.ufpb.lavid.pamin.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="atracao", schema="public")
public class Atracao {
	
	private int idatracao;
	@Column(name="tipoatracao")
	private String nome;
	
	public int getIdatracao() {
		return idatracao;
	}
	public void setIdatracao(int idatracao) {
		this.idatracao = idatracao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
