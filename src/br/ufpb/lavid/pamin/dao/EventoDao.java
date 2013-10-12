package br.ufpb.lavid.pamin.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ufpb.lavid.pamin.modelo.Evento;
import br.ufpb.lavid.pamin.modelo.EventoInfo;
import br.ufpb.lavid.pamin.modelo.Lugar;
import br.ufpb.lavid.pamin.util.HibernateUtil;

public class EventoDao implements Dao<EventoInfo>{

	// Insere novo evento no banco de dados
	@Override
	public int insert(EventoInfo eventoInfo) {
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
        // Preenche objeto a ser persistido na tabela lugar
        Lugar lugar = new Lugar();
        lugar.setBairro(eventoInfo.getBairro());
        lugar.setCidade(eventoInfo.getCidade());
        lugar.setLatitude(eventoInfo.getLatitude());
        lugar.setLongitude(eventoInfo.getLongitude());
        lugar.setLocal(eventoInfo.getLocal());
        lugar.setLogradouro(eventoInfo.getLogradouro());
        lugar.setEstado(eventoInfo.getEstado());    
        
        Session session = null;
        try { 
		   session = HibernateUtil.openSession();
		   Transaction tx = session.beginTransaction();
		
		   Query query = session.createQuery("from Lugar as lugar where " +
				   "bairro = :code1 and cidade = :code2 and " +
				   "latitude = :code3 and longitude = :code4 and " +
				   "local = :code5 and logradouro = :code6 and " +
				   "estado = :code7");
		   query.setParameter("code1", lugar.getBairro());
		   query.setParameter("code2", lugar.getCidade());
		   query.setParameter("code3", lugar.getLatitude());
		   query.setParameter("code4", lugar.getLongitude());
		   query.setParameter("code5", lugar.getLocal());
		   query.setParameter("code6", lugar.getLogradouro());
		   query.setParameter("code7", lugar.getEstado());
		   
		   // se o lugar ainda não existe, salva-o
		   if(query.uniqueResult() == null)
		      session.save(lugar);
		   tx.commit();
		   
	       lugar = (Lugar)query.uniqueResult();
	       
	       // Preenche objeto a ser persistido na tabela evento
		   Evento evento = new Evento();
		   evento.setNomeEvento(eventoInfo.getNomeEvento());
		   evento.setDescricao(eventoInfo.getDescricao());
		   evento.setDteventoini(sf.parse(eventoInfo.getDteventoini()));
		   evento.setDteventofim(sf.parse(eventoInfo.getDteventofim()));
		   evento.setFklugar(lugar.getIdlugar());
		   evento.setFkatracao(eventoInfo.getIdAtracao());
		   evento.setFkusuario(eventoInfo.getIdUsuario());
		   evento.setPreco(eventoInfo.getPreco());
		   evento.setHora(eventoInfo.getHora());
		   evento.setHoraAnexo(eventoInfo.getHoraAnexo());
		   evento.setNumeroVisitas(eventoInfo.getNumeroVisitas());
		   evento.setNomeAnexo(eventoInfo.getNomeAnexo());
		   evento.setObservacao(eventoInfo.getObservacao());
		   evento.setPromotorevento(eventoInfo.getPromotorevento());
		   evento.setContatopromotor(eventoInfo.getContatopromotor());
	       evento.setTag(eventoInfo.getTag());

	       tx = session.beginTransaction();
	       session.save(evento);
	       tx.commit();
	       
        } catch(Exception e) {
        	e.printStackTrace();
        	return 0;
        }
        finally { 
           if(session != null)
		      session.close();
        }
        
		return 1;
	}

