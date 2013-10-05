package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Usuario;

@Named @ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 5627761327059012897L;

	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;

	public String grava() {
		DAO<Usuario> dao = new DAO<Usuario>(Usuario.class);
		if (usuario.getId() == null) {
			dao.adiciona(usuario);
		} else {
			dao.atualiza(usuario);
		}
		this.usuarios = dao.listaTodos();
		this.usuario = new Usuario();
		
		return "usuario?faces-redirect=true";
	}

	public void remove(Usuario u) {
		DAO<Usuario> dao = new DAO<Usuario>(Usuario.class);
		dao.remove(u);
		this.usuarios = dao.listaTodos();
	}

	public void cancela() {
		this.usuario = new Usuario();
	}

	public List<Usuario> getLista() {
		if (usuarios == null) {
			System.out.println("Carregando usuarios...");
			DAO<Usuario> dao = new DAO<Usuario>(Usuario.class);
			usuarios = dao.listaTodos();
		}
		return usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
