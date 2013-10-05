package br.com.caelum.notasfiscais.teste;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
@RequestScoped
public class C implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void init() {
		System.out.println("Criei C");

	}
	
	public C() {
		System.out.println("C nao recebe origem");
	}
}
