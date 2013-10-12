package br.ufpb.lavid.pamin.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sf;
	
	public static Session openSession() {
		if(sf == null) {
			try{
				Configuration cfg = new AnnotationConfiguration();
				cfg.configure("/hibernate.cfg.xml");
				sf = cfg.buildSessionFactory();
			} catch(Exception e) {
				e.printStackTrace();
				throw new ExceptionInInitializerError(e);
			}
		}
		return sf.openSession();
	}
}
