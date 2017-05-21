package ideias.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import ideias.daos.IdeiaDAO;
import ideias.models.Ideias;
import ideias.seguranca.UsuarioLogado;
@Controller
public class IdeiasController {

	private Ideias ideia;
	private IdeiaDAO dao;
	private UsuarioLogado usuariologado;
	private Result result;
	private Validator validator;
	@Inject
	public IdeiasController(IdeiaDAO dao,
		UsuarioLogado usuariologado,Result result,Validator validator,Ideias ideia) {
	this.dao = dao;
	this.ideia = ideia;
	this.usuariologado = usuariologado;
	this.result = result;
	this.validator = validator;
		
}
public IdeiasController(){
	this(null,null,null,null,null);
}	
	@Open
	public void form (){
		
	}
    public void adiciona(@Valid Ideias ideia){
        validator.onErrorRedirectTo(this).form();
        ideia.setUsuario(usuariologado.getUsuario());
        dao.adiciona(ideia);
        result.redirectTo(this).lista();
    }
    @Open
    @Path("/lista/")
    public void lista (){
    	List<Ideias> ideias=dao.buscaPorUsuario(usuariologado.getUsuario());
    	
    	result.include("ideia",ideias);
    }
	
    
}
