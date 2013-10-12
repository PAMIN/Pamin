package br.ufpb.lavid.pamin.modelo;

import java.sql.Statement;


public class Comentarios implements java.io.Serializable{
	
	private int idcomentario;
	private int fkevento;
	private String comentario;
	private String nomeAutor;
	
	public int getIdComentario() {
		return idcomentario;
	}

	public void setIdComentario(int idcomentario) {
		this.idcomentario = idcomentario;
	}

	public int getFkevento() {
		return fkevento;
	}

	public void setFkvento(int fkevento) {
		this.fkevento = fkevento;
	}
	
	public String getComentario(){
		return comentario;
	}
	
	public void setComentario(String comentario){
		this.comentario = comentario;
	}
	
	public String getNomeAutor(){
		return nomeAutor;
	}
	
	public void setNomeAutor(String nomeAutor){
		this.nomeAutor = nomeAutor;
	}

}