	/*
	 * Lista todos os eventos registrados no banco de dados obtendo todas as 
	 * informações contidas nas tabelas: evento, lugar, atracao e usuario.
	 * Todas as informações do evento são armazenadas em um objeto EventoInfo
	 */
	public List<EventoInfo> list() {
		
	   SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");	
	   List<EventoInfo> listaEventos = new LinkedList<EventoInfo>();
	   Session session = null;
	      try { 
			 session = HibernateUtil.openSession();
			 Transaction tx = session.beginTransaction();
			
			 Query query = session.createSQLQuery("SELECT * FROM evento " +
						"INNER JOIN Lugar " +
						"ON Evento.fklugar = Lugar.idlugar " +
						"INNER JOIN Atracao " +
						"ON Evento.fkatracao = Atracao.idatracao " +
						"INNER JOIN Usuario " +
						"ON Evento.fkusuario = Usuario.idusuario " +
						"ORDER BY numerovisitas DESC"); 

			 List<Object[]> lista = query.list();
			 
			 for(Object[] row : lista ) {

				 EventoInfo eventoInfo = new EventoInfo();
			     eventoInfo.setIdEvento((int)row[0]);
			     eventoInfo.setIdLugar((int)row[1]);
			     eventoInfo.setIdAtracao((int)row[2]);
	             eventoInfo.setIdUsuario((int)row[3]);
	             eventoInfo.setNomeEvento((String)row[5]);
	             eventoInfo.setDescricao((String)row[6]);
	             eventoInfo.setHora((String)row[7]);
	             eventoInfo.setDteventoini(sf.format((java.sql.Date)row[8]));
	             eventoInfo.setDteventofim(sf.format((java.sql.Date)row[9]));
	             eventoInfo.setPreco((String)row[10]);
	             eventoInfo.setPromotorevento((String)row[11]);
	             eventoInfo.setContatopromotor((String)row[12]);
	             eventoInfo.setObservacao((String)row[13]);
	             eventoInfo.setNomeAnexo((String)row[14]);
	             eventoInfo.setHoraAnexo((String)row[15]);
	             if(row[16] != null) 
	                eventoInfo.setNumeroVisitas((int)row[16]);
	             eventoInfo.setTag((String)row[17]);
	             eventoInfo.setLogradouro((String)row[19]);
	             eventoInfo.setBairro((String)row[20]);
	             eventoInfo.setCidade((String)row[21]);
	             eventoInfo.setEstado((String)row[22]);
	             eventoInfo.setLatitude((String)row[23]);
	             eventoInfo.setLongitude((String)row[24]);
	             eventoInfo.setLocal((String)row[25]);
	             eventoInfo.setNomeAtracao((String)row[27]);
	             eventoInfo.setNomeUsuario((String)row[28]);
	             eventoInfo.setEmail((String)row[32]);

	             listaEventos.add(eventoInfo);
			 }
			 
	      } catch(Exception e) {
	    	  e.printStackTrace();
	    	  return null;
	      } finally {
	    	  if(session != null)
	    		  session.close();
	      }
		
		return listaEventos;
	}
	
	@Override
	public int remove(EventoInfo evento) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int update(EventoInfo obj) {
		// TODO Auto-generated method stub
		return 1;
	}

	/*
     * Busca um evento pelo seu id
	 */
	@Override
	public EventoInfo search(int id) {
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");	
		EventoInfo evento = new EventoInfo();
		Session session = null;
	      try { 
			 session = HibernateUtil.openSession();
			 Transaction tx = session.beginTransaction();
			
			 Query query = session.createSQLQuery("SELECT * FROM evento " +
						"INNER JOIN Lugar " +
						"ON Evento.fklugar = Lugar.idlugar " +
						"INNER JOIN Atracao " +
						"ON Evento.fkatracao = Atracao.idatracao " +
						"INNER JOIN Usuario " +
						"ON Evento.fkusuario = Usuario.idusuario " +
						"WHERE Evento.idevento=" + id +
						" ORDER BY numerovisitas DESC"); 

			 Object[] row = (Object[])query.uniqueResult();
			 
			 if(row == null) return null;
			 
		     evento.setIdEvento((int)row[0]);
		     evento.setIdLugar((int)row[1]);
		     evento.setIdAtracao((int)row[2]);
             evento.setIdUsuario((int)row[3]);
             evento.setNomeEvento((String)row[5]);
             evento.setDescricao((String)row[6]);
             evento.setHora((String)row[7]);
             evento.setDteventoini(sf.format((java.sql.Date)row[8]));
             evento.setDteventofim(sf.format((java.sql.Date)row[9]));
             evento.setPreco((String)row[10]);
             evento.setPromotorevento((String)row[11]);
             evento.setContatopromotor((String)row[12]);
             evento.setObservacao((String)row[13]);
             evento.setNomeAnexo((String)row[14]);
             evento.setHoraAnexo((String)row[15]);
             if(row[16] != null) 
                evento.setNumeroVisitas((int)row[16]);
             evento.setTag((String)row[17]);
             evento.setLogradouro((String)row[19]);
             evento.setBairro((String)row[20]);
             evento.setCidade((String)row[21]);
             evento.setEstado((String)row[22]);
             evento.setLatitude((String)row[23]);
             evento.setLongitude((String)row[24]);
             evento.setLocal((String)row[25]);
             evento.setNomeAtracao((String)row[27]);
             evento.setNomeUsuario((String)row[28]);
             evento.setEmail((String)row[32]);

	      } catch(Exception e) {
	    	  e.printStackTrace();
	    	  return null;
	      } finally {
	    	  if(session != null)
	    		  session.close();
	      }
		
		return evento;
	}
	
}
