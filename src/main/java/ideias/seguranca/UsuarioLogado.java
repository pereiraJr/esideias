package ideias.seguranca;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ideias.models.Usuario;

@SessionScoped
@Named
public class UsuarioLogado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario;

	public void fazLogin(Usuario usuario) {
		this.usuario = usuario;
	}

	public void desloga() {
		this.usuario = null;

	}

	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public boolean isLogado() {
		return this.usuario != null;

	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String getLoginAtivo() {
		return this.usuario.getLogin();
	}
	
}