package org.javace.social.lojinha.controller;

import org.javace.social.lojinha.model.Usuario;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class UsuarioWeb {

	private Usuario usuario;

	public void loga(Usuario usuario) {
		this.usuario = usuario;
	}
	public void logout() {
		usuario = null;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public boolean isLogado() {
		return usuario != null;
	}

}
