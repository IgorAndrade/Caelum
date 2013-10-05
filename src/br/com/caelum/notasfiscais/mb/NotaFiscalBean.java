package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;


import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Item;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;
import br.com.caelum.notasfiscais.modelo.Produto;

@ViewScoped @Named 
public class NotaFiscalBean implements Serializable {

	private static final long serialVersionUID = 4667252775910858657L;

	private NotaFiscal notaFiscal = new NotaFiscal();
	private Item item = new Item();
	

	public void gravar() {
		DAO<NotaFiscal> dao = new DAO<NotaFiscal>(NotaFiscal.class);
		dao.adiciona(this.notaFiscal);
		
		this.notaFiscal = new NotaFiscal();
	}

	public void guardaItem() {
			System.out.println("produto "+item.getProduto().getNome());
		notaFiscal.getItens().add(item);
		item.setNotaFiscal(notaFiscal);
		
		item = new Item();
	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	
	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
}
