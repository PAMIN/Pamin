package br.ufpb.lavid.pamin.controlador;

import java.util.ArrayList;
import java.util.List;

import br.ufpb.lavid.pamin.dao.EventoDao;
import br.ufpb.lavid.pamin.modelo.EventoInfo;
import br.ufpb.lavid.pamin.util.LocalizaCoordUtil;


public class ControladorEvento{
	
	public EventoInfo getDetalheEvento(int id) {
		EventoDao eventoDao = new EventoDao();
		EventoInfo eventoDetalhe = eventoDao.search(id);
		return eventoDetalhe;
	}

	public int cadastraEventos(EventoInfo evento){  //idevento não passo porque Ã© auto incremento
	
		LocalizaCoordUtil localCoord = new LocalizaCoordUtil();
		
		String[] latLng = localCoord.getCoordinates(evento.getLogradouro(), evento.getBairro(), evento.getCidade(), evento.getEstado());
		
        evento.setLatitude(latLng[0]);
        evento.setLongitude(latLng[1]);
       
		EventoDao eventoDao = new EventoDao();
		int flag = eventoDao.insert(evento);
		
		return flag;
		
	}//cadastraEvento
	
	public List<EventoInfo> getListaInfoEventos(){
		List listaInfoEventos = new ArrayList<EventoInfo>();
		EventoDao eventoDao = new EventoDao();
		listaInfoEventos = eventoDao.list();
		return listaInfoEventos;
	}

}//classe
