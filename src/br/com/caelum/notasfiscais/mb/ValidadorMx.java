package br.com.caelum.notasfiscais.mb;



import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("val")
public class ValidadorMx implements Validator {
@Override
public void validate(FacesContext arg0, UIComponent arg1, Object obj)
		throws ValidatorException {
	String valor = obj.toString();
	if(!valor.matches("[A-Z].*")){
		throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "comeca com M","" ));
	}
	
}
	

}
