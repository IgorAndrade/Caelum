package br.com.caelum.notasfiscais.datamodel;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;

public class DataModelNotasFiscais extends LazyDataModel<NotaFiscal> implements Serializable {

	private static final long serialVersionUID = -2258655839064305256L;

	public List<NotaFiscal> load(int inicio, int quantidade, String campoOrdenacao, 
								 SortOrder sentidoOrdenacao, Map<String, String> filtros) {
		
		DAO<NotaFiscal> dao = new DAO<NotaFiscal>(NotaFiscal.class);
		return dao.listaTodosPaginada(inicio, quantidade);
	}
}
