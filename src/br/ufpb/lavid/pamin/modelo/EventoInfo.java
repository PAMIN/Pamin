package br.ufpb.lavid.pamin.modelo;

/*
 * Classe que mantém todas as informações de um evento
 * recolhidas das entidades Evento, Usuario, Atracao e Lugar de 
 * um evento específico
 */
public class EventoInfo {

	private int idAtracao;
	private int idEvento;
	private int idLugar;
	private int idUsuario;
	private int numeroVisitas;
	private String nomeEvento;
	private String descricao;
	private String hora;
	private String dteventoini;
	private String dteventofim;
	private String promotorevento;
	private String contatopromotor;
	private String observacao;
	private String tag;
	private String nomeAnexo;
	private String horaAnexo;
	private String local;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String estado;
	private String latitude;
	private String longitude;
	private String nomeUsuario;
	private String email;
	private String nomeAtracao;
	private String preco;
	
	public int getIdAtracao() {
		return idAtracao;
	}
	
	public void setIdAtracao(int idAtracao) {
		this.idAtracao = idAtracao;
	}
	
	public int getIdEvento() {
		return idEvento;
	}
	
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	
	public int getIdLugar() {
		return idLugar;
	}
	
	public void setIdLugar(int idLugar) {
		this.idLugar = idLugar;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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
	
	public String getDteventoini() {
		return dteventoini;
	}
	
	public void setDteventoini(String dteventoini) {
		this.dteventoini = dteventoini;
	}
	
	public String getDteventofim() {
		return dteventofim;
	}
	
	public void setDteventofim(String dteventofim) {
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
	
	public String getLocal() {
		return local;
	}
	
	public void setLocal(String local) {
		this.local = local;
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
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
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
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	
	public void setNomeUsuario(String nome) {
		this.nomeUsuario = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNomeAtracao() {
		return nomeAtracao;
	}
	
	public void setNomeAtracao(String nomeAtracao) {
		this.nomeAtracao = nomeAtracao;
	}
	
}
