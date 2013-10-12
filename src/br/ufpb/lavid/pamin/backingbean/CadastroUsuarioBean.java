package br.ufpb.lavid.pamin.backingbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.ufpb.lavid.pamin.controlador.ControladorUsuario;
import br.ufpb.lavid.pamin.modelo.Usuario;

@ManagedBean(name="cadastroUsuarioBean")
@ViewScoped
public class CadastroUsuarioBean implements java.io.Serializable {

	private Usuario novoUsuario = new Usuario();

	public Usuario getNovoUsuario() {
		return novoUsuario;
	}

	public void setNovoUsuario(Usuario novoUsuario) {
		this.novoUsuario = novoUsuario;
	}
	
	public String cadastrarUsuario() {
		ControladorUsuario controlUsuario = new ControladorUsuario();
		int flag = controlUsuario.cadastrarUsuario(novoUsuario);
		
		if(flag == 1) {
			return "sucessoCadastro";
		} else {
			return "erroCadastro";
		}
	}
	
}
