package br.ufpb.lavid.pamin.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="lugar", schema="public")
public class Lugar {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="usuario_seq")
	@SequenceGenerator(name="usuario_seq", sequenceName="id_lugar")
	private int idlugar;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String estado;
	private String latitude;
	private String longitude;
	private String local;
	
	public int getIdlugar() {
		return idlugar;
	}
	public void setIdlugar(int idlugar) {
		this.idlugar = idlugar;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
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
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
