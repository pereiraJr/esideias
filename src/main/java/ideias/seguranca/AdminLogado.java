package ideias.seguranca;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ideias.models.Admin;

@SessionScoped
@Named
public class AdminLogado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Admin admin;

	public void fazlogin(Admin admin){
		this.admin = admin;
	}
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public boolean isLogado(){
		return this.admin !=null;
	}
	public String getLoginAtivo() {
		return this.admin.getLogin();
	}
}
