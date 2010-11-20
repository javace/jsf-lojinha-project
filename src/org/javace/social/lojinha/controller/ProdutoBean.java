package org.javace.social.lojinha.controller;

import java.util.ArrayList;
import java.util.List;

import org.javace.social.lojinha.model.Produto;
import org.javace.social.lojinha.service.ProdutoService;
import org.javace.social.lojinha.util.FacesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class ProdutoBean {

	private Produto produto = new Produto();
	private List<Produto> produtos = new ArrayList<Produto>();

	private ProdutoService service;
	private final FacesUtils facesUtils;
	
	@Autowired
	public ProdutoBean(ProdutoService service, FacesUtils facesUtils) {
		this.service = service;
		this.facesUtils = facesUtils;
	}
	
	public String lista() {
		produtos = service.listaTudo();
		return "lista_produtos";
	}
	
	public String adiciona() {
		service.adiciona(produto);
		facesUtils.adicionaMensagemDeInformacao("Produto adicionado com sucesso!");
		return lista();
	}
	
	public void remove() {
		service.remove(produto);
		facesUtils.adicionaMensagemDeInformacao("Produto removido com sucesso!");
		lista();
	}
	
	public String preparaParaAlterar() {
		produto = service.buscaPorCodigo(produto.getCodigo());
		return "altera_produto";
	}
	
	public String altera() {
		service.atualiza(produto);
		facesUtils.adicionaMensagemDeInformacao("Produto alterado com sucesso!");
		return lista();
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
}
