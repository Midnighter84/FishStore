package org.genia.fishstore.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class GenericDaoImpl<T> implements GenericDao<T>{

	@PersistenceContext
	EntityManager em;
	
	protected Class<T> entityClass;
	
	public GenericDaoImpl() {}
	
	public GenericDaoImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	@Override
	public T findById(int id) {
		return em.find(entityClass, id);
	}

	@Override
	public void save(T entity) {
		em.persist(entity);
	}

}