package org.javace.social.lojinha.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.javace.social.lojinha.model.Usuario;
import org.javace.social.lojinha.service.UsuarioService;
import org.springframework.stereotype.Service;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	@PersistenceContext
	EntityManager entityManager;
	
	public Usuario autentica(String login, String senha) {
		String hql = "from Usuario u where u.login = :login and u.senha = :senha";
		Query query = entityManager.createQuery(hql)
			.setParameter("login", login)
			.setParameter("senha", senha);
		try {
			return (Usuario) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
