package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import org.jboss.seam.faces.validation.InputField;

@FacesValidator("NomeDesc")
public class ValidadorNomeEDescricao implements Validator, Serializable{

	private static final long serialVersionUID = 1L;
	@Inject @InputField
	private String nome;
	@Inject @InputField
	private String descricao;
	
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		System.out.print("nome ="+nome);
		System.out.print("desc ="+descricao);
		if(nome != null && descricao != null && nome.equalsIgnoreCase(descricao)){
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"nome e desc nao podem ser iguais","erro"));
			
		}
		
	}
}
