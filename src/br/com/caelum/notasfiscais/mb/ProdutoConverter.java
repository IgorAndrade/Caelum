package br.com.caelum.notasfiscais.mb;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.notasfiscais.modelo.Produto;

@FacesConverter(forClass = Produto.class)
@RequestScoped
public class ProdutoConverter implements Converter {
	@Inject
	private EntityManager em;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String valor) {
		Long id = Long.valueOf(valor);
		System.out.println("convertendo: "+valor);
		return em.find(Produto.class, id);
		
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object valor) {
		Produto produto = (Produto) valor;
		return String.valueOf(produto.getId());
	}

}
