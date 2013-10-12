package br.ufpb.lavid.pamin.dao;
/*
 * Interface que obriga a cada clsse Dao implementar as operações 
 * fundamentais CRUD 
 */
public interface Dao<T> {

	public int insert(T obj);
	public int remove(T obj);
	public int update(T obj);
	public T search(int id);
	
}
