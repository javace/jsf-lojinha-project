package org.javace.social.lojinha.service;

import java.util.List;

import org.javace.social.lojinha.model.Produto;

public interface ProdutoService {

	public List<Produto> listaTudo();

	public void adiciona(Produto produto);

	public void atualiza(Produto produto);

	public void remove(Produto produto);

	public Produto buscaPorCodigo(Long codigo);

}
