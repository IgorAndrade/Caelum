package br.com.caelum.notasfiscais.teste;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

public class B implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@PostConstruct
	public void init() {
		System.out.println("Criei b");
	}
	@Inject
	public B(C c){
		System.out.println("B recebe c");
	}
	
	public B(){System.out.println("padrao b");}
}
