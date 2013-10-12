package br.ufpb.lavid.pamin.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="evento",schema="public")
public class Evento {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="evento_seq")
	@SequenceGenerator(name="evento_seq", sequenceName="id_evento")
	private int idEvento;
	private int fklugar;
	private int fkatracao;
	private int fkusuario;
	private int numeroVisitas;
	private String nomeEvento;
	private String descricao;
	@Column(name="horaevento")
	private String hora;
	@Temporal(TemporalType.DATE)
	private Date dteventoini;
	@Temporal(TemporalType.DATE)
	private Date dteventofim;
	@Column(name="precoevento")
	private String preco;
	private String promotorevento;
	private String contatopromotor;
	private String observacao;
	private String tag;
	private String nomeAnexo;
	private String horaAnexo;
	
	public int getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	public int getFklugar() {
		return fklugar;
	}
	public void setFklugar(int fklugar) {
		this.fklugar = fklugar;
	}
	public int getFkatracao() {
		return fkatracao;
	}
	public void setFkatracao(int fkatracao) {
		this.fkatracao = fkatracao;
	}
	public int getFkusuario() {
		return fkusuario;
	}
	public void setFkusuario(int fkusuario) {
		this.fkusuario = fkusuario;
	}
	public int getNumeroVisitas() {
		return numeroVisitas;
	}
	public void setNumeroVisitas(int numeroVisitas) {
		this.numeroVisitas = numeroVisitas;
	}
	public String getNomeEvento() {
		return nomeEvento;
	}
	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Date getDteventoini() {
		return dteventoini;
	}
	public void setDteventoini(Date dteventoini) {
		this.dteventoini = dteventoini;
	}
	public Date getDteventofim() {
		return dteventofim;
	}
	public void setDteventofim(Date dteventofim) {
		this.dteventofim = dteventofim;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public String getPromotorevento() {
		return promotorevento;
	}
	public void setPromotorevento(String promotorevento) {
		this.promotorevento = promotorevento;
	}
	public String getContatopromotor() {
		return contatopromotor;
	}
	public void setContatopromotor(String contatopromotor) {
		this.contatopromotor = contatopromotor;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getNomeAnexo() {
		return nomeAnexo;
	}
	public void setNomeAnexo(String nomeAnexo) {
		this.nomeAnexo = nomeAnexo;
	}
	public String getHoraAnexo() {
		return horaAnexo;
	}
	public void setHoraAnexo(String horaAnexo) {
		this.horaAnexo = horaAnexo;
	}
	
}
