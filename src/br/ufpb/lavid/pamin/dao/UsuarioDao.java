package br.ufpb.lavid.pamin.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ufpb.lavid.pamin.modelo.Usuario;
import br.ufpb.lavid.pamin.util.CriptografiaUtil;
import br.ufpb.lavid.pamin.util.HibernateUtil;

public class UsuarioDao implements Dao<Usuario>{

	/*
	 * Insere novo usuario na tabela de usuarios se nao existir
	 * o login escolhido
	 */
	@Override
	public int insert(Usuario user) {
		
		CriptografiaUtil encode = new CriptografiaUtil();
		
		user.setSenha(encode.criptografarSenha(user.getSenha()));
		
		Session session = null;
        try { 
		   session = HibernateUtil.openSession();
		   Transaction tx = session.beginTransaction();
		   
		   Query query = session.createQuery("from Usuario as user where " +
				   "login = :code");
		   query.setParameter("code", user.getLogin());
		   
		   // se o usuario ainda não existe, salva-o
		   if(query.uniqueResult() == null)
		      session.save(user);
		   else
			  return 0;
		   tx.commit();
        } catch(Exception e) {
           e.printStackTrace();
           return 0;
        } finally {
           if(session != null)
        	  session.close();
        }
		return 1;
	}

	@Override
	public int remove(Usuario obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Usuario obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Usuario search(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Usuario login(String login, String senha) {
		Usuario user = new Usuario();
        CriptografiaUtil encode = new CriptografiaUtil();
		
		senha = encode.criptografarSenha(senha);
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			Transaction tx = session.beginTransaction();
			   
			Query query = session.createQuery("from Usuario as user where " +
					   "login = :code1 and senha = :code2");
			query.setParameter("code1", login);
			query.setParameter("code2", senha);
			
			user = (Usuario)query.uniqueResult();
			   
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(session != null)
	            session.close();
		}
		return user;
	}

}
