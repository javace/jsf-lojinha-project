package org.javace.social.lojinha.service;

import org.javace.social.lojinha.model.Usuario;

public interface UsuarioService {

	public Usuario autentica(String login, String senha);

}
