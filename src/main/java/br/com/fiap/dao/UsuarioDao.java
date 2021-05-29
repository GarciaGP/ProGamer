package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Setup;
import br.com.fiap.model.Usuario;
import br.com.fiap.utils.EntityManagerFacade;

public class UsuarioDao {
	
	private EntityManager manager = new EntityManagerFacade().getEntityManager();

	public void save(Usuario user) {
		manager.getTransaction().begin();
		manager.persist(user);
		manager.getTransaction().commit();
		manager.clear();
	}

	public List<Usuario> getAll(){
		String jpql = "SELECT u FROM User u";
		TypedQuery<Usuario> createQuery = manager.createQuery(jpql, Usuario.class);
		return createQuery.getResultList();
	}
	
	public Usuario findById(Long id) {
		return manager.find(Usuario.class, id);		
	}

	public boolean exist(Usuario user) {
		TypedQuery<Usuario> query = manager.createQuery("SELECT u FROM User u WHERE "
							+ "email=:email AND "
							+ "password=:password",
							Usuario.class);
		query.setParameter("email", user.getEmail());
		query.setParameter("password", user.getPassword());
		
		try {
			query.getSingleResult();
			return true;
		} catch (NoResultException e) {
			return false;
		}

	}
	
	public void update(Usuario usuario) {
		manager.getTransaction().begin();
		manager.merge(usuario);
		manager.flush();
		manager.getTransaction().commit();
	}
	
	public void delete(Usuario usuario) {
		manager.getTransaction().begin();
		manager.remove(usuario);
		manager.flush();
		manager.getTransaction().commit();
	}

}
