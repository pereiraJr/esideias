package ideias.controllers;
import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;
import ideias.daos.UsuarioDAO;
import ideias.models.Usuario;
import ideias.seguranca.UsuarioLogado;

@Controller
public class UsuarioController{
    private Result result;
    private UsuarioDAO usuarioDAO;
    private Validator validator;
	private UsuarioLogado usuariologado;
    public UsuarioController(){}
    @Inject
    public UsuarioController(UsuarioLogado usuariologado,Result result, UsuarioDAO usuarioDAO, Validator validator){
        this.result = result;
        this.usuarioDAO = usuarioDAO;
        this.validator = validator;
        this.usuariologado= usuariologado;
    }
    
    @Open
    @Path("/usuario/")
    public void form(){
    	
    }
    
    @IncludeParameters
    @Post
    @Open
    public void adiciona(@Valid Usuario usuario){
        validator.onErrorRedirectTo(this).form();
        usuarioDAO.adicionar(usuario);
        usuariologado.fazLogin(usuario);
        result.redirectTo(IdeiasController.class).lista();
        
    }
    
    public void lista(){
        result.include("usuarios", usuarioDAO.lista());
    }
    @Get
    public void edita(String login){
	    Usuario traz = usuarioDAO.usuarioPorLogin(login);
	    result.include("u",traz);
	}
    @Put
    public void atualiza(String nome,String senha)
    {
    	Usuario retorno = usuarioDAO.usuarioPorLogin(usuariologado.getUsuario().getLogin());
    	Usuario u=new Usuario();
    	u.setNome(nome);
    	if(senha!=null){
    		
    		u.setSenha(senha);
    	}
    	usuarioDAO.editar(retorno,u);
    	result.redirectTo(IdeiasController.class).lista();
    }
}