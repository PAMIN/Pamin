package br.ufpb.lavid.pamin.controlador;

import br.ufpb.lavid.pamin.dao.UsuarioDao;
import br.ufpb.lavid.pamin.modelo.Usuario;

public class ControladorUsuario {

	private	int flag;
		
	public int cadastrarUsuario(Usuario novoUsuario) {

		UsuarioDao usuarioDao = new UsuarioDao();
		flag = usuarioDao.insert(novoUsuario);
		
		return flag;
	}
	
	public Usuario login(String login, String senha){
		UsuarioDao usuarioDao = new UsuarioDao();
		Usuario usuario = new Usuario();
		usuario = usuarioDao.login(login, senha);
		
		return usuario;
	}

}//classe