package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Setup;
import br.com.fiap.utils.EntityManagerFacade;
import br.com.fiap.utils.JPAUtil;

public class SetupDao {
	
	private EntityManager manager = new EntityManagerFacade().getEntityManager();

	
	public void save(Setup setup) {
		manager.getTransaction().begin();
		manager.persist(setup);
		manager.getTransaction().commit();
		manager.clear();
	}

	public List<Setup> getAll(){
		String jpql = "SELECT s FROM Setup s JOIN s.user u";
		TypedQuery<Setup> createQuery = manager.createQuery(jpql, Setup.class);
		return createQuery.getResultList();
	}

	public Setup findById(Long id) {
		return manager.find(Setup.class, id);		
	}
	
	public void update(Setup setup) {
		manager.getTransaction().begin();
		manager.merge(setup);
		manager.flush();
		manager.getTransaction().commit();
	}
	
	public void delete(Setup setup) {
		manager.getTransaction().begin();
		manager.remove(setup);
		manager.flush();
		manager.getTransaction().commit();
	}

}