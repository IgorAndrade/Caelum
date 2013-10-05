package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


import org.primefaces.model.LazyDataModel;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.datamodel.DataModelNotasFiscais;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;

@Named @RequestScoped
public class ListaNotasFiscaisBean implements Serializable {

	private static final long serialVersionUID = 423153852533006476L;

	private LazyDataModel<NotaFiscal> dataModel;

	@PostConstruct
	public void init() {
		this.dataModel = new DataModelNotasFiscais();
		
		DAO<NotaFiscal> dao = new DAO<NotaFiscal>(NotaFiscal.class);
		this.dataModel.setRowCount(dao.contaTodos());
	}
	
	public LazyDataModel<NotaFiscal> getDataModel() {
		return dataModel;
	}

	public void setDataModel(LazyDataModel<NotaFiscal> dataModel) {
		this.dataModel = dataModel;
	}

	public List<NotaFiscal> getNotasFiscais() {
		DAO<NotaFiscal> dao = new DAO<NotaFiscal>(NotaFiscal.class);
		return dao.listaTodos();
	}
}
