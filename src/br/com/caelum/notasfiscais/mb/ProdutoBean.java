package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ValidationException;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Produto;

@ViewScoped
@Named
public class ProdutoBean implements Serializable {

	private static final long serialVersionUID = 777809793908312542L;

	private Produto produto = new Produto();
	private List<Produto> produtos;
	private Long produtoId;
	@Inject
	DAO<Produto> dao;

	public void grava() {
		
		if (produto.getId() == null) {
			dao.adiciona(produto);
		} else {
			dao.atualiza(produto);
		}
		this.produtos = dao.listaTodos();
		this.produto = new Produto();

		// return "produto?faces-redirect=true";
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	public Long getProdutoId() {
		return produtoId;
	}

	public void remove(Produto p) {
		
		dao.remove(p);
		this.produtos = dao.listaTodos();
	}

	public String cancela() {
		this.produto = new Produto();
		return "produto";
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getLista() {
		if (produtos == null) {
			System.out.println("Carregando produtos...");
			 dao = new DAO<Produto>(Produto.class);
			this.produtos = dao.listaTodos();
		}
		return produtos;
	}

	public double getPrecoTotal() {
		double precoTotal = 0.0;
		if (produtos != null) {
			for (Produto p : produtos) {
				precoTotal += (p.getPreco() != null ? p.getPreco() : 0.0);
			}
		}
		return precoTotal;
	}

	public void comecaComMaiuscula(FacesContext fc, UIComponent comp, Object obj)
			throws ValidationException {
		String valor = obj.toString();
		if (!valor.matches("[A-Z].*")) {
			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "comeca com mauis", ""));
		}
	}

	public void carregaProduto() {
		System.out.println("id: "+this.produtoId);
		 
		if (produtoId != null && produtoId != 0) {
			this.produto = dao.buscaPorId(this.produtoId);
		}
	}
}
