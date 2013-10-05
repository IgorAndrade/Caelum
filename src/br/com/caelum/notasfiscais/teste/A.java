package br.com.caelum.notasfiscais.teste;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
//@Named
public class A implements Serializable{
	
	private static final long serialVersionUID = 1L;
	

	@PostConstruct
	public void init(){
		System.out.println("criei A");
		
	}
	
	@Inject
	public A(B b, C c){
		System.out.println("A recebeu b e c");
	}
	
	public A(){}
}
