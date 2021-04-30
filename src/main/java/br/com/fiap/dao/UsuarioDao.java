package br.com.fiap.dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Usuario;
import br.com.fiap.utils.JPAUtil;

public class UsuarioDao {

	public void save(Usuario usuario) {
		EntityManager manager = JPAUtil.getEntityManager();

		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();

		manager.close();

	}

	public List<Usuario> getAll() {
		EntityManager manager = JPAUtil.getEntityManager();

		try {
			String jpql = "SELECT u FROM Usuario u";
			TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
			return query.getResultList();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
		} finally {
			manager.close();
		}
		return null;

	}

}
