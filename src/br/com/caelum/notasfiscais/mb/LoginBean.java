package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.caelum.notasfiscais.dao.UsuarioDAO;
import br.com.caelum.notasfiscais.modelo.Usuario;
import br.com.caelum.notasfiscais.teste.A;

@Named
@RequestScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = -5861369176246430384L;
	@Inject
	private UsuarioLogado usarioLogado;
	
	private Usuario usuario = new Usuario() ;
	@Inject
	private UsuarioDAO dao;
	
	@Inject
	private A a;
	
	public String efetuaLogin() {
		System.out.println(a);
		boolean loginValido = dao.existe(usuario);
		System.out.println("O login era válido? " + loginValido);
		if (loginValido) {
			usarioLogado.setUsuario(usuario);
			return "produto?faces-redirect=true";
		} else {
			this.usuario = new Usuario();
			usarioLogado.setUsuario(null);
			return "login";
		}
	}

	public String efetuaLogout() {
		/*
		 * // Jeito dummy de efetuar logout this.usuario = new Usuario();
		 */
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.invalidate();

		return "login?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isUsuarioLogado() {
		return usarioLogado.isLogado();
	}
}
