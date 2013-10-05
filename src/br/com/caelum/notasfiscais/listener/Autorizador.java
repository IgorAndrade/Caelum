package br.com.caelum.notasfiscais.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.caelum.notasfiscais.mb.LoginBean;

public class Autorizador implements PhaseListener {

	private static final long serialVersionUID = 3763189288001459870L;

	@Override
	public void beforePhase(PhaseEvent event) {
		// void
	}

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();
		if ("/login.xhtml".equals(context.getViewRoot().getViewId())) {
			return;
		}
		System.out.println("verificando user");
		// Obtendo LoginBean da sessao
		LoginBean loginBean = context.getApplication().
				evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
		
		// Forcando a navegacao da aplicacao a encaminhar o usuario para a tela de login
		if (!loginBean.isUsuarioLogado()) {
			System.out.println("usuario nao logado");
			NavigationHandler handler = context.getApplication().getNavigationHandler();
			handler.handleNavigation(context, null, "login?faces-redirect=true");
			context.renderResponse();
		}
		System.out.println("retorna ok");
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
