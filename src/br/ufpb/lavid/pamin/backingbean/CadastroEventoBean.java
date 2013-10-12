package br.ufpb.lavid.pamin.backingbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import java.text.SimpleDateFormat;
import java.util.Date;
import br.ufpb.lavid.pamin.controlador.ControladorEvento;
import br.ufpb.lavid.pamin.modelo.EventoInfo;

@ManagedBean(name="cadastroEventoBean")
@ViewScoped
public class CadastroEventoBean implements java.io.Serializable{

    private EventoInfo evento = new EventoInfo();
    private Date dteventoiniaux;
    private Date dteventofimaux;
    // Radiobutton default "Outros" com id 12 do tipo de atracao
    public CadastroEventoBean () {
       evento.setIdAtracao(12);	
    }
    	
	public String cadastrarEvento(int idUsuario) {

		evento.setIdUsuario(idUsuario);
		
		ControladorEvento cadastro = new ControladorEvento();
		
		int flag = cadastro.cadastraEventos(evento);
		
		if(flag == 1) {
		    return "sucessoCadastro";
		} else {
		    return "erroCadastro";
		}
	}

	public EventoInfo getEvento() {
		return evento;
	}

	public void setEvento(EventoInfo evento) {
		this.evento = evento;
	}

	public Date getDteventoiniaux() {
		return dteventoiniaux;
	}

	public void setDteventoiniaux(Date dataeventoiniaux) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
		this.dteventoiniaux = dataeventoiniaux;
		System.out.println(sf.format(dataeventoiniaux));
		evento.setDteventoini(sf.format(dataeventoiniaux));
	}

	public Date getDteventofimaux() {
		return dteventofimaux;
	}

	public void setDteventofimaux(Date dataeventofimaux) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
		this.dteventofimaux = dataeventofimaux;
		System.out.println(sf.format(dteventofimaux));
		evento.setDteventofim(sf.format(dteventofimaux));
	}  
	
}
