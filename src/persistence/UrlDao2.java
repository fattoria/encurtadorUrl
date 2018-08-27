package persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Url;

public class UrlDao2 {

	Session session;
	Transaction transaction;
	Query query;
	
	public void create(Url u)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(u);
		transaction.commit();
		session.close();
	}
	
	public void update(Url u)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(u);
		transaction.commit();
		session.close();
	}
	
	public void delete(Url u)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(u);
		transaction.commit();
		session.close();
	}
	
	public List<Url> findAll(){
		session = HibernateUtil.getSessionFactory().openSession();
		List<Url> lista = session.createQuery("from Url").list();
		session.close();
		return lista;	
	}
}
