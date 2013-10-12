package br.ufpb.lavid.pamin.backingbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="testeBean")
@RequestScoped
public class TesteBean {

	public void showMessage() {
		FacesMessage mensagem = new FacesMessage("urma adicionada ");
		FacesContext.getCurrentInstance().addMessage("c1" , mensagem);
	}
}
