package br.com.openet.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.openet.entities.Usuario;
@Stateless
public class LoginService {
	@PersistenceContext(unitName="Openet-JPA")
	private EntityManager entityManager;
	
	public boolean existe(Usuario usuario) {
		TypedQuery<Usuario> query = entityManager
				.createQuery(
						"select u from usuarios u where u.login = :pLogin and u.senha= :pSenha ",
						Usuario.class
						);
		query.setParameter("pLogin", usuario.getLogin());
		query.setParameter("pSenha", usuario.getSenha());
		try {
			Usuario resultado = query.getSingleResult();
		}catch(NoResultException ex){
			return false;
		}
		return true;
	}

}
