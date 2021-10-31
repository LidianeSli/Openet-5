package br.com.openet.bean;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.openet.entities.Usuario;
import br.com.openet.service.LoginService;

@Named ("LoginBean")
@RequestScoped 
public class LoginBean {
	private Usuario usuario = new Usuario();
	
	@Inject
	private LoginService login;
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public String efetuaLogin() throws IOException {
		System.out.println("Fazendo login do usuarios" + this.usuario.getNome());
		
		FacesContext context = FacesContext.getCurrentInstance();
		boolean existe = login.existe(this.usuario);
		if (existe) {
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);
			System.out.println("Logado");
			return "logado?faces-redirect=true";
			
		}
		
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Usuario não encontrado"));
		return "login?faces-redirect=true";
	}
	
	public String deslogar() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("usuarioLogado");
		return "login?faces-redirect=true";
	}
	
}

