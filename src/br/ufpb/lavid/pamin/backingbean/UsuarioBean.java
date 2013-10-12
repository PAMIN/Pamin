package br.ufpb.lavid.pamin.backingbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ufpb.lavid.pamin.controlador.ControladorUsuario;
import br.ufpb.lavid.pamin.modelo.Usuario;

@ManagedBean(name="usuarioBean")
@SessionScoped
public class UsuarioBean implements java.io.Serializable {

	private String login;
	private String senha;
	private Usuario usuario;

	public Usuario getUsuario() {
		return this.usuario;
	}

	public Usuario setUsuario(Usuario usuario) {
		return this.usuario = usuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String login() {
		ControladorUsuario controlUsuario = new ControladorUsuario();
		this.usuario = controlUsuario.login(this.login, this.senha);
		
		if(this.usuario == null){
			return "erroLogin";
		}
		
		return "sucessoLogin";
	}

	public String logout() {
		usuario = null;
		return "principal";
	}
	
}