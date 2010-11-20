package org.javace.social.lojinha.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.javace.social.lojinha.model.Produto;
import org.javace.social.lojinha.service.ProdutoService;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@PersistenceContext
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Produto> listaTudo() {
		return entityManager
			.createQuery("from Produto")
			.getResultList();
	}

	public void adiciona(Produto produto) {
		entityManager.persist(produto);
	}

	public void atualiza(Produto produto) {
		entityManager.merge(produto);
	}

	public void remove(Produto produto) {
		produto = entityManager.merge(produto);
		entityManager.remove(produto);
	}

	public Produto buscaPorCodigo(Long codigo) {
		return entityManager.find(Produto.class, codigo);
	}

}