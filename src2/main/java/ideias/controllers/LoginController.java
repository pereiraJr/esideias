package ideias.controllers;

import javax.inject.Inject;
import javax.persistence.NoResultException;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import ideias.daos.UsuarioDAO;
import ideias.models.Usuario;
import ideias.seguranca.UsuarioLogado;

@Controller
public class LoginController {

	private final UsuarioDAO dao;
	private UsuarioLogado usuariologado;
	private Result result;
	private Validator validator;
	private Usuario usuario;
	
	@Inject
		public LoginController(UsuarioDAO dao,
			UsuarioLogado usuariologado,Result result,Validator validator,Usuario usuario) {
		this.dao = dao;
		this.usuario = usuario;
		this.usuariologado = usuariologado;
		this.result = result;
		this.validator = validator;
			
	}
	public LoginController(){
		this(null,null,null,null,null);
	}
	@Open
	public void form(){
		
	}
	@Open
	public void autentica(String Login,String Senha){
		
		try{
			usuario =dao.autenticarLogineSenha(Login,Senha);
		}catch(NoResultException e){

			 validator.add(new SimpleMessage("login_invalido",
					 "Login ou senha invalidos"));
			 validator.onErrorForwardTo(this).form();
		}

			usuariologado.fazLogin(usuario);
			result.redirectTo(IdeiasController.class).lista();
	
	
		
	}
	@Open
	public void desloga(){
		usuariologado.desloga();
		result.redirectTo(this).form();
	}
	
}
